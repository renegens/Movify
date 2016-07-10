package com.renegens.movify.topmovies;

import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.home.MainFragmentMVP;
import com.renegens.movify.home.MainFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TopMoviesModule {

    @Provides
    public ListFragmentMVP.Presenter provideListFragmentPresenter(MovieApiService movieApiService) {
        return new ListFragmentPresenter(movieApiService);
    }

    @Provides
    public MainFragmentMVP.Presenter provideMainFragmentPresenter() {
        return new MainFragmentPresenter();
    }
}
