package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "loginAjio")
    WebElement signInButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;



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
}
