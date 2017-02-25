package com.polbins.themoviedb.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by polbins on 25/02/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "iso_639_1",
        "name"
})
public class SpokenLanguage {

    @JsonProperty("iso_639_1")
    public String iso6391;
    @JsonProperty("name")
    public String name;

}
