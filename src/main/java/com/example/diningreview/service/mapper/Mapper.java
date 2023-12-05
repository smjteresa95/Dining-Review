package com.example.diningreview.service.mapper;

import com.example.diningreview.enums.CuisineType;
import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.model.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public RestaurantDto restaurantToDto(Restaurant entity){
        return RestaurantDto.builder()
                .name(entity.getName())
                .type(CuisineType.valueOf(entity.getType().toString()))
                .address(entity.getAddress())
                .city(entity.getCity())
                .state(entity.getState())
                .zipCode(entity.getZipCode())
                .phone(entity.getPhone())
                .website(entity.getWebsite())
                .peanutScore(entity.getPeanutScore())
                .eggScore(entity.getEggScore())
                .dairyScore(entity.getDairyScore())
                .overallScore(entity.getOverallScore())
                .build();
    }

}
