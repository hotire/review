package com.github.hotire.review.account;

import com.github.hotire.review.common.Review;
import com.github.hotire.review.strategy.ReviewStrategy;
import reactor.core.publisher.Mono;

public class AccountAraStrategy implements ReviewStrategy {

    @Override
    public Mono<Review> apply(Review review) {
        return Mono.empty();
    }
}
