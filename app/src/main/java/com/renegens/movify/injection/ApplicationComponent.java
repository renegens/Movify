package com.renegens.movify.injection;

import com.renegens.movify.AppClass;
import com.renegens.movify.ui.view.ListFragment;
import com.renegens.movify.ui.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(AppClass target);

    void inject(MainFragment target);

    void inject(ListFragment target);


}

