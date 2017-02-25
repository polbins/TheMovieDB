package com.polbins.themoviedb.app.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.polbins.themoviedb.R;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    public static final String MOVIE_ID = "movie_id";
    public static final String MOVIE_TITLE = "movie_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int movieId = extras.getInt(MOVIE_ID);
            String movieTitle = extras.getString(MOVIE_TITLE);

            setTitle(movieTitle);
            Toast.makeText(this, "id = " + movieId + ", title = " + movieTitle, Toast.LENGTH_SHORT).show();
        }
    }

}
