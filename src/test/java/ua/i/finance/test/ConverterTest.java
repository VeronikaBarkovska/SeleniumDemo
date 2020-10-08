package ua.i.finance.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.i.finance.BuilderData;
import ua.i.finance.dataprovider.ConverterPageDataProvider;
import ua.i.finance.pages.ConverterPage;

public class ConverterTest extends BaseTest{

    private ConverterPage converterPage;

    @BeforeMethod
    public void beforeMethod(){
        converterPage = new ConverterPage(driver);
    }

    @Test(dataProvider = "diffRate", dataProviderClass = ConverterPageDataProvider.class)
    public void testConverterSell(BuilderData converterData){
        converterPage = new ConverterPage(driver);
        converterPage.fillConverter(converterData);
        Assert.assertTrue(converterPage.checkCountOfRate(converterData));


    }
    @Test(dataProvider = "diffRate", dataProviderClass = ConverterPageDataProvider.class)
    public void testConverterBuy(BuilderData converterData){
        converterPage = new ConverterPage(driver);
        converterPage.clickBuyLink();
        converterPage.fillConverter(converterData);
        Assert.assertTrue(converterPage.checkCountOfRate(converterData));


    }



}
