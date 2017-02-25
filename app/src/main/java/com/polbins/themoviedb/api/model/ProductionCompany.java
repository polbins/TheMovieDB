package com.polbins.themoviedb.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by polbins on 25/02/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "id"
})
public class ProductionCompany {

    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public int id;

}
