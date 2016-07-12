package com.renegens.movify.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    public MainFragmentMVP.Presenter provideMainFragmentPresenter() {
        return new MainFragmentPresenter();
    }
}
