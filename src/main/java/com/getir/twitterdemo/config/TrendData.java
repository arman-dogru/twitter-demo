package com.getir.twitterdemo.model;

import lombok.Data;
import twitter4j.Trend;

@Data
public class TrendData {
    private int tweetVolume;
    private String trendName;
    private boolean trending;

    public TrendData(String trendName){
        this.trendName = trendName;
        this.trending = false;
        this.tweetVolume = 0; //not Trending
    }

    public TrendData(Trend trend){
        tweetVolume = trend.getTweetVolume();
        trendName = trend.getName();
        this.trending = true;
    }
}