package com.FruitDistribution.FruitDistribution_API.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
//BE DESCRIPTIVE
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) //only maps to JSON what is not the default
@Table(name = "PickRequestTable")
public class PickRequest {
    @Id
    @UuidGenerator
    @Column(name="id", unique = true, updatable = false)
    private String id;
    private String userId;
    private String homeownerName;
    private String postDate;
    private String postTime;
    private String scheduledDate;
    private String scheduledTime;
    private String address;
    private String additionalInfo;
    private boolean isCompleted;
}
