package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bgp.base.TestBase;

public class LoginPage extends TestBase{
	
	Logger log = Logger.getLogger(LoginPage.class);
	public WebDriver driver;
	
	@FindBy(name="CPUID")
	WebElement nric;
	
	@FindBy(name="CPUID_FullName")
	WebElement name;
	
	@FindBy(name="CPEntID")
	WebElement uen;
	
	@FindBy(xpath="//div[contains(@class,'base-container')]/form[2]/button")
	WebElement login;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver loginWithDetails(){
		nric.clear();
		nric.sendKeys(prop.getProperty("NRIC"));
		name.clear();
		name.sendKeys(prop.getProperty("Name"));
		uen.clear();
		uen.sendKeys(prop.getProperty("UEN"));
		
		Select selectRole = new Select(driver.findElement(By.name("CPRole")));
		selectRole.selectByValue(prop.getProperty("Role"));
		
		login.click();
		return driver;
	}
}
