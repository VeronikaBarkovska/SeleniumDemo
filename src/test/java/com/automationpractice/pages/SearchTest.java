package com.automationpractice.pages;

import com.automationpractice.info.InfoCreate;
import com.automationpractice.utils.TestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;


public class SearchTest extends BaseTest{
    private MainPage mainPage;
    private WebDriver driver;
    private InfoCreate infoCreate;
    private CartPage cartPage;
    private By ValueOfQuantity = By.xpath("//input[@name='quantity_2_7_0_0_hidden']");
    private TestHelper testHelper;


    @BeforeMethod
    public void beforeMethod(){
        infoCreate = new InfoCreate().enterSearchText("Blouse");
    }

    @Test
    public void testCanSearchInMainPage(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        Assert.assertTrue("Verify that search is worked",mainPage.isOpenedSearchResult());
    }

    @Test
    public void testCanSelectListView(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        Assert.assertTrue("Verify that ListView is worked",mainPage.isShownAddToCartBtn());
    }

    @Test
    public void testCanAddToCart(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        Assert.assertTrue("Verify that item is added",mainPage.isAddedItems());
    }
    @Test
    public void testCartIsOpened(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        Assert.assertTrue("Verify that cart is opened",cartPage.isOpenedCart());
    }
    @Test
    public void testCartWorkQuantity(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalProduct(3,1000);
        Assert.assertEquals("2",driver.findElement(ValueOfQuantity).getAttribute("value"));
    }
    @Test
    public void testCartTotalProduct() {
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalProduct(3,1000);
        Assert.assertEquals("$54.00",cartPage.checkTotalProduct());
    }
    @Test
    public void testCartTotalShipping(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalShipping(3,1000);
        Assert.assertEquals("$2.00",cartPage.checkTotalShipping());
    }
    @Test
    public void testCartTotalTax(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalTax(3,1000);
        Assert.assertEquals("$0.00",cartPage.checkTotalTax());
    }
    @Test
    public void testCartTotalPriceWithoutTax(){
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalPriceWithoutTax(3,1000);
        Assert.assertEquals("$56.00",cartPage.checkTotalPriceWithoutTax());
    }
    @Test
    public void testCartTotalPrice() {
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadTotalPrice(3,1000);
        Assert.assertEquals("$56.00",cartPage.checkTotalPrice());
    }
    @Test
    public void testCartDelete() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.enterAndSubmitSearch(infoCreate);
        mainPage.clickListView();
        mainPage.clickAddToCart();
        cartPage = mainPage.clickProceedToCheckout();
        cartPage.clickPlusQuantity();
        cartPage.clickDeleteBtn();
        Thread.sleep(2000);
        Assert.assertTrue("Verify that cart is empty",cartPage.isEmptyCart());
    }

}
