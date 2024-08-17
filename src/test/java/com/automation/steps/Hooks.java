package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        ConfigReader.initProperties();
        DriverManager.createDriver();
    }

    @After
    public void close(){
            DriverManager.getDriver().close();
    }

}
