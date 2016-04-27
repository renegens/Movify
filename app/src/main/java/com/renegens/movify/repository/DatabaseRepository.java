package com.renegens.movify.repository;

import org.themoviedb.models.toprated.Result;

import io.realm.RealmResults;

public interface DatabaseRepository {

    RealmResults<Result> getTopRatedMovies();
}
