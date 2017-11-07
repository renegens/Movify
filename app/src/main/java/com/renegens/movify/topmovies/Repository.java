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
        RealmResults<Result> results = realm.where(Result.class).findAll();
        Observable.from(results);
        return Observable.from(results)
                .doOnError(Throwable::printStackTrace);
    }

    @Override
    public Observable<Result> getFromMemory() {
        return Observable.from(results);
    }

    @Override
    public Observable<Result> getFromNetwork() {
        return movieApiService
                .getTopRatedMovies(1)
                .concatWith(movieApiService.getTopRatedMovies(2))
                .concatWith(movieApiService.getTopRatedMovies(3))
                .flatMap(topRated -> Observable.from(topRated.results))
                .doOnNext(result -> results.add(result));
    }

    @Override
    public Observable<Result> getData() {
        return getFromMemory().switchIfEmpty(getFromNetwork());
    }

}


