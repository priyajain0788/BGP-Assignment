package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bgp.base.TestBase;
import com.bgp.util.DateUtil;

public class ApplicationFormProposalPage extends TestBase{
	
	Logger log = Logger.getLogger(ApplicationFormProposalPage.class);
	
	@FindBy(id="react-project-title")
	WebElement projectTitle;
	
	@FindBy(id="react-project-start_date")
	WebElement startDate;
	
	@FindBy(id="react-project-end_date")
	WebElement endDate;
	
	@FindBy(id="react-project-description")
	WebElement projectDesc;
	
	/*@FindBy(xpath="//*[contains(@id,'js-app')]/div/div/div[2]/div[2]/div/div/div[1]/div[9]/div/div/div[2]/div/div/span[2]")
	WebElement activity;*/
	
	/*@FindBy(id="//*[contains(@id,'js-app')]/div/div/div[2]/div[2]/div/div/div[1]/div[11]/div/div[2]/div/div/span[2]/span")
	WebElement targetMarket;*/
	
	@FindBy(xpath="//*[contains(@id,'js-app')]/div/div/div[2]/div[2]/div/div/div[1]/div[12]/div/div[2]/label[1]/span[1]")
	WebElement isFirstTimeintoMOS;
	
	@FindBy(id="save-btn")
	WebElement clicksave;
	
	@FindBy(id="next-btn")
	WebElement clickNext;
	
	public ApplicationFormProposalPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fillProjectTitle(){
		projectTitle.sendKeys("project Title");
	}
	
	public void fillStartDate(){
		startDate.sendKeys(DateUtil.getDate());
	}
	
	public void fillEndDate(){
		endDate.sendKeys(DateUtil.getDate());
	}
	
	public void fillProjectDesc(){
		projectDesc.sendKeys("project Description");
	}
	
	public void fillActivity(){
		
		WebElement activity = driver.findElement(By.xpath("//*[contains(@id,'js-app')]/div/div/div[2]/div[2]/div/div/div[1]/div[9]/div/div/div[2]/div"));
		activity.click();
		
		WebElement selectActivity = driver.findElement(By.xpath("//*[contains(@id,'react-select-project-activity--value')]/div[2]/input"));
		selectActivity.sendKeys("FTA Consultancy", Keys.TAB);
		
	}
	
	public void fillTargetMarket(){
		WebElement targetMarket = driver.findElement(By.xpath("//*[contains(@id,'js-app')]/div/div/div[2]/div[2]/div/div/div[1]/div[11]/div/div[2]/div"));
		targetMarket.click();
		
		WebElement selectTargetMarket = driver.findElement(By.xpath("//*[contains(@id,'react-select-project-primary_market--value')]/div[2]/input"));
		selectTargetMarket.sendKeys("Singapore", Keys.TAB);
	}
	
	public void fillIsFirsttimeIntoMOS(){
		isFirstTimeintoMOS.click();
	}
	
	public void clickSave(){
		clicksave.click();
	}
	
	public void clickNext(){
		clickNext.click();
	}
	
	public void fillProposalPageForm(){
		fillProjectTitle();
		fillStartDate();
		fillEndDate();
		fillProjectDesc();
		fillActivity();
		fillTargetMarket();
		fillIsFirsttimeIntoMOS();
		clickSave();
		clickNext();
	}

}
