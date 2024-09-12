package com.automation.tests;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManagerWeb;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void setUp(){
        ConfigReader.initProperties();
        DriverManagerWeb.createDriver();
    }

    @AfterMethod
    public void clean(){
        DriverManagerWeb.getWebDriver().close();
    }


}
