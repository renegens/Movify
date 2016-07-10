package com.renegens.movify.topmovies;

import android.support.annotation.Nullable;

import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.http.NetworkRequest;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class ListFragmentPresenter implements ListFragmentMVP.Presenter {

    @Nullable
    private ListFragmentMVP.View view;
    private MovieApiService movieApiService;
    private Subscription subscription;

    public ListFragmentPresenter(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @Override
    public void onClick(int position) {

    }

    @Override
    public void onLongClick(int position) {

    }

    @Override
    public void setView(@Nullable ListFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void loadData() {

        Observable<TopRated> topRatedMovies = movieApiService.getTopRatedMovies(1);
        Observable<TopRated> topRatedMovies2 = movieApiService.getTopRatedMovies(2);
        Observable<TopRated> topRatedMovies3 = movieApiService.getTopRatedMovies(3);

        Observable<TopRated> merged = topRatedMovies.concatWith(topRatedMovies2).concatWith(topRatedMovies3);

        Observable<Result> resultObservable = merged.flatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated) {
                return Observable.from(topRated.results);
            }
        });

        subscription = NetworkRequest.performAsyncRequest(resultObservable, new Action1<Result>() {
            @Override
            public void call(Result result) {
                if (view != null) {
                    view.updateData(result);
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                if (view != null) {
                    view.showSnackbar("Error getting user info");
                }
            }
        });

    }

}


