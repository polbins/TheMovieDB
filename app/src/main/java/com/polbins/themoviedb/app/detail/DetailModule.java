package com.polbins.themoviedb.app.detail;

import com.polbins.themoviedb.app.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polbins on 25/02/2017.
 */

@Module
public class DetailModule {
    private final DetailContract.View DetailView;

    DetailModule(DetailContract.View DetailView) {
        this.DetailView = DetailView;
    }

    @Provides
    @ActivityScope
    DetailContract.View provideDetailView() {
        return DetailView;
    }

}

