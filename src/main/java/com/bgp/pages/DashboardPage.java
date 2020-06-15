package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgp.base.TestBase;

public class DashboardPage extends TestBase {
	Logger log = Logger.getLogger(DashboardPage.class);
	public WebDriver driver;
	
	/*@FindBy(xpath="//*[@id = 'dashboard-menubox-app-apply-grant']/section/div")
	WebElement getNewGrant;*/

	public DashboardPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver clickGetNewGrant(){
		WebElement newGrant =  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id = 'dashboard-menubox-app-apply-grant']/section/div")));
		newGrant.click();
		
		return driver;
		}
	}


