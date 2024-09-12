package com.automation.pages.mobile;

import com.automation.pages.interfaces.SingleProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingleProductPageMobile extends BasePageMobile implements SingleProductPage {

    @FindBy(xpath = "//android.widget.TextView[@text='SIMILAR']")
    WebElement similarButtonPopUp;

    @FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ril.ajio:id/add_to_closet']")
    WebElement wishListButtonPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Add To Bag']")
    WebElement addToBagButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ril.ajio:id/menu_cart_layout']")
    WebElement cartBagIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO BAG']")
    WebElement finalAddToBagButton;

    String loc = "//android.widget.TextView[@text='%s']";




    @Override
    public boolean verifyAddToBagIsDisplayed() {
        return isPresent(addToBagButton);
    }

    @Override
    public void clickOnAddToBagFirstTime(){
        clickOnElementIfPresent(addToBagButton);
    }

    public void clickOnTheWishListAndSimilarButtonPopUp() {
        clickOnElementIfPresent(wishListButtonPopUp);
        clickOnElementIfPresent(similarButtonPopUp);
    }

    @Override
    public void selectTheItemSize(String size) {
        waitForElementLocated(finalAddToBagButton);
        String xPath = String.format(loc,size);
        System.out.println(xPath);
        driver.findElement(By.xpath(xPath)).click();
    }

    @Override
    public void clickOnAddToBag() {
        waitForElementLocated(finalAddToBagButton);
        clickOnElementIfPresent(finalAddToBagButton);
    }

    @Override
    public void clickOnTheCartBagIcon() {
        clickOnElementIfPresent(cartBagIcon);
    }




}
