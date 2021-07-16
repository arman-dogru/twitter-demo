package com.getir.twitterdemo.core.service;

import com.getir.twitterdemo.core.data.TrendDataImpl;

public interface TwitterService {
    TrendDataImpl execute(String arg, int WOEID);
}
