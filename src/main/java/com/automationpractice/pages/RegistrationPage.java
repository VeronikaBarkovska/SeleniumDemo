package com.automationpractice.pages;

import com.automationpractice.account.AccountCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

    private By FirstNameFld = By.xpath("//input[@id='customer_firstname']");
    private By LastNameFld = By.xpath("//input[@id='customer_lastname']");
    private By PasswdFld = By.xpath("//input[@id='passwd']");
    private By FirstNameAddrFld = By.xpath("//input[@id='firstname']");
    private By LastNameAddrFld = By.xpath("//input[@id='lastname']");
    private By AddrOneFld = By.xpath("//input[@id='address1']");
    private By CityFld = By.xpath("//input[@id='city']");
    private By PostcodeFld = By.xpath("//input[@id='postcode']");
    private By PhonemobFld = By.xpath("//input[@id='phone_mobile']");
    private By AliasFld = By.xpath("//input[@id='alias']");
    private By RegisterBtn = By.xpath("//button[@id='submitAccount']");
    private By alertmessage = By.xpath("//div[@class='alert alert-danger']");
    private By TitleMr = By.xpath("//input[@id = 'id_gender1']");
    private By TitleMrs = By.xpath("//input[@id = 'id_gender2']");
    private By DayDropList = By.xpath("//select[@id = 'days']");
    private By MonthDropList = By.xpath("//select[@id = 'months']");
    private By YearDropList = By.xpath("//select[@id = 'years']");
    private By StateDropList = By.xpath("//select[@id = 'id_state']");
    private By CountryDropList = By.xpath("//select[@id = 'id_country']");
    private By CompanyFld = By.xpath("//input[@id = 'company']");
    private By Address2Fld = By.xpath("//input[@id = 'address2']");
    private By AddInfoFld= By.xpath("//textarea[@id = 'other']");
    private By HomePhoneFld = By.xpath("//input[@id = 'phone']");


 private WebDriver driver;



    public RegistrationPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillFirstName(String FirstName){ driver.findElement(FirstNameFld).sendKeys(FirstName);}
    public void fillLastName(String LastName){ driver.findElement(LastNameFld).sendKeys(LastName);}
    public void fillPasswd(String Passwd){ driver.findElement(PasswdFld).sendKeys(Passwd);}
    public void fillFirstNameAddr(String FirstNameAddr){ driver.findElement(FirstNameAddrFld).sendKeys(FirstNameAddr);}
    public void fillLastNameAddr(String LastNameAddr){ driver.findElement(LastNameAddrFld).sendKeys(LastNameAddr);}
    public void fillAddrOne(String AddrOne){ driver.findElement(AddrOneFld).sendKeys(AddrOne);}
    public void fillCity(String City){ driver.findElement(CityFld).sendKeys(City);}
    public void fillPostcode(String Postcode){ driver.findElement(PostcodeFld).sendKeys(Postcode);}
    public void fillPhonemob(String Phonemob){ driver.findElement(PhonemobFld).sendKeys(Phonemob);}
    public void fillAlias(String Alias){ driver.findElement(AliasFld).sendKeys(Alias);}

    public void selectTitle(String title){
        if (title.equals("Mr.")) {
        driver.findElement(TitleMr).click();
    } else {
        driver.findElement(TitleMrs).click();
    }
    }

    public void selectDay(String day){
        WebElement dayElm = driver.findElement(DayDropList);
        Select value = new Select(dayElm);
        value.selectByValue(day);
    }
    public void selectMonth(String month){
        WebElement monthElm = driver.findElement(MonthDropList);
        Select value = new Select(monthElm);
        value.selectByValue(month);
    }
    public void selectYear(String year){
        WebElement yearElm = driver.findElement(YearDropList);
        Select value = new Select(yearElm);
        value.selectByValue(year);
    }
    public void selectState(String state){
        WebElement stateElm = driver.findElement(StateDropList);
        Select value = new Select(stateElm);
        value.selectByVisibleText(state);
    }
    public void selectCountry(String country){
        WebElement countryElm = driver.findElement(CountryDropList);
        Select value = new Select(countryElm);
        value.selectByVisibleText(country);
    }
    public void fillCompany(String company){ driver.findElement(CompanyFld).sendKeys(company);}
    public void fillAddressTwo(String address2){ driver.findElement(Address2Fld).sendKeys(address2);}
    public void fillAddInfo(String addInfo){ driver.findElement(AddInfoFld).sendKeys(addInfo);}
    public void fillHomePhone(String homePhone){ driver.findElement(HomePhoneFld).sendKeys(homePhone);}


    public boolean isOpenRegistrPage() {
        WebElement FirstNameRegistPageFldElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(FirstNameFld));
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
        WebElement registerBtnElm= driver.findElement(RegisterBtn);
        registerBtnElm.click();
    }

    public boolean isShownAlertMessage() {
        WebElement AlertMessageElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(alertmessage));
        return AlertMessageElm.isDisplayed();
    }


}
