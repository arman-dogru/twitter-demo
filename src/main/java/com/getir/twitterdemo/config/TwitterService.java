package com.getir.twitterdemo.config;

import lombok.Builder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class TwitterService implements Service {

    public TwitterService(){}

    public String execute(String arg, int WOEID){
        try {
            InputStream input = new FileInputStream("src/main/resources/application.properties");
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/application.properties"));
            TwitterEngine twitter = new TwitterEngine(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("accessToken"), prop.getProperty("tokenSecret"));
            TrendData trendData = twitter.searchTrend(arg, WOEID);
            return "Topic searched: " + trendData.getTrendName() + " || Currently trending: " + trendData.isTrending() + " || Tweet volume of the Trend: " + trendData.getTweetVolume();
        } catch (Exception e) {
            return "There was a problem with API Keys";
        }
    }
}
