package com.automation.steps;

import com.automation.pages.interfaces.CartPage;
import com.automation.pages.mobile.CartPageMobile;
import com.automation.pages.web.CartPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartStepCommon {

    CartPage cartPage;
    public CartStepCommon() {
        String env = ConfigReader.getConfigValue("execute");
        if("web".equals(env)){
            cartPage =  new CartPageWeb();
        }else {
            cartPage = new CartPageMobile();
        }
    }

    @Then("verify cart is empty")
    public void verifyCartIsEmpty() {
        Assert.assertTrue(cartPage.getTextFromCartPage());
    }

    @Then("verify user on cart page")
    public void verifyUserOnCartPage() {
        Assert.assertTrue(cartPage.verifyUserOnCartPage());
    }

    @Then("verify the item is added")
    public void verifyTheItemIsAdded() {
        Assert.assertTrue(cartPage.verifyItemIsAdded());
    }


    @When("user sum the item price and delivery fee")
    public void userSumTheItemPriceAndDeliveryFee() {
        cartPage.USerSumTheItemPriceAndDeliveryFee();
    }

    @Then("verify with the total item price")
    public void verifyWithTheTotalItemPrice() {
        Assert.assertTrue(cartPage.verifyAmountPayableWithItemPriceAndDeliveryFee());
    }
}
