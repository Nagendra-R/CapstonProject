package com.automation.steps;

import com.automation.pages.interfaces.LoginPage;
import com.automation.pages.mobile.LoginPageMobile;
import com.automation.pages.web.LoginPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepCommon {

    LoginPage loginPage;

    public LoginStepCommon(){
        String env = ConfigReader.getConfigValue("execute");
        if("web".equals(env)){
            loginPage =  new LoginPageWeb();
        }else {
            loginPage = new LoginPageMobile();
        }
    }
//
//    LoginPageWeb loginPageWeb1 = new LoginPageWeb();

    @And("enter the mobile number {string}")
    public void enterTheMobileNumber(String mobileNumber) {
        loginPage.enterMobileNumber(mobileNumber);
    }

    @Then("verify user on login page")
    public void verifyUserOnLoginPage() {
        Assert.assertTrue(loginPage.verifyUserOnLoginPage());
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        loginPage.clickOnContinueButton();
    }

    @Then("verify the error message is shown below")
    public void verifyTheErrorMessageIsShownBelow(String errMessage) {
        Assert.assertTrue(loginPage.verifyErrorMessage(errMessage));
//        ReportManager.log("Invalid Phone Number");
//        ReportManager.attachScreenshot();
    }

    @Then("verify user on login screen")
    public void verifyUserOnLoginScreen() {
        Assert.assertTrue(loginPage.verifyUserOnLoginScreen());
    }

    @When("click on the sign in or login button")
    public void clickOnTheSignInLoginButton() {
        loginPage.clickOnTheSignInOrLoginIn();
    }

    @When("user fill the {string} phone number")
    public void userFillThePhoneNumber(String phoneNumber) {
        loginPage.fillThePhoneNumber(phoneNumber);
    }

    @And("user click on the continue button")
    public void userClickOnTheContinueButton() {
        loginPage.clickOnLoginContinueButton();
    }

    @Then("verify user on otp screen")
    public void verifyUserOnOtpScreen() {
        Assert.assertTrue(loginPage.verifyUserOnOtpScreen());
    }

    @When("fill the otp with random numbers")
    public void fillTheOtpWithRandomNumbers() {
        loginPage.fillTheRandomOtp();
    }

    @Then("verify the entered otp is wrong")
    public void verifyTheEnteredOtpIsWrong() {
        Assert.assertEquals("Wrong OTP entered", loginPage.getTheWrongMessage());
    }

    @When("fill the otp manually")
    public void fillTheOtpManually() {
        loginPage.fillTheOtpManually();
    }

    @Then("verify user can successfully login")
    public void verifyUserCanSuccessfullyLogin() {
        Assert.assertTrue(loginPage.verifyUserSuccessfullyLogin());
    }

    @When("user scroll till the logout button")
    public void userScrollTillTheLogoutButton() {
        loginPage.scrollTillTheLogoutButton();
    }

    @And("user click on the logout button")
    public void userClickOnTheLogoutButton() {
        loginPage.clickOnLogoutButton();
    }

    @Then("verify user can successfully logout")
    public void verifyUserCanSuccessfullyLogout() {
        Assert.assertTrue(loginPage.verifyUserOnSignUpLoginScreen());
    }












}
