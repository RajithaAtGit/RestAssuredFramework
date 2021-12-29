package com.spotify.oauth2.test;

import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;


import com.spotify.oauth2.utils.ConfigLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {



    @Test
    public void testCreateAPlaylist() {
        Playlist requestPlaylist = new Playlist().
                setName("New Playlist 001").
                setDescription("New Playlist 001 form POJO Class").
                setPublic(false);

        Response response = PlaylistApi.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(201));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.isPublic(), equalTo(requestPlaylist.isPublic()));
    }

    @Test
    public void testGetAPlaylist() {
        Playlist requestPlaylist = new Playlist().
                setName("Updated Playlist 30").
                setDescription("Updated by POJOs").
                setPublic(false);

        Response response = PlaylistApi.get(ConfigLoader.getInstance().getPlaylistId());
        assertThat(response.statusCode(), equalTo(200));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.isPublic(), equalTo(requestPlaylist.isPublic()));
    }

    @Test
    public void testUpdatePlaylistDetails() {
        Playlist requestPlaylist = new Playlist().
                setName("Updated Playlist 30").
                setDescription("Updated by POJOs").
                setPublic(false);

        Response response = PlaylistApi.update(requestPlaylist, ConfigLoader.getInstance().getPlaylistId());
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void testShouldNotBeAbleToCreatePlaylistWithoutAName() {
        Playlist requestPlaylist = new Playlist().
                setName("").
                setDescription("created by postman").
                setPublic(false);

        Response response = PlaylistApi.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(400));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(400));
        assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void testShouldNotBeAbleToCreateAPlaylistWithExpiredAccessToken() {
        Playlist requestPlaylist = new Playlist().
                setName("playlist 40").
                setDescription("created by postman")
                .setPublic(false);

        Response response = PlaylistApi.post(requestPlaylist, ConfigLoader.getInstance().getExpiredAccessToken());
        assertThat(response.statusCode(), equalTo(401));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(401));
        assertThat(error.getError().getMessage(), equalTo("The access token expired"));
    }

    @Test
    public void testShouldNotBeAbleToCreateAPlaylistWithInvalidAccessToken() {
        Playlist requestPlaylist = new Playlist().
                setName("playlist 40").
                setDescription("created by postman")
                .setPublic(false);

        Response response = PlaylistApi.post(requestPlaylist, ConfigLoader.getInstance().getInvalidAccessToken());
        assertThat(response.statusCode(), equalTo(401));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(401));
        assertThat(error.getError().getMessage(), equalTo("Invalid access token"));
    }
}
