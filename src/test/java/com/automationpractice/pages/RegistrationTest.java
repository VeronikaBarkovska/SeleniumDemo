package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;
    private WebDriver driver;
    private AccountCreate accountCreate;
    private ProfilePage profilePage;
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


        System.setProperty("webdriver.chrome.driver","C:\\Users\\Вероника\\IdeaProjects\\selenium-1\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/");
    }

    @Test
    public void testCanNavigateToSignInPage(){
        mainPage = new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        Assert.assertTrue("Verify that SignIn Page is opened", signInPage.isOpenSignIn());
    }

    @Test
    public void testCanNavigateToRegistrationPage(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        Assert.assertTrue(registrationPage.isOpenRegistrPage());
    }

    @Test
    public void testFillRequiredFldInRegistrPageWithoutList(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        registrationPage.fillAndSubmitRegistFormWithoutList(accountCreate);
        Assert.assertTrue("Verify that alert massage is shown", registrationPage.isShownAlertMessage());
    }

    @Test
    public void testFillAllFldinRegistrPage(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        Assert.assertTrue(profilePage.isOpenProfilePage());

    }

    @After
    public void cleanup(){
        this.driver.quit();
    }

}
