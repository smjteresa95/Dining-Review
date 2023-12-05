package com.example.diningreview.service;

import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.model.entity.Restaurant;
import com.example.diningreview.repository.RestaurantRepository;
import com.example.diningreview.service.mapper.Mapper;
import com.example.diningreview.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService implements RestaurantServiceInterface{

    private final RestaurantRepository repository;
    private final Mapper mapper;

    @Override
    public void save(RestaurantDto dto){
        repository.save(dto.toEntity());
    }

    @Override
    public Page<RestaurantDto> getAllRestaurant(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Restaurant> allRestaurants = repository.findAll(pageRequest);

        List<RestaurantDto> allRestaurantsDto = new ArrayList<>();
        for(Restaurant restaurant:allRestaurants) {
            allRestaurantsDto.add(mapper.restaurantToDto(restaurant));
        }

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allRestaurants.getSize());
        allRestaurantsDto = allRestaurantsDto.subList(start, end);

        return new PageImpl<>(allRestaurantsDto, pageRequest, allRestaurantsDto.size());
    }

    @Override
    public Boolean validateRestaurant(RestaurantDto dto){

        //필수 필드 검증
        if (ValidationUtils.isNull(dto.getName(), "restaurant name")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getType(), "restaurant type")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getAddress(), "street address")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getCity(), "city")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getZipCode(), "zipcode")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getPhone(), "restaurant phone number")) {
            return false;
        }


        if (!ValidationUtils.isValidateScore(dto.getDairyScore(), "dairy score")) {
            return false;
        }
        if (!ValidationUtils.isValidateScore(dto.getEggScore(), "egg score")) {
            return false;
        }
        if (!ValidationUtils.isValidateScore(dto.getPeanutScore(), "peanut score")) {
            return false;
        }

        return true;
    }
}
