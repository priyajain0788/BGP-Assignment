package com.bgp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgp.base.TestBase;

public class MRAGrantActionPage extends TestBase {
	
	public WebDriver driver;

	/*@FindBy(xpath="//div[contains(text(),'IT')]")
	WebElement selectSeletor;*/
	
	public MRAGrantActionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectSelector(){
		WebDriverWait wait =  new WebDriverWait(driver, 30);
		WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'IT')]")));
		select.click();
	}
	
	public void selectGrant() {
		WebElement selectGrant = driver.findElement(By.xpath(
				"//*[contains(text(),'Bring my business overseas or establish a stronger international presence')]"));
		selectGrant.click();
	}

	public void overseasPlan() {
		WebElement overseasPlan = driver.findElement(By.xpath("//*[contains(text(),'Market Readiness Assistance')]"));
		overseasPlan.click();
	}

	public void clickapply() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement clickapply = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("go-to-grant"))));
		clickapply.click();
	}
	
	public WebDriver fillGrantActionPage(){
		selectSelector();
		selectGrant();
		overseasPlan();
		clickapply();
		return driver;
	}
}
