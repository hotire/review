package com.github.hotire.review.strategy;

import com.github.hotire.review.common.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
