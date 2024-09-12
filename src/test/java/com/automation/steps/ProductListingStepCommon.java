package com.automation.steps;

import com.automation.pages.interfaces.ProductListingPage;
import com.automation.pages.mobile.ProductListingPageMobile;
import com.automation.pages.web.ProductListingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductListingStepCommon {

    ProductListingPage productListingPage;

    public ProductListingStepCommon() {
        String env = ConfigReader.getConfigValue("execute");
        if ("web".equals(env)) {
            productListingPage = new ProductListingPageWeb();
        } else {
            productListingPage = new ProductListingPageMobile();
        }
    }

    @Then("verify each item with {string} in title of the item")
    public void verifyEachItemWithInTitleOfTheItem(String itemText) {
        Assert.assertTrue(productListingPage.verifyEachItemWithText(itemText));
    }

    @Then("verify the items are shown")
    public void verifyTheItemsAreShown() {
        if(!productListingPage.verifyItemsAreShown()){
            System.out.println("Its valid word only");
        }else{
            System.out.println("Meaning less word");
//            ReportManager.log("Meaningless word search!!.. Search with meaningful word");
//            ReportManager.attachScreenshot();
        }
    }

    @Then("verify user on searched item page")
    public void verifyUserOnSearchedItemPage() {
        Assert.assertTrue(productListingPage.verifyUserOnSearchedItemPage());
    }

    @And("user click on the filters")
    public void userClickOnTheFilters() {
        productListingPage.clickOnTheFilters();
    }

    @And("user click on the price text")
    public void userClickOnThePriceText() {
        productListingPage.clickOnThePriceButton();
    }

    @When("fill the min {string} and max {string} amount")
    public void fillTheMinAndMaxAmount(String min, String max) {
        productListingPage.fillTheMinAndMaxAmount(min,max);
    }

    @Then("validate the price is between {string} and {string}")
    public void validateThePriceIsBetween(String minPrice, String maxPrice) {
        Assert.assertTrue(productListingPage.verifyThePriceBetweenMinAndMax(minPrice,maxPrice));
    }

    @When("sort price by {string}")
    public void sortPriceBy(String sortType) {
        productListingPage.selectTheHighestPrice(sortType);
    }

    @Then("verify the price in desc order")
    public void verifyThePriceInDescOrder() {
        Assert.assertTrue(productListingPage.checkItemPricesInDescendingOrder());
    }

    @When("click on first item")
    public void clickOnFirstItem() {
        productListingPage.clickOnFirstItem();
    }


    @Then("verify with correct discount")
    public void verifyWithCorrectDiscount() {
        Assert.assertTrue(productListingPage.verifyWithCorrectDiscountOff());
    }
}
