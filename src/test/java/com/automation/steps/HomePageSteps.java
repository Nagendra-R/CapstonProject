package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps{

    HomePage homePage = new HomePage();

    @Given("user opens the website")
    public void user_opens_the_website() {

        homePage.openWebsite();

    }
    @Given("user navigates to the bottom of the page")
    public void user_navigates_to_the_bottom_of_the_page() {

        homePage.gotoBottomSection();

    }
    @When("user clicks on the goto top arrow button")
    public void user_clicks_on_the_goto_top_arrow_button() {
        homePage.clicksOnButton();

    }
    @Then("user must reach the top of the page")
    public void user_must_reach_the_top_of_the_page() {
        Assert.assertTrue(homePage.verifyTopSectionDisplayed());
    }
//-------------------------------------------------------------------------------------------
//--------------------------------- coupon verification -------------------------------------

    @Then("user search for a product {string} in the search input field")
    public void userSearchForAProductInTheSearchInputField(String product) {
        homePage.productSearchProcess(ConfigReader.getConfigValue(product));
    }
}
