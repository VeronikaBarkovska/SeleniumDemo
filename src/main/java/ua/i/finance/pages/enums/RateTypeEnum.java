package ua.i.finance.pages.enums;

public enum RateTypeEnum {
    FORWARD("Форвард"),
    NBU("НБУ"),
    ALPHABANK("Альфа-банк"),
    OSCHADBANK("Ощадбанк"),
    PRAVEKSBANK("Правэкс-Банк"),
    PRIVATBANK("ПриватБанк"),
    UKREKSSIBBANK("Укрэксимбанк"),
    AMMOUNTRATE("Средний курс"),
    UKRGASBANK("Укргазбанк"),
    PIVDENNIY("Пивденний"),
    KREDOBANK("Кредобанк"),
    INDUSTRIALBANK("Индустриалбанк"),
    TASKOMBANK("ТАСкомбанк"),
    KREDITVESTBANK("Кредитвест банк"),
    METABANK("Мета банк"),
    SBERBANK("Сбербанк России"),
    PROMINVESTBANK("Проминвестбанк"),
    PIRIUSBANKMKB("Пиреус Банк МКБ"),
    PUMB("ПУМБ"),
    ASVIO("Асвио"),
    BANKTHREEANDFOUR("Банк 3/4"),
    BANKINVESTICIYISBEREZHENIY("Банк инвестиций и сбережений"),
    ZEMELNIYKAPITAL("Земельный капитал"),
    KOMINVESTBANK("Коминвестбанк"),
    CREDITAGRICOLE("Credit Agricole"),
    CREDITDNEPR("Кредит Днепр"),
    INTERNATIONALINVEST("International Invest"),
    GLOBUS("Глобус"),
    UKRSIBBANK("УкрСиббанк"),
    CONKORD("Конкорд"),
    YUNEKSBANK("ЮНЕКС БАНК"),
    ALYANSBANK("АЛЬЯНС БАНК"),
    ABANK("А-Банк"),
    AGROPROSPERISBANK("Агропросперис Банк"),
    IBOXBANK("Айбокс Банк"),
    ACCORDBANK("Аккордбанк"),
    ALTBANK("Альтбанк"),
    BTABANK("БТА Банк"),
    GRANT("Грант"),
    EUROPROMBANK("Европромбанк"),
    CLIRINGOVIYDOM("Клиринговый Дом"),
    CREDIREUROPABANK("Кредит Европа Банк"),
    CRYSTALBANK("Кристалбанк"),
    MEGABANK("Мегабанк"),
    MISTOBANK("Мисто Банк"),
    OXIBANK("ОКСИ Банк"),
    PERVIYINVESTBANK("Первый Инвестиционный Банк"),
    POLTAVABANK("Полтава-Банк"),
    RADABANK("Радабанк"),
    MONOBANK("Monobank");

    private String name;

    RateTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
