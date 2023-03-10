package com.bookstore.framework.utils.listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Class for setting test-cases retries
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;

    static final Logger logger = Logger.getLogger(RetryAnalyzer.class);

    /**
     * method sets number of test-case reruns
     */
    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            logger.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");

            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
