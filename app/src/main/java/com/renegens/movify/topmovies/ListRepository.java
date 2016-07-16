package com.renegens.movify.topmovies;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public interface ListRepository {

    Observable<Result> getFromDB();

    Observable<Result> getFromMemory();

    Observable<Result> getFromNetwork();

    Observable<Result> getData();

}
