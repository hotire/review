package com.github.hotire.review.common.strategy;

import com.github.hotire.review.common.model.ReviewType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StrategyService {

    private final ApplicationContext context;

    public List<ReviewStrategy> findReviewStrategies(final ReviewType reviewType) {
        final StrategyDefinitions strategyDefinitions = reviewType.getClass().getDeclaredAnnotation(StrategyDefinitions.class);
        return Stream.of(strategyDefinitions.araStrategy(), strategyDefinitions.lmpStrategy())
                     .sorted(Comparator.comparingInt(StrategyDefinition::order))
                     .collect(Collectors.toList())
                     .stream()
                     .map(StrategyDefinition::value)
                     .map(context::getBean)
                     .collect(Collectors.toList());
    }

    public ReviewStrategy findReviewStrategy(final ReviewType reviewType, final ReviewStrategyType reviewStrategyType) {
        final StrategyDefinitions strategyDefinitions = reviewType.getClass().getDeclaredAnnotation(StrategyDefinitions.class);
        return context.getBean(reviewStrategyType.getStrategyDefinition(strategyDefinitions).value());
    }


}
