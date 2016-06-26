package com.renegens.movify.injection;

import android.app.Application;
import android.content.Context;

import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.ui.presenter.ListFragmentMVP;
import com.renegens.movify.ui.presenter.ListFragmentPresenter;
import com.renegens.movify.ui.presenter.MainFragmentMVP;
import com.renegens.movify.ui.presenter.MainFragmentPresenter;

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


    @Provides
    public Realm providesRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    public ListFragmentMVP.Presenter provideListFragmentPresenter(MovieApiService movieApiService){
        return new ListFragmentPresenter(movieApiService);
    }

    @Provides
    public MainFragmentMVP.Presenter provideMainFragmentPresenter(){
        return new MainFragmentPresenter();
    }



}

