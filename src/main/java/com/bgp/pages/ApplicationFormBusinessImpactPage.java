package com.bgp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bgp.base.TestBase;
import com.bgp.util.DateUtil;


public class ApplicationFormBusinessImpactPage extends TestBase {
	@FindBy(id = "react-project_impact-fy_end_date_0")
	WebElement currentFYEndDate;

	@FindBy(id = "react-project_impact-fy_end_date_1")
	WebElement firstYearFYEndDate;

	@FindBy(id = "react-project_impact-fy_end_date_2")
	WebElement secondYearFYEndDate;

	@FindBy(id = "react-project_impact-fy_end_date_3")
	WebElement thirdYearFYEndDate;

	@FindBy(id = "react-project_impact-overseas_sales_0")
	WebElement currentFYOverseasSales;

	@FindBy(id = "react-project_impact-overseas_sales_1")
	WebElement firstYearFYOverseasSales;

	@FindBy(id = "react-project_impact-overseas_sales_2")
	WebElement secondYearFYOverseasSales;

	@FindBy(id = "react-project_impact-overseas_sales_3")
	WebElement thirdYearFYOverseasSales;

	@FindBy(id = "react-project_impact-overseas_investments_0")
	WebElement currentFYOverseasInvestment;

	@FindBy(id = "react-project_impact-overseas_investments_1")
	WebElement firstYearFYOverseasInvestment;

	@FindBy(id = "react-project_impact-overseas_investments_2")
	WebElement secondYearFYOverseasInvestment;

	@FindBy(id = "react-project_impact-overseas_investments_3")
	WebElement thirdYearFYOverseasInvestment;

	@FindBy(id = "react-project_impact-rationale_remarks")
	WebElement rationaleForProjections;

	@FindBy(id = "react-project_impact-benefits_remarks")
	WebElement nonTangibleBenefits;

	@FindBy(id = "next-btn")
	WebElement nextBtn;

	@FindBy(id = "save-btn")
	WebElement saveBtn;

	public ApplicationFormBusinessImpactPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillCurrentFYEndDate() {
		currentFYEndDate.sendKeys(DateUtil.getDate());
	}

	public void fillFirstYearFYEndDate() {
		firstYearFYEndDate.sendKeys(DateUtil.getDate());
	}

	public void fillSecondYearFYEndDate() {
		secondYearFYEndDate.sendKeys(DateUtil.getDate());
	}

	public void fillThirdYearFYEndDate() {
		thirdYearFYEndDate.sendKeys(DateUtil.getDate());
	}

	public void fillCurrentFYOverseasSales() {
		/*WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project_impact-overseas_sales_0")));*/
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		currentFYOverseasSales.sendKeys("2500");
	}
	
	public void fillBusinessImpactpageForm(){
		fillCurrentFYEndDate();
		fillCurrentFYOverseasSales();
		fillFirstFYOverseasSales();
		fillSecondFYOverseasSales();
		fillThirdFYOverseasSales();
		fillCurrentFYOverseasInvestment();
		fillFirstFYOverseasInvestment();
		fillSecondFYOverseasInvestment();
		fillThirdFYOverseasInvestment();
		fillRationaleForProjections();
		fillNonTangibleBenefits();
		clickSave();
		clickNext();
	}

	public void fillFirstFYOverseasSales() {
		firstYearFYOverseasSales.sendKeys("2500");
	}

	public void fillSecondFYOverseasSales() {
		secondYearFYOverseasSales.sendKeys("2500");
	}

	public void fillThirdFYOverseasSales() {
		thirdYearFYOverseasSales.sendKeys("2500");
	}
	
	public void fillCurrentFYOverseasInvestment() {
		currentFYOverseasInvestment.sendKeys("2500");
	}

	public void fillFirstFYOverseasInvestment() {
		firstYearFYOverseasInvestment.sendKeys("2500");
	}

	public void fillSecondFYOverseasInvestment() {
		secondYearFYOverseasInvestment.sendKeys("2500");
	}

	public void fillThirdFYOverseasInvestment() {
		thirdYearFYOverseasInvestment.sendKeys("2500");
		
	}
	
	public void fillRationaleForProjections(){
		rationaleForProjections.sendKeys("Rationale For Projections");
	}
	
	public void fillNonTangibleBenefits(){
		nonTangibleBenefits.sendKeys("Non Tangible Benefits");
	}
	public void clickSave(){
		saveBtn.click();
	}
	
	public void clickNext(){
		nextBtn.click();
	}

}
