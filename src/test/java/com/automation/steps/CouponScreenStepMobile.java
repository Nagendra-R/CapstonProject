package com.automation.steps;

import com.automation.pages.CouponScreenPageMobile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CouponScreenStepMobile {

    CouponScreenPageMobile couponScreenPageMobile = new CouponScreenPageMobile();


    @Then("validate user on coupon screen")
    public void validateUserOnCouponScreen() {
        Assert.assertTrue(couponScreenPageMobile.verifyUserOnCouponScreen());
    }

    @When("click on the first coupon on the coupon screen")
    public void clickOnTheFirstCouponOnTheCouponScreen() {
        couponScreenPageMobile.clickOnFirstApplyCoupon();
    }
}
