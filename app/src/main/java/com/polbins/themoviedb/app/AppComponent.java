package com.polbins.themoviedb.app;

import android.app.Application;

import com.polbins.themoviedb.api.ApiModule;
import com.polbins.themoviedb.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by polbins on 25/02/2017.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface AppComponent {

    Application application();

    ApiService apiService();

    void inject(App app);

}

