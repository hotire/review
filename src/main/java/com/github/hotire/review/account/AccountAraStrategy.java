package com.github.hotire.review.account;

import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.common.strategy.ReviewStrategy;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountAraStrategy implements ReviewStrategy {

    @Override
    public Mono<Review> apply(Review review) {
        return Mono.empty();
    }
}
