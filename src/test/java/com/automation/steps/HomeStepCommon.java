package com.automation.steps;

import com.automation.pages.interfaces.HomePage;
import com.automation.pages.mobile.HomePageMobile;
import com.automation.pages.web.HomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class HomeStepCommon {
    HomePage homePage;

    public HomeStepCommon(){
        String env = ConfigReader.getConfigValue("execute");
        if("web".equals(env)){
            homePage =  new HomePageWeb();
        }else {
            homePage = new HomePageMobile();
        }
    }

//    HomePageWeb homePageWeb = new HomePageWeb();



    @Given("user open the website")
    public void user_open_the_website() {
        homePage.openWebsite();
    }

    @Then("verify user on home page")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(homePage.verifyUserOnHomepage());
    }

    @When("user click on the cart button")
    public void userClickOnTheCartButton() {
        homePage.clickOnCartButton();
    }

    @When("search with {string} in search bar")
    public void searchWithInSearchBar(String item) {
        homePage.searchWithItem(item);
    }

    @And("click on the search symbol")
    public void clickOnTheSearchSymbol() {
        homePage.clickOnTheSearchSymbol();
    }

    @When("user click on the sign in button")
    public void userClickOnTheSignInButton() {
        homePage.clickOnSignInButton();
    }

    @When("user click on the visit ajioluxe tab")
    public void userClickOnTheVisitAjioluxeTab() {
        homePage.clickOnAJioluxe();
    }

    @Then("verify user on ajioluxe page")
    public void verifyUserOnAjioluxePage() {
        Assert.assertTrue(homePage.verifyUserOnAjioLuxePage());
    }

    @When("go to footer and click on the men")
    public void goToFooterAndClickOnThe() {
        homePage.clickOnFooterItem();
    }

    @Then("validate user on mens page")
    public void validateUserOnMensPage() {
        Assert.assertEquals("https://www.ajio.com/shop/men",homePage.verifyUserOnMensPage());
    }

    @When("move the cursor to the men web element")
    public void moveTheCursorToTheMenWebElement() {
        homePage.moveCursorToMenWebElement();
    }

    @Then("verify mouse hover is working or not")
    public void verifyMouseHoverIsWorkingOrNot() {
        Assert.assertTrue(homePage.validateTheMouseHoverIsWorking());
    }

    @When("click on the account")
    public void clickOnTheAccount() {
        homePage.clickOnAccount();
    }






//
//    @Then("validate user on home page")
//    public void validate_user_on_home_page() {
//        Assert.assertEquals("https://www.ajio.com/", homePage.verifyUserOnHomePage());
//    }
//
//






//    @Then("verify user on home screen")
//    public void verifyUserOnHomeScreen() {
//        assertTrue(homePage.verifyUserOnHomeScreen());
//    }




//
//
//    @When("user search with {string}")
//    public void userSearchWith(String item) {
//        homePage.searchWithItem(item);
//    }
//
//
//    @When("user click on the cart button")
//    public void userClickOnTheCartButton() {
//        homePage.clickOnCartButton();
//
//    }
//

//

//




}
