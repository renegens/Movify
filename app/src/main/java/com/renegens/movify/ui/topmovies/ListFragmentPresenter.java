package com.renegens.movify.ui.topmovies;

import android.support.annotation.Nullable;

import org.themoviedb.models.toprated.Result;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListFragmentPresenter implements ListFragmentMVP.Presenter {

    @Nullable
    private ListFragmentMVP.View view;
    private ListFragmentMVP.Model model;
    private Subscription subscription = null;

    public ListFragmentPresenter(ListFragmentMVP.Model model) {
        this.model = model;
    }

    @Override
    public void onClick(int position) {

    }

    @Override
    public void onLongClick(int position) {

    }

    @Override
    public void setView(@Nullable ListFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void loadData() {


        subscription = model.result().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showSnackbar("Error getting movies");
                        }
                    }

                    @Override
                    public void onNext(Result result) {
                        if (view != null) {
                            view.updateData(result);
                        }
                    }
                });
    }

}


