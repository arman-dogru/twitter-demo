package com.getir.twitterdemo.config;

import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TwitterService implements Service {

    public TwitterService(){}

    public JSONObject execute(String arg, int WOEID){
        try {
            InputStream input = new FileInputStream("src/main/resources/application.properties");
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/application.properties"));
            TwitterEngine twitter = new TwitterEngine(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("accessToken"), prop.getProperty("tokenSecret"));
            TrendData trendData = twitter.searchTrend(arg, WOEID);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Topic Searched", trendData.getTrendName());
            jsonObject.put("Currently trending", trendData.isTrending());
            jsonObject.put("Tweet volume of the Trend", trendData.getTweetVolume());
            //return "Topic searched: " + trendData.getTrendName() + " || Currently trending: " + trendData.isTrending() + " || Tweet volume of the Trend: " + trendData.getTweetVolume();
            return jsonObject;
        } catch (Exception e) {
            return new JSONObject();
        }
    }
}
