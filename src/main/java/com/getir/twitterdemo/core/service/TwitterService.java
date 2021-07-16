package com.getir.twitterdemo.core.service;

import com.getir.twitterdemo.core.data.TrendData;

public interface TwitterService {
    TrendData execute(String arg, int WOEID);
}
