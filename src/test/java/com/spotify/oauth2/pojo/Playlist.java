package com.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("images")
    private List<Object> images;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("collaborative")
    private boolean collaborative;

    @JsonProperty("description")
    private String description;

    @JsonProperty("primary_color")
    private Object primaryColor;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("tracks")
    private Tracks tracks;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("public")
    private boolean Public;

    @JsonProperty("name")
    private String name;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setCollaborative(boolean collaborative) {
        this.collaborative = collaborative;
    }

    public boolean isCollaborative() {
        return collaborative;
    }

    public Playlist setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setPrimaryColor(Object primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Object getPrimaryColor() {
        return primaryColor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public Followers getFollowers() {
        return followers;
    }

    public Playlist setPublic(boolean aPublic) {
        this.Public = aPublic;
        return this;
    }

    public boolean isPublic() {
        return Public;
    }

    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }
}