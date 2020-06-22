package com.github.hotire.review.strategy;

public @interface StrategyDefinitions {
    StrategyDefinition araStrategy() default @StrategyDefinition();
    StrategyDefinition lmpStrategy() default @StrategyDefinition();
}
