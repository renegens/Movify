package com.renegens.movify.http;

import org.themoviedb.models.MovieLatest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiService {

    @GET("latest")
    Call<MovieLatest>getLatestMovies();


}
