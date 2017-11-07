package com.renegens.movify.repository;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public interface ListRepository {

    Observable<Result> getFromDB();

    Observable<Result> getFromMemory();

    Observable<Result> getFromNetwork();

    Observable<Result> getData();

}
