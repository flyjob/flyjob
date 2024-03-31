package com.intellibucket.onnetwork.exchange.domain.presentation.dto.feign.response;

import az.rock.lib.valueObject.CurrencyCode;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Data
@ToString
public class ExchangeRates {
    private Map<CurrencyCode, BigDecimal> data;

    public ExchangeRates() {
        this.data = new HashMap<>();
    }

    public static ExchangeRates of() {
        return new ExchangeRates();
    }

    public void addCurrencyRate(CurrencyCode currencyCode, BigDecimal rate) {
        this.data.put(currencyCode, rate);
    }

    public void addCurrencyRate(String currencyCode, BigDecimal rate) {
        this.addCurrencyRate(CurrencyCode.valueOf(currencyCode.toUpperCase()), rate);
    }
}
