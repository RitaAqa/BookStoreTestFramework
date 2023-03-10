package com.bookstore.framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bookstore.framework.BookStore;
import com.bookstore.framework.utils.report.ExtentManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Class contains instruction that should be executed before and after testing
 */
public class BaseTest {

    public static final Logger logger = Logger.getLogger(BaseTest.class);
    protected static BookStore bookStore;


    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentTest getTest() {
        return test;
    }


    @BeforeTest(description = "Setup a web driver and create an extent report")
    public void setup() {
        logger.info("Setup a web driver");
        try {
            bookStore = new BookStore();
        } catch (Exception e) {
            logger.error("Cannot get the driver. Test cases are skipped");
            throw new SkipException("Testing is stopped");
        }
        logger.info("Create an extent report");
        extent = ExtentManager.getInstance();
    }

    @BeforeClass
    public void createTestForReport() {
        test = extent.createTest(getClass().getName());
    }

    @AfterTest(description = "Stop the web driver and close the report")
    public void tearDown() {
        logger.info("Stop the driver");
        bookStore.closeApp();
        logger.info("Close the report");
        extent.flush();
    }
}
