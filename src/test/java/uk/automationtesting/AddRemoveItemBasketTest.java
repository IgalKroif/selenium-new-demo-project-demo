package uk.automationtesting;

import base.ExtentManager;
import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

        ExtentManager.log("Starting AddRemoveItemBasketTest...");

        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        ShopHomepage shopHome = new ShopHomepage();
        ExtentManager.pass("Reached the shop homepage!");
        shopHome.getProdOne().click();

        ShopProductPage shopProd = new ShopProductPage();
        ExtentManager.pass("Reached the shop product page!");
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Have successfully selected product size!");
        shopProd.getQuantityIncrease().click();
        ExtentManager.pass("have successfully increased quantity");
        shopProd.getAddToCartBtn().click();
        ExtentManager.pass("Have successfully added product to basket.");

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

        try{
            Assert.assertEquals(cart.getTotalValue().getText(), "$45.23");
            ExtentManager.pass("The total amount matches the expected amount");
        } catch (AssertionError e){
            Assert.fail("Cart amount did not match the expected amount, it found"
                    + cart.getTotalValue().getText() + " expected: $45.23");
            ExtentManager.fail("The total amount did not match the expected amount.");
        }
        //Assert.assertEquals(cart.getTotalValue().getText(), "$45.24");
    }
}