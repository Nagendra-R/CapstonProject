package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeStep {
    HomePage homePage = new HomePage();

    @Given("user open the application")
    public void user_open_the_application() {
        homePage.openWebsite();
    }
    @Then("validate user on home page")
    public void validate_user_on_home_page() {
        Assert.assertEquals("https://www.ajio.com/",homePage.verifyUserOnHomePage());
    }


    @When("user click on the signInButton")
    public void userClickOnTheSignInButton() {
        homePage.clickOnSignInButton();
    }

    @And("enter the mobile number {string}")
    public void enterTheMobileNumber(String mobileNumber) {
        homePage.enterMobileNumber(mobileNumber);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        homePage.clickOnContinueButton();

    }

    @Then("verify the error message is shown below")
    public void verifyTheErrorMessageIsShownBelow(String errMessage) {
        Assert.assertTrue(homePage.verifyErrorMessage(errMessage));
        ReportManager.log("Invalid Phone Number");
        ReportManager.attachScreenshot();
    }

    @When("user click on the visit ajioluxe tab")
    public void userClickOnTheVisitAjioluxeTab() {
        homePage.clickOnAJioluxe();
    }

    @Then("verify user on ajioluxe page")
    public void verifyUserOnAjioluxePage() {
        Assert.assertEquals("https://luxe.ajio.com/",homePage.verifyUserOnAjioLuxePage());
    }


    @When("user search with {string}")
    public void userSearchWith(String item) {
        homePage.searchWithItem(item);
    }


}
