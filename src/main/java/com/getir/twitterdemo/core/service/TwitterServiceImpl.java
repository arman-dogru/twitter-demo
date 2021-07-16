package com.getir.twitterdemo.core.service;

import com.getir.twitterdemo.core.engine.TwitterEngine;
import com.getir.twitterdemo.core.data.TrendData;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterServiceImpl implements TwitterService {

    @Autowired
    TwitterEngine twitter;

    public TwitterServiceImpl(){ twitter = new TwitterEngine(); }

    public TrendData execute(String arg, int WOEID){
            try {
                return twitter.searchTrend(arg, WOEID);
            } catch (Exception e) {
                System.out.println("Could not Search");
                return null;
            }
    }
}
