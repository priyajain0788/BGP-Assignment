package com.bgp.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.bgp.listeners.WebEventListener;

public class DriverUtil {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListner;
	public static EventFiringWebDriver e_driver;
	public TestUtil testUtil;

	public WebDriver launchDriver(String browserName){
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		// for action logs 
				e_driver = new EventFiringWebDriver(driver);
				eventListner = new WebEventListener();
				e_driver.register(eventListner);
				driver = e_driver;
				
		return driver;
	}

	public WebDriver launchUrl(WebDriver driver){

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
		
		driver.findElement(By.id("login-button")).click();
		return driver;
	}
	
	public void closeDriver(){
		driver.quit();
	}

}
