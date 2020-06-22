package com.github.hotire.review.common;

import com.github.hotire.review.strategy.ReviewStrategy;
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
    private final List<Mono<Review>> strategies = new ArrayList<>();

    public ReviewContext addStrategy(final ReviewStrategy strategy) {
        this.strategies.add(strategy.apply(review));
        return this;
    }

    public ReviewContext addStrategies(final List<ReviewStrategy> strategy) {
        this.strategies.addAll(strategy.stream()
                                       .map(reviewService -> reviewService.apply(review))
                                       .collect(Collectors.toList()));
        return this;
    }

    public Mono<Review> execute() {
        return Mono.when(strategies)
                   .thenReturn(review);
    }

    public ReviewType getReviewType() {
        return review.getReviewType();
    }
}
