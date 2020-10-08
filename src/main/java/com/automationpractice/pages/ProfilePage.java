package com.automationpractice.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private By IconMyAddress = By.xpath("//i[@class = 'icon-building']");
    private WebDriver driver;

    @FindBy(xpath = "(//a[@title = 'Dresses'])[2]")
    private WebElement dressesTab;

    @FindBy (xpath = "//a[@class='logout']")
    private WebElement signOutBtn;


    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpenProfilePage() {
        WebElement iconElm = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(IconMyAddress));
        return iconElm.isDisplayed();
    }
    public DressesPage clickDressesTab(){
        new TestHelper(driver).waitUntilElementWillBeClickable(dressesTab).click();
        return new DressesPage(driver);

    }

    public SignInPage clickSignOutBtn(){
        new TestHelper(driver).waitUntilElementWillBeClickable(signOutBtn).click();
        return new SignInPage(driver);
    }

}
