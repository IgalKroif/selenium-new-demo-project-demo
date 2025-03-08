package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ShopContentPanel extends BasePage {
    public WebDriver driver;

    By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By checkoutBtn = By.linkText("\uE876PROCEED TO CHECKOUT");


    public ShopContentPanel() throws IOException {
        super();
        this.driver = getDriver();
    }

    public WebElement getContinueShopBtn() {
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        return driver.findElement(checkoutBtn);
    }
}
