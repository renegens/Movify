package com.renegens.movify.helpers;

import android.app.Application;

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

