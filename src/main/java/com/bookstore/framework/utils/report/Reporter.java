package com.bookstore.framework.utils.report;

import com.bookstore.framework.utils.listeners.TestListener;
import org.apache.log4j.Logger;

/**
 * Class add test steps info to log and test report
 */
public class Reporter {

    public static final Logger logger = Logger.getLogger(Reporter.class);

    public static void log(String... msg) {
        if (msg.length > 0) {
            writeTestStepsInfoToLog(msg);
            writeTestStepsInfoToReport(msg);
        }
    }

    private static void writeTestStepsInfoToReport(String... msg) {
        TestListener.getNode().info(msg[0]);
    }

    private static void writeTestStepsInfoToLog(String... msg) {
        logger.info(msg[0]);
    }
}
