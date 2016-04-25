package com.renegens.movify.helpers;

import com.renegens.movify.view.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MovifyApp target);

    void inject(MainActivityFragment target);

}

