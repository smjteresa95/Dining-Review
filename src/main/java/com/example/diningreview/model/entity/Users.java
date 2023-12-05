package com.example.diningreview.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String city;
    private String state;
    private String zipcode;

    private Boolean hasPeanutAllergies;
    private Boolean hasEggAllergies;
    private Boolean hasDairyAllergies;
}
