package com.intellibucket.onnetwork.exchange.domain.core.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.exchange.ExchangeID;
import az.rock.lib.valueObject.CurrencyCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExchangeRoot extends AggregateRoot<ExchangeID> {
    private LocalDateTime fetchDate;
    private CurrencyCode baseCurrency;
    private CurrencyCode targetCurrency;
    private BigDecimal rate;
}
