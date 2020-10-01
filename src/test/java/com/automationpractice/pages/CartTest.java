package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import com.automationpractice.info.InfoCreate;
import com.automationpractice.pages.enums.SortEnum;
import com.automationpractice.utils.TestHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CartTest {
    private MainPage mainPage;
    private WebDriver driver;
    private InfoCreate infoCreate;
    private CartPage cartPage;
    private SignInPage signInPage;
    private AccountCreate accountCreate;
    private ProfilePage profilePage;
    private RegistrationPage registrationPage;
    private DressesPage dressesPage;
    private TestHelper testHelper;
    private AddressCartPage addressCartPage;
    private ShippingCartPage shippingCartPage;
    private PaymentCartPage paymentCartPage;
    Random random = new Random();


    @Before
    public void setup(){
        accountCreate = new AccountCreate()
                .enterEmail("veronikabark"+random.nextInt()+"@gmail.com")
                .enterFirstName("Veronika")
                .enterLastName("Barkovska")
                .enterPassword("12345678")
                .enterFirstNameAddr("Veronika")
                .enterLastNameAddr("Barkovska")
                .enterAddress1("Volinskiy")
                .enterCity("Kiev")
                .enterZipCode("02000")
                .enterPhoneMobile("0671111111")
                .enterAliasAddress("MyAddress")
                .enterTitle("Mrs.")
                .enterDay("26")
                .enterMonth("2")
                .enterYear("1998")
                .enterCompany("BarkovskaComp")
                .enterState("Alabama")
                .enterAddress2("Arizona")
                .enterCountry("United States")
                .enterAddinfo("Cool")
                .enterHomePhone("+380445558888")
                .build();
        infoCreate = new InfoCreate().enterSortType(SortEnum.PRICELOWESTFIRST);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Вероника\\IdeaProjects\\selenium-1\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void testFillAllFldinRegistrPage(){
        mainPage =new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        profilePage = new ProfilePage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        signInPage.submitEmailCrtFld();
        registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        Assert.assertTrue(profilePage.isOpenProfilePage());

    }

    @Test
    public void testIsOpenDressesPage(){
        mainPage =new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        profilePage = new ProfilePage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        signInPage.submitEmailCrtFld();
        registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        profilePage.clickDressesTab();
        dressesPage = new DressesPage(driver);
        Assert.assertTrue("Verify that Dresses Page is opened", dressesPage.isOpenDressesPage());
    }

    @Test
    public void testSortByPrice(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.selectSortSearch(infoCreate.getSortType());
        testHelper = new TestHelper(driver);
        testHelper.waitForLoadScreen(5,5000);
        Assert.assertEquals("Verify that Sort By is worked", "$16.40", dressesPage.getFirstItemPrice());

    }

    @Test
    public void testAddSpecialTwoItems(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        dressesPage.selectSortSearch(SortEnum.PRICELOWESTFIRST);
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickAddToCartBtn2();
        cartPage = dressesPage.clickProceedToCheckout();
        Assert.assertTrue("Verify that two items in cart", cartPage.checkItems());
    }
    @Test
    public void testAddSpecialTwoItemsTotal(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        //dressesPage.selectSortSearch(SortEnum.PRICELOWESTFIRST);
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickAddToCartBtn2();
        cartPage = dressesPage.clickProceedToCheckout();
        String item1 = cartPage.checkTotalItem1();
        String item2 = cartPage.checkTotalItem2();
        String totalProducts = cartPage.checkTotalProducts();
        String actualResult = "Total item 1: " + item1 + ", Total item 2: " + item2 + ", Total Products: " + totalProducts;
        String expectedResult = "Total item 1: $26.00, Total item 2: $50.99, Total Products: $76.99";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSaleItem(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickSelectedAddToCartBtn();
        cartPage = dressesPage.clickProceedToCheckout();
        String actualResult = cartPage.checkSalePrice();
        String oldPrice = "$20.50";
        String saleText = "-20%";
        String newPrice = "$16.40";
        String expectedResult = oldPrice + " "+ saleText+" "+newPrice;
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testAddressBilling(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickSelectedAddToCartBtn();
        cartPage = dressesPage.clickProceedToCheckout();
        addressCartPage = cartPage.clickProceedToCheckout();
        String actualResult = addressCartPage.checkBillingAddress();
        String expectedResult = accountCreate.getFirstNameAddr()+" "
                +accountCreate.getLastNameAddr()+" "
                +accountCreate.getCompany()+" "
                +accountCreate.getAddress1()+" "
                +accountCreate.getAddress2()+" "
                +accountCreate.getCity()+", "
                +accountCreate.getState()+" "
                +accountCreate.getPostcode()+" "
                +accountCreate.getCountry()+" "
                +accountCreate.getHomePhone()+" "
                +accountCreate.getPhone_mobile();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testShippingCart(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickSelectedAddToCartBtn();
        cartPage = dressesPage.clickProceedToCheckout();
        addressCartPage = cartPage.clickProceedToCheckout();
        shippingCartPage = addressCartPage.clickProceedToCheckoutAddress();
        shippingCartPage.clickAgreeCheckbox();
        Assert.assertTrue("Verify that Shipping Cart Page is opened", shippingCartPage.isOpenShippingCartPage());
    }

    @Test
    public void testPaymentCart(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        dressesPage = profilePage.clickDressesTab();
        dressesPage.clickListView();
        dressesPage.scrollToItem();
        dressesPage.selectLSize();
        dressesPage.clickAddToCartBtn1();
        dressesPage.clickContinueShopping();
        dressesPage.clickSelectedAddToCartBtn();
        cartPage = dressesPage.clickProceedToCheckout();
        String expectedResult = cartPage.checkAllTotalPrice()+ " "+ cartPage.checkSalePrice();
        addressCartPage = cartPage.clickProceedToCheckout();
        shippingCartPage = addressCartPage.clickProceedToCheckoutAddress();
        shippingCartPage.clickAgreeCheckbox();
        paymentCartPage = shippingCartPage.clickProceedToCheckoutShipping();
        String actualResult = paymentCartPage.checkTotalPrice()+ " "+ paymentCartPage.checkSalePrice();
        Assert.assertEquals(expectedResult, actualResult);
    }




    @After
    public void cleanup(){
        this.driver.quit();
    }


}
