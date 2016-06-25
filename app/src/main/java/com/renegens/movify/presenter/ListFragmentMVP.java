package com.renegens.movify.presenter;

public interface ListFragmentMVP {

    interface Presenter {

        void onClick(int position);

        void onLongClick(int position);

        void setView(ListFragmentMVP.View view);
    }

    interface View {

        void showToast(String msg);

    }

    interface Model {

    }

}
