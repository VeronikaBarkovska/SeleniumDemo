package com.automationpractice.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressCartPage {

    private WebDriver driver;

    @FindBy(xpath = "(//li[@class= 'address_firstname address_lastname'])[2]")
    private WebElement billingAddressName;

    @FindBy(xpath = "(//li[@class= 'address_company'])[2]")
    private WebElement billingAddressCompany;

    @FindBy(xpath = "(//li[@class= 'address_address1 address_address2'])[2]")
    private WebElement billingAddressAddress;

    @FindBy(xpath = "(//li[@class= 'address_city address_state_name address_postcode'])[2]")
    private WebElement billingAddressCityStatePostCode;

    @FindBy(xpath = "(//li[@class= 'address_country_name'])[2]")
    private WebElement billingAddressCountry;

    @FindBy(xpath = "(//li[@class= 'address_phone'])[2]")
    private WebElement billingAddressPhone;

    @FindBy(xpath = "(//li[@class= 'address_phone_mobile'])[2]")
    private WebElement billingAddressPhoneMobile;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement proceedToCheckoutAddressBtn;





    public AddressCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkBillingAddressName(){
        return billingAddressName.getText();
    }
    public String checkBillingAddressCompany(){
        return billingAddressCompany.getText();
    }
    public String checkBillingAddressAddress(){
        return billingAddressAddress.getText();
    }
    public String checkBillingAddressCityStatePostcode(){
        return billingAddressCityStatePostCode.getText();
    }
    public String checkBillingAddressCountry(){
        return billingAddressCountry.getText();
    }
    public String checkBillingAddressPhone(){
        return billingAddressPhone.getText();
    }
    public String checkBillingAddressPhoneMobile(){
        return billingAddressPhoneMobile.getText();
    }
    public String checkBillingAddress(){
        String billingaddress = checkBillingAddressName()+" "
        +checkBillingAddressCompany()+" "
        +checkBillingAddressAddress()+" "
        +checkBillingAddressCityStatePostcode()+" "
        +checkBillingAddressCountry()+" "
        +checkBillingAddressPhone()+" "
        +checkBillingAddressPhoneMobile();
        return billingaddress;
    }

    public ShippingCartPage clickProceedToCheckoutAddress() {
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutAddressBtn).click();
        return new ShippingCartPage(driver);
    }


}
