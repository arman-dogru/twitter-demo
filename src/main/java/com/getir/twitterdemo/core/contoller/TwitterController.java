package com.getir.twitterdemo.core.contoller;

import com.getir.twitterdemo.core.service.TwitterService;
import com.getir.twitterdemo.core.data.TrendDataImpl;
import com.getir.twitterdemo.core.service.TwitterServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("twitter")
public class TwitterController {

    @GetMapping("/{arg},{WOEID}")
    public TrendDataImpl getSegmentByCity(@PathVariable String arg, int WOEID){
        //localhost:8080/twitter/{getir},{23424969}
        TwitterService service = new TwitterServiceImpl();

        return service.execute(arg,WOEID);
    }
}
