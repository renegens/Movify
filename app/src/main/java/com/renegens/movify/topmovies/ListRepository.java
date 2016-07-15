package com.renegens.movify.topmovies;

import java.util.List;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public interface ListRepository {

    Observable<Result> getFromDB();

    Observable<Result> getFromNetwork();

    Observable<List<Result>> getListFromNetwork();

    Observable<Result> getData();

}
