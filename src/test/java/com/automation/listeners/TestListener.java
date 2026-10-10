package com.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.tests.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    @Override

    public void onTestStart(ITestResult result) {

        System.out.println("Test Started");                

        BaseTest baseTest = (BaseTest) result.getInstance(); 
        
        String testName = result.getMethod().getMethodName();

        ExtentTest test =
                ExtentReportManager.getReportInstance().createTest(testName);

        baseTest.setTest(test);

        String description = result.getMethod().getDescription();                

        if (description != null && !description.isEmpty()) {

            test.info("Description: " + description);

        } 

        else {

            test.info("Test execution started");                    

        }

    }

    @Override

    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed");

        BaseTest baseTest = (BaseTest) result.getInstance();

        baseTest.getTest().pass("Test Passed Successfully");                

    }

    @Override

    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed" );                              

        BaseTest baseTest = (BaseTest) result.getInstance();

        String screenshotPath =

                ScreenshotUtil.takeScreenshot(baseTest.getDriver(),"Failure_" + System.currentTimeMillis());                                                                

        baseTest.getTest().fail("Test Failed").addScreenCaptureFromPath(screenshotPath);



    }

}