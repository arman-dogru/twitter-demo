package com.getir.twitterdemo.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TwitterService implements Service {

    public TwitterService(){}

    public TrendData execute(String arg, int WOEID){
        try {
            InputStream input = new FileInputStream("src/main/resources/application.properties");
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/application.properties"));
            TwitterEngine twitter = new TwitterEngine(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("accessToken"), prop.getProperty("tokenSecret"));
            return twitter.searchTrend(arg, WOEID);
        } catch (Exception a) {
            System.out.println("OAuth Keys are not correct");
            return null;
            //return "Topic searched: " + trendData.getTrendName() + " || Currently trending: " + trendData.isTrending() + " || Tweet volume of the Trend: " + trendData.getTweetVolume()
        }
    }
}
