package com.renegens.movify.ui.topmovies;

import com.renegens.movify.repository.ListRepository;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public class ListFragmentModel implements ListFragmentMVP.Model {

    private ListRepository repository;

    public ListFragmentModel(ListRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Result> result() {

        return repository.getData();

    }
}

