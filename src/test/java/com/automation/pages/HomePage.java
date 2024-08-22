package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    //------------- Goto Top Arrow Button --------------------------
    @FindBy(xpath = "//strong[contains(text(), 'Follow us')]")
    WebElement followUsText;

    @FindBy(xpath = "//img[@width='130px']")
    WebElement mainLogo;

    @FindBy(xpath = "//aside[@data-testid='react-scroll-up-button']")
    WebElement goToTopBtn;
    //----------------------------------------------------------------------



    //------------- Goto Top Arrow Button --------------------------

    public void openWebsite() {
        driver.get("https://www.ajio.com/");
    }

    public String verifyUserOnHomePage() {
        return driver.getCurrentUrl();
    }

    public void gotoBottomSection(){
        followUsText.click();
    }
    public void clicksOnButton(){
        goToTopBtn.click();
    }
    public boolean verifyTopSectionDisplayed(){
        return mainLogo.isDisplayed();
    }
    //-----------------------------------------------------------------



}
