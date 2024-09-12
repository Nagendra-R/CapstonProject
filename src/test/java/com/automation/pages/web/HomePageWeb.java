package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageWeb extends BasePageWeb implements HomePage {

    @FindBy(xpath = "//div[@class='ic-cart ']")
    WebElement cartIconButton;

    @FindBy(xpath = "//input[@name='searchVal']")
    WebElement searchInput;

    @FindBy(xpath = "//span[@class='ic-search']")
    WebElement searchButton;

    @FindBy(id = "loginAjio")
    WebElement signInButton;

    @FindBy(xpath = "//li[@class='visit-ajio']/a")
    WebElement ajioLuxe;

    @FindBy(xpath = "//div[@class='ftr-items']/a[@title='Men']")
    WebElement footerItemMen;

    @FindBy(xpath = "//span[text()='MEN']")
    WebElement menMouseHover;

    @FindBy(xpath = "(//div[@class='title']/a/span/strong[text()='CLOTHING'])[1]")
    WebElement afterMouseHover;



    @Override
    public void openWebsite() {
        driver.get("https://www.ajio.com/");
    }

    @Override
    public boolean verifyUserOnHomepage() {
        String url = driver.getCurrentUrl();
        return "https://www.ajio.com/".equals(url);
    }

    @Override
    public void clickOnCartButton() {
        cartIconButton.click();
    }

    @Override
    public void searchWithItem(String item) {
        searchInput.sendKeys(item);
    }

    @Override
    public void clickOnTheSearchSymbol() {
        searchButton.click();
    }


    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnAJioluxe() {
        ajioLuxe.click();
    }

    public boolean verifyUserOnAjioLuxePage() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.contains("https://luxe.ajio.com");
    }

    public void clickOnFooterItem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        footerItemMen.click();
    }

    public String verifyUserOnMensPage() {
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
