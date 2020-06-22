package com.github.hotire.review.strategy;

public enum ReviewStrategyType {
    ARA {
        @Override
        StrategyDefinition getStrategyDefinition(StrategyDefinitions strategyDefinitions) {
            return strategyDefinitions.araStrategy();
        }
    },
    LMP {
        @Override
        StrategyDefinition getStrategyDefinition(StrategyDefinitions strategyDefinitions) {
            return strategyDefinitions.lmpStrategy();
        }
    }
    ;

    abstract StrategyDefinition getStrategyDefinition(final StrategyDefinitions strategyDefinitions);
}
