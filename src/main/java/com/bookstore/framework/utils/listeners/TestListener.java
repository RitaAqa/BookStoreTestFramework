package com.bookstore.framework.utils.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.bookstore.framework.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.bookstore.framework.utils.Helpers.*;


/**
 * Class listeners with processing different test-cases events
 */
public class TestListener implements ITestListener {

    static final Logger logger = Logger.getLogger(TestListener.class);

    public static ExtentTest getNode() {
        return node;
    }

    private static ExtentTest node;


    @Override
    public void onTestStart(ITestResult result) {
        logger.info("New TC " + result.getName() + " started");
        node = BaseTest.getTest().createNode(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test " + result.getName() + " successfully finished");
        node.log(Status.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String failedTest = result.getName();
        logger.error("Test " + failedTest + "was failed");
        // ".." is added to screenshotPath in order to the extent report saw a screenshot
        String screenshotPath = "../" + captureScreenshotAsFile(failedTest);
        System.out.println("dddddddddddddddddddddddddddddd" + screenshotPath);
        // add failed test info
        node.log(Status.FAIL, result.getThrowable())
               // .addScreenCaptureFromPath(screenshotPath)
              //  .addScreenCaptureFromBase64String(captureScreenshotAsBase64())
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build())
              //  .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshotAsBase64()).build())
                .assignCategory(result.getMethod().getGroups())
                .info(result.getMethod().getDescription());
   }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test " + result.getName() + " was skipped");
        node.log(Status.SKIP, result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("This is OnStart method " + context.getOutputDirectory());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("this is OnFinish method. Number of passed TCs: " + context.getPassedTests().getAllResults().size());
        logger.info("this is OnFinish method. Number of failed TCs: " + context.getFailedTests().getAllResults().size());
    }
}
