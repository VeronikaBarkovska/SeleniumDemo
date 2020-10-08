package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;


public class SignInPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailFld;

    @FindBy(id = "email_create")
    private WebElement emailCreateFld;

    @FindBy(xpath = "//i[@class = 'icon-user left']")
    private WebElement emailCreateBtn;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwdFld;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInBtn;

    @FindBy(xpath = "(//div[@class='alert alert-danger'])[1]")
    private WebElement alertMessageSignIn;

    private By FirstNameRegistPageFld = By.xpath("//input[@id='customer_firstname']");
    private By signInLink = By.xpath("//a[@class = 'login']");
    private By contactUsLink = By.id("contact-link");
    private By logoImg = By.xpath("//img[@class = 'logo img-responsive']");
    private By searchFld = By.xpath("//input[@id = 'search_query_top']");
    private By searchBtn = By.name("submit_search");
    private By cartBtn = By.xpath("//div[@class = 'shopping_cart']");
    private By womenBtn =By.xpath("//a[@title = 'Women']");
    private By dressesBtn =By.xpath("//a[@title = 'Dresses']");
    private By tshirtsBtn =By.xpath("//a[@title = 'T-shirts']");
    private By homeBtn = By.xpath("//a[@class = 'home']");
    private By AuthpgBtn = By.xpath("//span[@class = 'navigation_page']");
    private By forgotPasswdLink = By.xpath("//a[@title = 'Recover your forgotten password']");
    private By newsletterFld = By.id("newsletter-input");
    private By newsletterBtn = By.name("submitNewsletter");
    private By followFacebookBtn = By.xpath("//li[@class = 'facebook']");
    private By followTwitterBtn = By.xpath("//li[@class = 'twitter']");
    private By followYoutubeBtn = By.xpath("//li[@class = 'youtube']");
    private By followGoogleBtn = By.xpath("//li[@class = 'google-plus']");
    private By footerWomenLk = By.xpath("//li[@class = 'last']//span[@class='grower CLOSE']");
    private By footerSpecialsLk = By.xpath("//a[@title = 'Specials']");
    private By footerNewProdLk = By.xpath("//a[@title = 'New products']");
    private By footerBstSellLk = By.xpath("//a[@title = 'Best sellers']");
    private By footerOurStrsLk = By.xpath("//a[@title = 'Our stores']");
    private By footerMyOrdersLk = By.xpath("//a[@title = 'My orders']");
    private By footerMyCredSlipLk = By.xpath("//a[@title = 'My credit slips']");
    private By footerMyAddrLk = By.xpath("//a[@title = 'My addresses']");
    private By footerMyinfLk = By.xpath("//a[@title = 'Manage my personal information']");

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isOpenSignIn() {
        return new TestHelper(driver).waitUntilElementWillBeClickable(emailFld).isDisplayed();
    }

    public void enterEmailCrtFld(String email) {
        emailCreateFld.sendKeys(email);
    }

    public void fillEmail(String email){emailFld.sendKeys(email);}

    public void fillPasswd(String passwd){passwdFld.sendKeys(passwd);}

    public void fillAndSubmitEmailPasswd(AccountCreate accountCreate) {
        fillEmail(accountCreate.getEmail());
        fillPasswd(accountCreate.getPasswd());
        new TestHelper(driver).waitUntilElementWillBeClickable(signInBtn).click();
    }


    public RegistrationPage submitEmailCrtFld() {
        emailCreateBtn.click();
        return new RegistrationPage(driver);
    }

    public boolean isShownAlertMessage(){
        new TestHelper(driver).isPageLoad();
        return alertMessageSignIn.isDisplayed();
    }




}
