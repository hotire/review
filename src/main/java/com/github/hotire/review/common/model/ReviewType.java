package com.github.hotire.review.common.model;

import com.github.hotire.review.account.AccountAraStrategy;
import com.github.hotire.review.account.AccountLmpStrategy;
import com.github.hotire.review.common.strategy.StrategyDefinition;
import com.github.hotire.review.common.strategy.StrategyDefinitions;
import com.github.hotire.review.media.MediaAraStrategy;
import com.github.hotire.review.media.MediaLmpStrategy;

public enum ReviewType {
    @StrategyDefinitions(
            araStrategy = @StrategyDefinition(value = AccountAraStrategy.class, order = 1),
            lmpStrategy = @StrategyDefinition(value = AccountLmpStrategy.class, order = 2)
    )
    ACCOUNT,

    @StrategyDefinitions(
            araStrategy = @StrategyDefinition(value = MediaAraStrategy.class, order = 1),
            lmpStrategy = @StrategyDefinition(value = MediaLmpStrategy.class, order = 2)
    )
    MEDIA

    ;
}
