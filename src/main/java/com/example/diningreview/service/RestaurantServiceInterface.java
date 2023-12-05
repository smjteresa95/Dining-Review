package com.example.diningreview.service;

import com.example.diningreview.model.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantServiceInterface {
    public void save(RestaurantDto dto);
    public Boolean validateRestaurant(RestaurantDto dto);
    public Page<RestaurantDto> getAllRestaurant(int page, int size);

}
