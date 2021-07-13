package com.getir.twitterdemo.contoller;

import com.getir.twitterdemo.config.Login;
import com.getir.twitterdemo.config.TwitterEngine;
import com.getir.twitterdemo.config.TrendData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;


@RestController
@RequestMapping("twitter")
public class TwitterController {

    @GetMapping("/{arg},{WOEID}")
    public String getSegmentByCity(@PathVariable String arg, int WOEID) throws TwitterException, IllegalArgumentException {
        //localhost:8080/twitter/{getir},{23424969}
        try {
            TwitterEngine twitter = new TwitterEngine(Login.getConsumerKey(), Login.getConsumerSecret(), Login.getAccessToken(), Login.getTokenSecret());
        } catch (Exception e) {
            return "There was a problem with API Keys";
        }

        TwitterEngine twitter = new TwitterEngine(Login.getConsumerKey(), Login.getConsumerSecret(), Login.getAccessToken(), Login.getTokenSecret());
        TrendData trendData = twitter.searchTrend(arg, WOEID);
        return "Topic searched: " + trendData.getTrendName() + " || Currently trending: " + trendData.isTrending() + " || Tweet volume of the Trend: " + trendData.getTweetVolume();
    }

}
