package com.automation.pages.interfaces;

public interface ProductListingPage {
    boolean verifyEachItemWithText(String itemText);

    boolean verifyItemsAreShown();

    void clickOnTheFilters();

    void clickOnThePriceButton();

    void fillTheMinAndMaxAmount(String min, String max);

    boolean verifyUserOnSearchedItemPage();

    boolean verifyThePriceBetweenMinAndMax(String minPrice,String maxPrice);


    void selectTheHighestPrice(String highestPrice);

    boolean checkItemPricesInDescendingOrder();

    void clickOnFirstItem();

    boolean verifyWithCorrectDiscountOff();

}
