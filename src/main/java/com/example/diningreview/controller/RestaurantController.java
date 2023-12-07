package com.example.diningreview.controller;

import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<RestaurantDto>> getAllRestaurant(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                                @RequestParam(value = "size", required = false, defaultValue = "10") int size){
        return ResponseEntity.ok(service.getAllRestaurant(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<RestaurantDto>> searchRestaurant(@RequestParam(value = "zipcode", required = false) String zipcode,
                                                                @RequestParam(value = "peanutScore", required = false) Float peanutScore,
                                                                @RequestParam(value = "eggScore", required = false) Float eggScore,
                                                                @RequestParam(value = "dairyScore", required = false) Float dairyScore,
                                                                @RequestParam(value = "overallScore", required = false) Float overallScore,
                                                                @RequestParam(value="page", required=false, defaultValue = "0") int page,
                                                                @RequestParam(value="size", required=false, defaultValue = "10") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(service.searchRestaurant(zipcode, peanutScore, eggScore, dairyScore, overallScore, pageRequest));
    }
}
