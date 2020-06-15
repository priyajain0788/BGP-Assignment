package com.bgp.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bgp.base.TestBase;
import com.bgp.pages.ApplicationFormBusinessImpactPage;
import com.bgp.pages.ApplicationFormContactDetailsPage;
import com.bgp.pages.ApplicationFormCostPage;
import com.bgp.pages.ApplicationFormDeclarePage;
import com.bgp.pages.ApplicationFormEligibilityPage;
import com.bgp.pages.ApplicationFormProposalPage;
import com.bgp.pages.DashboardPage;
import com.bgp.pages.LoginPage;
import com.bgp.pages.MRAGrantActionPage;
import com.bgp.pages.MyGrantApplicationPage;
import com.bgp.pages.ReviewFormPage;
import com.bgp.pages.SuccessGrantPage;
import com.bgp.util.DateUtil;
import com.bgp.util.TestUtil;

public class FormSubmission extends TestBase{
	
	Logger log = Logger.getLogger(FormSubmission.class);
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MRAGrantActionPage grantActionPage;
	MyGrantApplicationPage grantApplicationPage;
	ApplicationFormEligibilityPage applicationFormEligibilityPage;
	ApplicationFormContactDetailsPage formContactDetails;
	ApplicationFormProposalPage formProposalPage;
	ApplicationFormBusinessImpactPage formBusinessImpactPage;
	ApplicationFormCostPage formCostPage;
	ApplicationFormDeclarePage formDeclarePage;
	ReviewFormPage reviewFormPage;
	SuccessGrantPage successPage;
	TestUtil testUtil;
	DateUtil dateutil;
	
	@BeforeMethod
	public void getFormPages(){
		loginPage = new LoginPage(driver);
		driver = loginPage.loginWithDetails();
		
		dashboardPage = new DashboardPage(driver);
		driver=dashboardPage.clickGetNewGrant();
		
		grantActionPage = new MRAGrantActionPage(driver);
		driver = grantActionPage.fillGrantActionPage();
		
		grantApplicationPage = new MyGrantApplicationPage();
		grantApplicationPage.clickProceed();
	}
	
	@Test(priority=1)
	public void verifyReadOnlySummeryPageDetails(){
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();
		
		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillContactDetailsForm();
		
		formProposalPage = new ApplicationFormProposalPage();
		formProposalPage.fillProposalPageForm();
		
		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillBusinessImpactpageForm();
		
		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillCostPageForm();
		
		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();
		
		assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Verify that the information provided is correct, then submit your grant.')]")).isDisplayed());
		
		// Eligibility form check 
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Eligibility')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-eligibility-sg_registered_check")).getText(), "Yes");
		assertEquals(driver.findElement(By.id("react-eligibility-turnover_check")).getText(), "Yes");
		assertEquals(driver.findElement(By.id("react-eligibility-global_hq_check")).getText(), "Yes");
		assertEquals(driver.findElement(By.id("react-eligibility-new_target_market_check")).getText(), "Yes");
		assertEquals(driver.findElement(By.id("react-eligibility-started_project_check")).getText(), "Yes");
		
		// Contact Details form check
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Contact Details')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-contact_info-name")).getText(), "abc");
		assertEquals(driver.findElement(By.id("react-contact_info-designation")).getText(), "Test Analyst");
		assertEquals(driver.findElement(By.id("react-contact_info-phone")).getText(), "98765432");
		assertEquals(driver.findElement(By.id("react-contact_info-primary_email")).getText(), "abc@bgp.com");
		
		// Proposal form check
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Proposal')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-project-title")).getText(), "project Title");
		assertEquals(driver.findElement(By.id("react-project-start_date")).getText(), DateUtil.getDate());
		assertEquals(driver.findElement(By.id("react-project-end_date")).getText(), DateUtil.getDate());
		assertEquals(driver.findElement(By.id("react-project-project_duration_months")).getText(), "1 month");
		assertEquals(driver.findElement(By.id("react-project-activity")).getText(), "FTA Consultancy");
		assertEquals(driver.findElement(By.id("react-project-primary_market")).getText(), "Singapore");
		
		// Business Impact form check
		
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Business Impact')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-project_impact-fy_end_date_0")).getText(), DateUtil.getDate());
		assertEquals(driver.findElement(By.id("react-project_impact-overseas_sales_0")).getText(), "2,500.00");
		assertEquals(driver.findElement(By.id("react-project_impact-overseas_investments_0")).getText(), "2,500.00");
		assertEquals(driver.findElement(By.id("react-project_impact-rationale_remarks")).getText(), "Rationale For Projections");
		assertEquals(driver.findElement(By.id("react-project_impact-benefits_remarks")).getText(), "Non Tangible Benefits");
		
		// Cost form check
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Cost')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-project_cost-vendors-0-local_vendor")).getText(), "Overseas");
		assertEquals(driver.findElement(By.id("react-project_cost-vendors-0-vendor_name")).getText(), "Testing");
		assertEquals(driver.findElement(By.id("react-project_cost-vendors-0-amount_in_billing_currency")).getText(), "SGD 25.00");
		assertEquals(driver.findElement(By.id("react-project_cost-vendors-0-estimated_cost")).getText(), "SGD 25.00");
		assertEquals(driver.findElement(By.xpath("//*[contains(text(),'ACE_QE_Tech_Challenge_Jun2019.pdf')]")).getText(), "ACE_QE_Tech_Challenge_Jun2019.pdf");
		
		// Declare form check 
		assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Declare & Review')]")).isDisplayed());
		assertEquals(driver.findElement(By.id("react-declaration-criminal_liability_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-civil_proceeding_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-insolvency_proceeding_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-project_incentives_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-other_incentives_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-project_commence_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-related_party_check")).getText(), "No");
		assertEquals(driver.findElement(By.id("react-declaration-covid_safe_check")).getText(), "Yes");
		assertEquals(driver.findElement(By.id("react-declaration-covid_safe_ques_check")).getText(), "Yes");
	}
	
	@Test(priority=2)
	public void verifySubmittedFormAndProcessingTab(){
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();
		
		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillContactDetailsForm();
		
		formProposalPage = new ApplicationFormProposalPage();
		formProposalPage.fillProposalPageForm();
		
		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillBusinessImpactpageForm();
		
		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillCostPageForm();
		
		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();
		
		reviewFormPage = new ReviewFormPage();
		reviewFormPage.fillReviewPageForm();
		
		successPage = new SuccessGrantPage();
		log.info(successPage.getSuccessMsg());
		Assert.assertEquals("Your application has been submitted.", successPage.getSuccessMsg());
		assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Ref ID:')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Agency Details:')]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Agency Details:')]/following::span[1]")).getText(), "Enterprise Singapore");
		String id= driver.findElement(By.xpath("//*[contains(text(),'Ref ID:')]/following-sibling::td")).getText();
		log.info("Ref ID : " +id);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement procced = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sgds-nav-start")));
		procced.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement process = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'#processing')]")));
		process.click();
		
		assertEquals(driver.findElement(By.xpath("//*[@id='db-apps-processing']/tbody/tr[1]/td[1]")).getText(), id);
		
	}
}

