package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bgp.base.TestBase;

public class SuccessGrantPage extends TestBase{
	
	Logger log = Logger.getLogger(SuccessGrantPage.class);
	
	@FindBy(xpath="//*[contains(text(),'Your application has been submitted.')]")
	WebElement successMsg;
	
	public SuccessGrantPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessMsg(){
		return successMsg.getText();
	}
	

}
