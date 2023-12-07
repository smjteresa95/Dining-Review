package com.example.diningreview.repository;

import com.example.diningreview.model.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, String Zipcode);
    Page<Restaurant> findAll(Pageable pageable);


    Page<Restaurant> findByZipCode(String zipcode, Pageable pageable);

    //null인 경우 쿼리에서 무시되고, 인자가 제공된 경우에만 필터링 조건으로 사용한다.
    @Query("SELECT r FROM Restaurant r WHERE " +
            "(:zipcode IS NULL OR r.zipcode = :zipcode) AND " +
            "((:peanutScore IS NULL OR r.peanutScore >= :peanutScore) AND " +
            "(:eggScore IS NULL OR r.eggScore >= :eggScore) AND " +
            "(:dairyScore IS NULL OR r.dairyScore >= :dairyScore) AND" +
            "(:overallScore IS NULL OR r.overallScore >= :overallScore)) " +
            "ORDER BY r.overallScore DESC")
    Page<Restaurant> findByZipcodeAndScores(@Param("zipcode") String zipcode,
                                            @Param("peanutScore") Float peanutScore,
                                            @Param("eggScore") Float eggScore,
                                            @Param("dairyScore") Float dairyScore,
                                            @Param("overallScore") Float overallScore);

}
