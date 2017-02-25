package com.polbins.themoviedb.app.detail;

import com.polbins.themoviedb.app.ActivityScope;
import com.polbins.themoviedb.app.AppComponent;

import dagger.Component;

/**
 * Created by polbins on 25/02/2017.
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = DetailModule.class
)
interface DetailComponent {

    void inject(DetailActivity DetailActivity);

}

