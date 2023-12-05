package com.example.diningreview.model.dto;

import com.example.diningreview.enums.ReviewStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
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
