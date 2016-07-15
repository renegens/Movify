package com.renegens.movify.http;

import java.util.List;

import org.themoviedb.models.toprated.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieApiService {

    @GET("latest")
    Call<ResponseBody> getLatestMovies();

    @GET("top_rated")
    Observable <List<Result>> getTopRatedMovies(@Query("page") Integer page);


}
