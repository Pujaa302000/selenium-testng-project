package com.automation.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setDocumentTitle("Automation Test Execution Report");
            spark.config().setReportName("SauceDemo Automation Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String reportGeneratedAt =
                    LocalDateTime.now().format(formatter);

            extent.setSystemInfo("Report Generated At", reportGeneratedAt);

            extent.setSystemInfo("Project", "Selenium TestNG Automation");
            extent.setSystemInfo("Tester", "Puja");
            extent.setSystemInfo("Environment", "QA");

            extent.setSystemInfo("Browser", "Google Chrome");
            extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
        }

        return extent;
    }
}