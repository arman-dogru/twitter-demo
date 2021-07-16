package com.getir.twitterdemo.core.service;

import com.getir.twitterdemo.core.engine.TwitterEngine;
import com.getir.twitterdemo.core.data.TrendDataImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Properties;

public class TwitterServiceImpl implements TwitterService {

    @Autowired
    TwitterEngine twitter;

    InputStream input;
    Properties prop;

    public TwitterServiceImpl(){
        twitter = new TwitterEngine();
    }

    public TrendDataImpl execute(String arg, int WOEID){
            try {
                return twitter.searchTrend(arg, WOEID);
            } catch (Exception e) {
                System.out.println("Could not Search");
                return null;
            }
    }
}
