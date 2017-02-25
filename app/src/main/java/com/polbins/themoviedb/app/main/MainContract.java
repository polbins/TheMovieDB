package com.polbins.themoviedb.app.main;

import com.polbins.themoviedb.api.model.Images;
import com.polbins.themoviedb.api.model.Movie;

import java.util.List;

/**
 * Created by polbins on 25/02/2017.
 */

public interface MainContract {

    interface View {

        void showLoading(boolean isRefresh);

        void showContent(List<Movie> movies, boolean isRefresh);

        void showError();

        void onConfigurationSet(Images images);

    }

    interface Presenter {

        void start();

        void onPullToRefresh();

        void onScrollToBottom();

        void finish();

    }

}
