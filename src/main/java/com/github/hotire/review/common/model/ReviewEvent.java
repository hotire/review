package com.github.hotire.review.common.model;

import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.servcie.ReviewStrategy;
import lombok.Data;

@Data
public class ReviewEvent {
    private Review review;
    private ReviewStrategy reviewStrategy;
}
