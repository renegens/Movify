package com.renegens.movify.ui.presenter;

import org.themoviedb.models.toprated.Result;

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

    }

}
