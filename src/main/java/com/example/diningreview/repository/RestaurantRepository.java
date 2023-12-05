package com.example.diningreview.repository;

import com.example.diningreview.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, String Zipcode);
    Iterable<Restaurant> findByZipCodeAndPeanutScoreOrderByPeanutScore(String zipCode, Float peanutScore);
    Iterable<Restaurant> findByZipCodeAndDairyScoreOrderByDairyScore(String zipCode, Float dairyScore);
    Iterable<Restaurant> findByZipCodeAndEggScoreOrderByEggScore(String zipCode, Float eggScore);
}
