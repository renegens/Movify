package com.renegens.movify.home;

public class MainFragmentPresenter implements MainFragmentMVP.Presenter {

    private MainFragmentMVP.View view;


    @Override
    public void setView(MainFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public void topRatedMoviesClicked() {
        view.showListFragment();
    }
}
