package com.automation.steps;

import com.automation.pages.ItemsListPageMobile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ItemsListStepMobile {
    ItemsListPageMobile itemsListStepMobile = new ItemsListPageMobile();

    @Then("verify user on items screen")
    public void verifyUserOnItemsScreen() {
        Assert.assertTrue(itemsListStepMobile.verifyUserOnItemsScreen());
    }

    @When("click on the first item")
    public void clickOnTheFirstItem() {
        itemsListStepMobile.clickOnFirstItem();
    }

    @When("user click on the wishlist pop up")
    public void userClickOnTheWishlistPopUp() {
        itemsListStepMobile.clickOnTheWishList();
    }
}
