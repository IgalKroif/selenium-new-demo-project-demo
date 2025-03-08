package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShoppingCart extends BasePage {
    public WebDriver driver;

    By promoCode = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextbox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn = By.cssSelector("form[method='post']  span");
    By proceedToCheckoutBtn = By.cssSelector(".js-cart-detailed-actions .btn-primary");
    By deleteItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalValue = By.cssSelector(".cart-total .value");

    public ShoppingCart() throws IOException {
        super();
        this.driver = getDriver();
    }

    public WebElement getPromoCode()  {
        return driver.findElement(promoCode);
    }
    public WebElement getPromoTextBox() {
        return driver.findElement(promoTextbox);
    }
    public WebElement getPromoAddBtn() {
        return driver.findElement(promoAddBtn);
    }
    public WebElement getProceedToCheckoutBtn() {
        return driver.findElement(proceedToCheckoutBtn);
    }
    public WebElement getDeleteItemOne() {
        return driver.findElement(deleteItemOne);
    }
    public WebElement getDeleteItemTwo() {
        return driver.findElement(deleteItemTwo);
    }
    public WebElement getTotalValue() {
        return driver.findElement(totalValue);
    }
}
