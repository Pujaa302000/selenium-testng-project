package com.automation.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	protected static ExtentReports extent;
	protected ExtentTest test;
	public ExtentTest getTest() {
	    return test;
	}
	
	public void setTest(ExtentTest test) {
	    this.test = test;
	}

    public WebDriver driver;
    protected WebDriverWait wait;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	
    	extent = ExtentReportManager.getReportInstance();
    	//test = extent.createTest(getClass().getSimpleName());

    	ChromeOptions options = new ChromeOptions();

    	Map<String, Object> prefs = new HashMap<>();

    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);
    	prefs.put("profile.password_manager_leak_detection", false);

    	options.setExperimentalOption("prefs", prefs);

    	driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

      /*  if (ITestResult.FAILURE == result.getStatus()) {

            String screenshotPath =
                    ScreenshotUtil.takeScreenshot(driver, result.getName());

            test.fail("Test Failed")
                .addScreenCaptureFromPath(screenshotPath);
        }*/

        driver.quit();

        extent.flush();
    }
}