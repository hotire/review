package com.github.hotire.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.common.model.ReviewEvent;
import com.github.hotire.review.common.repository.ReviewRepository;
import com.github.hotire.review.servcie.ReviewServiceResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewKafkaListener {
    private final ObjectMapper objectMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewServiceResolver reviewServiceResolver;

    @KafkaListener
    public void listen(final String event) {
        final ReviewEvent reviewEvent = objectMapper.convertValue(event, ReviewEvent.class);
        final Review review = reviewRepository.findById(reviewEvent.getReview().getId()).orElse(new Review(reviewEvent.getReview().getReviewType()));

        reviewServiceResolver.resolve(review.getReviewType(), reviewEvent.getReviewStrategy());


    }
}
