package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySalaryID;
import az.rock.lib.valueObject.CurrencyCode;
import az.rock.lib.valueObject.vacancy.Payment;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class VacancySalaryRoot extends AggregateRoot<VacancySalaryID> {
    private VacancyID vacancy;

    private Boolean hasSalary;

    private CurrencyCode currencyCode;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private Boolean isEstimated;

    private Payment payment;
}
