package com.example.diningreview.model.entity;

import com.example.diningreview.enums.CuisineType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="RESTAURANT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String zipcode;

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
