package com.polbins.themoviedb.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by polbins on 25/02/2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "poster_path",
        "adult",
        "overview",
        "release_date",
        "genre_ids",
        "id",
        "original_title",
        "original_language",
        "title",
        "backdrop_path",
        "popularity",
        "vote_count",
        "video",
        "vote_average"
})
public class Movie {

    @JsonProperty("poster_path")
    public String posterPath;
    @JsonProperty("adult")
    public boolean adult;
    @JsonProperty("overview")
    public String overview;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("genre_ids")
    public List<Integer> genreIds = null;
    @JsonProperty("id")
    public int id;
    @JsonProperty("original_title")
    public String originalTitle;
    @JsonProperty("original_language")
    public String originalLanguage;
    @JsonProperty("title")
    public String title;
    @JsonProperty("backdrop_path")
    public String backdropPath;
    @JsonProperty("popularity")
    public float popularity;
    @JsonProperty("vote_count")
    public int voteCount;
    @JsonProperty("video")
    public boolean video;
    @JsonProperty("vote_average")
    public int voteAverage;

}
