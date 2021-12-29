package com.spotify.oauth2.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId() {
        String property = properties.getProperty("client_id");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property client_id is not specified in the config.properties file");
    }

    public String getClientSecret() {
        String property = properties.getProperty("client_secret");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property client_secret is not specified in the config.properties file");
    }

    public String getGrantType() {
        String property = properties.getProperty("grant_type");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property grant_type is not specified in the config.properties file");
    }

    public String getRefreshToken() {
        String property = properties.getProperty("refresh_token");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property refresh_token is not specified in the config.properties file");
    }

    public String getUserId() {
        String property = properties.getProperty("user_id");
        if (property != null) {
            return property;
        } else throw new RuntimeException("property user_id is not specified in the config.properties file");
    }

}
