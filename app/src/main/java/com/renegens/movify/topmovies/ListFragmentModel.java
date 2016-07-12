package com.renegens.movify.topmovies;

import org.themoviedb.models.toprated.Result;
import org.themoviedb.models.toprated.TopRated;

import rx.Observable;
import rx.functions.Func1;

public class ListFragmentModel implements ListFragmentMVP.Model {

    private ListRepository repository;

    public ListFragmentModel(ListRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Result> results() {

        return repository.getData().flatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated) {
                return Observable.from(topRated.results);
            }
        });
    }

}
