package com.automation.steps;

import com.automation.pages.CheckOutPageMobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckOutStepMobile {

    CheckOutPageMobile checkOutPageMobile = new CheckOutPageMobile();

    @Then("verify user on the add to bag screen")
    public void verifyUserOnTheAddToBagScreen() {
        Assert.assertTrue(checkOutPageMobile.verifyAddToBagButtonIsDisplayed());
    }

    @When("click on the add to bag button on checkout")
    public void clickOnTheAddToBagButtonOnCheckout() {
        checkOutPageMobile.clickOnAddToBagButton();
    }

    @And("select the {string} size and click on add to bag")
    public void selectTheSizeAndClickOnAddToBag(String size) {
        checkOutPageMobile.clickOnSizeAndAddToBagButton(size);
    }

    @Then("verify add to bag is changed to view bag")
    public void verifyAddToBagIsChangedToViewBag() {
        Assert.assertTrue(checkOutPageMobile.verifyViewBagIsDisplayed());
    }

    @When("click on the view bag")
    public void clickOnTheViewBag() {
        checkOutPageMobile.clickOnViewBagButton();
    }

    @When("click on the wishlist and similar button to remove popup")
    public void clickOnTheWishlistAndSimilarButtonToRemovePopup() {
        checkOutPageMobile.clickOnTheWishListAndSimilarButtonPopUp();
    }

    @When("user scroll till the select size text")
    public void userScrollTillTheSelectSizeText() {
        checkOutPageMobile.scrollTillTheSelectSize();
    }

    @Then("validate the item has more than one color")
    public void validateTheItemHasMoreThanOneColor() {
        Assert.assertTrue(checkOutPageMobile.verifyItemHasMoreThanOneColourItem());
    }
}
