package com.renegens.movify.ui.topmovies;

import com.renegens.movify.http.ApiModule;
import com.renegens.movify.http.MovieApiService;
import com.renegens.movify.repository.ListRepository;
import com.renegens.movify.repository.Repository;

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
