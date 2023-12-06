package com.example.diningreview.repository;

import com.example.diningreview.model.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, String Zipcode);
    Page<Restaurant> findAll(Pageable pageable);

    Page<Restaurant> findByZipCode(String zipcode, Pageable pageable);

    Page<Restaurant> findByZipCodeAndPeanutScoreOrderByPeanutScore(String zipCode, Pageable pageable);
    Page<Restaurant> findByZipCodeAndDairyScoreOrderByDairyScore(String zipCode, Pageable pageable);
    Page<Restaurant> findByZipCodeAndEggScoreOrderByEggScore(String zipCode, Pageable pageable);

    Page<Restaurant> findByPeanutScoreOrderByPeanutScore(Pageable pageable);
    Page<Restaurant> findByDairyScoreOrderByDairyScore(Pageable pageable);
    Page<Restaurant> findByEggScoreOrderByEggScore(Pageable pageable);
}
