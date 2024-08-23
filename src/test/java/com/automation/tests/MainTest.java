package com.automation.tests;

import com.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void verifyUserOpenWebsite(){
        HomePage homePage = new HomePage();
        homePage.openWebsite();
        Assert.assertEquals("https://www.ajio.com/",homePage.verifyUserOnHomePage());
    }
}
