package com.automation.steps;

import com.automation.pages.ItemProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ItemProductStep {
    ItemProductPage itemProductPage = new ItemProductPage();

    @Then("verify user on shirts item page")
    public void verifyUserOnShirtsItemPage() {
        Assert.assertTrue(itemProductPage.verifyUserOnShirtsPage());
    }

    @When("select price {string}")
    public void selectPrice(String highestPrice) {
        itemProductPage.selectTheHighestPrice(highestPrice);
    }

    @Then("verify the price in desc order")
    public void verifyThePriceInDescOrder() {
        Assert.assertTrue(itemProductPage.checkItemPricesInDescendingOrder());
    }
}
