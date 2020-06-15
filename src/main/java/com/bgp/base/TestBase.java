package com.bgp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bgp.util.DriverUtil;
import com.bgp.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public TestUtil testUtil;
	public DriverUtil driverUtil;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/bgp/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Extent.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void beforeMethod() {
		driverUtil = new DriverUtil();
		driver = driverUtil.launchDriver(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver = driverUtil.launchUrl(driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		driverUtil.closeDriver();
	}

}
