package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bgp.base.TestBase;

public class ApplicationFormEligibilityPage extends TestBase {

	Logger log = Logger.getLogger(ApplicationFormEligibilityPage.class);

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[4]/div/div/div/label")
	WebElement firstQues;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[5]/div/div/div/label")
	WebElement secondQues;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[6]/div/div/div/label")
	WebElement thirdQues;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[7]/div/div/div/label")
	WebElement fourthQues;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[8]/div/div/div/label")
	WebElement fifthQues;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[4]/div/div[2]/label/input")
	WebElement firstQuestY;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[4]/div/div[2]/label[2]/input")
	WebElement firstQuestN;
	
	@FindBy(xpath = "//*[contains(text(),'The applicant may not meet the eligibility criteria for this grant. Visit')]")
	WebElement warningMsg;
	
	@FindBy(xpath="//a[contains(@href,'FAQ')]")
	WebElement faq;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[5]/div/div[2]/label/input")
	WebElement secondQuesY;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[5]/div/div[2]/label[2]/input")
	WebElement secondQuesN;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[6]/div/div[2]/label/input")
	WebElement thirdQuesY;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[6]/div/div[2]/label[2]/input")
	WebElement thirdQuesN;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[7]/div/div[2]/label/input")
	WebElement fourthQuesY;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[7]/div/div[2]/label[2]/input")
	WebElement fourthQuesN;

	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[8]/div/div[2]/label/input")
	WebElement fifthQuesY;
	
	@FindBy(xpath = "//*[contains(@class,'main')]/div/div[8]/div/div[2]/label[2]/input")
	WebElement fifthQuesN;
	
	@FindBy(id = "save-btn")
	WebElement saveBtn;
	
	@FindBy(id = "next-btn")
	WebElement nextBtn;

	public ApplicationFormEligibilityPage() {
		PageFactory.initElements(driver, this);
	}

	public String firstQuest() {
		return firstQues.getText();
	}

	public String secondQuest() {
		return secondQues.getText();
	}

	public String thirdQuest() {
		return thirdQues.getText();
	}

	public String fourthQuest() {
		return fifthQues.getText();
	}

	public void FillEligibilityForm() {
			selectFirstQuestY();
			selectSecondQuesY();
			selectThirdQuesY();
			selectFourthQuesY();
			selectFifthQuesY();
			clickSave();
			clickNext();
	}
	
	public WebElement selectFirstQuestY() {
		firstQuestY.click();
		return firstQuestY;
	}
	
	public WebElement selectFirstQuestN() {
		firstQuestN.click();
		return firstQuestN;
	}

	public WebElement getWarningMsg() {
		return warningMsg;
	}
	
	public void getFaq() {
		faq.click();
	}
	
	public WebElement selectSecondQuesY() {
		secondQuesY.click();
		return secondQuesY;
	}
	
	public WebElement selectSecondQuesN() {
		secondQuesN.click();
		return secondQuesN;
	}

	public WebElement selectThirdQuesY() {
		thirdQuesY.click();
		return thirdQuesY;
	}
	
	public WebElement selectThirdQuesN() {
		thirdQuesN.click();
		return thirdQuesN;
	}

	public WebElement selectFourthQuesY() {
		fourthQuesY.click();
		return fourthQuesY;
	}
	
	public WebElement selectFourthQuesN() {
		fourthQuesN.click();
		return fourthQuesN;
	}

	public WebElement selectFifthQuesY() {
		fifthQuesY.click();
		return fifthQuesY;
	}
	
	public WebElement selectFifthQuesN() {
		fifthQuesN.click();
		return fifthQuesN;
	}
	
	public void clickSave() {
		saveBtn.click();
	}

	public void clickNext() {
		nextBtn.click();
	}

}
