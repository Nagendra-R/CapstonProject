package com.automation.pages.web;

import com.automation.utils.DriverManagerWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageWeb {

    WebDriver driver;
    WebDriverWait wait;

    public BasePageWeb() {
        this.driver = DriverManagerWeb.getWebDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementLocated(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListOfElementLocated(List<WebElement> eleList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(eleList));
    }






}
