package com.renegens.movify.topmovies;

import org.themoviedb.models.toprated.TopRated;

import rx.Observable;

public interface DatabaseRepository {

    Observable <TopRated> getTopRatedMovies(int pageNumber);
}
