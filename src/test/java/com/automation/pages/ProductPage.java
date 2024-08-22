package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage{

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


}
