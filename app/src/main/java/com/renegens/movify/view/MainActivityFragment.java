package com.renegens.movify.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renegens.movify.R;
import com.renegens.movify.helpers.MovifyApp;
import com.renegens.movify.http.MovieApiService;

import javax.inject.Inject;
import java.util.List;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getName();

    @Inject
    MovieApiService movieApiService;

    @Inject
    Realm realm;


    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MovifyApp) (getActivity().getApplication())).getComponent().inject(this);
        //latestMovie();
        topratedmovies();
    }

    private void topratedmovies() {

        for (int i = 1; i < 10; i++) {

            movieApiService.getTopRatedMovies(i).enqueue(new Callback<TopRated>() {
                @Override
                public void onResponse(Call<TopRated> call, Response<TopRated> response) {
                    List<Result> results = response.body().getResults();

                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(results);
                    realm.commitTransaction();

                }

                @Override
                public void onFailure(Call<TopRated> call, Throwable t) {
                    t.printStackTrace();

                }
            });
        }
    }

  /*  private void topratedmovies() {

        movieApiService.getTopRatedMovies(1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream is = response.body().byteStream();
                realm.beginTransaction();
                try {
                    realm.createObjectFromJson(TopRatedList.class, is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                realm.commitTransaction();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "error");
                t.printStackTrace();
            }
        });
    }

    private void latestMovie() {
        movieApiService.getLatestMovies().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                InputStream is = response.body().byteStream();
                realm.beginTransaction();
                try {
                    realm.createOrUpdateObjectFromJson(MovieLatestObject.class, is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                realm.commitTransaction();

                //RealmQuery<MovieLatestObject> query = realm.where(MovieLatestObject.class);
                //MovieLatestObject movieLatest = query.findFirst();
                //Log.i(TAG, movieLatest.getGenres().get(0).toString());


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "error");
                t.printStackTrace();
            }
        });
    }*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
