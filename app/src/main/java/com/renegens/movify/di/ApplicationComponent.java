package com.renegens.movify.di;

import com.renegens.movify.ui.home.HomeModule;
import com.renegens.movify.ui.home.MainFragment;
import com.renegens.movify.http.ApiModule;
import com.renegens.movify.AppClass;
import com.renegens.movify.MainActivity;
import com.renegens.movify.ui.topmovies.ListFragment;
import com.renegens.movify.ui.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, TopMoviesModule.class, HomeModule.class})
public interface ApplicationComponent {

    void inject(AppClass target);

    void inject(MainFragment target);

    void inject(ListFragment target);

    void inject(MainActivity target);





}

