package com.spotify.oauth2.test;

import com.spotify.oauth2.api.Assertions;
import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;

import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static com.spotify.oauth2.utils.FackerUtils.generateDescription;
import static com.spotify.oauth2.utils.FackerUtils.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTest  extends BaseTest{

    private final Assertions assertions = new Assertions();

    @Story("Create a Playlist in Spotify Account using Web API")
    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist")
    @Link(name = "post-playlists", type = "spotify-console-playlist")
    @TmsLink("198")
    @Issue("198")
    @Test(description = "Should be able to create a playlist on Spotify Account")
    @Description("This test case is used to check, Whether api can perform playlist creation with valid access token")
    public void testCreateAPlaylist() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(),false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertions.assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPlaylist(response.as(Playlist.class), requestPlaylist);
    }

    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/get-playlist")
    @Link(name = "get-playlist", type = "spotify-console-playlist")
    @Test(description = "Should be able to fetch a playlist form Spotify ")
    @Description("This test case is used to check, Whether api can fetch a playlist with valid access token")
    public void testGetAPlaylist() {
        Playlist requestPlaylist = playlistBuilder("New Playlist 001", "New Playlist 001 form POJO Class", false);
        Response response = PlaylistApi.get(DataLoader.getInstance().getPlaylistId());
        assertions.assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPlaylist(response.as(Playlist.class), requestPlaylist);
    }


    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/change-playlist-details")
    @Link(name = "put-playlist", type = "spotify-console-playlist")
    @Test(description = "Should be able to update a playlist details")
    @Description("This test case is used to check, Whether api can update a playlist details  with valid access token")
    public void testUpdatePlaylistDetails() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistApi.update(requestPlaylist, DataLoader.getInstance().getUpdatePlaylistId());
        assertions.assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    }

    @Story("Create a Playlist in Spotify Account using Web API")
    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist")
    @Link(value = "Spotify Web API Error REFERENCE", url = "https://developer.spotify.com/documentation/web-api/")
    @Link(name = "post-playlists", type = "spotify-console-playlist")
    @Test(description = "Should not be able to create a playlist without a name")
    @Description("This test case is used to check, Whether api can not create a playlist without a name and with valid access token ")
    public void testShouldNotBeAbleToCreatePlaylistWithoutAName() {
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertions.assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertions.assertError(response.as(Error.class), StatusCode.CODE_400);
    }

    @Story("Create a Playlist in Spotify Account using Web API")
    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist")
    @Link(value = "Spotify Web API Error REFERENCE", url = "https://developer.spotify.com/documentation/web-api/")
    @Link(name = "post-playlists", type = "spotify-console-playlist")
    @Test(description = "Should not be able to create a playlist with expired access token")
    @Description("This test case is used to check, Whether api can not create a playlist with expired access token")
    public void testShouldNotBeAbleToCreateAPlaylistWithExpiredAccessToken() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistApi.post(requestPlaylist, DataLoader.getInstance().getExpiredAccessToken());
        assertions.assertStatusCode(response.statusCode(),StatusCode.CODE_401_E);
        assertions.assertError(response.as(Error.class), StatusCode.CODE_401_E);
    }

    @Story("Create a Playlist in Spotify Account using Web API")
    @Link(value = "Spotify Web API PLAYLIST REFERENCE", url = "https://developer.spotify.com/documentation/web-api/reference/#/operations/create-playlist")
    @Link(value = "Spotify Web API Error REFERENCE", url = "https://developer.spotify.com/documentation/web-api/")
    @Link(name = "post-playlists", type = "spotify-console-playlist")
    @Test(description = "Should not be able to create a playlist with invalid access token")
    @Description("This test case is used to check, Whether api can not create a playlist with invalid access token")
    public void testShouldNotBeAbleToCreateAPlaylistWithInvalidAccessToken() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistApi.post(requestPlaylist, DataLoader.getInstance().getInvalidAccessToken());
        assertions.assertStatusCode(response.statusCode(), StatusCode.CODE_401_I);
        assertions.assertError(response.as(Error.class), StatusCode.CODE_401_I);
    }

    @Step
    public Playlist playlistBuilder(String name, String description, boolean _public) {
        return Playlist.builder().
                name(name).
                description(description).
                Public(_public).
                build();
    }

    @Step
    public void assertPlaylist(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.isPublic(), equalTo(requestPlaylist.isPublic()));
    }
}
