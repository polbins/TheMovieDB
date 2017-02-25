package com.polbins.themoviedb.app.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.polbins.themoviedb.R;
import com.polbins.themoviedb.api.model.Images;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.app.App;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
    public static final String MOVIE_ID = "movie_id";
    public static final String MOVIE_TITLE = "movie_title";

    @Inject
    DetailPresenter detailPresenter;

    private int movieId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        DaggerDetailComponent.builder()
                .appComponent(App.getAppComponent(getApplication()))
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movieId = extras.getInt(MOVIE_ID);
            String movieTitle = extras.getString(MOVIE_TITLE);

            setTitle(movieTitle);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.start(movieId);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent(Movie movie) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onConfigurationSet(Images images) {

    }

}
