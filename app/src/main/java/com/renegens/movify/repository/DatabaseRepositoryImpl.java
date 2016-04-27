package com.renegens.movify.repository;

import com.renegens.movify.http.MovieApiService;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositoryImpl implements DatabaseRepository {

    private Realm realm;
    private MovieApiService movieApiService;
    private RealmResults<Result> results = null;

    public DatabaseRepositoryImpl(Realm realm, MovieApiService movieApiService) {
        this.realm = realm;
        this.movieApiService = movieApiService;
    }

    @Override
    public RealmResults<Result> getTopRatedMovies() {

        for (int i = 1; i < 10; i++) {
            movieApiService.getTopRatedMovies(i).enqueue(new Callback<TopRated>() {
                @Override
                public void onResponse(Call<TopRated> call, Response<TopRated> response) {
                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(response.body().getResults());
                    realm.commitTransaction();
                }

                @Override
                public void onFailure(Call<TopRated> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }

        results = realm.where(Result.class).findAll().sort("popularity", Sort.DESCENDING);
        return results;
    }

}

