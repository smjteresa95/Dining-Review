package com.example.diningreview.model.dto;

import com.example.diningreview.enums.CuisineType;
import com.example.diningreview.model.entity.Restaurant;
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

    public Restaurant toEntity(){
        return Restaurant.builder()
                .name(name)
                .type(type)
                .address(address)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .phone(phone)
                .website(website)
                .peanutScore(peanutScore)
                .eggScore(eggScore)
                .dairyScore(dairyScore)
                .overallScore(overallScore)
                .build();
    }
}
