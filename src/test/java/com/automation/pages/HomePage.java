package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(xpath = "//div[@class='ic-cart ']")
    WebElement cartIconButton;

    @FindBy(xpath = "//div[@class='ftr-items']/a[@title='Men']")
    WebElement footerItem;

    @FindBy(xpath = "//span[text()='MEN']")
    WebElement menMouseHover;

    @FindBy(xpath = "(//div[@class='title']/a/span/strong[text()='CLOTHING'])[1]")
    WebElement afterMouseHover;


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

    public void clickOnCartButton() {
        cartIconButton.click();
    }

    public void clickOnFooterItem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public String verifyUseronMensPage() {
        return driver.getCurrentUrl();
    }

    public void moveCursorToMenWebElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(menMouseHover).perform();
    }

    public boolean validateTheMouseHoverIsWorking() {
        return afterMouseHover.isDisplayed();
    }
}
