package com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.services.command.abstracts;

import com.intellibucket.onnetwork.exchange.domain.presentation.dto.feign.response.ExchangeRates;

public interface AbstractExchangeCommandDomainPresentationService {
    void saveLatestRates(ExchangeRates currencyRates);
}
