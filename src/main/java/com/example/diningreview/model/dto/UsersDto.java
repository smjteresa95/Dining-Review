package com.example.diningreview.model.dto;

import com.example.diningreview.model.entity.Users;
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

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .city(city)
                .state(state)
                .zipcode(zipcode)
                .hasPeanutAllergies(hasPeanutAllergies)
                .hasDairyAllergies(hasDairyAllergies)
                .hasEggAllergies(hasEggAllergies)
                .build();
    }
}
