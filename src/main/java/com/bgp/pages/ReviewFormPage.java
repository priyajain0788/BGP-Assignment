package com.bgp.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgp.base.TestBase;
import com.bgp.util.TestUtil;

public class ReviewFormPage extends TestBase{
	
	Logger log = Logger.getLogger(ReviewFormPage.class);
	
	@FindBy(id="react-declaration-info_truthfulness_check")
	WebElement acknowledge;
	
	@FindBy(id="submit-btn")
	WebElement submitBtn;
	
	public ReviewFormPage() {
		PageFactory.initElements(driver, this);
	}

	public void acknowledgeReview(){
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		acknowledge.click();
	}
	
	public void submit(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}
	
	public void fillReviewPageForm(){
		acknowledgeReview();
		submit();
	}
	
	public void getEligibilityForm(){
		
		/*List<WebElement> eligibilityForm = driver.findElements(By.id("eligibility"));
		for(int i=1;i<eligibilityForm.size();i++){
			
		}*/
		
		
	}
}
