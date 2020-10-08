package com.automationpractice.pages;
import com.automationpractice.info.InfoCreate;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FilterTest extends BaseTest{
    private MainPage mainPage;
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
        Assert.assertEquals(expectedResult, actualResult);

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

