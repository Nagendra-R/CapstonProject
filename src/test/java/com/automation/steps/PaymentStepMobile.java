package com.automation.steps;

import com.automation.pages.PaymentPageMobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PaymentStepMobile {
    PaymentPageMobile paymentPageMobile = new PaymentPageMobile();



    @Then("verify user on the payment screen")
    public void verifyUserOnThePaymentScreen() {
        Assert.assertTrue(paymentPageMobile.verifyUserOnPaymentScreen());
    }

    @When("user store the amount before apply coupon")
    public void userStoreTheAmountBeforeApplyCoupon() {
        paymentPageMobile.storeAmountBeforeApplyingCoupon();
    }

    @When("user click on the apply coupon")
    public void userClickOnTheApplyCoupon() {
        paymentPageMobile.clickOnApplyCoupon();
    }


    @And("click on the cancel pop up")
    public void clickOnTheCancelPopUp() {
        paymentPageMobile.clickOnCancelButtonAfterCouponApplied();
    }

    @Then("verify coupon has applied")
    public void verifyCouponHasApplied() {
        Assert.assertTrue(paymentPageMobile.checkBalanceBeforeAndAfterCouponApplied());
    }
}
