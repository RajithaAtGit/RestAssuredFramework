package com.spotify.oauth2.test;

import com.spotify.oauth2.pojo.Error;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Assertions {
    @Step
    public void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(expectedStatusCode));
    }
    @Step
    public void assertError(Error error, int statusCode, String message) {
        MatcherAssert.assertThat(error.getError().getStatus(), Matchers.equalTo(statusCode));
        MatcherAssert.assertThat(error.getError().getMessage(), Matchers.equalTo(message));
    }
}