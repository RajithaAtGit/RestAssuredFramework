package com.spotify.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(String access_token) {

//        baseURI = "https://api.spotify.com";
        baseURI=System.getProperty("BASE_URL");
        basePath = "/v1";
        return new RequestSpecBuilder().
                addHeader("Authorization", "Bearer " + access_token).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("ACCOUNT_BASE_URI")).
//                setBaseUri("https://accounts.spotify.com").
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).build();
    }
}

/*
*
*        mvn test -DBASE_URL="https://api.spotify.com" -DACCOUNT_BASE_URI="https://accounts.spotify.com"
* */