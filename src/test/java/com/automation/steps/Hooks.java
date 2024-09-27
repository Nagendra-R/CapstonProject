package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.*;

public class Hooks {


    @BeforeAll
    public static void initialSetUp() {
        ConfigReader.initProperties();
        ExtentReportManager.initExtentReporter();
    }


    @Before
    public void setUp(Scenario scenario) {
        DriverManager.createDriver();
        ReportManager.initReporter(scenario);
        ExtentReportManager.createTest(scenario.getName());
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ReportManager.attachScreenshot();
            ExtentReportManager.attachScreenShot();
            ExtentReportManager.getTest().fail("Test Failed : " + scenario.getName());
        } else {
            ExtentReportManager.getTest().pass("Test Passed : " + scenario.getName());
        }
        DriverManager.getDriver().quit();
    }


    @AfterAll
    public static void finalCleanUp() {
        ExtentReportManager.flush();
    }

}



