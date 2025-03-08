package uk.automationtesting;

import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

@Listeners(base.Listeners.class)
public class OrderCompleteTest extends Hooks {

    // Create a constructor from BasePage that uses the config.properties file.
    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws IOException {
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
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getPromoCode().click();
        cart.getPromoTextBox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        cart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo pInfo = new OrderFormPersInfo();
        pInfo.getGenderMr().click();
        pInfo.getFirstNameField().sendKeys("John");
        pInfo.getLastnameField().sendKeys("Smith");
        pInfo.getEmailField().sendKeys("johnsmithyus@test.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getStateDropdown());
        state.selectByVisibleText("Texas");
        orderDelivery.getPostcodeField().sendKeys("77021");
        orderDelivery.getContinueBtn().click();

        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
        shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in please leave my delivery on my porch");
        shipMethod.getContinueBtn().click();

        OrderFormPayment paymentMethod = new OrderFormPayment();
        paymentMethod.getPayByCheckRadioBtn().click();
        paymentMethod.getTermsConditionsCheckbox().click();
        paymentMethod.getOrderBtn().click();
    }
}