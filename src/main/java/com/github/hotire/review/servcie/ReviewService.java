package com.github.hotire.review.servcie;

import com.github.hotire.review.common.entity.Review;
import reactor.core.publisher.Mono;

public interface ReviewService {
    default Mono<Review> approve(Review review) {
        return Mono.just(review);
    }
    default Mono<Review> reject(Review review) { return Mono.just(review); }
    default Mono<Review> pend(Review review) { return Mono.just(review); }
    default Mono<Review> review(Review review) { return Mono.just(review); }
}
