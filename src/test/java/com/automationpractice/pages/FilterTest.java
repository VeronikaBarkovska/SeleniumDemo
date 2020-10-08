package com.automationpractice.pages;

import com.automationpractice.info.InfoCreate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class FilterTest extends BaseTest{
    private MainPage mainPage;
    private WebDriver driver;
    private CartPage cartPage;
    private InfoCreate infoCreate;
    private WomenPage womenPage;


    @BeforeMethod
    public void beforeMethod(){
        infoCreate = new InfoCreate().enterSearchText("Blouse");
    }

    @Test
    public void testPriceSliderIsWorked() {
        mainPage = new MainPage(driver);
        womenPage = mainPage.clickWomenTab();
        womenPage.scrollToItem();
        womenPage.dragLeftSlider();
        womenPage.dragRightSlider();
        String actualResult = "$25.25 - $45.23";
        String expectedResult = womenPage.getRange();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void testPriceFilterIsWorked() {
        mainPage = new MainPage(driver);
        womenPage = mainPage.clickWomenTab();
        womenPage.scrollToItem();
        womenPage.dragLeftSlider();
        womenPage.dragRightSlider();
        womenPage.checkPriceFilterWorking();
        Assert.assertTrue(womenPage.checkPriceFilterWorking());

    }
    @Test
    public void testAddToItemsAfterFilter() {
        mainPage = new MainPage(driver);
        womenPage = mainPage.clickWomenTab();
        womenPage.scrollToItem();
        womenPage.dragLeftSlider();
        womenPage.dragRightSlider();
        womenPage.clickListView();
        womenPage.clickAddToCartBtn1();
        womenPage.clickContinueShopping();
        womenPage.clickAddToCartBtn2();
        cartPage =womenPage.clickProceedToCheckout();
        Assert.assertTrue(cartPage.isOpenedCart());

    }

    @Test
    public void testCompareItemsWherePriceMore() {
        mainPage = new MainPage(driver);
        womenPage = mainPage.clickWomenTab();
        womenPage.scrollToItem();
        womenPage.dragLeftSlider();
        womenPage.dragRightSlider();
        womenPage.clickListView();
        womenPage.clickAddToCartBtn1();
        womenPage.clickContinueShopping();
        womenPage.clickAddToCartBtn2();
        cartPage =womenPage.clickProceedToCheckout();
        Assert.assertEquals(cartPage.compareTwoPriceItems(),28);
    }

    @Test
    public void testDeleteItemsWherePriceMore() {
        mainPage = new MainPage(driver);
        womenPage = mainPage.clickWomenTab();
        womenPage.scrollToItem();
        womenPage.dragLeftSlider();
        womenPage.dragRightSlider();
        womenPage.clickListView();
        womenPage.clickAddToCartBtn1();
        womenPage.clickContinueShopping();
        womenPage.clickAddToCartBtn2();
        cartPage =womenPage.clickProceedToCheckout();
        cartPage.deleteCompareTwoPriceItems();
        Assert.assertEquals(cartPage.getFirstTotalPriceWomenTab(),26);
    }

}

