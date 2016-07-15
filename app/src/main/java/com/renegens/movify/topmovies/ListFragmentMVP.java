package com.renegens.movify.topmovies;

import java.util.List;

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

        void updateData(List<Result> result);

        void showSnackbar(String s);
    }

    interface Model {

        Observable<List<Result>> results();

    }

}
