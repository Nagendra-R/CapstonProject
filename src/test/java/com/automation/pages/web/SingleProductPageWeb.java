package com.automation.pages.web;

import com.automation.pages.interfaces.SingleProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingleProductPageWeb extends BasePageWeb implements SingleProductPage {

    @FindBy(xpath = "//span[text() = 'ADD TO BAG']")
    WebElement addToBagButton;

    @FindBy(xpath = "//div[@class='ic-cart ']")
    WebElement cartBagIcon;

    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToButton;

    String loc = "//span[text()='%s']";



    @Override
    public boolean verifyAddToBagIsDisplayed() {
        return addToBagButton.isDisplayed();
    }

    @Override
    public void selectTheItemSize(String size) {
        String xPath = String.format(loc,size);
        driver.findElement(By.xpath(xPath)).click();
    }

    @Override
    public void clickOnAddToBag() {
        addToBagButton.click();
    }

    @Override
    public void clickOnTheCartBagIcon() {
        waitForElementLocated(goToButton);
        cartBagIcon.click();
    }


}
