package com.renegens.movify;

import android.app.Application;

import com.renegens.movify.di.ApplicationComponent;
import com.renegens.movify.di.ApplicationModule;
import com.renegens.movify.di.DaggerApplicationComponent;
import com.renegens.movify.ui.home.HomeModule;
import com.renegens.movify.http.ApiModule;
import com.renegens.movify.ui.topmovies.TopMoviesModule;

import io.realm.Realm;

public class AppClass extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .homeModule(new HomeModule())
                .topMoviesModule(new TopMoviesModule())
                .apiModule(new ApiModule())
                .build();

        Realm.init(this);


    }

    public ApplicationComponent getComponent() {
        return component;
    }
}

