package com.spotify.oauth2.test;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void setUp(Method method) {
        System.out.println("STARTING TEST: "+method.getName());
        System.out.println("THREAD ID: "+ Thread.currentThread().getId());
    }
}
