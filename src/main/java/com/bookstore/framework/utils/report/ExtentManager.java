package com.bookstore.framework.utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class creates extent report
 */
public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();

        return extent;
    }

    public static ExtentReports createInstance() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM_dd_yyyy");

        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") +
                File.separator + "reports" + File.separator + ft.format(dNow) + "_WEB_" + "testreport.html");
        //Set dashboard as default view of the report
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.EXCEPTION, ViewName.LOG});
        reporter.config().setReportName("Smoke Tests");
        reporter.config().setDocumentTitle("Smoke Tests");
        reporter.config().setTimeStampFormat("yyyy/MM/dd hh:mm:ss a");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
