package com.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getNext() {
        return next;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public List<Object> getItems() {
        return items;
    }
}