package com.automation.steps;

import com.automation.pages.CustomerCare;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CustomerCareSteps {

    CustomerCare customerCare = new CustomerCare();

    @Then("user clicks on customer care option")
    public void user_clicks_on_customer_care_option() {

        customerCare.customerCarePage();

    }
    @When("user select topic {string} and issue")
    public void user_select_topic_and_issue(String topic) {

        customerCare.topicAndIssueSelection(ConfigReader.getConfigValue(topic));

    }
    @Then("verify message is displayed in the get assistance section")
    public void verify_message_is_displayed_in_the_get_assistance_section() {

        Assert.assertTrue(customerCare.verifyGetAssistanceMsg());

    }
}
