package uk.automationtesting;

import base.BasePage;
import base.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException {
        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        ShopHomepage shopHome = new ShopHomepage();
        shopHome.getProdOne().click();

        ShopProductPage shopProd = new ShopProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantityIncrease().click();
        shopProd.getAddToCartBtn().click();

        ShopContentPanel cPanel = new ShopContentPanel();
        cPanel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        //WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        //wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));
        waitForElementInvisible(cart.getDeleteItemTwo(), 120);
        cart.getTotalValue().getText();

        Assert.assertEquals(cart.getTotalValue().getText(), "$45.23");
    }
}