package com.renegens.movify.http;


import org.themoviedb.models.toprated.TopRated;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieApiService {

    @GET("latest")
    Call<ResponseBody> getLatestMovies();

    @GET("top_rated")
    Observable <TopRated> getTopRatedMovies(@Query("page") Integer page);


}
