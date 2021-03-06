package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistApi {


    @Step
    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(requestPlaylist, USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken());
    }

    @Step
    // for Invalid and Expired access token
    public static Response post(Playlist requestPlaylist, String access_token) {
        return RestResource.post(requestPlaylist, USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, access_token);
    }

    @Step
    public static Response get(String playlist_id) {
        return RestResource.get(PLAYLISTS + "/" + playlist_id, getToken());
    }

    @Step
    public static Response update(Playlist requestPlaylist, String playlist_id) {
        return RestResource.update(requestPlaylist, PLAYLISTS + "/" + playlist_id, getToken());
    }
}