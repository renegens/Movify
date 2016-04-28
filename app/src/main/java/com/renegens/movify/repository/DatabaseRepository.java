package com.renegens.movify.repository;

import org.themoviedb.models.toprated.TopRated;

import rx.Observable;

public interface DatabaseRepository {

    Observable <TopRated> getTopRatedMovies(int pageNumber);
}
