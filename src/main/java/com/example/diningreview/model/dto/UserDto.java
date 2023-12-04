package com.example.diningreview.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor @Builder

public class UserDto {
    private Long userId;

    private String name;
    private String city;
    private String state;
    private String zipcode;

    private Boolean hasPeanutAllergies;
    private Boolean hasEggAllergies;
    private Boolean hasDairyAllergies;
}
