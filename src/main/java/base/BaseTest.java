package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.extentReportManager;
import utils.log;



public class BaseTest {
 protected WebDriver driver;
 protected static ExtentReports extent;
 public static ExtentTest test;
 
 @BeforeSuite
 public void setReport()
 {
	 extent = extentReportManager.getReportInstance();
 }
 @AfterSuite
 public void teardownReport()
 {
	 extent.flush();
 }
 
 @BeforeMethod
 public void setUp()
 {
	 log.info("Starting WebDriver....");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 log.info("Navigating to the URL....");
	 driver.get("https://admin-demo.nopcommerce.com/login");
 }
 
 @AfterMethod
 public void tearDown(ITestResult result)
 {
 
 if(result.getStatus()== ITestResult.FAILURE)
 {
	 String screenshotPath = extentReportManager.captureScreenshot(driver, "Login Failure");
	 test.fail("Test Failed..check screenshot",
			 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
 }
	 if(driver !=null)
	 {
		 log.info("Closing Browser......");
		 driver.quit();
	 }
 }
}
