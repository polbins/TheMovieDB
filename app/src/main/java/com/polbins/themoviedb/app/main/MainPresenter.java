package com.polbins.themoviedb.app.main;

import com.polbins.themoviedb.api.ApiService;

import javax.inject.Inject;

/**
 * Created by polbins on 25/02/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private ApiService apiService;

    @Inject
    MainPresenter(MainContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void start() {
        view.showLoading(false);
    }

    @Override
    public void onPullToRefresh() {

    }

    @Override
    public void onScrollToBottom() {

    }

    @Override
    public void finish() {

    }

}
