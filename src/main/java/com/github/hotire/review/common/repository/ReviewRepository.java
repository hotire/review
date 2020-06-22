package com.github.hotire.review.common.repository;

import com.github.hotire.review.common.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
