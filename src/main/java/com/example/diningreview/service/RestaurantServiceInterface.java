package com.example.diningreview.service;

import com.example.diningreview.model.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RestaurantServiceInterface {
    public void save(RestaurantDto dto);
    public Boolean validateRestaurant(RestaurantDto dto);
    public Page<RestaurantDto> getAllRestaurant(int page, int size);
    public Optional<RestaurantDto> getRestaurantById(long id);
    public Page<RestaurantDto> searchRestaurant(String zipCode, String allergy, Pageable pageable);

}
