package com.example.diningreview.model.entity;

import com.example.diningreview.enums.CuisineType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.checkerframework.checker.nullness.qual.NonNull;

@Entity
@Table(name="RESTAURANT")
@Getter
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CuisineType type;

    private String address;
    private String city;
    private String state;
    private String zipCode;

    private String phone;
    private String website;

    @Column(nullable = false)
    private Float peanutScore;
    @Column(nullable = false)
    private Float eggScore;
    @Column(nullable = false)
    private Float dairyScore;
    @Column(nullable = false)
    private Float overallScore;
}
