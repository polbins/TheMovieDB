package com.polbins.themoviedb.app.detail;

import com.polbins.themoviedb.api.ApiService;
import com.polbins.themoviedb.api.model.Configuration;
import com.polbins.themoviedb.api.model.Images;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.app.utils.JsonTestUtil;
import com.polbins.themoviedb.app.utils.RetrofitTestUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by polbins on 25/02/2017.
 */
public class DetailPresenterTest {

    @Mock
    DetailContract.View view;

    @Mock
    ApiService apiService;

    private DetailPresenter presenter;
    private Movie movie;
    private Images images;
    private static int DUMMY_MOVIE_ID = 123;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new DetailPresenter(view, apiService);

        // Initialize API Model
        movie = JsonTestUtil.getJsonFromFile("movie.json", Movie.class);
        Configuration configuration = JsonTestUtil.getJsonFromFile("configuration.json", Configuration.class);
        images = configuration.images;

        // Mock API Call
        when(apiService.getMovie(anyInt()))
                .thenReturn(RetrofitTestUtil.createCall(movie));
        when(apiService.getConfiguration())
                .thenReturn(RetrofitTestUtil.createCall(configuration));
    }

    private void makeGetMovieFail() {
        when(apiService.getMovie(anyInt()))
                .thenReturn(RetrofitTestUtil.createCall(500, new Movie()));
    }

    @Test
    public void onStartLoadsContent() {
        presenter.start(DUMMY_MOVIE_ID);

        verify(view).showLoading();
        verify(view).showContent(movie);
        verify(view).onConfigurationSet(images);
    }

    @Test
    public void onStartLoadsContentFail() {
        makeGetMovieFail();
        presenter.start(DUMMY_MOVIE_ID);

        verify(view).showLoading();
        verify(view).showError();
    }

}