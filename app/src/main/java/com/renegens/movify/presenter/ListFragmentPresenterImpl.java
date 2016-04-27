package com.renegens.movify.presenter;

import com.renegens.movify.repository.DatabaseRepository;

public class ListFragmentPresenterImpl implements ListFragmentPresenter {

    private DatabaseRepository databaseRepository;
    private ListFragmentView view;

    public ListFragmentPresenterImpl(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public void onClick(int position) {



    }

    @Override
    public void onLongClick(int position) {


    }

    @Override
    public void setView(ListFragmentView view) {
        this.view = view;
    }

}
