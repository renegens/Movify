package com.renegens.movify.topmovies;

import java.util.List;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public class ListFragmentModel implements ListFragmentMVP.Model {

    private ListRepository repository;

    public ListFragmentModel(ListRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Result>> results() {

        return repository.getListFromNetwork();

    }
}

