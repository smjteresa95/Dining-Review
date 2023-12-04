package com.example.diningreview.controller;

import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto dto){
        if(!service.validateRestaurant(dto)){
            return ResponseEntity.badRequest().body("Invalid restaurant data");
        }

        //DTO를 엔티티로 변환하고 저장 서비스 단에서 메서드

    }


}
