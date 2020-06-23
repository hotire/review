package com.github.hotire.review.common.model;

import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.common.strategy.ReviewStrategy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReviewContext {
    @Getter
    private final Review review;
    @Getter
    private final List<ReviewStrategy> strategies = new ArrayList<>();

    public ReviewContext addStrategy(final ReviewStrategy strategy) {
        this.strategies.add(strategy);
        return this;
    }

    public ReviewContext addStrategies(final List<ReviewStrategy> strategy) {
        this.strategies.addAll(strategy.stream()
                                       .map(reviewService -> reviewService)
                                       .collect(Collectors.toList()));
        return this;
    }

    public Mono<Review> execute() {
       return Mono.empty();
    }

    public ReviewType getReviewType() {
        return review.getReviewType();
    }
}
