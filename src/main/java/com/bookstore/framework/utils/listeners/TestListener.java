package com.bookstore.framework.utils.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bookstore.framework.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Arrays;

import static com.bookstore.framework.utils.Helpers.captureScreenshot;


/**
 * Class listeners with processing different test-cases events
 */
public class TestListener implements ITestListener {

    static final Logger logger = Logger.getLogger(TestListener.class);
    private static ExtentTest node;


    @Override
    public void onTestStart(ITestResult result) {
        logger.info("New TC started " + result.getName());
        node = BaseTest.getTest().createNode(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test successfully finished " + result.getName());
        node.log(Status.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String failedTest = result.getName();
        String filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "result" + File.separator;
        logger.error("Test " + failedTest + "was failed");
        captureScreenshot(failedTest);
        // add failed test info
        node.log(Status.FAIL, result.getThrowable())
                .addScreenCaptureFromPath(filePath + failedTest + ".png")
                .assignCategory(result.getMethod().getGroups())
                .info(result.getMethod().getDescription())
                .info(Arrays.toString(result.getMethod().getGroups()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test was skipped " + result.getName());
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
