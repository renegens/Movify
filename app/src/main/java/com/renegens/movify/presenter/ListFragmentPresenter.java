package com.renegens.movify.presenter;

public interface ListFragmentPresenter {

    void onClick(int position);

    void onLongClick(int position);

    void setView(ListFragmentView view);

}
