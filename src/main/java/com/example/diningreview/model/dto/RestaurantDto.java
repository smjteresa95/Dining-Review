package com.example.diningreview.model.dto;

import com.example.diningreview.enums.CuisineType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class RestaurantDto {
    private Long id;

    private String name;
    private CuisineType type;

    private String address;
    private String city;
    private String state;
    private String zipCode;

    private String phone;
    private String website;

    private Float peanutScore;
    private Float eggScore;
    private Float dairyScore;
    private Float overallScore;
}
