package com.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
//@Data
//@Setter @Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @JsonProperty("owner")
    Owner owner;

    @JsonProperty("images")
    List<Object> images;

    @JsonProperty("snapshot_id")
    String snapshotId;

    @JsonProperty("collaborative")
    boolean collaborative;

    @JsonProperty("description")
    String description;

    @JsonProperty("primary_color")
    Object primaryColor;

    @JsonProperty("type")
    String type;

    @JsonProperty("uri")
    String uri;

    @JsonProperty("tracks")
    Tracks tracks;

    @JsonProperty("followers")
    Followers followers;

    @JsonProperty("public")
    boolean Public;

    @JsonProperty("name")
    String name;

    @JsonProperty("href")
    String href;

    @JsonProperty("id")
    String id;

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
}