package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Followers {

    @JsonProperty("total")
    private int total;

    @JsonProperty("href")
    private Object href;

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setHref(Object href) {
        this.href = href;
    }

    public Object getHref() {
        return href;
    }
}