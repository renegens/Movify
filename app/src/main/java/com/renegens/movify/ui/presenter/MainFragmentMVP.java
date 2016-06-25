package com.renegens.movify.ui.presenter;

public interface MainFragmentMVP {

    interface Presenter {

        void setView(MainFragmentMVP.View view);

        void topRatedMoviesClicked();

    }

    interface View {

        void showToast(String msg);

        void showListFragment();
    }

    interface Model {

    }
}
