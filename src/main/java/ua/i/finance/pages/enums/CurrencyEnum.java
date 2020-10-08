package ua.i.finance.pages.enums;

public enum CurrencyEnum {

    EUR("EUR"),
    RUB("RUB"),
    UAH("UAH"),
    PLN("PLN"),
    USD("USD");

    private String name;

    CurrencyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
