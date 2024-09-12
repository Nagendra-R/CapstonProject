package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageWeb extends BasePageWeb implements CartPage {

    @FindBy(xpath = "//p[@class='empty-msg']")
    WebElement textInEmptyCartPage;

    @FindBy(xpath = "//div[text()='Delete']")
    WebElement deleteButton;



    @Override
    public boolean getTextFromCartPage() {
        return textInEmptyCartPage.isDisplayed();
    }

    @Override
    public boolean verifyUserOnCartPage() {
        return deleteButton.isDisplayed();
    }

    @Override
    public boolean verifyItemIsAdded() {
        return deleteButton.isDisplayed();
    }
}
