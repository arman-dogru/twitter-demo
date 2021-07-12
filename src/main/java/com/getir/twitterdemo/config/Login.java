package com.getir.twitterdemo.config;

abstract public class Login {
    private static String consumerKey = ""; //Consumer Key goes here
    private static String consumerSecret = ""; //Secret Consumer Key
    private static String accessToken = ""; //AccessToken goes here
    private static String tokenSecret = ""; //Secret Access Token

    public static String getConsumerKey() {
        return consumerKey;
    }

    public static String getConsumerSecret() {
        return consumerSecret;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static String getTokenSecret() {
        return tokenSecret;
    }
}
