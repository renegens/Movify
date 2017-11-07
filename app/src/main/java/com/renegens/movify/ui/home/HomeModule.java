package com.renegens.movify.ui.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    public MainFragmentMVP.Presenter provideMainFragmentPresenter() {
        return new MainFragmentPresenter();
    }
}
