package com.example.diningreview.service;

import com.example.diningreview.enums.CuisineType;
import com.example.diningreview.model.dto.RestaurantDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void RestaurantValidationTest(){

        RestaurantDto restaurantDto = RestaurantDto.builder()
                .name("name")
                .type(CuisineType.KOREAN)
                .address("123 st")
                .city("Fairfax")
                .state("VA")
                .zipCode("12345")
                .phone("123-456-7890")
                .website("restaurant.com")
                .peanutScore(4.0f)
                .dairyScore(2.5f)
                .eggScore(4.0f)
                .overallScore(4.0f)
                .build();

        assertThat(service.validateRestaurant(restaurantDto)).isTrue();

    }
}
