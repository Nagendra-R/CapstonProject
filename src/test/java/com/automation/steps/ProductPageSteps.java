package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {

    ProductPage productPage = new ProductPage();

    @Then("hover over men section and click on a type {string}")
    public void hover_over_men_section_and_click_on_a_type(String type) {

        productPage.hoverFunctionality(ConfigReader.getConfigValue(type));

    }

    @When("product list page is displayed select a category")
    public void productListPageIsDisplayedSelectACategory() {

        productPage.categorySelection();

    }

    @Then("verify the number along the category is same as total products")
    public void verify_the_number_along_the_category_is_same_as_total_products() throws InterruptedException {

        Assert.assertTrue(productPage.verifyNumberOfProducts());

    }



//-------------------------------------------------------------------------------------------
    // RATING VERIFICATION

    @And("clicks on the home and kitchen menu from the header")
    public void clicksOnTheHomeAndKitchenMenuFromTheHeader() {
        productPage.menuFromTheHeaderClicks();

    }


    @When("user is on home and kitchen page, click on a rating {string}")
    public void userIsOnHomeAndKitchenPageClickOnARating(String rating) throws InterruptedException {

        productPage.ratingSelectionMethod(ConfigReader.getConfigValue(rating));

    }

    @Then("verify the products have the selected rating only")
    public void verifyTheProductsHaveTheSelectedRatingOnly() throws InterruptedException {

        Assert.assertTrue(productPage.verifyRatingOfProducts());

    }

//----------------------------------------------------------------------------------------------------
//--------------      brand selection verification      -------------------

    @And("user hovers above a menu in the header section")
    public void userHoversAboveAMenuInTheHeaderSection() {

        productPage.headerSectionMenuHovering();
    }


    @Then("hover over the brand menu option")
    public void hoverOverTheBrandMenuOption() {

        productPage.brandMenuHovering();
    }

    @And("select a particular brand {string}")
    public void selectAParticularBrand(String brand) {

        productPage.brandSelection(ConfigReader.getConfigValue(brand));
    }

    @When("user is on the product listing page")
    public void userIsOnTheProductListingPage() throws InterruptedException {

        Assert.assertTrue(productPage.productListingOfBrand());
    }

    @Then("verify every product is of the selected brand only")
    public void verifyEveryProductIsOfTheSelectedBrandOnly() throws InterruptedException {

        Assert.assertTrue(productPage.verifyProductBrand());
    }

//-------------------------------------------------------------------------------------------
//---------------------------- coupon verification ------------------------------------------

    @Then("click on a product")
    public void clickOnAProduct() {
        productPage.singleProductClick();
    }
}
