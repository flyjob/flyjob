package com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.services.command.concretes;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.onnetwork.exchange.domain.presentation.dto.feign.response.ExchangeRates;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.services.command.abstracts.AbstractExchangeCommandDomainPresentationService;
import org.springframework.stereotype.Service;

@InputPort
@Service
public class ExchangeCommandDomainPresentationService implements AbstractExchangeCommandDomainPresentationService {
    @Override
    public void saveLatestRates(ExchangeRates currencyRates) {

    }
}
