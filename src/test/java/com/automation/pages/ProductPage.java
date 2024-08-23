package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class ProductPage extends BasePage{

    GridViewPage gridViewPage = new GridViewPage();

    Actions action = new Actions(driver);

//---------------- category number verification ------------------------

    @FindBy(xpath = "//span[@aria-label='MEN']")
    WebElement menElementToHover;

    String clothTypeStr = "//a[@title='%s' and @href='/men-jackets-coats/c/830216010']";


    @FindBy(xpath = "//input[@id='Women - Jackets & Shrugs']/following-sibling::label")
    WebElement jacketsAndShrugs;

    @FindBy(xpath = "//div[contains(@aria-label, 'Found')]/strong")
    WebElement itemsFoundText;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void hoverFunctionality(String clothType){
        action.moveToElement(menElementToHover).perform();

        String clothTypeXpath = String.format(clothTypeStr, clothType);
        driver.findElement(By.xpath(clothTypeXpath)).click();
    }

    public void categorySelection(){
        jacketsAndShrugs.click();

    }
    public String getTheNumber(){
        String jacketsStr = jacketsAndShrugs.getText();
        int startIndex = jacketsStr.indexOf('(');
        int endIndex = jacketsStr.indexOf(')');

        return jacketsStr.substring(startIndex+1, endIndex);
    }

    public boolean verifyNumberOfProducts() throws InterruptedException {
        Thread.sleep(4000);
        String itemsFoundStr = itemsFoundText.getText();
        System.out.println("Items found section: "+itemsFoundStr);
        System.out.println("Category selection:"+ getTheNumber());
        return itemsFoundStr.contains(getTheNumber());
    }

//--------------------------------------------------------------------------------------

// ----After clicking on certain rating, make sure product with that rating is displayed-----

    @FindBy(xpath = "//div[@id='0']//div[@class='_1gIWf']/p")
    List<WebElement> ratingsList;

    @FindBy(xpath = "//a[@title='HOME AND KITCHEN']")
    WebElement homeAndKitchenMenu;

    String ratingXpathString = "//input[@id='%d star & above'] ";

    @FindBy(xpath = "//span[contains(text(), 'rating')]")
    WebElement ratingMenu;


    public void menuFromTheHeaderClicks(){
        homeAndKitchenMenu.click();
    }

    public void ratingSelectionMethod(String rating) throws InterruptedException {
        ratingMenu.click();

        String ratingString = String.format(ratingXpathString, Integer.parseInt(rating));
        driver.findElement(By.xpath(ratingString)).click();
        Thread.sleep(4000);

    }
    boolean finalResult;
    public boolean verifyRatingOfProducts() throws InterruptedException {
        Thread.sleep(3000);
        int ratingValue = Integer.parseInt(ConfigReader.getConfigValue("rating.option"));
        for(WebElement rate : ratingsList){
            System.out.println("All the ratings:"+rate.getText());
            int value = Integer.parseInt(rate.getText());
            if(value >= ratingValue){
                finalResult = true;

            }
        }
        return finalResult;
    }

//-----------------------------------------------------------------------------------------------
//-------------------      verifying selected brand only displayed      -------------------------

    @FindBy(xpath = "//a[text()='Brands']")
    WebElement brandElementToHover;

    String brandToSelect = "//a[text()='%s']";

    String productListingPageName = "//div[@aria-label='%s']";

    String individualBrandName = "//div[@aria-label='%s']";



    public void headerSectionMenuHovering(){

        action.moveToElement(menElementToHover).perform();

    }

    public void brandMenuHovering(){
        action.moveToElement(brandElementToHover).perform();

    }

    public void brandSelection(String brand){

        String brandSelectXpathMake = String.format(brandToSelect, brand);
        driver.findElement(By.xpath(brandSelectXpathMake)).click();
    }

    public boolean productListingOfBrand() throws InterruptedException {
        Thread.sleep(3000);
        gridViewPage.gridViewButton.click();
        Thread.sleep(3000);

        String productListingPageNameXpath = String.format(productListingPageName, ConfigReader.getConfigValue("brand").toUpperCase(Locale.ROOT));
        WebElement heading = driver.findElement(By.xpath(productListingPageNameXpath));
        return heading.isDisplayed();
    }

    boolean noRepetitionResult;
    public boolean verifyProductBrand() throws InterruptedException {
        Thread.sleep(3000);
        String brandName  = String.format(individualBrandName, ConfigReader.getConfigValue("brand").toUpperCase());
        List<WebElement> listOfNames = driver.findElements(By.xpath(brandName));
        int max = 10;
        if (listOfNames.size() > max) {
            listOfNames = listOfNames.subList(0, max);
        }
        for(WebElement element : listOfNames){
            if(element.getText().equals(ConfigReader.getConfigValue("brand").toUpperCase())){
                noRepetitionResult = true;
            }
        }
        return noRepetitionResult;
    }
//-----------------------------------------------------------------------------------------
//------------------------------- coupon verification -------------------------------------
    @FindBy(xpath = "//div[@aria-label='grid']/div/div[1]")
    WebElement singleProductSelection;

    public void singleProductClick(){
        singleProductSelection.click();
    }




}
