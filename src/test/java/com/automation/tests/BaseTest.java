package com.automation.tests;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void setUp(){
        ConfigReader.initProperties();
        DriverManager.createDriver();
    }

    @AfterMethod
    public void clean(){
        DriverManager.getDriver().close();
    }


}
