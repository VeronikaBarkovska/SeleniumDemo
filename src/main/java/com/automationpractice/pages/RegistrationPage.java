package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstNameFld;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement lastNameFld;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwdFld;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameAddrFld;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameAddrFld;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement addrOneFld;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityFld;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcodeFld;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement phoneMobileFld;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement aliasFld;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertMessage;

    @FindBy(xpath = "//input[@id = 'id_gender1']")
    private WebElement titleMr;

    @FindBy(xpath = "//input[@id = 'id_gender2']")
    private WebElement titleMrs;

    @FindBy(xpath = "//select[@id = 'days']")
    private WebElement dayDropList;

    @FindBy(xpath = "//select[@id = 'months']")
    private WebElement monthDropList;

    @FindBy(xpath = "//select[@id = 'years']")
    private WebElement yearDropList;

    @FindBy(xpath = "//select[@id = 'id_state']")
    private WebElement stateDropList;

    @FindBy(xpath = "//select[@id = 'id_country']")
    private WebElement countryDropList;

    @FindBy(xpath = "//input[@id = 'company']")
    private WebElement companyFld;

    @FindBy(xpath = "//input[@id = 'address2']")
    private WebElement address2Fld;

    @FindBy(xpath = "//textarea[@id = 'other']")
    private WebElement addInfoFld;

    @FindBy(xpath = "//input[@id = 'phone']")
    private WebElement homePhoneFld;


 private WebDriver driver;



    public RegistrationPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName(String firstName){ firstNameFld.sendKeys(firstName);}
    public void fillLastName(String lastName){ lastNameFld.sendKeys(lastName);}
    public void fillPasswd(String passwd){ passwdFld.sendKeys(passwd);}
    public void fillFirstNameAddr(String firstNameAddr){
        firstNameAddrFld.clear();
        firstNameAddrFld.sendKeys(firstNameAddr);}
    public void fillLastNameAddr(String lastNameAddr){
        lastNameAddrFld.clear();
        lastNameAddrFld.sendKeys(lastNameAddr);}
    public void fillAddrOne(String addrOne){ addrOneFld.sendKeys(addrOne);}
    public void fillCity(String city){ cityFld.sendKeys(city);}
    public void fillPostcode(String postcode){ postcodeFld.sendKeys(postcode);}
    public void fillPhonemob(String phoneMob){ phoneMobileFld.sendKeys(phoneMob);}
    public void fillAlias(String alias){
        aliasFld.clear();
        aliasFld.sendKeys(alias);}

    public void selectTitle(String title){
        if (title.equals("Mr.")) {
        titleMr.click();
    } else {
        titleMrs.click();
    }
    }

    public void selectDay(String day){
        Select value = new Select(dayDropList);
        value.selectByValue(day);
    }
    public void selectMonth(String month){
        Select value = new Select(monthDropList);
        value.selectByValue(month);
    }
    public void selectYear(String year){
        Select value = new Select(yearDropList);
        value.selectByValue(year);
    }
    public void selectState(String state){
        Select value = new Select(stateDropList);
        value.selectByVisibleText(state);
    }
    public void selectCountry(String country){
        Select value = new Select(countryDropList);
        value.selectByVisibleText(country);
    }
    public void fillCompany(String company){ companyFld.sendKeys(company);}
    public void fillAddressTwo(String address2){ address2Fld.sendKeys(address2);}
    public void fillAddInfo(String addInfo){ addInfoFld.sendKeys(addInfo);}
    public void fillHomePhone(String homePhone){ homePhoneFld.sendKeys(homePhone);}


    public boolean isOpenRegistrPage() {
        WebElement FirstNameRegistPageFldElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(firstNameFld));
        return FirstNameRegistPageFldElm.isDisplayed();
    }

    public void fillRegistrFormWithoutList(AccountCreate account) {
        fillFirstName(account.getFirstName());
        fillLastName(account.getLastName());
        fillPasswd(account.getPasswd());
        fillFirstNameAddr(account.getFirstNameAddr());
        fillLastNameAddr(account.getLastNameAddr());
        fillAddrOne(account.getAddress1());
        fillCity(account.getCity());
        fillPostcode(account.getPostcode());
        fillPhonemob(account.getPhone_mobile());
        fillAlias(account.getAlias());


    }
    public void fillAllRegistrForm(AccountCreate account) {
        this.fillRegistrFormWithoutList(account);
        fillCompany(account.getCompany());
        fillAddressTwo(account.getAddress2());
        selectTitle(account.getTitle());
        selectDay(account.getDay());
        selectMonth(account.getMonth());
        selectYear(account.getYear());
        selectState(account.getState());
        selectCountry(account.getCountry());
        fillAddInfo(account.getAddinfo());
        fillHomePhone(account.getHomePhone());
    }

    public RegistrationPage fillAndSubmitRegistFormWithoutList(AccountCreate account) {
        this.fillRegistrFormWithoutList(account);
        this.clickRegister();
        return new RegistrationPage(driver);
    }
    public ProfilePage fillAllAndSubmitRegistForm(AccountCreate account) {
        this.fillAllRegistrForm(account);
        this.clickRegister();
        return new ProfilePage(driver);
    }

    public void clickRegister() {
        registerBtn.click();
    }

    public boolean isShownAlertMessage() {
        WebElement AlertMessageElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(alertMessage));
        return AlertMessageElm.isDisplayed();
    }


}
