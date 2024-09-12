package com.automation.pages.interfaces;

public interface SingleProductPage {

    boolean verifyAddToBagIsDisplayed();

    default void clickOnTheWishListAndSimilarButtonPopUp() {
    }

    void selectTheItemSize(String size);

    void clickOnAddToBag();

    void clickOnTheCartBagIcon();

     default void clickOnAddToBagFirstTime(){

     }
}
