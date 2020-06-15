package com.bgp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgp.base.TestBase;

public class MyGrantApplicationPage extends TestBase {
	
	public MyGrantApplicationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickProceed(){
	WebElement procced = driver.findElement(By.id("keyPage-form-button"));
	WebDriverWait wait = new WebDriverWait(driver, 30);
	procced = wait.until(ExpectedConditions.visibilityOf(procced));
	procced.click();
	}
}
