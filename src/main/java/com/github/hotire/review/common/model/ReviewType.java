package com.github.hotire.review.common.model;

import com.github.hotire.review.account.AccountAbaStrategy;
import com.github.hotire.review.account.AccountAraStrategy;
import com.github.hotire.review.ad.AdAbaStrategy;
import com.github.hotire.review.common.strategy.StrategyDefinition;
import com.github.hotire.review.common.strategy.StrategyDefinitions;
import com.github.hotire.review.media.MediaAbaStrategy;
import com.github.hotire.review.media.MediaAraStrategy;

public enum ReviewType {
    @StrategyDefinitions(
            araStrategy = @StrategyDefinition(value = AccountAraStrategy.class, order = 1),
            abaStrategy = @StrategyDefinition(value = AccountAbaStrategy.class, order = 2)
    )
    ACCOUNT(false, true),

    @StrategyDefinitions(
            araStrategy = @StrategyDefinition(value = MediaAraStrategy.class, order = 1),
            abaStrategy = @StrategyDefinition(value = MediaAbaStrategy.class, order = 2)
    )
    MEDIA(true, true),

    @StrategyDefinitions(abaStrategy = @StrategyDefinition(value = AdAbaStrategy.class))
    AD(false, true)

    ;







    private final boolean araStrategy;
    private final boolean lmpStrategy;

    ReviewType(boolean araStrategy, boolean lmpStrategy) {
        this.araStrategy = araStrategy;
        this.lmpStrategy = lmpStrategy;
    }
}
