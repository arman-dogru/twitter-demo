package com.getir.twitterdemo.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrendData {
    private String trendName;
    private int tweetVolume;
    private boolean trending;
}