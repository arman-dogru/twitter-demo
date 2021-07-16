package com.getir.twitterdemo.config;

import org.json.simple.JSONObject;

public interface Service{
    public TrendData execute(String arg, int WOEID);
}
