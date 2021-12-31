package com.spotify.oauth2.utils;

import com.github.javafaker.Faker;

public class FackerUtils {

    public static String generateName() {
        Faker faker = new Faker();
        return faker.regexify("[A-Z-a-z-0-9,_-]{15}");
    }
    public static String generateDescription(){
        Faker faker = new Faker();
        return faker.regexify("[A-z-0-9_@./#&+-]{50}");
    }
}
