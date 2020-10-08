package com.automationpractice.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WomenPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
    private WebElement rangePrice;

    @FindBy(xpath = "(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]")
    private WebElement rangePriceLeft;

    @FindBy(xpath = "//a[@class='ui-slider-handle ui-state-default ui-corner-all']")
    private WebElement rangePriceRight;

    @FindBy(xpath = "//span[@id = 'layered_price_range']")
    private WebElement range;

    @FindBy(xpath = "(//span[@itemprop = 'price'])[8]")
    private WebElement priceMore50;

    @FindBy(xpath = "//a[@data-id-product='3']//span")
    private WebElement firstItemWithDressText;

    @FindBy(xpath = "//a[@data-id-product='5']//span")
    private WebElement secondItemWithSale;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listViewBtn;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToItem() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", rangePrice);
    }

    public String getRange() {
        return range.getText();
    }

    public void dragLeftSlider() {
        Actions move = new Actions(driver);
        move.moveToElement(rangePriceLeft).click().dragAndDropBy(new TestHelper(driver).waitUntilElementWillBeClickable(rangePriceLeft), 60, 0).click().build().perform();

    }

    public void dragRightSlider() {
        Actions move = new Actions(driver);
        move.moveToElement(rangePriceRight).click().dragAndDropBy(new TestHelper(driver).waitUntilElementWillBeClickable(rangePriceRight), -49, 0).click().build().perform();

    }

    public boolean isFilterLoad() {
        return new TestHelper(driver).isPageLoad();
    }

    public boolean checkPriceFilterWorking() {

        if (priceMore50.getText().equals("$50.99")) {
            return false;
        } else return true;
    }
    public void clickListView() {
        new TestHelper(driver).waitUntilElementWillBeClickable(listViewBtn).click();
    }

    public void clickAddToCartBtn1() {
       new TestHelper(driver).waitUntilElementWillBeClickable(firstItemWithDressText).click();
    }

    public void clickAddToCartBtn2() {
        new TestHelper(driver).waitUntilElementWillBeClickable(secondItemWithSale).click();
    }

    public void clickContinueShopping() {
        new TestHelper(driver).waitUntilElementWillBeClickable(continueShoppingBtn).click();
    }

    public CartPage clickProceedToCheckout() {
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutBtn).click();
        return new CartPage(driver);
    }
}
