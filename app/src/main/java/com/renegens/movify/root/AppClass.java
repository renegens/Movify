package com.renegens.movify.root;

import android.app.Application;

import com.renegens.movify.home.HomeModule;
import com.renegens.movify.http.ApiModule;
import com.renegens.movify.topmovies.TopMoviesModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

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

