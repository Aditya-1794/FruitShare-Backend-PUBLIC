package com.FruitDistribution.FruitDistribution_API.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.UuidGenerator;
//BE DESCRIPTIVE
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) //only maps to JSON what is not the default
@Table(name = "PickRequest")
public class PickRequest {
    @Id
    @UuidGenerator
    @Column(name="id", unique = true, updatable = false)
    private String id;
    private String homeownerName;
    private String postDate;
    private String postTime; //change to built-in time feature
    private String scheduledDate;
    private String scheduledTime;
    private String address; //maybe split later
    private String fruitType;
    private String imageURL;
    private boolean isCompleted;
}
