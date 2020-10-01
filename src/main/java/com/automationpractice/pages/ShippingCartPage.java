package com.automationpractice.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ShippingCartPage {

    private WebDriver driver;


    @FindBy(xpath = "//input[@id='cgv']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//button[@class = 'button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutShippingBtn;



    public ShippingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShippingCartPage clickAgreeCheckbox(){
        agreeCheckbox.click();
        return this;
    }

    public PaymentCartPage clickProceedToCheckoutShipping() {
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutShippingBtn).click();
        return new PaymentCartPage(driver);
    }
    public boolean isOpenShippingCartPage(){
        return agreeCheckbox.isEnabled();

    }




}
