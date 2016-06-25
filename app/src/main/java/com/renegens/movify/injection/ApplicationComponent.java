package com.renegens.movify.injection;

import com.renegens.movify.MovifyApp;
import com.renegens.movify.view.ListFragment;
import com.renegens.movify.view.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MovifyApp target);

    void inject(MainActivityFragment target);

    void inject(ListFragment target);

}

