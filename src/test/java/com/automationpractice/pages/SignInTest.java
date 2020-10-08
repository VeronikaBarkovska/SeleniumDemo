package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import org.junit.Assert;
import com.automationpractice.dataproviders.SignInPageDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignInTest extends BaseTest{
    private MainPage mainPage;
    private AccountCreate accountCreate;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;


    @BeforeMethod
    public void beforeMethod(){
        accountCreate = new AccountCreate()
                .enterEmail("veronikabark3535@gmail.com")
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
    public void testFillAllFldinRegistrPage(){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.enterEmailCrtFld(accountCreate.getEmail());
        registrationPage = signInPage.submitEmailCrtFld();
        profilePage = registrationPage.fillAllAndSubmitRegistForm(accountCreate);
        Assert.assertTrue(profilePage.isOpenProfilePage());}

    @Test(dataProvider = "registerNewUser", dataProviderClass = SignInPageDataProvider.class)
    public void testAlreadyRegistered(AccountCreate signInData){
        mainPage =new MainPage(driver);
        signInPage = mainPage.openSignInPage(driver);
        signInPage.fillAndSubmitEmailPasswd(signInData);
        Assert.assertTrue(signInPage.isShownAlertMessage());

    }




}
