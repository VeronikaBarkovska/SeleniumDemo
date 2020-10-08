package com.automationpractice.utils;

import com.automationpractice.pages.CartPage;
import com.automationpractice.pages.DressesPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {
    private WebDriver driver;



    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementWillBeClickable(WebElement element){
    return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isPageLoad(){
        return getJsExecutor(driver).executeScript("return document.readyState").equals("complete");
    }
    public JavascriptExecutor getJsExecutor(WebDriver driver){
        return (JavascriptExecutor) driver;
    }




    public void waitForLoadScreen(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if (new DressesPage(driver).getFirstItemPrice() == "$16.40")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadTotalPrice(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if ((new CartPage(driver).checkTotalPrice()) == "$56.00")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadTotalProduct(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if ((new CartPage(driver).checkTotalProduct()) == "$54.00")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadTotalShipping(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if ((new CartPage(driver).checkTotalShipping()) == "$2.00")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadTotalPriceWithoutTax(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if ((new CartPage(driver).checkTotalPrice()) == "$56.00")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadTotalTax(long iteration, long milliseconds){
        for(int i=0; i< iteration;i++) {
            try{
                if ((new CartPage(driver).checkTotalPrice()) == "$0.00")
                    break;}catch (NoSuchElementException e){e.printStackTrace();}
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
