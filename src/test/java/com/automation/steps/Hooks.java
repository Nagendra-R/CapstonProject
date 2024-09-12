package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManagerMobile;
import com.automation.utils.DriverManagerWeb;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


//    @Before
//    public void setUp(Scenario scenario) {
//        ConfigReader.initProperties();
//        DriverManagerWeb.createDriver();
//        ReportManager.initReporter(scenario);
//    }
//
//    @After
//    public void close() {
//        DriverManagerWeb.getDriver().quit();
//    }



    @Before
    public void setUp(Scenario scenario) {
//        System.out.println("fcghjkol");
        ConfigReader.initProperties();
        if (ConfigReader.getConfigValue("execute").equals("mobile")) {
            DriverManagerMobile.createDriver();
        } else {
            DriverManagerWeb.createDriver();
        }

        ExtentReportManager.initExtentReporter();
        ExtentReportManager.createTest(scenario.getName());


    }

    @After
    public void cleanUp(Scenario scenario) {
        if (ConfigReader.getConfigValue("execute").equals("mobile")) {
            DriverManagerMobile.getMobileDriver().quit();
        } else {
            ExtentReportManager.attachScreenShot();
            ExtentReportManager.flush();
            DriverManagerWeb.getWebDriver().quit();
        }

    }

}
