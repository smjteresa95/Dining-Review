package com.example.diningreview.model.dto;

import com.example.diningreview.enums.ReviewStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor @Builder
public class ReviewDto {
    private long id;

    private String writer;
    private Long restaurantId;
    private Float peanutScore;
    private Float eggScore;
    private Float dairyScore;
    private String comment;

    private ReviewStatus status;
}
