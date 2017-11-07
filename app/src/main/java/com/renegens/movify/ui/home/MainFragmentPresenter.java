package com.renegens.movify.ui.home;

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
