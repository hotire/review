package com.github.hotire.review;

import com.github.hotire.review.strategy.ReviewStrategy;
import reactor.core.publisher.Mono;

public class AccountLmpStrategy implements ReviewStrategy {

    @Override
    public Mono<Review> apply(Review review) {
        return null;
    }
}
