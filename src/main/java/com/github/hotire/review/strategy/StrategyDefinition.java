package com.github.hotire.review.strategy;

public @interface StrategyDefinition {
    int order() default 1;
    Class<? extends ReviewStrategy> value() default ReviewStrategy.class;
}
