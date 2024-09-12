package com.automation.pages.mobile;

import com.automation.utils.DriverManagerMobile;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BasePageMobile {

    static AppiumDriver driver;
    WebDriverWait wait;


    public BasePageMobile() {
        driver = DriverManagerMobile.getMobileDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public boolean isPresent(WebElement element) {
        try {
            setImplicitWait(10);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(30);
        }
    }


    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }

    public void setImplicitWait(long sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public void waitForElementLocated(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListOfElementLocated(List<WebElement> eleList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(eleList));
    }

    public String getRandomInteger() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 10);
        return String.valueOf(randomNumber);
    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }


}
