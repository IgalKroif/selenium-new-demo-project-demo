package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopProductPage extends BasePage {

    public WebDriver driver;

    By sizeOption = By.cssSelector("select#group_1");
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector("[data-button-action]");
    By homepageLink = By.xpath("//span[.='Home']");

    public ShopProductPage() throws IOException {
        super();
        this.driver = getDriver();
    }

    public WebElement getSizeOption() {
        return driver.findElement(sizeOption);
    }

    public WebElement getQuantityIncrease() {
        return driver.findElement(quantityIncrease);
    }

    public WebElement getQuantityDecrease() {
        return driver.findElement(quantityDecrease);
    }

    public WebElement getAddToCartBtn() {
        return driver.findElement(addToCartBtn);
    }

    public WebElement getHomepageLink() {
        return driver.findElement(homepageLink);
    }

}
