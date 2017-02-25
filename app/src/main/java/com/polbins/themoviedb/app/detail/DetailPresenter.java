package com.polbins.themoviedb.app.detail;

import com.polbins.themoviedb.api.ApiService;
import com.polbins.themoviedb.api.model.Configuration;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by polbins on 25/02/2017.
 */

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View view;
    private ApiService apiService;

    @Inject
    DetailPresenter(DetailContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void start(int movieId) {
        
    }

    @Override
    public void finish() {

    }

}
