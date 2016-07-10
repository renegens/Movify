package com.renegens.movify.home;

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
