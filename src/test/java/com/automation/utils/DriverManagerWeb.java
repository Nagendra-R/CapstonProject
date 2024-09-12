package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManagerWeb {

     static WebDriver driver;

    public static void createDriver() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    public static WebDriver getWebDriver() {
        return DriverManagerWeb.driver;
    }


}
