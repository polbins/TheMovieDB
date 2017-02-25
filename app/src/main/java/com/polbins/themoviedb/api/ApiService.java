package com.polbins.themoviedb.api;

import com.polbins.themoviedb.api.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by polbins on 25/02/2017.
 */

public interface ApiService {

    enum SortBy {
        RELEASE_DATE_ASCENDING("release_date.asc"),
        RELEASE_DATE_DESCENDING("release_date.desc");

        String value;

        SortBy(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return this.value;
        }
    }

    @GET("/discover/movie?sort_by={sort_by}&page={page}")
    Call<Movies> getMovies(@Query("sort_by") SortBy sortBy, @Query("page") int page);

    @GET("/movie/{id}")
    Call<Movies> getMovie(@Query("id") int id);

}
