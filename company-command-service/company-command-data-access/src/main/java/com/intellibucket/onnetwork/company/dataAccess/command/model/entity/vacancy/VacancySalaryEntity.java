package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.CurrencyCode;
import az.rock.lib.valueObject.vacancy.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancy_salaries")
@Entity(name = "VacancySalaryEntity")
public class VacancySalaryEntity extends BaseEntity {
    @OneToOne
    private VacancyEntity vacancy;

    @Column(name = "has_salary")
    private Boolean hasSalary;

    @Column(name = "currency")
    private CurrencyCode currencyCode;

    @Column(name = "start_amount")
    private BigDecimal startAmount;

    @Column(name = "end_amount")
    private BigDecimal endAmount;

    @Column(name = "is_estimated",nullable = false, columnDefinition = "boolean default false")
    private Boolean isEstimated;

    @Enumerated(EnumType.STRING)
    private Payment payment;
}
