package com.renegens.movify.injection;

import com.renegens.movify.AppClass;
import com.renegens.movify.http.ApiModule;
import com.renegens.movify.topmovies.ListFragment;
import com.renegens.movify.topmovies.TopMoviesModule;
import com.renegens.movify.home.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, TopMoviesModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(AppClass target);

    void inject(MainFragment target);

    void inject(ListFragment target);


}

