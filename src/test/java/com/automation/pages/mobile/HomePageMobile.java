package com.automation.pages.mobile;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageMobile extends BasePageMobile implements HomePage {


    @FindBy(xpath = "//android.widget.Button[@text='Allow']")
    WebElement allowBut;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/fahIvMenu']")
    WebElement menuButton;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ril.ajio:id/tab_icon'])[5]")
    WebElement bagIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/llpsTvSearch']")
    WebElement searchFieldInput;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement passInputText;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/search_image']")
    WebElement searchButton;

    @FindBy(xpath = "//strong[text()='Visit AJIO']")
    WebElement aJioTab;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ril.ajio:id/tab_icon'])[3]")
    WebElement accountButton;




    @Override
    public void openWebsite() {
        clickOnElementIfPresent(allowBut);
    }

    @Override
    public boolean verifyUserOnHomepage() {
        return isPresent(menuButton);
    }

    @Override
    public void clickOnCartButton() {
        clickOnElementIfPresent(bagIcon);
    }

    @Override
    public void searchWithItem(String item) {
        searchFieldInput.click();
        passInputText.sendKeys(item);
    }

    @Override
    public void clickOnTheSearchSymbol() {
        clickOnElementIfPresent(searchButton);
    }

    public void clickOnAjio(){
        aJioTab.click();
    }

    @Override
    public void clickOnAccount(){
        clickOnElementIfPresent(accountButton);
    }






}
