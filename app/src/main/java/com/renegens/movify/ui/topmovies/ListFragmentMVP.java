package com.renegens.movify.ui.topmovies;

import org.themoviedb.models.toprated.Result;

import rx.Observable;

public interface ListFragmentMVP {

    interface Presenter {

        void onClick(int position);

        void onLongClick(int position);

        void setView(ListFragmentMVP.View view);

        void loadData();

        void rxUnsubscribe();
    }

    interface View {

        void updateData(Result result);

        void showSnackbar(String s);
    }

    interface Model {

        Observable<Result> result();

    }

}
