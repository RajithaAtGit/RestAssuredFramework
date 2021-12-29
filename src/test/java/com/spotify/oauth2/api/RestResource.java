package com.spotify.oauth2.api;

import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.Route.API;
import static com.spotify.oauth2.api.Route.TOKEN;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(Object requestObject, String path, String access_token) {
        return given(getRequestSpec(access_token)).
                body(requestObject).
                when().
                post(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String access_token) {
        return given(getRequestSpec(access_token)).
                when().
                get(path).
                then().spec(getResponseSpec()).
                assertThat().
                extract().
                response();
    }

    public static Response update(Object requestObject, String path, String access_token) {
        return given(getRequestSpec(access_token)).
                body(requestObject).
                put(path).
                then().spec(getResponseSpec().contentType("")).
                extract().
                response();
    }

    public static Response postAccount(HashMap<String, String> formParams) {
        return given(getAccountRequestSpec()).
                formParams(formParams).
                when().
                post(API+TOKEN).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
