package com.FruitDistribution.FruitDistribution_API.domain;

import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;
//BE DESCRIPTIVE
public class PickRequest {
    @Id
    @UuidGenerator
    private String ID;
    private String homeownerName;
    private String postDate;
    private String postTime; //change to built-in time feature
    private String scheduledDate;
    private String scheduledTime;
    private String address; //maybe split later
    private String fruitType;
    private String imageURL;
}
