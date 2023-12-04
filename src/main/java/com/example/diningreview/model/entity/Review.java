package com.example.diningreview.model.entity;

import com.example.diningreview.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name= "REVIEW")
@Getter
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String writer;
    private Long restaurantId;
    private Float peanutScore;
    private Float eggScore;
    private Float dairyScore;
    private String comment;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;
}
