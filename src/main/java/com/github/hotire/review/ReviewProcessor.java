package com.github.hotire.review;

import com.github.hotire.review.strategy.ReviewRepository;
import com.github.hotire.review.strategy.ReviewStrategy;
import com.github.hotire.review.strategy.StrategyDefinitions;
import com.github.hotire.review.strategy.StrategyDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReviewProcessor {
    private final ReviewRepository reviewRepository;
    private final ApplicationContext context;

    public Mono<Review> findById(final Long id) {
        return Mono.create(sink -> sink.success(reviewRepository.findById(id).orElse(null)));
    }

    public void service(final Long id) {
        findById(id)
                .map(ReviewContext::new)
                .map(reviewContext -> reviewContext.addStrategies(getReviewService(reviewContext.getReviewType())))
                .flatMap(ReviewContext::execute)
                .block();
    }

    public List<ReviewStrategy> getReviewService(final ReviewType reviewType) {
        final StrategyDefinitions strategyDefinitions = reviewType.getClass().getDeclaredAnnotation(StrategyDefinitions.class);
        return Stream.of(strategyDefinitions.araStrategy(), strategyDefinitions.lmpStrategy())
                     .sorted(Comparator.comparingInt(StrategyDefinition::order))
                     .collect(Collectors.toList())
                     .stream()
                     .map(StrategyDefinition::value)
                     .map(context::getBean)
                     .collect(Collectors.toList());
    }

}
