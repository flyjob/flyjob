package com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.schedulers.concretes;

import com.intellibucket.onnetwork.exchange.domain.presentation.dto.feign.response.ExchangeRates;
import com.intellibucket.onnetwork.exchange.domain.presentation.lib.aspect.annotations.JExecutionTime;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.schedulers.abstracts.AbstractCurrencyScheduler;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.services.command.abstracts.AbstractCurrencyCommandDomainPresentationService;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.services.command.abstracts.AbstractExchangeCommandDomainPresentationService;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.currency.abstracts.FreeCurrencyAPIClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FreeCurrencyAPIScheduler implements AbstractCurrencyScheduler {
    @Value("${external-api.free-currency.key}")
    private String apiKey;
    private final FreeCurrencyAPIClient freeCurrencyAPIClient;
    private final AbstractCurrencyCommandDomainPresentationService currencyCommandDomainPresentationService;
    private final AbstractExchangeCommandDomainPresentationService exchangeCommandDomainPresentationService;


    @Override
    @Scheduled(fixedRateString = "${ws.values.scheduler.latest-rate}")
    @JExecutionTime
    public void latestRateScheduler() {
        log.info("Latest rate scheduler started");
        var currencyRates = ExchangeRates.of();
        this.freeCurrencyAPIClient.fetchAllLatestRates(this.apiKey)
                .get("data").fields().forEachRemaining(entry -> {
                    currencyRates.addCurrencyRate(entry.getKey(), entry.getValue().decimalValue());
                });
        this.exchangeCommandDomainPresentationService.saveLatestRates(currencyRates);
    }

    @Override
    @Scheduled(cron = "${ws.values.scheduler.exchange-info-rate}")
    //This scheduler must be executed every 1 month
    public void exchangeInfoScheduler() {
        log.info("Historical rate scheduler");
    }

}
