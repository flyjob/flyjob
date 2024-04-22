package com.intellibucket.onnetwork.exchange.domain.core.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.exchange.CurrencyID;
import az.rock.lib.valueObject.CurrencyCode;


public class CurrencyRoot extends AggregateRoot<CurrencyID> {
    private CurrencyCode code;
    private String symbol;
    private String name;
    private String symbolNative;
    private String decimalDigits;
    private String rounding;
    private String namePlural;
    private String type;
}
