package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tracks {

    @JsonProperty("next")
    private Object next;

    @JsonProperty("total")
    private int total;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("previous")
    private Object previous;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("href")
    private String href;

    @JsonProperty("items")
    private List<Object> items;
}