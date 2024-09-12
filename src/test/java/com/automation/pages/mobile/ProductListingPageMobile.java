package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductListingPageMobile extends BasePageMobile implements ProductListingPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_row_prd_name_tv']")
    List<WebElement> listOfItems;

    @FindBy()
    WebElement meaningLessText;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ril.ajio:id/plp_filter_view']")
    WebElement filtersButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Price']")
    WebElement priceButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/price_facet_value_range_min_tv']")
    WebElement minField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.ril.ajio:id/price_facet_bottomsheet_min_et']")
    WebElement minFieldInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.ril.ajio:id/price_facet_bottomsheet_max_et']")
    WebElement maxFieldInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Done']")
    WebElement doneButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Apply Filter']")
    WebElement applyFilterButton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_row_brand_tv'])[1]")
    WebElement firstItem;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_row_final_price_tv']")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ril.ajio:id/plp_sort_by_view']")
    WebElement sortByButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_sort_row_title_tv']")
    List<WebElement> listOfSortType;



    @Override
    public boolean verifyEachItemWithText(String itemText) {
        for (WebElement element : listOfItems){
            if(!element.getText().contains(itemText)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verifyItemsAreShown() {
        return isPresent(meaningLessText);
    }

    @Override
    public boolean verifyUserOnSearchedItemPage() {
        return isPresent(firstItem);
    }


    @Override
    public void clickOnTheFilters() {
        clickOnElementIfPresent(filtersButton);
    }

    @Override
    public void clickOnThePriceButton() {
        clickOnElementIfPresent(priceButton);
    }

    @Override
    public void fillTheMinAndMaxAmount(String min, String max) {
        minField.click();
        minFieldInput.sendKeys(min);
        maxFieldInput.sendKeys(max);
        clickOnElementIfPresent(doneButton);
        clickOnElementIfPresent(applyFilterButton);
    }

    @Override
    public boolean verifyThePriceBetweenMinAndMax(String minPrice,String maxPrice) {
        double min = Double.parseDouble(minPrice);
        double max = Double.parseDouble(maxPrice);
        for (WebElement eachItemPrice :listOfPrices){
            double itemPrice = Double.parseDouble(eachItemPrice.getText().substring(1));
            if(!(itemPrice>=min && itemPrice<=max)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void selectTheHighestPrice(String highestPrice) {
        clickOnElementIfPresent(sortByButton);
        for (WebElement sortType : listOfSortType){
            if (sortType.getText().equals(highestPrice)){
                sortType.click();
                break;
            }
        }

    }

    @Override
    public boolean checkItemPricesInDescendingOrder() {
        List<Double> list = new ArrayList<>();

        for (WebElement listOfPrice : listOfPrices) {
            double itemPrice = Double.parseDouble(listOfPrice.getText().substring(1));
            list.add(itemPrice);
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clickOnFirstItem() {
        clickOnElementIfPresent(firstItem);
    }

    @Override
    public boolean verifyWithCorrectDiscountOff() {
        return false;
    }


}
