package com.renegens.movify.injection;

import android.app.Application;
import android.content.Context;

import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.presenter.ListFragmentMVP;
import com.renegens.movify.presenter.ListFragmentPresenter;
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
    public DatabaseRepository provideDatabaseRepository(Realm realm, MovieApiService movieApiService) {
        return new DatabaseRepositoryImpl(realm, movieApiService);
    }

    @Provides
    public Realm providesRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    public ListFragmentMVP.Presenter provideListFragmentPresenter(DatabaseRepository databaseRepository){
        return new ListFragmentPresenter(databaseRepository);
    }



}

