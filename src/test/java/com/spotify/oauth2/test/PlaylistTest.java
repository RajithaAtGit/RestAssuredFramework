package com.spotify.oauth2.test;

import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;

import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {

    private final Assertions assertions = new Assertions();

    @Test
    public void testCreateAPlaylist() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 001", "New Playlist 001 form POJO Class", false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertions.assertStatusCode(response.statusCode(), 201);
        assertPlaylist(response.as(Playlist.class), requestPlaylist);
    }

    @Test
    public void testGetAPlaylist() {
        Playlist requestPlaylist = playlistBuilder("Updated Playlist 30", "Updated by POJOs", false);
        Response response = PlaylistApi.get(DataLoader.getInstance().getPlaylistId());
        assertions.assertStatusCode(response.statusCode(), 200);
        assertPlaylist(response.as(Playlist.class), requestPlaylist);
    }

    @Test
    public void testUpdatePlaylistDetails() {
        Playlist requestPlaylist = playlistBuilder("Updated Playlist 30", "Updated by POJOs", false);
        Response response = PlaylistApi.update(requestPlaylist, DataLoader.getInstance().getUpdatePlaylistId());
        assertions.assertStatusCode(response.statusCode(), 200);
    }

    @Test
    public void testShouldNotBeAbleToCreatePlaylistWithoutAName() {
        Playlist requestPlaylist = playlistBuilder("", "created by postman", false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertions.assertStatusCode(response.statusCode(), 400);
        assertions.assertError(response.as(Error.class), 400, "Missing required field: name");
    }

    @Test
    public void testShouldNotBeAbleToCreateAPlaylistWithExpiredAccessToken() {
        Playlist requestPlaylist = playlistBuilder("playlist 40", "created by postman", false);
        Response response = PlaylistApi.post(requestPlaylist, DataLoader.getInstance().getExpiredAccessToken());
        assertThat(response.statusCode(), equalTo(401));
        assertions.assertError(response.as(Error.class), 401, "The access token expired");
    }

    @Test
    public void testShouldNotBeAbleToCreateAPlaylistWithInvalidAccessToken() {
        Playlist requestPlaylist = playlistBuilder("playlist 40", "created by postman", false);
        Response response = PlaylistApi.post(requestPlaylist, DataLoader.getInstance().getInvalidAccessToken());
        assertions.assertStatusCode(response.statusCode(), 401);
        assertions.assertError(response.as(Error.class), 401, "Invalid access token");
    }

    public Playlist playlistBuilder(String name, String description, boolean _public) {
        return Playlist.builder().
                name(name).
                description(description).
                Public(_public).
                build();
    }

    public void assertPlaylist(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.isPublic(), equalTo(requestPlaylist.isPublic()));
    }
}
