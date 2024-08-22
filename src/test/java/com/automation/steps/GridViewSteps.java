package com.automation.steps;

import com.automation.pages.GridViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GridViewSteps {

    GridViewPage gridViewPage = new GridViewPage();


    @And("user clicks on the beauty menu from the homepage")
    public void userClicksOnTheBeautyMenuFromTheHomepage() {

        gridViewPage.beautyMenuOptionClicks();

    }

    @When("user is on the beauty page and clicks grid button")
    public void userIsOnTheBeautyPageAndClicksGridButton() throws InterruptedException {

        gridViewPage.gridViewBtnClicks();
    }

    @Then("verify number of products displayed in a single row changed")
    public void verifyNumberOfProductsDisplayedInASingleRowChanged() {

        Assert.assertTrue(gridViewPage.verifyRowChanged());
    }
}
