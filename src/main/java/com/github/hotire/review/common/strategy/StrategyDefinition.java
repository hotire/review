package com.github.hotire.review.common.strategy;

public @interface StrategyDefinition {
    int order() default 1;
    Class<? extends ReviewStrategy> value() default ReviewStrategy.class;
}
