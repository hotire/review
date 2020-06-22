package com.github.hotire.review.strategy;

import com.github.hotire.review.common.Review;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public interface ReviewStrategy extends Function<Review, Mono<Review>> {
    default Mono<Review> apply(Review review) {
        return Mono.just(review);
    }
}
