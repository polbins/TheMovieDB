package com.polbins.themoviedb.app.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.polbins.themoviedb.R;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.app.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final String TAG = "Main";

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainComponent.builder()
                .appComponent(App.getAppComponent(getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.start();
    }

    @Override
    public void showLoading(boolean isRefresh) {
        Toast.makeText(this, "Loading Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContent(List<Movie> movies, boolean isRefresh) {

    }

    @Override
    public void showError() {

    }

}
