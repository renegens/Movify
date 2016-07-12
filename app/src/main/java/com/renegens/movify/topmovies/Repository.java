package com.renegens.movify.topmovies;

import com.renegens.movify.http.MovieApiService;

import org.themoviedb.models.toprated.TopRated;

import rx.Observable;

public class Repository implements ListRepository {

    private MovieApiService movieApiService;
    private Observable<TopRated> topRatedObservable;

    public Repository(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }



    @Override
    public Observable<TopRated> getFromMemory() {
        return Observable.create(Observable.OnSubscribe<TopRated> topRatedObservable);
    }

    @Override
    public Observable<TopRated> getFromNetwork() {

        topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2)).concatWith(movieApiService.getTopRatedMovies(3));
        return topRatedObservable;
    }

    @Override
    public Observable<TopRated> getData() {
        return getFromMemory().switchIfEmpty(getFromNetwork());
    }

}


