package com.renegens.movify.topmovies;

import com.renegens.movify.http.MovieApiService;

import java.util.ArrayList;
import java.util.List;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Repository implements ListRepository {

    private MovieApiService movieApiService;
    private Realm realm;
    private List<Result> results;

    public Repository(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
        realm = Realm.getDefaultInstance();
        results = new ArrayList<>();

    }

    @Override
    public Observable<Result> getFromDB() {

        Observable<RealmResults<Result>> results = realm.where(Result.class).findAll().asObservable();

        return results.flatMap(new Func1<RealmResults<Result>, Observable<Result>>() {
            @Override
            public Observable<Result> call(RealmResults<Result> results) {
                return Observable.from(results);
            }
        }).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public Observable<Result> getFromMemory() {
        return Observable.from(results);
    }

    @Override
    public Observable<Result> getFromNetwork() {

        Observable<TopRated> topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2)).concatWith(movieApiService.getTopRatedMovies(3));

        return topRatedObservable.flatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated) {
                return Observable.from(topRated.results);
            }
        }).doOnNext(new Action1<Result>() {
            @Override
            public void call(Result result) {
                results.add(result);
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends Result>>() {
            @Override
            public Observable<? extends Result> call(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });

    }

    @Override
    public Observable<Result> getData() {
        return getFromMemory().switchIfEmpty(getFromNetwork());
    }

}


