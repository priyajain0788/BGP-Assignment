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
import org.testng.annotations.BeforeMethod;

import com.bgp.util.DriverUtil;
import com.bgp.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public TestUtil testUtil;
	public DriverUtil driverUtil;
	
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
