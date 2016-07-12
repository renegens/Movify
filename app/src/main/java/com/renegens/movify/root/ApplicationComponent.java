package com.renegens.movify.root;

import com.renegens.movify.home.HomeModule;
import com.renegens.movify.home.MainFragment;
import com.renegens.movify.http.ApiModule;
import com.renegens.movify.topmovies.ListFragment;
import com.renegens.movify.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, TopMoviesModule.class, HomeModule.class})
public interface ApplicationComponent {

    void inject(AppClass target);

    void inject(MainFragment target);

    void inject(ListFragment target);





}

