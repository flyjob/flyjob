package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy;

import az.rock.lib.valueObject.CurrencyCode;
import az.rock.lib.valueObject.vacancy.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancySalaryCommand {
    private Boolean hasSalary;

    private CurrencyCode currencyCode;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private Boolean isEstimated;

    private Payment payment;
}
