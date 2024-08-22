package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GridViewPage extends BasePage{

    @FindBy(xpath = "//span[@aria-label='BEAUTY']")
    WebElement beautyMenu;

    @FindBy(xpath = "//div[@id='0']//div[@class='nameCls']")
    List<WebElement> gridViewProductList;

    @FindBy(xpath = "//div[@aria-label='View grid 5']")
    WebElement gridViewButton;

    @FindBy(xpath = "//div[@aria-label='View grid 3']")
    WebElement threeGridViewButton;


    public void beautyMenuOptionClicks(){

        beautyMenu.click();
    }


    public void gridViewBtnClicks() throws InterruptedException {

        gridViewButton.click();
        Thread.sleep(3000);

    }
    boolean finalResult;

    public boolean verifyRowChanged(){
        threeGridViewButton.click();
        int beforeSize = gridViewProductList.size();
        gridViewButton.click();
        int afterSize = gridViewProductList.size();

        if((beforeSize != afterSize) && afterSize == 5 && beforeSize == 3){
            finalResult = true;
        }
        System.out.println("before Size:"+beforeSize);
        System.out.println("After Size:"+afterSize);
        return finalResult;
    }
}
