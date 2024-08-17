package com.automation.pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "loginAjio")
    WebElement signInButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    @FindBy(id = "error-msg")
    WebElement errMsg;

    @FindBy(xpath = "//li[@class='visit-ajio']/a")
    WebElement ajioLuxe;

    @FindBy(xpath = "//input[@name='searchVal']")
    WebElement searchInput;

    @FindBy(xpath = "//span[@class='ic-search']")
    WebElement searchButton;


    public void openWebsite() {
        driver.get("https://www.ajio.com/");
    }

    public String verifyUserOnHomePage() {
        return driver.getCurrentUrl();
    }


    public void clickOnSignInButton() {
        signInButton.click();
    }


    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }


    public void clickOnContinueButton() {
        continueButton.click();
    }

    public boolean verifyErrorMessage(String errMessage) {
        return errMsg.getText().equals(errMessage);
    }

    public void clickOnAJioluxe() {
        ajioLuxe.click();
    }

    public String verifyUserOnAjioLuxePage() {
        return driver.getCurrentUrl();
    }

    public void searchWithItem(String item) {
        searchInput.sendKeys(item);
        searchButton.click();
    }


}
