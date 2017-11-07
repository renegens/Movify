package com.renegens.movify.ui.home;

public interface MainFragmentMVP {

    interface Presenter {

        void setView(MainFragmentMVP.View view);

        void topRatedMoviesClicked();

    }

    interface View {

        void showListFragment();
    }

    interface Model {

    }
}
