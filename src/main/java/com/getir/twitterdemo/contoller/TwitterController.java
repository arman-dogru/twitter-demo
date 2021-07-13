package com.getir.twitterdemo.contoller;

import com.getir.twitterdemo.config.TwitterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("twitter")
public class TwitterController {

    @GetMapping("/{arg},{WOEID}")
    public String getSegmentByCity(@PathVariable String arg, int WOEID) {
        //localhost:8080/twitter/{getir},{23424969}
        return TwitterService.execute(arg,WOEID);
    }
}
