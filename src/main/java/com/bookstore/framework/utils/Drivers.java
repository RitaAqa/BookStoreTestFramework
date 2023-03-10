package com.bookstore.framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Class contains different web drivers with their settings
 */
public class Drivers {

    public static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //set diff option here if needed
        //options.addArguments("headless");
        return new ChromeDriver(options);
    }

    public static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //set diff option here if needed
        //options.addArguments("headless");
        return new FirefoxDriver(options);
    }
}
