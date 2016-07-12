package com.renegens.movify.topmovies;

import org.themoviedb.models.toprated.TopRated;

import rx.Observable;

public interface ListRepository {

    Observable<TopRated> getFromMemory();

    Observable<TopRated> getFromNetwork();

    Observable<TopRated> getData();

}
