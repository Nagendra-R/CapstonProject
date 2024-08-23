package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ItemProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='header2']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='sortBy']/option")
    List<WebElement> listOfSortType;

    @FindBy(xpath = "//span[@class='price  ']/strong")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//div[@class='nameCls']")
    List<WebElement> listOfItemNames;

    @FindBy(xpath = "//div[@class='nameCls'][1]")
    WebElement firstItem;

    @FindBy(xpath = "//span[text() = 'ADD TO BAG']")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[text() = 'L']")
    WebElement selectSize;

    @FindBy(xpath = "//span[text()='price']")
    WebElement priceButton;

    @FindBy(xpath = "//input[@name='minPrice']")
    WebElement minPriceField;

    @FindBy(xpath = "//input[@name='maxPrice']")
    WebElement maxPriceField;

    @FindBy(xpath = "//div[@class='facet-min-price-filter']/button")
    WebElement submitMinMaxButton;

    @FindBy(xpath = "//div[contains(text(), 'Sorry')]")
    WebElement meaninglessText;


    public boolean verifyUserOnShirtsPage() {
        return searchText.isDisplayed();
    }

    public void selectTheHighestPrice(String sortType) {
        for (WebElement priceType : listOfSortType) {
            if (priceType.getText().equals(sortType)) {
                priceType.click();
            }
        }
        waitForListOfElementLocated(listOfPrices);

    }

    public boolean checkItemPricesInDescendingOrder() {
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

    public boolean verifyItemsWithItemName(String itemName) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            if (!listOfItemNames.get(i).getText().contains(itemName)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnFirstItem() {
        firstItem.click();
        Set<String> handles = driver.getWindowHandles();
        String[] handleArray = handles.toArray(new String[0]);
        // Switch to the new tab or window (usually the second handle in the list)
        driver.switchTo().window(handleArray[1]);

    }

    public boolean verifyAddToBagIsDisplayed() {
        return addToBagButton.isDisplayed();
    }

    public void clickOnAddToBag() {
        selectSize.click();
        addToBagButton.click();

    }


    public void fillTheMinAndMaxAmount(String min, String max) {
        priceButton.click();
        minPriceField.sendKeys(min);
        maxPriceField.sendKeys(max);
        submitMinMaxButton.click();
    }

    public boolean verifyThePriceBetweenMinAndMax() {
        waitForListOfElementLocated(listOfPrices);
        for (int i = 0; i < 10; i++) {
            String eachPrice = listOfPrices.get(i).getText();
            System.out.println("===>" + eachPrice);
            double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",", ""));
            if (!(itemPrice >= 600 && itemPrice <= 1200)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyItemsAreShown() {
        return meaninglessText.isDisplayed();
    }
}
