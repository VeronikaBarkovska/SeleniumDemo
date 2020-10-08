package ua.i.finance.dataprovider;

import org.testng.annotations.DataProvider;
import ua.i.finance.BuilderData;
import ua.i.finance.pages.enums.CurrencyEnum;
import ua.i.finance.pages.enums.RateTypeEnum;

public class ConverterPageDataProvider {

    @DataProvider
    public Object[][] diffRate() {
        return new Object[][]{
                {new BuilderData()
                        .enterSum(0)
                        .enterRateType(RateTypeEnum.AMMOUNTRATE)
                        .enterCurrency(CurrencyEnum.UAH)
                        .build()},
                {new BuilderData()
                        .enterSum(20)
                        .enterRateType(RateTypeEnum.PRIVATBANK)
                        .enterCurrency(CurrencyEnum.EUR)
                        .build()},
                {new BuilderData()
                        .enterSum(200)
                        .enterRateType(RateTypeEnum.MONOBANK)
                        .enterCurrency(CurrencyEnum.PLN)
                        .build()},
                {new BuilderData()
                        .enterSum(2000)
                        .enterRateType(RateTypeEnum.UKRSIBBANK)
                        .enterCurrency(CurrencyEnum.USD)
                        .build()},
                {new BuilderData()
                        .enterSum(20000)
                        .enterRateType(RateTypeEnum.OSCHADBANK)
                        .enterCurrency(CurrencyEnum.RUB)
                        .build()}

        };


    }
}
