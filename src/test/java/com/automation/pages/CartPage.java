package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='ic-cart ']")
    WebElement cartIconButton;

    @FindBy(xpath = "//button[text()='Proceed to shipping']")
    WebElement proceedToShippingButton;

    @FindBy(id = "error-tooltip")
    WebElement textInEmptyCartPage;

    public boolean verifyItemAddedToBag() {
        clickElementByJS(cartIconButton);
        return proceedToShippingButton.isDisplayed();
    }



    public String getTextFromCartPage() {
        return textInEmptyCartPage.getText();
    }
}
