package com.getir.twitterdemo.core.data;

import lombok.Data;

@Data
public class TrendData {
    private String trendName;
    private int tweetVolume;
    private boolean trending;

    public TrendData(String trendName, int tweetVolume, boolean trending) {
        this.trendName = trendName;
        this.tweetVolume = tweetVolume;
        this.trending = trending;
    }
}