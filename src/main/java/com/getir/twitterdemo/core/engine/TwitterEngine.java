package com.getir.twitterdemo.core.engine;

import com.getir.twitterdemo.core.data.TrendDataImpl;
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

    public TrendDataImpl searchTrend(String trendName, int WOEID) throws TwitterException, IllegalArgumentException {
        if(trendName.equals(""))
            throw new IllegalArgumentException("Please enter an argument to search in Top Trendings");

        Trends trends = twitter.getPlaceTrends(WOEID);
        List<Trend> trendList = Arrays.asList(trends.getTrends());

        Trend temp = trendList.stream().filter(trend -> trendName.equalsIgnoreCase(trend.getName())).findFirst().orElse(null);
        if (temp != null){
            return new TrendDataImpl(temp.getName(),temp.getTweetVolume(),true);
        }
        return new TrendDataImpl(trendName,0,false);
    }
}