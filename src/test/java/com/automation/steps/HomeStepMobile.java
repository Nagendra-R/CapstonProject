package com.automation.steps;

import com.automation.pages.HomePageMobile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeStepMobile {
    HomePageMobile homePageMobile = new HomePageMobile();


    @Given("user open the application in mobile")
    public void userOpenTheApplicationInMobile() {
        homePageMobile.userOpenApplication();
    }


    @Then("verify user on home screen")
    public void verifyUserOnHomeScreen() {
        Assert.assertTrue(homePageMobile.verifyUserOnHOmeScreen());
    }






    @When("user click on the bag button")
    public void userClickOnTheBagButton() {
        homePageMobile.clickOnBag();
    }

    @Then("verify the bag is empty")
    public void verifyTheBagIsEmpty() {
        Assert.assertEquals("Your Bag is Empty!", homePageMobile.getTheTextInsideTheBag());
    }

    @When("search with {string} in search bar")
    public void searchWithInSearchBar(String item) {
        homePageMobile.searchWithItem(item);
    }

    @Then("verify each item with {string} in title of the item")
    public void verifyEachItemWithInTitleOfTheItem(String itemText) {
        Assert.assertTrue(homePageMobile.verifyEachItemWithText(itemText));
    }


    @When("click on the account")
    public void clickOnTheAccount() {
        homePageMobile.clickOnAccount();
    }
}
