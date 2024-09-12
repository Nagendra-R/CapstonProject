package com.automation.steps;

import com.automation.pages.interfaces.SingleProductPage;
import com.automation.pages.mobile.SingleProductPageMobile;
import com.automation.pages.web.SingleProductPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SingleProductStepCommon {

    SingleProductPage singleProductPage;

    public SingleProductStepCommon() {
        String env = ConfigReader.getConfigValue("execute");
        if ("web".equals(env)) {
            singleProductPage =  new SingleProductPageWeb();
        } else {
            singleProductPage = new SingleProductPageMobile();
        }
    }



    @Then("verify user on single product page")
    public void verifyUserOnSingleProductPage() {
        Assert.assertTrue(singleProductPage.verifyAddToBagIsDisplayed());
    }

    @When("click on the wishlist and similar button to remove popup")
    public void clickOnTheWishlistAndSimilarButtonToRemovePopup() {
        singleProductPage.clickOnTheWishListAndSimilarButtonPopUp();
    }

    @And("select the size {string}")
    public void selectTheSize(String size) {
        singleProductPage.selectTheItemSize(size);
    }

    @When("click on the add to bag button")
    public void clickOnTheAddToBagButton() {
        singleProductPage.clickOnAddToBag();
    }

    @Then("user click on the cart button in single product page")
    public void userClickOnTheCartButtonInSingleProductPage() {
        singleProductPage.clickOnTheCartBagIcon();
    }

    @And("click on the add to bag button firstTime")
    public void clickOnTheAddToBagButtonFirstTime() {
        singleProductPage.clickOnAddToBagFirstTime();
    }
}
