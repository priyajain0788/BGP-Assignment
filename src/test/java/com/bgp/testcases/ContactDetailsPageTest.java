package com.bgp.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bgp.base.TestBase;
import com.bgp.pages.ApplicationFormContactDetailsPage;
import com.bgp.pages.ApplicationFormEligibilityPage;
import com.bgp.pages.DashboardPage;
import com.bgp.pages.LoginPage;
import com.bgp.pages.MRAGrantActionPage;
import com.bgp.pages.MyGrantApplicationPage;
import com.bgp.util.TestUtil;

public class ContactDetailsPageTest extends TestBase{
	
	Logger log = Logger.getLogger(ContactDetailsPageTest.class);
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MRAGrantActionPage grantActionPage;
	MyGrantApplicationPage grantApplicationPage;
	ApplicationFormEligibilityPage applicationFormEligibilityPage;
	ApplicationFormContactDetailsPage applicationFormContactDetailsPage;
	TestUtil testUtil;
	
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
		
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.FillEligibilityForm();
		
	}
	
	@Test(priority=1)
	public void verifySubSectionOfMainContactPerson(){
		applicationFormContactDetailsPage = new ApplicationFormContactDetailsPage();
		assertTrue(applicationFormContactDetailsPage.fillName().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.fillJobTitle().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.fillContactNo().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.fillemail().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.checkMailingAddess().isDisplayed());
	}
	
	@Test(priority=2)
	public void verifyCheckBoxSameAsAddressCompanyProfile(){
		applicationFormContactDetailsPage = new ApplicationFormContactDetailsPage();
		assertTrue("".equals(applicationFormContactDetailsPage.blockNumber()));
		assertTrue("".equals(applicationFormContactDetailsPage.streetDetail()));
		assertTrue("".equals(applicationFormContactDetailsPage.levelNumber()));
		assertTrue("".equals(applicationFormContactDetailsPage.unitNumber()));
		applicationFormContactDetailsPage.checkMailingAddess();
		assertTrue(!"".equals(applicationFormContactDetailsPage.blockNumber()));
		assertTrue(!"".equals(applicationFormContactDetailsPage.streetDetail()));
		assertTrue(!"".equals(applicationFormContactDetailsPage.levelNumber()));
		assertTrue(!"".equals(applicationFormContactDetailsPage.unitNumber()));
	}
	
	@Test(priority=3)
	public void verifySubSectionOfLetterOfAddressee(){
		applicationFormContactDetailsPage = new ApplicationFormContactDetailsPage();
		assertTrue(applicationFormContactDetailsPage.nameLoa().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.jobTitleLoa().isDisplayed());
		assertTrue(applicationFormContactDetailsPage.emailLoa().isDisplayed());
	}
	
	@Test(priority=4)
	public void verifyCheckBoxSameAsMainContactPerson(){
		applicationFormContactDetailsPage = new ApplicationFormContactDetailsPage();
		applicationFormContactDetailsPage.copyContactDetails();
		assertEquals(applicationFormContactDetailsPage.nameLoa().getAttribute("value"), applicationFormContactDetailsPage.fillNameLocator().getAttribute("value"));
		assertEquals(applicationFormContactDetailsPage.jobTitleLoa().getAttribute("value"), applicationFormContactDetailsPage.fillJobTitleLocator().getAttribute("value"));
		assertEquals(applicationFormContactDetailsPage.emailLoa().getAttribute("value"), applicationFormContactDetailsPage.fillemailLocator().getAttribute("value"));
	}
	
	@Test(priority=5)
	public void verifySaveAndRefresh() throws InterruptedException{
		applicationFormContactDetailsPage = new ApplicationFormContactDetailsPage();
		applicationFormContactDetailsPage.fillName();
		applicationFormContactDetailsPage.fillJobTitle();
		applicationFormContactDetailsPage.fillContactNo();
		applicationFormContactDetailsPage.fillemail();
		applicationFormContactDetailsPage.checkMailingAddess();
		applicationFormContactDetailsPage.copyContactDetails();
		applicationFormContactDetailsPage.clickSave();
		
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		assertEquals(applicationFormContactDetailsPage.fillNameLocator().getAttribute("value"), "abc");
		assertEquals(applicationFormContactDetailsPage.fillJobTitleLocator().getAttribute("value"), "Test Analyst");
		assertEquals(applicationFormContactDetailsPage.fillContactNoLocator().getAttribute("value"),"98765432");
		assertEquals(applicationFormContactDetailsPage.fillemailLocator().getAttribute("value"), "abc@bgp.com");
		assertEquals(applicationFormContactDetailsPage.checkMailingAddessLocator().getAttribute("value"), "on");
		assertEquals(applicationFormContactDetailsPage.copyContactDetailsLocator().getAttribute("value"), "on");
		assertEquals(applicationFormContactDetailsPage.nameLoa().getAttribute("value"), applicationFormContactDetailsPage.fillNameLocator().getAttribute("value"));
		assertEquals(applicationFormContactDetailsPage.jobTitleLoa().getAttribute("value"), applicationFormContactDetailsPage.fillJobTitleLocator().getAttribute("value"));
		assertEquals(applicationFormContactDetailsPage.emailLoa().getAttribute("value"), applicationFormContactDetailsPage.fillemailLocator().getAttribute("value"));
		
	}
}
