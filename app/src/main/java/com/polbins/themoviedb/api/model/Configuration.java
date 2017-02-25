package com.polbins.themoviedb.api.model;

/**
 * Created by polbins on 25/02/2017.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Configuration {

    @JsonProperty("images")
    public Images images;
    @JsonProperty("change_keys")
    public List<String> changeKeys = null;

}
