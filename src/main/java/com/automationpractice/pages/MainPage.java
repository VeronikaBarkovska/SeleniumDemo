package com.automationpractice.pages;

import com.automationpractice.info.InfoCreate;
import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

private WebDriver driver;

@FindBy(xpath = "//a[@class='login']")
private WebElement signInBtn;

@FindBy(xpath = "//i[@class='icon-th-list']")
private WebElement listSearchBtn;

@FindBy(xpath = "//input[@id='search_query_top']")
private WebElement searchFld;

@FindBy(xpath = "//button[@name='submit_search']")
private WebElement searchBtn;

@FindBy(xpath = "(//a[@class='button ajax_add_to_cart_button btn btn-default'])[1]")
private WebElement addToCartBtn1;

@FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
private WebElement proceedToCheckoutBtn;

@FindBy(xpath = "//a[@title = 'Women']")
private WebElement womenTab;


public MainPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void fillSearchFld(String searchText){ searchFld.sendKeys(searchText);}

public SignInPage openSignInPage(WebDriver driver) {
    signInBtn.click();
        return new SignInPage(this.driver);
    }

    public MainPage enterAndSubmitSearch(InfoCreate info) {
        this.fillSearchFld(info.getSearchText());
        this.clickSearchBtn();
        return new MainPage(driver);

    }
    public void clickSearchBtn(){
    new TestHelper(driver).waitUntilElementWillBeClickable(searchBtn).click();
    }

    public void clickListView() {
        new TestHelper(driver).waitUntilElementWillBeClickable(listSearchBtn).click();
    }
    public boolean isOpenedSearchResult(){
        return new TestHelper(driver).waitUntilElementWillBeClickable(listSearchBtn).isDisplayed();
    }
    public boolean isShownAddToCartBtn(){
        return new TestHelper(driver).waitUntilElementWillBeClickable(addToCartBtn1).isDisplayed();
    }

    public void clickAddToCart() {
        new TestHelper(driver).waitUntilElementWillBeClickable(addToCartBtn1).click();
    }

    public boolean isAddedItems(){
        return new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutBtn).isDisplayed();
    }

    public CartPage clickProceedToCheckout() {
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutBtn).click();
        return new CartPage(driver);
    }

    public WomenPage clickWomenTab(){
    womenTab.click();
    return new WomenPage(driver);
    }
}
