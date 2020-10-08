package com.automationpractice.pages;

import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//td[@id='total_product']")
    private WebElement totalProduct;

    @FindBy(xpath = "//td[@id='total_shipping']")
    private WebElement totalShipping;

    @FindBy(xpath ="//td[@id='total_price_without_tax']")
    private WebElement totalPriceWithoutTax;

    @FindBy(xpath ="//td[@id='total_tax']")
    private WebElement totalTax;

    @FindBy(xpath ="//td[@id='total_price_container']")
    private WebElement totalPrice;

    @FindBy(xpath ="//i[@class='icon-trash']")
    private WebElement deleteBtn;

    private By emptyCartMessage = By.xpath("//p[@class='alert alert-warning']");

    @FindBy(xpath = "(//i[@class='icon-plus'])[1]")
    private WebElement plusQuantityBtn;

    @FindBy(xpath = "//tbody//child::tr")
    private WebElement itemsBlock;

    @FindBy(xpath = "//tbody//child::tr[1]")
    private WebElement items1;

    @FindBy(xpath = "//tbody//child::tr[last-1]")
    private WebElement items2;


    @FindBy(xpath = "(//span[@class='price'])[5]")
    private WebElement totalItem1;

    @FindBy(xpath = "(//span[@class='price'])[4]")
    private WebElement totalSpecialItem1;

    @FindBy(xpath = "(//span[@class='price'])[8]")
    private WebElement totalItem2;

    @FindBy(xpath = "(//span[@class='price'])[7]")
    private WebElement totalSpecialItem2;

    @FindBy(xpath = "//td[@id='total_product']")
    private WebElement totalProducts;

    @FindBy(xpath = "(//span[@class='old-price'])[1]")
    private WebElement totalItemOldPrice1;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "(//span[@class = 'price-percent-reduction small'])[1]")
    private WebElement saleText;

    @FindBy(xpath = "//span[@class = 'price special-price']")
    private WebElement newPrice;

    @FindBy(xpath = "(//span[@class='price' and contains(@id,'total_product_price')])[1]")
    private WebElement totalPriceWomenTab1;

    @FindBy(xpath = "(//span[@class='price' and contains(@id,'total_product_price')])[1]/parent::td/following-sibling::td/div/a")
    private WebElement deleteWomenTabBtn1;

    @FindBy(xpath = "(//span[@class='price' and contains(@id,'total_product_price')])[2]")
    private WebElement totalPriceWomenTab2;

    @FindBy(xpath = "(//span[@class='price' and contains(@id,'total_product_price')])[2]/parent::td/following-sibling::td/div/a")
    private WebElement deleteWomenTabBtn2;



    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpenedCart(){
        return plusQuantityBtn.isDisplayed();
    }
    public void clickPlusQuantity(){
        new TestHelper(driver).waitUntilElementWillBeClickable(plusQuantityBtn).click();
    }

    public String checkTotalPrice() {
        return totalPrice.getText();
    }

    public String checkTotalProduct(){
        return totalProduct.getText();
    }
    public String checkTotalShipping()  {

        return totalShipping.getText();
    }

    public String checkTotalPriceWithoutTax(){
    return totalPriceWithoutTax.getText();
    }

    public String checkTotalTax(){
        return totalTax.getText();
    }
    public void clickDeleteBtn(){
        new TestHelper(driver).waitUntilElementWillBeClickable(deleteBtn).click();
    }
    public boolean isEmptyCart(){
        WebElement deleteMessageElm = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(emptyCartMessage));
        return deleteMessageElm.isDisplayed();

    }
    public boolean checkItems(){
        if(totalItem1.isDisplayed() && totalItem2.isDisplayed()){
            return true;
        }
        return false;
    }

    public String checkTotalItem1(){
        return totalItem1.getText();
    }

    public String checkTotalItem2(){
        return totalItem2.getText();
    }

    public String checkTotalSpecialItem1(){
        return totalSpecialItem1.getText();
    }

    public String checkTotalSpecialItem2(){
        return totalSpecialItem2.getText();
    }

    public String checkTotalProducts(){
        return totalProducts.getText();
    }

    public String checkAllTotalPrice(){
        return checkTotalSpecialItem1()
                +checkTotalSpecialItem2()
                +checkTotalProducts();
    }

    public String checkSaleText(){
        return saleText.getText();
    }

    public String checkOldPrice(){
        return totalItemOldPrice1.getText();
    }

    public String checkNewPrice(){return newPrice.getText();}

    public String checkSalePrice(){
        return checkOldPrice()
                +checkSaleText()
                +checkNewPrice();
    }

    public AddressCartPage clickProceedToCheckout(){
        new TestHelper(driver).waitUntilElementWillBeClickable(proceedToCheckoutBtn).click();
        return new AddressCartPage(driver);

    }

    public int compareTwoPriceItems(){
        String totalPriceWomen1 = totalPriceWomenTab1.getText().replace("$","").replace(".00","");
        String totalPriceWomen2 = totalPriceWomenTab2.getText().replace("$","").replace(".98","");
        int tP1=Integer.parseInt(totalPriceWomen1);
        int tP2=Integer.parseInt(totalPriceWomen2);
        if(tP1 > tP2){
        return tP1;
    }

        return tP2;
    }

    public void deleteCompareTwoPriceItems(){
        String totalPriceWomen1 = totalPriceWomenTab1.getText().replace("$","").replace(".00","");
        String totalPriceWomen2 = totalPriceWomenTab2.getText().replace("$","").replace(".98","");
        int tP1=Integer.parseInt(totalPriceWomen1);
        int tP2=Integer.parseInt(totalPriceWomen2);
        if(tP1 > tP2){
            deleteWomenTabBtn1.click();
        }
        deleteWomenTabBtn2.click();
    }

    public int getFirstTotalPriceWomenTab(){
        String totalPriceWomen1 = totalPriceWomenTab1.getText().replace("$","").replace(".00","");
        int tP1=Integer.parseInt(totalPriceWomen1);
        return tP1;
    }

    }



