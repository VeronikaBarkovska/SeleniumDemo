package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private By WelcomText = By.xpath("//p[@class='info-account']");
    private By IconMyAddress = By.xpath("//i[@class = 'icon-building']");
    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpenProfilePage() {
        WebElement iconElm = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(IconMyAddress));
        return iconElm.isDisplayed();
    }
}
