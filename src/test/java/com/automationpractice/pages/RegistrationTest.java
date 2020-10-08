package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class RegistrationTest extends BaseTest{
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;
    private AccountCreate accountCreate;
    private ProfilePage profilePage;
    Random random = new Random();

    @BeforeMethod
    public void beforeMethod(){
        accountCreate = new AccountCreate()
                .enterEmail("veronikabark"+random.nextInt()+"@gmail.com")
                .enterFirstName("Veronika")
                .enterLastName("Barkovska")
                .enterPassword("12345678Admin")
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

    }

    @Test
    public void testCanNavigateToSignInPage(){
        mainPage = new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        Assert.assertTrue(signInPage.isOpenSignIn(),"Verify that SignIn Page is opened");
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
        Assert.assertTrue(registrationPage.isShownAlertMessage(), "Verify that alert massage is shown");
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


}
