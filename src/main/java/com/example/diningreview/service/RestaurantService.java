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

import java.util.*;

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
    public Optional<RestaurantDto> getRestaurantById(long id){
        Optional<Restaurant> restaurant = repository.findById(id);
        //optional 의 map 함수를 이용해서 값 추출 후 restaurantToDto 메서드에 전달한다.
        return restaurant.map(mapper::restaurantToDto);
    }

    @Override
    public Page<RestaurantDto> searchRestaurant(String zipcode,
                                                Float peanutScore,
                                                Float eggScore,
                                                Float dairyScore,
                                                Float overallScore,
                                                Pageable pageable){

        //지정해 준 allergyScore 보다 높은 레스토랑 얻어오기.
        if(!ValidationUtils.isValidZipcode(zipcode)){
            throw new IllegalArgumentException("Invalid zipcode");
        }

        if(ValidationUtils.isInvalidScore(peanutScore, "peanutScore") ||
                ValidationUtils.isInvalidScore(eggScore, "eggScore") ||
                ValidationUtils.isInvalidScore(dairyScore, "dairyScore")){
            throw new IllegalArgumentException("Invalid allergy score arg");
        }

        Page<Restaurant> restaurants;
        restaurants = repository.findByZipcodeAndScores(zipcode, peanutScore, eggScore, dairyScore, overallScore, pageable);

        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for(Restaurant restaurant:restaurants){
            restaurantDtoList.add(mapper.restaurantToDto(restaurant));
        }

        return new PageImpl<>(restaurantDtoList, pageable, restaurants.getSize());
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
        if (ValidationUtils.isNull(dto.getZipcode(), "zipcode")) {
            return false;
        }
        if (ValidationUtils.isNull(dto.getPhone(), "restaurant phone number")) {
            return false;
        }


        if (ValidationUtils.isInvalidScore(dto.getDairyScore(), "dairy score")) {
            return false;
        }
        if (ValidationUtils.isInvalidScore(dto.getEggScore(), "egg score")) {
            return false;
        }
        if (ValidationUtils.isInvalidScore(dto.getPeanutScore(), "peanut score")) {
            return false;
        }

        return true;
    }
}
