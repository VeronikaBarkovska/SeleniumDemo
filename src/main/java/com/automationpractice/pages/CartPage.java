package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPage {
    private By PlusQuantityBtn = By.xpath("(//i[@class='icon-plus'])[1]");
    private WebDriver driver;
    private By totalProduct = By.xpath("//td[@id='total_product']");
    private By totalShipping = By.xpath("//td[@id='total_shipping']");
    private By totalPriceWithoutTax = By.xpath("//td[@id='total_price_without_tax']");
    private By totalTax = By.xpath("//td[@id='total_tax']");
    private By totalPrice = By.xpath("//td[@id='total_price_container']");
    private By deleteBtn = By.xpath("//i[@class='icon-trash']");
    private By emptyCartMessage = By.xpath("//p[@class='alert alert-warning']");



    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpenedCart(){
        WebElement PlusQuantityElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(PlusQuantityBtn));
        return PlusQuantityElm.isDisplayed();
    }
    public void clickPlusQuantity(){
        WebElement PlusQuantityElm= driver.findElement(PlusQuantityBtn);
        PlusQuantityElm.click();
    }

    public String checkTotalPrice() throws InterruptedException {
        WebElement totalPriceElm = driver.findElement(totalPrice);
        Thread.sleep(1000);
        return totalPriceElm.getText();
    }

    public String checkTotalProduct() throws InterruptedException {
        WebElement totalProductElm = driver.findElement(totalProduct);
        Thread.sleep(1000);
        return totalProductElm.getText();
    }
    public String checkTotalShipping() throws InterruptedException {
        WebElement totalShippingElm = driver.findElement(totalShipping);
        Thread.sleep(1000);
        return totalShippingElm.getText();
    }

    public String checkTotalPriceWithoutTax() throws InterruptedException {
    WebElement totalPriceWithoutTaxElm =driver.findElement(totalPriceWithoutTax);
        Thread.sleep(1000);
    return totalPriceWithoutTaxElm.getText();
    }

    public String checkTotalTax() throws InterruptedException {
        WebElement totalTaxElm = driver.findElement(totalTax);
        Thread.sleep(1000);
        return totalTaxElm.getText();
    }
    public void clickDeleteBtn(){
        WebElement DeleteElm= driver.findElement(deleteBtn);
        DeleteElm.click();
    }
    public boolean isEmptyCart(){
        WebElement DeleteMessageElm = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(emptyCartMessage));
        return DeleteMessageElm.isDisplayed();

    }

    }



