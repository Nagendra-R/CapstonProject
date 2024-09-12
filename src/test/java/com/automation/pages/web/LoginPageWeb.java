package com.automation.pages.web;

import com.automation.pages.interfaces.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageWeb extends BasePageWeb implements LoginPage {

    @FindBy(xpath = "//input[@type='number']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    @FindBy(id = "error-msg")
    WebElement errMsg;






    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public boolean verifyUserOnLoginPage() {
        return continueButton.isDisplayed();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public boolean verifyErrorMessage(String errMessage) {
        return errMsg.getText().equals(errMessage);
    }





}
