package com.app.base;

import com.app.utils.LoggerUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Logger logger = LoggerUtility.getLogger(BasePage.class);
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(5);

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitAndClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
            logger.info("ACTION : Waiting for element to be clickable: {}", getElementDescription(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("ACTION : Element is clickable: {}", getElementDescription(element));
            element.click();
            logger.info("ACTION : Clicked on element: {}", getElementDescription(element));
        } catch (RuntimeException e) {
            logger.error("ERROR : Exception while clicking element: {}", getElementDescription(element), e);
            throw e;
        }
    }

    public String waitAndGetText(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
            logger.info("ACTION : Waiting for element to be visible: {}", getElementDescription(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("ACTION : Element is visible: {}", getElementDescription(element));
            String text = element.getText();
            logger.info("ACTION : Captured text: {}", text);
            return text;
        } catch (RuntimeException e) {
            logger.error("ERROR : Exception while getting text from element: {}", getElementDescription(element), e);
            throw e;
        }
    }

    public void waitAndSendKeys(WebElement element, String textToEnter) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
            logger.info("ACTION : Waiting for element to be visible: {}", getElementDescription(element));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("ACTION : Element is visible: {}", getElementDescription(element));
            element.sendKeys(textToEnter);
            logger.info("ACTION : Sent text to element: {}", textToEnter);
        } catch (RuntimeException e) {
            logger.error("ERROR : Exception while sending keys to element: {}", getElementDescription(element), e);
            throw e;
        }
    }

    public boolean waitAndCheckVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        wait.withTimeout(Duration.ofSeconds(2));
        logger.info("ACTION : Waiting for 2 seconds");
        if (element.isDisplayed()) {
            logger.info("ACTION : The Element is Displayed: {}", getElementDescription(element));
            return true;
        } else {
            logger.info("ACTION : Element is not Displayed: {}", getElementDescription(element));
            return false;
        }
    }

    private String getElementDescription(WebElement element) {
        try {
            return element.toString() + " | Text: " + element.getText();
        } catch (Exception e) {
            return element.toString();
        }
    }
}
