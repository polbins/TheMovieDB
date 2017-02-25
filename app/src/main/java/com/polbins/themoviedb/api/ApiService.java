package com.polbins.themoviedb.api;

import com.polbins.themoviedb.api.model.Configuration;
import com.polbins.themoviedb.api.model.Movie;
import com.polbins.themoviedb.api.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
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

    @GET("/3/discover/movie")
    Call<Movies> getMovies(@Query("sort_by") SortBy sortBy, @Query("page") int page);

    @GET("/3/movie/{id}")
    Call<Movie> getMovie(@Path("id") int id);


    @Headers("Cache-Control: public, max-stale=2419200") // 4 weeks
    @GET("/3/configuration")
    Call<Configuration> getConfiguration();

}
