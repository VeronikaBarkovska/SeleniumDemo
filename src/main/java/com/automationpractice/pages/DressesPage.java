package com.automationpractice.pages;

import com.automationpractice.pages.enums.SortEnum;
import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressesPage {
    private WebDriver driver;

    @FindBy(xpath = "(//a[@title = 'Summer Dresses'])[3]")
    private WebElement summerDressesCategory;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listViewBtn;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeLcheckbox;

    @FindBy(id = "selectProductSort")
    private WebElement sortProduct;

    @FindBy(xpath = "(//a[@class= 'button ajax_add_to_cart_button btn btn-default'])[1]")
    private WebElement addToCartBtn1;

    @FindBy(xpath = "(//a[@class= 'button ajax_add_to_cart_button btn btn-default'])[2]")
    private WebElement addToCartBtn2;

    @FindBy(xpath = "(//a[@class= 'button ajax_add_to_cart_button btn btn-default'])[5]")
    private WebElement addToCartBtnSelected;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@class='product-image-container']")
    private WebElement itemView;

    @FindBy(xpath = "(//span[@class='price product-price'])[2]")
    private WebElement firstItemPrice;

    public DressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isOpenDressesPage(){
        return new TestHelper(driver).waitUntilElementWillBeClickable(summerDressesCategory).isDisplayed();

    }
    public void clickListView() {
        new TestHelper(driver).waitUntilElementWillBeClickable(listViewBtn).click();
    }
    public DressesPage selectLSize(){
        sizeLcheckbox.click();
        return this;

    }
    public void selectSortSearch(SortEnum sortType){
        Select value = new Select(sortProduct);
        value.selectByVisibleText(sortType.getName());
    }

    public void clickSelectedAddToCartBtn(){
        new TestHelper(driver).waitUntilElementWillBeClickable(addToCartBtnSelected).click();
    }



    public void clickAddToCartBtn1(){
        new TestHelper(driver).waitUntilElementWillBeClickable(addToCartBtn1).click();
    }
    public void clickContinueShopping(){
        new TestHelper(driver).waitUntilElementWillBeClickable(continueShoppingBtn).click();
    }
    public void clickAddToCartBtn2(){
        new TestHelper(driver).waitUntilElementWillBeClickable(addToCartBtn2).click();
    }
    public CartPage clickProceedToCheckout() {
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutBtn).click();
        return new CartPage(driver);
    }
    public void scrollToItem(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", itemView);
    }
    public String getFirstItemPrice(){
        return firstItemPrice.getText();
    }
}
