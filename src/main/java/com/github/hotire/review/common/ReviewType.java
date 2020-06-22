package com.github.hotire.review.common;

import com.github.hotire.review.account.AccountAraStrategy;
import com.github.hotire.review.account.AccountLmpStrategy;
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
