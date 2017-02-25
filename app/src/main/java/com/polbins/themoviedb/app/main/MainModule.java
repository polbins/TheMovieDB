package com.polbins.themoviedb.app.main;

import com.polbins.themoviedb.app.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polbins on 25/02/2017.
 */

@Module
public class MainModule {
    private final MainContract.View mainView;

    MainModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainView() {
        return mainView;
    }

}

