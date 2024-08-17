package com.automation.steps;

import com.automation.pages.HomePage;
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
}
