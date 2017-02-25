package com.polbins.themoviedb.app.main;

import com.polbins.themoviedb.api.ApiService;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.api.model.Movies;
import com.polbins.themoviedb.app.utils.JsonTestUtil;
import com.polbins.themoviedb.app.utils.RetrofitTestUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.refEq;
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

    private List<Movie> moviesFirstPage;
    private List<Movie> moviesSecondPage;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new MainPresenter(view, apiService);

        // Initialize API Models
        Movies moviesFirstPage = JsonTestUtil.getJsonFromFile("movies_first_page.json", Movies.class);
        Movies moviesSecondPage = JsonTestUtil.getJsonFromFile("movies_second_page.json", Movies.class);
        this.moviesFirstPage = moviesFirstPage.movies;
        this.moviesSecondPage = moviesSecondPage.movies;

        // Mock API Calls
        when(apiService.getMovies(ApiService.SortBy.RELEASE_DATE_DESCENDING, 1))
                .thenReturn(RetrofitTestUtil.createCall(moviesFirstPage));
        when(apiService.getMovies(ApiService.SortBy.RELEASE_DATE_DESCENDING, 2))
                .thenReturn(RetrofitTestUtil.createCall(moviesSecondPage));
    }

    @Test
    public void onStartLoadsContent() {
        presenter.start();

        verify(view).showLoading(false);
        verify(view).showContent(moviesFirstPage, true);
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

}