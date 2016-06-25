package com.renegens.movify;

import android.app.Application;

import com.renegens.movify.injection.ApiModule;
import com.renegens.movify.injection.ApplicationComponent;
import com.renegens.movify.injection.ApplicationModule;
import com.renegens.movify.injection.DaggerApplicationComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MovifyApp extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        //needs to run once to generate it

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
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

