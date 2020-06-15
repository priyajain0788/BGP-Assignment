package com.bgp.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bgp.base.TestBase;
import com.bgp.pages.ApplicationFormEligibilityPage;
import com.bgp.pages.DashboardPage;
import com.bgp.pages.LoginPage;
import com.bgp.pages.MRAGrantActionPage;
import com.bgp.pages.MyGrantApplicationPage;
import com.bgp.util.TestUtil;

public class EligibilityPageTest  extends TestBase{
	
	Logger log = Logger.getLogger(EligibilityPageTest.class);
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MRAGrantActionPage grantActionPage;
	MyGrantApplicationPage grantApplicationPage;
	ApplicationFormEligibilityPage applicationFormEligibilityPage;
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
	}
	
	@Test
	public void verifyAllQuestionsAvailable() {
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		String firstQ = applicationFormEligibilityPage.firstQuest();
		Assert.assertTrue(firstQ.contains(prop.getProperty("ExpectedFirstQues")));

		String secondQ = applicationFormEligibilityPage.secondQuest();
		Assert.assertTrue(secondQ.contains(prop.getProperty("ExpectedSecondQues")));

		String thirdQ = applicationFormEligibilityPage.thirdQuest();
		Assert.assertTrue(thirdQ.contains(prop.getProperty("ExpectedThirdQues")));

		String fourthQ = applicationFormEligibilityPage.fourthQuest();
		Assert.assertTrue(fourthQ.contains(prop.getProperty("ExpectedFourthQues")));
		
	}
	
	@Test
	public void verifyWarningMsgForAllQuestions() {
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		// first ques for No
		applicationFormEligibilityPage.selectFirstQuestN();
		if (applicationFormEligibilityPage.selectFirstQuestN().isSelected()) {
			WebElement warning = applicationFormEligibilityPage.getWarningMsg();
			log.info("warning displayed 1: " + warning.isDisplayed());
			assertTrue(warning.isDisplayed());
			
			// check for FAQ URL
			applicationFormEligibilityPage.getFaq();
			String parent=driver.getWindowHandle();
			Set<String>s1= driver.getWindowHandles();
			
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			    Assert.assertEquals(driver.switchTo().window(child_window).getCurrentUrl(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
			  }
			}
			driver.switchTo().window(parent);
			System.out.println(driver.switchTo().window(parent).getCurrentUrl());
		}
		

		// first ques for Yes
		applicationFormEligibilityPage.selectFirstQuestY();
		assertTrue(applicationFormEligibilityPage.selectFirstQuestY().isSelected());

		// Second ques for No
		applicationFormEligibilityPage.selectSecondQuesN();
		if (applicationFormEligibilityPage.selectSecondQuesN().isSelected()) {
			WebElement warning = applicationFormEligibilityPage.getWarningMsg();
			log.info("warning displayed 2 : " + warning.isDisplayed());
			assertTrue(warning.isDisplayed());
			// check for FAQ URL
			applicationFormEligibilityPage.getFaq();
			String parent=driver.getWindowHandle();
			Set<String>s1= driver.getWindowHandles();
			
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			    Assert.assertEquals(driver.switchTo().window(child_window).getCurrentUrl(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
			  }
			}
			driver.switchTo().window(parent);
			System.out.println(driver.switchTo().window(parent).getCurrentUrl());
		}

		// Second ques for Y
		applicationFormEligibilityPage.selectSecondQuesY();
		assertTrue(applicationFormEligibilityPage.selectSecondQuesY().isSelected());

		// third ques for N
		applicationFormEligibilityPage.selectThirdQuesN();
		if (applicationFormEligibilityPage.selectThirdQuesN().isSelected()) {
			WebElement warning = applicationFormEligibilityPage.getWarningMsg();
			log.info("warning displayed 3 : " + warning.isDisplayed());
			assertTrue(warning.isDisplayed());
			applicationFormEligibilityPage.getFaq();
			String parent=driver.getWindowHandle();
			Set<String>s1= driver.getWindowHandles();
			
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			    Assert.assertEquals(driver.switchTo().window(child_window).getCurrentUrl(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
			  }
			}
			driver.switchTo().window(parent);
			System.out.println(driver.switchTo().window(parent).getCurrentUrl());
		}

		// Third Ques for Y
		applicationFormEligibilityPage.selectThirdQuesY();
		assertTrue(applicationFormEligibilityPage.selectThirdQuesY().isSelected());

		// forth ques for N
		applicationFormEligibilityPage.selectFourthQuesN();
		if (applicationFormEligibilityPage.selectFourthQuesN().isSelected()) {
			WebElement warning = applicationFormEligibilityPage.getWarningMsg();
			log.info("warning displayed 4 : " + warning.isDisplayed());
			assertTrue(warning.isDisplayed());
			applicationFormEligibilityPage.getFaq();
			String parent=driver.getWindowHandle();
			Set<String>s1= driver.getWindowHandles();
			
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			    Assert.assertEquals(driver.switchTo().window(child_window).getCurrentUrl(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
			  }
			}
			driver.switchTo().window(parent);
			System.out.println(driver.switchTo().window(parent).getCurrentUrl());
		}

		// forth ques for Y
		applicationFormEligibilityPage.selectFourthQuesY();
		assertTrue(applicationFormEligibilityPage.selectFourthQuesY().isSelected());

		// fifth ques for N
		applicationFormEligibilityPage.selectFifthQuesN();
		if (applicationFormEligibilityPage.selectFifthQuesN().isSelected()) {
			WebElement warning = applicationFormEligibilityPage.getWarningMsg();
			log.info("warning displayed 5 : " + warning.isDisplayed());
			assertTrue(warning.isDisplayed());
			applicationFormEligibilityPage.getFaq();
			String parent=driver.getWindowHandle();
			Set<String>s1= driver.getWindowHandles();
			
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			    Assert.assertEquals(driver.switchTo().window(child_window).getCurrentUrl(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
			  }
			}
			driver.switchTo().window(parent);
			System.out.println(driver.switchTo().window(parent).getCurrentUrl());
		}

		// fifth ques for Y
		applicationFormEligibilityPage.selectFifthQuesY();
		assertTrue(applicationFormEligibilityPage.selectFifthQuesY().isSelected());
	}
	
	@Test
	public void verifySaveAndRefreshPage() {
		applicationFormEligibilityPage = new ApplicationFormEligibilityPage();
		applicationFormEligibilityPage.selectFirstQuestY();
		applicationFormEligibilityPage.selectSecondQuesY();
		applicationFormEligibilityPage.selectThirdQuesY();
		applicationFormEligibilityPage.selectFourthQuesY();
		applicationFormEligibilityPage.selectFifthQuesY();
		applicationFormEligibilityPage.clickSave();
		
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		assertTrue(applicationFormEligibilityPage.selectFirstQuestY().isSelected());
		assertTrue(applicationFormEligibilityPage.selectSecondQuesY().isSelected());
		assertTrue(applicationFormEligibilityPage.selectThirdQuesY().isSelected());
		assertTrue(applicationFormEligibilityPage.selectFourthQuesY().isSelected());
		assertTrue(applicationFormEligibilityPage.selectFifthQuesY().isSelected());
	}
	
}

