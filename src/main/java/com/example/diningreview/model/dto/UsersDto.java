package com.example.diningreview.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class UsersDto {
    private Long userId;

    private String name;
    private String city;
    private String state;
    private String zipcode;

    private Boolean hasPeanutAllergies;
    private Boolean hasEggAllergies;
    private Boolean hasDairyAllergies;
}
