package com.bgp.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgp.base.TestBase;

public class ApplicationFormDeclarePage extends TestBase {

	Logger log = Logger.getLogger(ApplicationFormDeclarePage.class);
	
	WebElement questions;

	@FindBy(css = "ol.bgp-list-group")
	WebElement listGroup;
	
	/*@FindBy(id="react-declaration-consent_acknowledgement_check")
	WebElement acknowledge;*/
	
	@FindBy(id="save-btn")
	WebElement saveBtn;
	
	@FindBy(id="review-btn")
	WebElement reviewBtn;

	public ApplicationFormDeclarePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectanswers() {
			List<WebElement> listQuesns = driver.findElements(By.xpath("//*[contains(@class,'bgp-list-group')]/li"));
			for (int i = 1; i <= listQuesns.size(); i++) {
				if (i <= 7) {
					questions = driver.findElement(
							By.xpath("//*[contains(@class,'bgp-list-group')]/li[" + i + "]/div/div[2]/label[1]/input"));
					questions.click();
				} else {
					questions = driver.findElement(
							By.xpath("//*[contains(@class,'bgp-list-group')]/li[" + i + "]/div/div[2]/label[2]/input"));
					questions.click();
				}
			}
	}
	
	public void checkAcknowledge(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement acknowledge = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-declaration-consent_acknowledgement_check")));
		acknowledge.click();
		//acknowledge.click();
	}
	
	public void save(){
		saveBtn.click();
	}
	
	public void review(){
		reviewBtn.click();
	}
	
	public void fillDeclareformPage(){
		selectanswers();
		checkAcknowledge();
		save();
		review();
		
	}

}
