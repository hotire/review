package com.github.hotire.review.common.strategy;

public @interface StrategyDefinitions {
    StrategyDefinition araStrategy() default @StrategyDefinition();
    StrategyDefinition abaStrategy() default @StrategyDefinition();
}
