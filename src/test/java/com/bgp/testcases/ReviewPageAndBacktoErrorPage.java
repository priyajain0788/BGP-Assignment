package com.bgp.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.bgp.util.TestUtil;

public class ReviewPageAndBacktoErrorPage extends TestBase {

	Logger log = Logger.getLogger(ReviewPageAndBacktoErrorPage.class);

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

	@BeforeMethod
	public void getFormPages() {
		loginPage = new LoginPage(driver);
		driver = loginPage.loginWithDetails();

		dashboardPage = new DashboardPage(driver);
		driver = dashboardPage.clickGetNewGrant();

		grantActionPage = new MRAGrantActionPage(driver);
		driver = grantActionPage.fillGrantActionPage();

		grantApplicationPage = new MyGrantApplicationPage();
		grantApplicationPage.clickProceed();
	}

	@Test
	public void verifyBackOnEligibiltyPage() {

		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		// applicationFormEligibilityPage.selectFirstQuestY();
		// applicationFormEligibilityPage.selectSecondQuesY();
		applicationFormEligibilityPage.selectThirdQuesY();
		applicationFormEligibilityPage.selectFourthQuesY();
		applicationFormEligibilityPage.selectFifthQuesY();
		applicationFormEligibilityPage.clickSave();
		applicationFormEligibilityPage.clickNext();

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

		log.info("verify eligibility page : "
				+ driver.findElement(By.xpath("//*[contains(text(),'Check Your Eligibility')]")).isDisplayed());
		List<WebElement> count = driver.findElements(By.xpath("//*[contains(text(),'Select an option')]"));
		log.info("error count : " + count.size());
		log.info("get error page title : " + driver.getTitle());

		String count1 = driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText();
		log.info("Count : " +count1);
		
		assertEquals(true, driver.findElement(By.xpath("//*[contains(text(),'Check Your Eligibility')]")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "2");

	}

	@Test
	public void verifyBackOnContactDetailsPage() {

		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.selectFirstQuestY();
		applicationFormEligibilityPage.selectSecondQuesY();
		applicationFormEligibilityPage.selectThirdQuesY();
		applicationFormEligibilityPage.selectFourthQuesY();
		applicationFormEligibilityPage.selectFifthQuesY();
		applicationFormEligibilityPage.clickSave();
		applicationFormEligibilityPage.clickNext();

		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillName();
		// formContactDetails.fillJobTitle();
		formContactDetails.fillContactNo();
		formContactDetails.fillemail();
		formContactDetails.checkMailingAddess();
		formContactDetails.copyContactDetails();
		formContactDetails.clickNext();

		formProposalPage = new ApplicationFormProposalPage();
		formProposalPage.fillProposalPageForm();

		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillBusinessImpactpageForm();

		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillCostPageForm();

		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();

		assertEquals(true,
				driver.findElement(By.xpath("//*[contains(text(),'Provide Your Contact Details')]")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "2");

	}

	@Test
	public void verifyBackOnProposalPage() throws InterruptedException {

		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();

		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillContactDetailsForm();

		formProposalPage = new ApplicationFormProposalPage();
		// formProposalPage.fillProjectTitle();
		formProposalPage.fillStartDate();
		formProposalPage.fillEndDate();
		formProposalPage.fillProjectDesc();
		formProposalPage.fillActivity();
		formProposalPage.fillTargetMarket();
		formProposalPage.fillIsFirsttimeIntoMOS();
		formProposalPage.clickSave();
		formProposalPage.clickNext();

		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillBusinessImpactpageForm();

		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillCostPageForm();

		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();

		assertEquals(true, driver.findElement(By.xpath("//*[contains(text(),'Submit Your Proposal')]")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "1");
	}

	@Test
	public void verifyBackOnBIPage() {

		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();

		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillContactDetailsForm();

		formProposalPage = new ApplicationFormProposalPage();
		formProposalPage.fillProposalPageForm();

		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillCurrentFYEndDate();
		formBusinessImpactPage.fillCurrentFYOverseasSales();
		// formBusinessImpactPage.fillFirstFYOverseasSales();
		formBusinessImpactPage.fillSecondFYOverseasSales();
		formBusinessImpactPage.fillThirdFYOverseasSales();
		formBusinessImpactPage.fillCurrentFYOverseasInvestment();
		formBusinessImpactPage.fillFirstFYOverseasInvestment();
		formBusinessImpactPage.fillSecondFYOverseasInvestment();
		formBusinessImpactPage.fillThirdFYOverseasInvestment();
		formBusinessImpactPage.fillRationaleForProjections();
		formBusinessImpactPage.fillNonTangibleBenefits();
		formBusinessImpactPage.clickSave();
		formBusinessImpactPage.clickNext();

		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillCostPageForm();

		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();

		assertEquals(true,
				driver.findElement(By.xpath("//*[contains(text(),'Explain The Business Impact')]")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "1");

	}

	@Test
	public void verifyBackOnCostPage() {

		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();

		formContactDetails = new ApplicationFormContactDetailsPage();
		formContactDetails.fillContactDetailsForm();

		formProposalPage = new ApplicationFormProposalPage();
		formProposalPage.fillProposalPageForm();

		formBusinessImpactPage = new ApplicationFormBusinessImpactPage();
		formBusinessImpactPage.fillBusinessImpactpageForm();

		formCostPage = new ApplicationFormCostPage();
		formCostPage.fillThirdPartyVendor();
		formCostPage.selectAddNewItem();
		formCostPage.selectVendorRegistered();
		formCostPage.selectVendorName();
		// formCostPage.uploadSupportingDoc();
		formCostPage.fillEstimatedCost();
		formCostPage.clickSave();
		formCostPage.clickNext();

		formDeclarePage = new ApplicationFormDeclarePage();
		formDeclarePage.fillDeclareformPage();

		assertEquals(true,
				driver.findElement(By.xpath("//*[contains(text(),'Provide Details of Costs')]")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "1");

	}

	@Test
	public void verifyBackOnDeclarePage() {

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
		//formDeclarePage.selectanswers();
		formDeclarePage.checkAcknowledge();
		formDeclarePage.save();
		
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		formDeclarePage.review();

		assertEquals(true,
				driver.findElement(By.xpath("//*[contains(text(),'Declare & Acknowledge Terms')]")).isDisplayed());

		assertEquals(driver.findElement(By.xpath("//span[contains(@class,'label label-error')]")).getText(), "9");
		
	}
}
