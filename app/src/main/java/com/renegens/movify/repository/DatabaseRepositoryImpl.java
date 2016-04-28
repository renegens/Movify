package com.renegens.movify.repository;

import com.renegens.movify.http.MovieApiService;

import java.util.List;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import io.realm.Realm;
import rx.Observable;

public class DatabaseRepositoryImpl implements DatabaseRepository {

    private Realm realm;
    private MovieApiService movieApiService;
    //private RealmResults<Result> results = null;
    private List <Result> results = null;

    public DatabaseRepositoryImpl(Realm realm, MovieApiService movieApiService) {
        this.realm = realm;
        this.movieApiService = movieApiService;
    }

    //Observable topMovies = movieApiService.getTopRatedMovies(1);

    @Override
    public Observable <TopRated> getTopRatedMovies(int pageNumber) {
        Observable topRatedMovies = movieApiService.getTopRatedMovies(pageNumber);
        return topRatedMovies;
    }




   /*

   topMovies.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<TopRated>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TopRated topRated) {
                        results = topRated.getResults();
                        Log.i("RxResult", results.get(0).title);
                    }
                });


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
    }*/

}

