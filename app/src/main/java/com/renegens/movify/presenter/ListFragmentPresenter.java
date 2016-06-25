package com.renegens.movify.presenter;

import com.renegens.movify.repository.DatabaseRepository;

public class ListFragmentPresenter implements ListFragmentMVP.Presenter {

    private DatabaseRepository databaseRepository;
    private ListFragmentMVP.View view;

    public ListFragmentPresenter(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }



    @Override
    public void onClick(int position) {


    }

    @Override
    public void onLongClick(int position) {


    }

    @Override
    public void setView(ListFragmentMVP.View view) {
        this.view = view;
    }

}
