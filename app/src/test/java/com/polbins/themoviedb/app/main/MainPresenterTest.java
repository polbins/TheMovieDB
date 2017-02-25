package com.polbins.themoviedb.app.main;

import com.polbins.themoviedb.api.ApiService;
import com.polbins.themoviedb.api.model.Configuration;
import com.polbins.themoviedb.api.model.Images;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.api.model.Movies;
import com.polbins.themoviedb.app.utils.JsonTestUtil;
import com.polbins.themoviedb.app.utils.RetrofitTestUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by polbins on 25/02/2017.
 */
public class MainPresenterTest {
    @Mock
    MainContract.View view;

    @Mock
    ApiService apiService;

    private MainPresenter presenter;

    private ApiService.SortBy defaultApiSortBy = ApiService.SortBy.RELEASE_DATE_DESCENDING;
    private List<Movie> moviesFirstPage;
    private List<Movie> moviesSecondPage;
    private Images images;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new MainPresenter(view, apiService);

        // Initialize API Models
        Movies moviesFirstPage = JsonTestUtil.getJsonFromFile("movies_first_page.json", Movies.class);
        Movies moviesSecondPage = JsonTestUtil.getJsonFromFile("movies_second_page.json", Movies.class);
        Configuration configuration = JsonTestUtil.getJsonFromFile("configuration.json", Configuration.class);
        this.moviesFirstPage = moviesFirstPage.movies;
        this.moviesSecondPage = moviesSecondPage.movies;
        this.images = configuration.images;

        // Mock API Calls
        when(apiService.getMovies(defaultApiSortBy, 1))
                .thenReturn(RetrofitTestUtil.createCall(moviesFirstPage));
        when(apiService.getMovies(defaultApiSortBy, 2))
                .thenReturn(RetrofitTestUtil.createCall(moviesSecondPage));
        when(apiService.getConfiguration())
                .thenReturn(RetrofitTestUtil.createCall(configuration));
    }

    private void makeGetMoviesFail() {
        when(apiService.getMovies(any(ApiService.SortBy.class), anyInt()))
                .thenReturn(RetrofitTestUtil.createCall(500, new Movies()));
    }

    @Test
    public void onStartLoadsContent() {
        presenter.start();

        verify(view).showLoading(false);
        verify(view).showContent(moviesFirstPage, true);
        verify(view).onConfigurationSet(images);
    }

    @Test
    public void onPullToRefreshRefreshesContent() {
        presenter.onPullToRefresh();

        verify(view).showLoading(true);
        verify(view).showContent(moviesFirstPage, true);
    }

    @Test
    public void onScrollToBottomLoadsMoreContent() {
        presenter.onScrollToBottom();

        // make use of PTR for loading more content
        verify(view).showLoading(true);
        verify(view).showContent(moviesSecondPage, false);
    }

    @Test
    public void onStartLoadsContentFail() {
        makeGetMoviesFail();
        presenter.start();

        verify(view).showLoading(false);
        verify(view).showError();
    }

    @Test
    public void onPullToRefreshRefreshesContentFail() {
        makeGetMoviesFail();
        presenter.onPullToRefresh();

        verify(view).showLoading(true);
        verify(view).showError();
    }

    @Test
    public void onScrollToBottomLoadsMoreContentFail() {
        makeGetMoviesFail();
        presenter.onScrollToBottom();

        // make use of PTR for loading more content
        verify(view).showLoading(true);
        verify(view).showError();
    }

}