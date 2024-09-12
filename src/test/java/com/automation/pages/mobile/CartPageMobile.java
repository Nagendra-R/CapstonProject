package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageMobile extends BasePageMobile implements CartPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/bagEmptyHeaderTv']")
    WebElement emptyBagText;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove']")
    WebElement removeButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/offerPrice']")
    WebElement itemPriceElement;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/fee_value_tv']")
    WebElement deliveryFeeElement;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/row_cart_summary_tv_total']")
    WebElement amountPayable;


    double itemPrice=0.0;
    double deliveryFee=0.0;
    double itemPriceAndDeliveryFee=0.0;
    double finalAmount;



    @Override
    public boolean getTextFromCartPage() {
        return isPresent(emptyBagText);
    }

    @Override
    public boolean verifyUserOnCartPage() {
        return isPresent(removeButton);
    }

    @Override
    public boolean verifyItemIsAdded() {
        return isPresent(removeButton);
    }

    @Override
    public void USerSumTheItemPriceAndDeliveryFee(){
        itemPrice = Double.parseDouble(itemPriceElement.getText().replace(",","").substring(1));
        deliveryFee = Double.parseDouble(deliveryFeeElement.getText().replace(",","").substring(1));
        itemPriceAndDeliveryFee = itemPrice + deliveryFee;
        System.out.println(itemPrice+ " "+ deliveryFee +" "+ itemPriceAndDeliveryFee);
    }

    public boolean verifyAmountPayableWithItemPriceAndDeliveryFee(){
        finalAmount = Double.parseDouble(amountPayable.getText().replace(",","").substring(1));
        System.out.println(finalAmount);
        return finalAmount == itemPriceAndDeliveryFee;

    }



}
