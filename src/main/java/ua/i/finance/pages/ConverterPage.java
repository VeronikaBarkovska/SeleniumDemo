package ua.i.finance.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ua.i.finance.BuilderData;
import ua.i.finance.pages.enums.CurrencyEnum;
import ua.i.finance.pages.enums.RateTypeEnum;

public class ConverterPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='currency_amount']")
    private WebElement sumFld;

    @FindBy(xpath = "//li[@id='buy']")
    private WebElement buyLink;

    @FindBy(xpath = "//li[@id='sell']")
    private WebElement sellLink;

    @FindBy(xpath = "//select[@name='converter_bank']")
    private WebElement rateTypeDropDownList;

    @FindBy(xpath = "//p[@id='UAH']/input[@id='currency_exchange']")
    private WebElement resultUAHFld;

    @FindBy(xpath = "//p[@id='EUR']/input[@id='currency_exchange']")
    private WebElement resultEURFld;

    @FindBy(xpath = "//p[@id='RUB']/input[@id='currency_exchange']")
    private WebElement resultRUBFld;

    @FindBy(xpath = "//p[@id='PLN']/input[@id='currency_exchange']")
    private WebElement resultPLNFld;

    @FindBy(xpath = "//p[@id='USD']/input[@id='currency_exchange']")
    private WebElement resultUSDFld;

    @FindBy(xpath = "//p[@id='UAH']/input[@id='currency_rate']")
    private WebElement rateUAHFld;

    @FindBy(xpath = "//p[@id='EUR']/input[@id='currency_rate']")
    private WebElement rateEURFld;

    @FindBy(xpath = "//p[@id='RUB']/input[@id='currency_rate']")
    private WebElement rateRUBFld;

    @FindBy(xpath = "//p[@id='PLN']/input[@id='currency_rate']")
    private WebElement ratePLNFld;

    @FindBy(xpath = "//p[@id='USD']/input[@id='currency_rate']")
    private WebElement rateUSDFld;

    @FindBy(xpath = "//select[@id='converter_currency']")
    private WebElement currencyDropDownList;


    public ConverterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillSum(int sum){
        sumFld.sendKeys(String.valueOf(sum));
    }

    public void selectRate(RateTypeEnum rateType){
        Select value = new Select(rateTypeDropDownList);
        value.selectByVisibleText(rateType.getName());
    }
    public void selectCurrency(CurrencyEnum currency){
        Select value = new Select(currencyDropDownList);
        value.selectByValue(currency.getName());
    }


    public void fillConverter(BuilderData data) {
        fillSum(data.getSum());
        selectRate(data.getRateType());
        selectCurrency(data.getCurrency());
    }

    public boolean checkCountOfRate(BuilderData data){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String rate1 = rateEURFld.getAttribute("value"); //Wrong, empty String
        String result1 = resultEURFld.getAttribute("value");//Wrong, empty String
        int sum = data.getSum();
        double rate=Double.parseDouble(rate1);
        double result=Double.parseDouble(result1);
        if(sum*rate == result){
            return true;
        }
        return false;
    }

    public void clickBuyLink(){
        new TestHelper(driver).waitUntilElementWillBeClickable(buyLink).click();
    }



}
