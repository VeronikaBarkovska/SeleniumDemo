package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PaymentCartPage {

    private WebDriver driver;



    @FindBy(xpath = "(//span[@class='price'])[4]")
    private WebElement totalItem1;

    @FindBy(xpath = "(//span[@class='price'])[7]")
    private WebElement totalItem2;

    @FindBy(xpath = "//td[@id='total_product']")
    private WebElement totalProducts;

    @FindBy(xpath = "(//span[@class='old-price'])[1]")
    private WebElement totalItemOldPrice1;

    @FindBy(xpath = "(//span[@class = 'price-percent-reduction small'])[1]")
    private WebElement saleText;

    @FindBy(xpath = "//span[@class = 'price special-price']")
    private WebElement newPrice;





    public PaymentCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean checkItems(){
        if(totalItem1.isDisplayed() && totalItem2.isDisplayed()){
            return true;
        }
        return false;
    }

    public String checkTotalItem1(){
        return totalItem1.getText();
    }

    public String checkTotalItem2(){
        return totalItem2.getText();
    }

    public String checkTotalProducts(){
        return totalProducts.getText();
    }

    public String checkTotalPrice(){
        return checkTotalItem1()
                +checkTotalItem2()
                +checkTotalProducts();
    }

    public String checkSaleText(){
        return saleText.getText();
    }

    public String checkOldPrice(){
        return totalItemOldPrice1.getText();
    }

    public String checkNewPrice(){return newPrice.getText();}

    public String checkSalePrice(){
        return checkOldPrice()
                +checkSaleText()
                +checkNewPrice();
    }









}
