package com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.schedulers.abstracts;

public interface AbstractCurrencyScheduler {
    void latestRateScheduler();

    void exchangeInfoScheduler();

}
