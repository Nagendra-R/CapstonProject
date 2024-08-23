package com.automation.steps;

import com.automation.pages.LoginPageMobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepMobile {

    LoginPageMobile loginPageMobile = new LoginPageMobile();

    @When("fill the otp manually")
    public void fillTheOtpManually() {
        loginPageMobile.fillTheOtpManually();
    }

    @Then("verify user on login page")
    public void verifyUserOnLoginPage() {
        Assert.assertTrue(loginPageMobile.verifyUserOnSignUpLoginScreen());
    }

    @When("user fill the {string} phone number")
    public void userFillThePhoneNumber(String phoneNumber) {
        loginPageMobile.fillThePhoneNumber(phoneNumber);
    }

    @And("user click on the continue button")
    public void userClickOnTheContinueButton() {
        loginPageMobile.clickOnContinueButton();
    }

    @Then("verify user on otp screen")
    public void verifyUserOnOtpScreen() {
        Assert.assertTrue(loginPageMobile.verifyUserOnOtpScreen());
    }

    @When("fill the otp with random numbers")
    public void fillTheOtpWithRandomNumbers() {
        loginPageMobile.fillTheRandomOtp();
    }

    @Then("verify the entered otp is wrong")
    public void verifyTheEnteredOtpIsWrong() {
        Assert.assertEquals("Wrong OTP entered", loginPageMobile.getTheWrongMessage());
    }

    @Then("verify user on login screen")
    public void verifyUserOnLoginScreen() {
        Assert.assertTrue(loginPageMobile.verifyUserOnLoginScreen());
    }

    @When("click on the login sign up button")
    public void clickOnTheLoginSignUpButton() {
        loginPageMobile.clickOnTheLoginSignUpButton();
    }

    @Then("verify user can successfully login")
    public void verifyUserCanSuccessfullyLogin() {
        Assert.assertTrue(loginPageMobile.verifyUserSuccessfullyLogin());
    }

    @When("user scroll till the logout button")
    public void userScrollTillTheLogoutButton() {
        loginPageMobile.scrollTillTheLogoutButton();
    }

    @And("user click on the logout button")
    public void userClickOnTheLogoutButton() {
        loginPageMobile.clickOnLogoutButton();
    }

    @Then("verify user can successfully logout")
    public void verifyUserCanSuccessfullyLogout() {
        loginPageMobile.verifyUserOnSignUpLoginScreen();
    }
}
