package com.bookstore.framework.utils;

import com.bookstore.framework.BookStore;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.bookstore.framework.utils.PropertiesLoader.BASE_URL;

public class Helpers {

    /**
     * Method returns start URL
     *
     * @param relUrl - start endpoint
     * @return start URL
     */
    static final Logger logger = Logger.getLogger(Helpers.class);

    public static String prepareUrl(String relUrl) {
        URL mergedURL = null;
        try {
            mergedURL = new URL(new URL(BASE_URL), relUrl);
        } catch (MalformedURLException e) {
            throw new AssertionError("Cannot get Url");
        }
        return mergedURL.toString();
    }

    /**
     * Method takes screenshot as File
     * returns path to screenshot
     *
     * @param methodName
     */
    public static String captureScreenshotAsFile(String methodName) {
        String fileName = methodName + ".png";
        String filePath = "reports" + File.separator + "screenshots" + File.separator;
        String imagePath = filePath + fileName;
        File destination = new File(imagePath);
        try {
            File screenshot = ((TakesScreenshot) BookStore.getDriver()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, destination);
            logger.info("Screenshot is taken");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagePath;
    }

    /**
     * Method takes screenshot as Base64 string
     * returns path to screenshot
     */
    public static String captureScreenshotAsBase64() {
        String base64Code = ((TakesScreenshot) BookStore.getDriver()).getScreenshotAs(OutputType.BASE64);
        logger.info("Screenshot is taken");
        return base64Code;
    }
}
