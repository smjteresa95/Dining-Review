package com.example.diningreview.repository;

import com.example.diningreview.model.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, String Zipcode);
    Page<Restaurant> findAll(Pageable pageable);
    //Iterable 인터페이스는 List, set 등의 Collection interface 보다 상위. JPA와 호환된다.
    Iterable<Restaurant> findByZipCodeAndPeanutScoreOrderByPeanutScore(String zipCode, Float peanutScore, Pageable pageable);
    Iterable<Restaurant> findByZipCodeAndDairyScoreOrderByDairyScore(String zipCode, Float dairyScore);
    Iterable<Restaurant> findByZipCodeAndEggScoreOrderByEggScore(String zipCode, Float eggScore);
}
