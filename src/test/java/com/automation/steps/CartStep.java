package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStep {

    CartPage cartPage = new CartPage();

    @Then("verify the item is added to bag")
    public void verifyTheItemIsAddedToBag() {
        Assert.assertTrue(cartPage.verifyItemAddedToBag());
    }

    @Then("verify cart is empty")
    public void verifyCartIsEmpty() {
        Assert.assertEquals("Cart not found",cartPage.getTextFromCartPage());
    }


}
