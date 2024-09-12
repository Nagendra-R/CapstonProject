package com.automation.pages.interfaces;

public interface CartPage {
       boolean getTextFromCartPage();

       boolean verifyUserOnCartPage();

       boolean verifyItemIsAdded();

       default void USerSumTheItemPriceAndDeliveryFee(){
       }

       default boolean verifyAmountPayableWithItemPriceAndDeliveryFee(){
              return false;
       }
}
