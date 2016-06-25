package com.renegens.movify.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.renegens.movify.R;
import com.renegens.movify.MovifyApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getName();

    @BindView(R.id.main_fragment_button_one)Button oneButton;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ((MovifyApp) (getActivity().getApplication())).getComponent().inject(this);
        //latestMovie();
        //topratedmovies();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick (R.id.main_fragment_button_one)
    public void buttonClick(){

        ListFragment listFragment = new ListFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, listFragment)
                .commit();

    }



    /*
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
}
