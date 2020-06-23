package com.github.hotire.review.common.strategy;

public enum ReviewStrategyType {
    ARA {
        @Override
        StrategyDefinition getStrategyDefinition(StrategyDefinitions strategyDefinitions) {
            return strategyDefinitions.araStrategy();
        }
    },
    ABA {
        @Override
        StrategyDefinition getStrategyDefinition(StrategyDefinitions strategyDefinitions) {
            return strategyDefinitions.abaStrategy();
        }
    }
    ;



    abstract StrategyDefinition getStrategyDefinition(final StrategyDefinitions strategyDefinitions);
}
