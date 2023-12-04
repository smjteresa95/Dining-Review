package com.example.diningreview.repository;

import com.example.diningreview.enums.ReviewStatus;
import com.example.diningreview.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStatus(ReviewStatus reviewStatus);
    List<Review> findByStatusAndRestaurantId(ReviewStatus reviewStatus, Long RestaurantId);
}
