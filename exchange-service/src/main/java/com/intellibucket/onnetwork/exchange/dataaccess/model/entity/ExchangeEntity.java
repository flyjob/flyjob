package com.intellibucket.onnetwork.exchange.dataaccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.CurrencyCode;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ExchangeEntity")
@Table(name = "exchanges", schema = "exchange")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeEntity extends BaseEntity {
    @Column(name = "fetch_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fetchDate;
    @Enumerated(EnumType.STRING)
    private CurrencyCode baseCurrency;
    @Enumerated(EnumType.STRING)
    private CurrencyCode targetCurrency;
    @Column(name = "rate", nullable = false)
    private BigDecimal rate;
}
