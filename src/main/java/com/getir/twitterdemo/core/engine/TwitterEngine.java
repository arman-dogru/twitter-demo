package com.getir.twitterdemo.core.engine;

import com.getir.twitterdemo.core.data.TrendData;
import org.springframework.stereotype.Service;
import twitter4j.Trend;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public  class TwitterEngine{
    Twitter twitter;

    public TwitterEngine() {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (Exception e) {
            System.out.println("Path file Error");
        }
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(prop.getProperty("consumerKey"));
        cb.setOAuthConsumerSecret(prop.getProperty("consumerSecret"));
        cb.setOAuthAccessToken(prop.getProperty("accessToken"));
        cb.setOAuthAccessTokenSecret(prop.getProperty("tokenSecret"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public TrendData searchTrend(String trendName, int WOEID) {
        if(trendName.equals(""))
            throw new IllegalArgumentException("Please enter an argument to search in Top Trendings");
        Trends trends;
        List<Trend> trendList = null;
        try {
            trends = twitter.getPlaceTrends(WOEID);
            trendList = Arrays.asList(trends.getTrends());
        } catch (Exception e) {
            System.out.println("OAuth working");
        }
        Trend temp = trendList.stream().filter(trend -> trendName.equalsIgnoreCase(trend.getName())).findFirst().orElse(null);
        if (temp != null){
            return new TrendData(temp.getName(),temp.getTweetVolume(),true);
        }
        return new TrendData(trendName,0,false);
    }
}