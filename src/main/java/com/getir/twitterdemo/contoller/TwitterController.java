package com.getir.twitterdemo.contoller;


import com.getir.twitterdemo.config.TwitterEngine;
import com.getir.twitterdemo.config.TrendData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("twitter")
public class TwitterController {

    @GetMapping("/{arg},{WOEID}")
    public String getSegmentByCity(@PathVariable String arg, int WOEID) throws TwitterException, IllegalArgumentException {
        //localhost:8080/twitter/{getir},{23424969}
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
