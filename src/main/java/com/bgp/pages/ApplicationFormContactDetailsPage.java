package com.bgp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bgp.base.TestBase;

public class ApplicationFormContactDetailsPage extends TestBase {

	@FindBy(css = "input#react-contact_info-name")
	WebElement name;

	@FindBy(css = "input#react-contact_info-designation")
	WebElement jobTitle;

	@FindBy(css = "input#react-contact_info-phone")
	WebElement contactNo;

	@FindBy(css = "input#react-contact_info-primary_email")
	WebElement email;

	@FindBy(css = "input#react-contact_info-correspondence_address-copied")
	WebElement mailingAddress;

	@FindBy(css = "input#react-contact_info-copied")
	WebElement copycontactDetails;

	@FindBy(css = "button#next-btn")
	WebElement clickNext;
	
	@FindBy(css = "button#save-btn")
	WebElement clickSave;


	@FindBy(id = "react-contact_info-correspondence_address-block")
	WebElement blkNo;
	
	@FindBy(id="react-contact_info-correspondence_address-street")
	WebElement street;
	
	@FindBy(id="react-contact_info-correspondence_address-street")
	WebElement level;
	
	@FindBy(id="react-contact_info-correspondence_address-unit")
	WebElement unit;
	
	@FindBy(id = "react-contact_info-offeree_name")
	WebElement nameLoa;

	@FindBy(id = "react-contact_info-offeree_designation")
	WebElement jobTitleLoa;

	@FindBy(id = "react-contact_info-offeree_email")
	WebElement emailLoa;

	public ApplicationFormContactDetailsPage() {
		PageFactory.initElements(driver, this);

	}

	public WebElement fillName() {
		name.clear();
		name.sendKeys("abc");
		return name;
	}
	
	public WebElement fillNameLocator() {
		return name;
	}

	public WebElement fillJobTitle() {
		jobTitle.clear();
		jobTitle.sendKeys("Test Analyst");
		return jobTitle;
	}
	
	public WebElement fillJobTitleLocator() {
		return jobTitle;
	}

	public WebElement fillContactNo() {
		contactNo.clear();
		contactNo.sendKeys("98765432");
		return contactNo;
	}
	
	public WebElement fillContactNoLocator() {
		return contactNo;
	}

	public WebElement fillemail() {
		email.clear();
		email.sendKeys("abc@bgp.com");
		return email;
	}
	
	public WebElement fillemailLocator() {
		return email;
	}
	
	public WebElement nameLoa() {
		return nameLoa;
	}

	public WebElement jobTitleLoa() {
		return jobTitle;
	}

	public WebElement emailLoa() {
		return email;
	}

	public WebElement checkMailingAddess() {
		mailingAddress.click();
		return mailingAddress;
	}
	
	public WebElement checkMailingAddessLocator() {
		return mailingAddress;
	}

	public String blockNumber() {
		String value = blkNo.getAttribute("value");
		return value;
	}

	public String streetDetail(){
		String streetdetail = street.getAttribute("value");
		return streetdetail;
	}
	
	public String levelNumber(){
		String levelNo = level.getAttribute("value");
		return levelNo;
	}
	
	public String unitNumber(){
		String unitNumber = unit.getAttribute("value");
		return unitNumber;
	}
	
	public WebElement copyContactDetails() {
		copycontactDetails.click();
		return copycontactDetails;
	}
	
	public WebElement copyContactDetailsLocator() {
		return copycontactDetails;
	}

	public void clickNext() {
		clickNext.click();
	}
	
	public void clickSave() {
		clickSave.click();
	}

	public void fillContactDetailsForm() {
		fillName();
		fillJobTitle();
		fillContactNo();
		fillemail();
		checkMailingAddess();
		copyContactDetails();
		clickNext();
	}
}
