package com.renegens.movify.root;

import android.app.Application;

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
                .topMoviesModule(new TopMoviesModule())
                .apiModule(new ApiModule())
                .build();

        //Config Realm for the application
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("movie.realm")
                .build();
        //Realm.deleteRealm(realmConfiguration); //Deletes the realm
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}

