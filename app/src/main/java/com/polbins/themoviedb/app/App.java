package com.polbins.themoviedb.app;

import android.app.Application;

import com.polbins.themoviedb.R;
import com.polbins.themoviedb.api.ApiModule;

/**
 * Created by polbins on 25/02/2017.
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(getString(R.string.base_url), getString(R.string.api_key)))
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(Application application) {
        return ((App) application).getAppComponent();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}

