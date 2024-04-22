package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum CurrencyCode {
    EUR("€"),
    USD("$"),
    AZN("₼"),
    TRY("₺"),
    JPY("¥"),
    BGN("лв"),
    CZK("Kč"),
    DKK("kr"),
    GBP("£"),
    HUF("Ft"),
    PLN("zł"),
    RON("lei"),
    SEK("sek"),
    CHF("chf"),
    ISK("kr"),
    NOK("kr"),
    HRK("kn"),
    RUB("₽"),
    AUD("$"),
    BRL("R$"),
    CAD("$"),
    CNY("¥"),
    HKD("$"),
    IDR("Rp"),
    ILS("₪"),
    INR("inr"),
    KRW("krw"),
    MXN("$"),
    MYR("RM"),
    NZD("$"),
    PHP("₱"),
    SGD("$"),
    THB("฿"),
    ZAR("R"),
    NONE("NONE");

    private final String sign;

    CurrencyCode(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
