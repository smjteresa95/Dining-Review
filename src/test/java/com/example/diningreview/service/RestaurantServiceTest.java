package com.example.diningreview.service;

import com.example.diningreview.enums.CuisineType;
import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.model.entity.Restaurant;
import com.example.diningreview.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService service;
    @Autowired
    private RestaurantRepository repository;

    @BeforeEach
    public void setUp(){
        Restaurant restaurant = Restaurant.builder()
                .name("name")
                .type(CuisineType.KOREAN)
                .address("123 st")
                .city("Fairfax")
                .state("VA")
                .zipcode("12345")
                .phone("123-456-7890")
                .website("restaurant.com")
                .peanutScore(4.0f)
                .dairyScore(2.5f)
                .eggScore(4.0f)
                .overallScore(4.0f)
                .build();
        repository.save(restaurant);
    }

    @Test
    public void restaurantValidationTest(){

        RestaurantDto restaurantDto = RestaurantDto.builder()
                .name("name")
                .type(CuisineType.KOREAN)
                .address("123 st")
                .city("Fairfax")
                .state("VA")
                .zipcode("12345")
                .phone("123-456-7890")
                .website("restaurant.com")
                .peanutScore(4.0f)
                .dairyScore(2.5f)
                .eggScore(4.0f)
                .overallScore(4.0f)
                .build();

        assertThat(service.validateRestaurant(restaurantDto)).isTrue();
    }

    @Test
    public void findRestaurantById(){
        Optional<RestaurantDto> dto = service.getRestaurantById(1);
        assertThat(dto.get().getCity()).isEqualTo("Fairfax");
    }
}
