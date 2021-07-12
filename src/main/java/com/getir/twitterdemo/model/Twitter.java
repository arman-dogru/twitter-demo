package com.getir.twitterdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Twitter {

    private int id;
    private String name;
}
