package com.example.diningreview.repository;

import com.example.diningreview.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, String Zipcode);
    Iterable<Restaurant> findByZipCodeAndPeanutScoreOrderByPeanutScore(Long id);
    Iterable<Restaurant> findByZipCodeAndDairyScoreOrderByDairyScore(Long id);
    Iterable<Restaurant> findByZipCodeAndEggScoreOrderByEggScore(Long id);
}
