package com.spotify.oauth2.api;

import com.spotify.oauth2.pojo.Error;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Assertions {
    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCodee) {
        MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(statusCodee.code));
    }
    @Step
    public void assertError(Error error, StatusCode statusCode) {
        MatcherAssert.assertThat(error.getError().getStatus(), Matchers.equalTo(statusCode.code));
        MatcherAssert.assertThat(error.getError().getMessage(), Matchers.equalTo(statusCode.message));
    }
}