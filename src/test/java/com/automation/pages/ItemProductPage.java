package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ItemProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='header2']")
    WebElement shirtsText;

    @FindBy(xpath = "//select[@id='sortBy']/option")
    List<WebElement> listOfSortType;

    @FindBy(xpath = "//span[@class='price  ']/strong")
    List<WebElement> listOfPrices;

    public boolean verifyUserOnShirtsPage() {
        return shirtsText.isDisplayed();
    }

    public void selectTheHighestPrice(String sortType) {
        for (WebElement priceType:listOfSortType){
            if(priceType.getText().equals(sortType)){
                priceType.click();
            }
        }

        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    public boolean checkItemPricesInDescendingOrder() {
        List<Double> prices = new ArrayList<>();
        for(int i=0;i<10;i++){
            String eachPrice = listOfPrices.get(i).getText();
            Double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",",""));

            prices.add(itemPrice);
        }
        System.out.println(prices);
        for(int i=1;i<prices.size();i++){
            if(prices.get(i) > prices.get(i - 1)){
                return false;
            }
        }
        return true;
    }
}
