package com.automation.steps;

import com.automation.pages.ItemProductPage;
import com.automation.utils.ReportManager;
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

    @Then("user check the each item result with the {string}")
    public void userCheckTheEachItemResultWithThe(String itemName) {
        Assert.assertTrue(itemProductPage.verifyItemsWithItemName(itemName));
    }

    @When("click on first item")
    public void clickOnFirstItem() {
        itemProductPage.clickOnFirstItem();
    }

    @Then("verify user on add to bag page")
    public void verifyUserOnAddToBagPage() {
        Assert.assertTrue(itemProductPage.verifyAddToBagIsDisplayed());
    }

    @When("click on the add to bag button")
    public void clickOnTheAddToBagButton() {
        itemProductPage.clickOnAddToBag();
    }


    @When("fill the min {string} and max {string} amount")
    public void fillTheMinAndMaxAmount(String min, String max) {
        itemProductPage.fillTheMinAndMaxAmount(min,max);
    }

    @Then("validate the price is between min and max")
    public void validateThePriceIsBetweenMinAndMax() {
        Assert.assertTrue(itemProductPage.verifyThePriceBetweenMinAndMax());
    }

    @Then("verify the items are shown")
    public void verifyTheItemsAreShown() {
        if(!itemProductPage.verifyItemsAreShown()){
            System.out.println("Its valid word only");
        }else{
            System.out.println("Meaning less word");
            ReportManager.log("Meaningless word search!!.. Search with meaningful text");
            ReportManager.attachScreenshot();
        }
    }



}
