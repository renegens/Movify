package com.renegens.movify.topmovies;

import android.util.Log;

import com.renegens.movify.http.MovieApiService;

import java.util.List;

import org.themoviedb.models.toprated.Result;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Func1;

public class Repository implements ListRepository {

    private MovieApiService movieApiService;
    private Realm realm;

    public Repository(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;

    }

    @Override
    public Observable<Result> getFromDB() {

        realm = Realm.getDefaultInstance();
        Observable<RealmResults<Result>> results = realm.where(Result.class).findAll().asObservable();
        realm.close();

        return results.flatMap(new Func1<RealmResults<Result>, Observable<Result>>() {
            @Override
            public Observable<Result> call(RealmResults<Result> results) {
                Log.d("Realm", "Returning results") ;
                return Observable.from(results);
            }
        });
    }

    @Override
    public Observable<Result> getFromNetwork() {
        return null;

    }

    @Override
    public Observable<List<Result>> getListFromNetwork() {
        /*Observable<List<Result>> topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2)).concatWith(movieApiService.getTopRatedMovies(3));
        topRatedObservable.doOnNext(new Action1<List<Result>>() {
            @Override
            public void call(List<Result> results) {
                realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(results);
                realm.commitTransaction();
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Result>>>() {
            @Override
            public Observable<? extends List<Result>> call(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });

        return topRatedObservable;*/

        return movieApiService.getTopRatedMovies(1);
    }

    @Override
    public Observable <Result> getData() {
        return getFromDB().switchIfEmpty(getFromNetwork());
    }

}


