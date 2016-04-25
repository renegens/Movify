package com.renegens.movify.helpers;

import android.app.Application;
import android.content.Context;

import com.renegens.movify.repository.DatabaseRepository;
import com.renegens.movify.repository.DatabaseRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    public DatabaseRepository provideDatabaseRepository(Realm realm) {
        return new DatabaseRepositoryImpl(realm);
    }

    @Provides
    public Realm providesRealm() {
        return Realm.getDefaultInstance();
    }

  /*  @Provides
    public ForecastService provideForecastService(RestAdapter restAdapter) {
        return new ForecastServiceImpl(restAdapter);
    }*/


}

