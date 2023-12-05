package com.example.diningreview.controller;

import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.service.RestaurantService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        service.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantDto>> getAllRestaurant(@RequestParam("page") int page,
                                                                @RequestParam("size") int size){
        return ResponseEntity.ok(service.getAllRestaurant(page, size));
    }
}
