package com.example.diningreview.service;

import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.repository.RestaurantRepository;
import com.example.diningreview.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public void save(RestaurantDto dto){
        repository.save(dto.toEntity());
    }

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
