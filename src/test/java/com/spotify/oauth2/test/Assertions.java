package com.spotify.oauth2.test;

import com.spotify.oauth2.pojo.Error;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Assertions {

    public void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(expectedStatusCode));
    }

    public void assertError(Error error, int statusCode, String message) {
        MatcherAssert.assertThat(error.getError().getStatus(), Matchers.equalTo(statusCode));
        MatcherAssert.assertThat(error.getError().getMessage(), Matchers.equalTo(message));
    }
}