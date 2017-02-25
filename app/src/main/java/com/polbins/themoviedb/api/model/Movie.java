package com.polbins.themoviedb.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by polbins on 25/02/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "adult",
        "backdrop_path",
        "belongs_to_collection",
        "budget",
        "genres",
        "homepage",
        "id",
        "imdb_id",
        "original_language",
        "original_title",
        "overview",
        "popularity",
        "poster_path",
        "production_companies",
        "production_countries",
        "release_date",
        "revenue",
        "runtime",
        "spoken_languages",
        "status",
        "tagline",
        "title",
        "video",
        "vote_average",
        "vote_count"
})
public class Movie {

    @JsonProperty("adult")
    public boolean adult;
    @JsonProperty("backdrop_path")
    public String backdropPath;
    @JsonProperty("belongs_to_collection")
    public BelongsToCollection belongsToCollection;
    @JsonProperty("budget")
    public int budget;
    @JsonProperty("genres")
    public List<Genre> genres = null;
    @JsonProperty("homepage")
    public String homepage;
    @JsonProperty("id")
    public int id;
    @JsonProperty("imdb_id")
    public String imdbId;
    @JsonProperty("original_language")
    public String originalLanguage;
    @JsonProperty("original_title")
    public String originalTitle;
    @JsonProperty("overview")
    public String overview;
    @JsonProperty("popularity")
    public float popularity;
    @JsonProperty("poster_path")
    public String posterPath;
    @JsonProperty("production_companies")
    public List<ProductionCompany> productionCompanies = null;
    @JsonProperty("production_countries")
    public List<ProductionCountry> productionCountries = null;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("revenue")
    public int revenue;
    @JsonProperty("runtime")
    public int runtime;
    @JsonProperty("spoken_languages")
    public List<SpokenLanguage> spokenLanguages = null;
    @JsonProperty("status")
    public String status;
    @JsonProperty("tagline")
    public String tagline;
    @JsonProperty("title")
    public String title;
    @JsonProperty("video")
    public boolean video;
    @JsonProperty("vote_average")
    public float voteAverage;
    @JsonProperty("vote_count")
    public int voteCount;

}
