package com.getir.twitterdemo.config;

import org.json.simple.JSONObject;

public interface Service{
    public JSONObject execute(String arg, int WOEID);
}
