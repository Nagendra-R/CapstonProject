package com.automation.pages.web;

import com.automation.pages.interfaces.ProductListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductListingPageWeb extends BasePageWeb implements ProductListingPage {

    @FindBy(xpath = "//div[@class='nameCls']")
    List<WebElement> listOfItemNames;

    @FindBy(xpath = "//div[contains(text(), 'Sorry')]")
    WebElement meaninglessText;

    @FindBy(xpath = "(//div[@class='nameCls'])[1]")
    WebElement firstItem;

    @FindBy(xpath = "//span[@class='price  ']/strong")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//span[text()='price']")
    WebElement priceButton;

    @FindBy(xpath = "//input[@name='minPrice']")
    WebElement minPriceField;

    @FindBy(xpath = "//input[@name='maxPrice']")
    WebElement maxPriceField;

    @FindBy(xpath = "//div[@class='facet-min-price-filter']/button")
    WebElement submitMinMaxButton;

    @FindBy(xpath = "//select[@id='sortBy']/option")
    List<WebElement> listOfSortType;

    @FindBy(xpath = "//div[@class='fnl-plp-afliter']")
    WebElement filterOption;

    @FindBy(xpath = "//span[@class='discount']")
    List<WebElement> listOfDiscountOff;

    @FindBy(xpath = "//span[@class='orginal-price']")
    List<WebElement>  listOfOriginalPrices;


    @Override
    public boolean verifyEachItemWithText(String itemText) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            if (!listOfItemNames.get(i).getText().contains(itemText)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verifyItemsAreShown() {
        return meaninglessText.isDisplayed();
    }

    @Override
    public void clickOnTheFilters() {

    }

    @Override
    public void clickOnThePriceButton() {
        priceButton.click();
    }

    @Override
    public void fillTheMinAndMaxAmount(String min, String max) {

        minPriceField.sendKeys(min);
        maxPriceField.sendKeys(max);
        submitMinMaxButton.click();
    }

    @Override
    public boolean verifyUserOnSearchedItemPage() {
        return firstItem.isDisplayed();
    }

    @Override
    public boolean verifyThePriceBetweenMinAndMax(String minPrice,String maxPrice) {
        double min = Double.parseDouble(minPrice);
        double max = Double.parseDouble(maxPrice);
        waitForListOfElementLocated(listOfPrices);
        waitForElementLocated(filterOption);
        for (int i = 0; i < 10; i++) {
            String eachPrice = listOfPrices.get(i).getText();
            System.out.println("===>" + eachPrice);
            double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",", ""));
            if (!(itemPrice >= min && itemPrice <= max)) {
                return false;
            }
        }
        return true;
    }

    public void selectTheHighestPrice(String sortType) {
        for (WebElement priceType : listOfSortType) {
            if (priceType.getText().equals(sortType)) {
                priceType.click();
                break;
            }
        }

    }



    public boolean checkItemPricesInDescendingOrder() {
        waitForListOfElementLocated(listOfPrices);
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String eachPrice = listOfPrices.get(i).getText();
            Double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",", ""));
            prices.add(itemPrice);
        }
        System.out.println(prices);
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clickOnFirstItem() {
        firstItem.click();
        Set<String> handles = driver.getWindowHandles();
        String[] handleArray = handles.toArray(new String[0]);
        // Switch to the new tab or window (usually the second handle in the list)
        driver.switchTo().window(handleArray[1]);
    }

    @Override
    public boolean verifyWithCorrectDiscountOff() {
        System.out.println(listOfDiscountOff.size());
        for (WebElement eachItem:listOfDiscountOff){
            int discount = 100 - Integer.parseInt(eachItem.getText().substring(1,3));
            int initalPrice;
            System.out.println(discount);
        }

        for (int i=0;i<listOfDiscountOff.size();i++){
            int discount = 100 - Integer.parseInt(listOfDiscountOff.get(i).getText().substring(1,3));
        }

        return true;
    }


}
