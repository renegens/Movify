package com.renegens.movify.topmovies;

import android.support.annotation.Nullable;

import java.util.List;

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

        subscription = model.results().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Result>>() {
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
                    public void onNext(List<Result> results) {
                        if (view != null) {
                            view.updateData(results);
                        }
                    }
                });
    }

}


