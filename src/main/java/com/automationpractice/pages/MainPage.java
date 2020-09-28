package com.automationpractice.pages;

import com.automationpractice.info.InfoCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

private WebDriver driver;
private By SignInBtn = By.xpath("//a[@class='login']");
private By ListSearchBtn = By.xpath("//i[@class='icon-th-list']");
private By SearchFld = By.xpath("//input[@id='search_query_top']");
private By SearchBtn = By.xpath("//button[@name='submit_search']");
private By AddToCartBtn1 = By.xpath("(//a[@class='button ajax_add_to_cart_button btn btn-default'])[1]");
private By ContinueShoppingBtn = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
private By ProceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default button button-medium']");


public MainPage(WebDriver driver){
    this.driver = driver;
}

public void fillSearchFld(String searchText){ driver.findElement(SearchFld).sendKeys(searchText);}

public SignInPage openSignInPage(WebDriver driver) {
    this.driver.findElement(SignInBtn).click();
        return new SignInPage(this.driver);
    }

    public MainPage enterAndSubmitSearch(InfoCreate info) {
        this.fillSearchFld(info.getSearchText());
        this.clickSearchBtn();
        return new MainPage(driver);

    }
    public void clickSearchBtn(){
        WebElement SearchBtnElm= driver.findElement(SearchBtn);
        SearchBtnElm.click();
    }

    public void clickListView() {
        WebElement ListViewElm= driver.findElement(ListSearchBtn);
        ListViewElm.click();
    }
    public boolean isOpenedSearchResult(){
        WebElement ListViewElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ListSearchBtn));
        return ListViewElm.isDisplayed();
    }
    public boolean isShownAddToCartBtn(){
        WebElement AddToCartElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(AddToCartBtn1));
        return AddToCartElm.isDisplayed();
    }

    public void clickAddToCart() {
        WebElement AddToCartElm= driver.findElement(AddToCartBtn1);
        AddToCartElm.click();
    }

    public boolean isAddedItems(){
        WebElement ProceedToCheckoutElm = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ProceedToCheckoutBtn));
        return ProceedToCheckoutElm.isDisplayed();
    }

    public CartPage clickProceedToCheckout() {
        WebElement ProceedToCheckoutElm= driver.findElement(ProceedToCheckoutBtn);
        ProceedToCheckoutElm.click();
        return new CartPage(driver);
    }
}
