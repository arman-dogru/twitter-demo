package com.getir.twitterdemo.config;

import twitter4j.Trend;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Arrays;
import java.util.List;

public class TwitterEngine {
    ConfigurationBuilder cb;
    Twitter twitter;
    TwitterFactory tf;

    public TwitterEngine(String consumerKey, String consumerSecret,String accessToken, String tokenSecret){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(tokenSecret);
        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public TrendData searchTrend(String trendName, int WOEID) throws TwitterException, IllegalArgumentException {
        if(trendName.equals(""))
            throw new IllegalArgumentException("Please enter an argument to search in Top Trendings");

        Trends trends = twitter.getPlaceTrends(WOEID);
        List<Trend> trendList = Arrays.asList(trends.getTrends());

        Trend temp = trendList.stream().filter(trend -> trendName.equalsIgnoreCase(trend.getName())).findFirst().orElse(null);
        if (temp != null){
            return new TrendData(temp.getName(),temp.getTweetVolume(),true);
        }
        return new TrendData(trendName,0,false);
    }
}