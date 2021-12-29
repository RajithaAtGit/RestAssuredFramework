package com.spotify.oauth2.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getPlaylistId() {
        String property = properties.getProperty("playlist_id");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property playlist_id is not specified in the config.properties file");
    }

    public String getUpdatePlaylistId() {
        String property = properties.getProperty("update_playlist_id");
        if (property != null) {
            return property;
        } else
            throw new RuntimeException("property update_playlist_id is not specified in the config.properties file");
    }

    public String getExpiredAccessToken() {
        String property = properties.getProperty("expired_access_token");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property expired_access_token is not specified in the config.properties file");
    }

    public String getInvalidAccessToken() {
        String property = properties.getProperty("invalid_access_token");
        if (property != null) {
            return property;
        } else
            throw new RuntimeException("property invalid_access_token is not specified in the config.properties file");
    }

}
