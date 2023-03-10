package com.bookstore.framework.base;

import com.bookstore.framework.BookStore;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.bookstore.framework.utils.PropertiesLoader.TIMEOUT;

/**
 * class contains common methods for web elements
 */
public class BasePage {

    private final By pageHeader = By.xpath("//div[@class='main-header']");

    public static final Logger logger = Logger.getLogger(BasePage.class);


    protected void click(By element) {
        getElement(element).click();
    }


    protected void clickForceWhenElementIsOverlapped(By element) throws InterruptedException {
        //wait user to login
        Thread.sleep(1000);
        WebElement elem = getElement(element);
        JavascriptExecutor js = (JavascriptExecutor) BookStore.getDriver();
        ;
        js.executeScript("arguments[0].click()", elem);
    }

    protected void enterText(By element, String text) {
        getElement(element).sendKeys(text);
    }

    protected boolean isElementDisplayed(By element) {
        return getElement(element).isDisplayed();
    }

    protected WebElement getElement(By element) {
        waitForElementIsPresent(element);
        return BookStore.getDriver().findElement(element);
    }

    protected void waitForElementIsPresent(By elem) {
        try {
            WebDriverWait wait = new WebDriverWait(BookStore.getDriver(), Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(elem));
        } catch (TimeoutException e) {
            throw new AssertionError("Cannot find element :" + elem);
        }
    }

    public String getCurrentPage() {
        return getElement(pageHeader).getText();
    }
}
