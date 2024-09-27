package com.automation.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest test;
    private static ExtentSparkReporter reporter;

    public static void initExtentReporter(){
        String reportPath = "src/test/resources/reports/extentReport.html";
        reporter = new ExtentSparkReporter(reportPath);
        extentReports = new ExtentReports();
    }

    public static ExtentTest getTest(){
        return test;
    }

    public static void createTest(String name){
        test = extentReports.createTest(name);
    }

    public static void attachScreenShot(){
        try {
            test.addScreenCaptureFromPath(takeScreenshot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        Random ran = new Random();
        String filePath = "src/test/resources/screenshots" + "/screenshot"+ran.nextInt(1000)+".png";
        FileUtils.copyFile(file,new File(filePath));
        return System.getProperty("user.dir") + "/" + filePath;
    }

    public static void flush() {
        extentReports.attachReporter(reporter);
        extentReports.flush();
    }


}


