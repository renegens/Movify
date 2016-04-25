package com.renegens.movify.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renegens.movify.R;
import com.renegens.movify.helpers.MovifyApp;
import com.renegens.movify.http.MovieApiService;

import javax.inject.Inject;

import org.themoviedb.models.MovieLatest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getName();

    @Inject
    MovieApiService movieApiService;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MovifyApp) (getActivity().getApplication())).getComponent().inject(this);
        movieApiService.getLatestMovies().enqueue(new Callback<MovieLatest>() {
            @Override
            public void onResponse(Call<MovieLatest> call, Response<MovieLatest> response) {
                Log.i(TAG, response.body().toString());

            }

            @Override
            public void onFailure(Call<MovieLatest> call, Throwable t) {
                Log.i(TAG, "error");
                t.printStackTrace();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


}
