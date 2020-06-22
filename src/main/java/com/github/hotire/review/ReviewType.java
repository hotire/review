package com.github.hotire.review;

import com.github.hotire.review.strategy.StrategyDefinition;
import com.github.hotire.review.strategy.StrategyDefinitions;

public enum ReviewType {
    @StrategyDefinitions(
            araStrategy = @StrategyDefinition(value = AccountAraStrategy.class, order = 1),
            lmpStrategy = @StrategyDefinition(value = AccountLmpStrategy.class, order = 2)
    )
    ACCOUNT,

    MEDIA

    ;
}
