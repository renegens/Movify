package com.renegens.movify.topmovies;

import com.renegens.movify.http.ApiModule;
import com.renegens.movify.http.MovieApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes={ApiModule.class})
public class TopMoviesModule {

    @Provides
    public ListFragmentMVP.Presenter provideListFragmentPresenter(ListFragmentMVP.Model listFragmentModel) {
        return new ListFragmentPresenter(listFragmentModel);
    }


    @Provides
    public ListFragmentMVP.Model provideListFragmentModel(ListRepository repository){
        return new ListFragmentModel(repository);
    }
    @Singleton
    @Provides
    public ListRepository provideRepo(MovieApiService movieApiService){
        return new Repository(movieApiService);
    }


}
