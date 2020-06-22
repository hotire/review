package com.github.hotire.review;

import com.github.hotire.review.strategy.ReviewRepository;
import com.github.hotire.review.strategy.StrategyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReviewProcessor {
    private final ReviewRepository reviewRepository;
    private final StrategyService strategyService;

    public Mono<Review> findById(final Long id) {
        return Mono.create(sink -> sink.success(reviewRepository.findById(id).orElse(null)));
    }

    public void service(final Long id) {
        findById(id)
                .map(ReviewContext::new)
                .map(reviewContext -> reviewContext.addStrategies(strategyService.findReviewStrategies(reviewContext.getReviewType())))
                .flatMap(ReviewContext::execute)
                .block();
    }
}
