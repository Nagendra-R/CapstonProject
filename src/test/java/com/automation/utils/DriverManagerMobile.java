package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManagerMobile {

    static AppiumDriver driver;

    public static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "C://Users//280751//Downloads//ajio.apk");
        desiredCapabilities.setCapability("appPackage", "com.ril.ajio");
        desiredCapabilities.setCapability("appActivity", "com.ril.ajio.launch.activity.SplashScreenActivity");
        driver = new AndroidDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static AppiumDriver getMobileDriver() {
        return DriverManagerMobile.driver;
    }
}
