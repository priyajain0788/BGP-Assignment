package com.bgp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.bgp.base.TestBase;

public class ApplicationFormCostPage extends TestBase {

	Logger log = Logger.getLogger(ApplicationFormCostPage.class);

	/*
	 * @FindBy(xpath = "//*[contains(text(),'Third Party Vendors')]") WebElement
	 * thirdPartyVendor;
	 */

	@FindBy(id = "react-project_cost-vendors-add-item")
	WebElement addNewItem;

	@FindBy(xpath = "//*[contains(@id,'react-project_cost-vendors-0')]/div/div/div[1]/div[1]/div/div[2]/label[2]/span[1]")
	WebElement vendorRegistered;

	/*
	 * @FindBy(css = "input#react-project_cost-vendors-0-vendor_name")
	 * WebElement vendorName;
	 */

	@FindBy(css = "input#react-project_cost-vendors-0-amount_in_billing_currency")
	WebElement estimatedCost;

	@FindBy(id = "save-btn")
	WebElement saveBtn;

	/*
	 * @FindBy(id = "next-btn") WebElement nextBtn;
	 */

	public ApplicationFormCostPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillThirdPartyVendor() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement tpv = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Third Party Vendors')]")));
		tpv.click();

	}

	public void selectAddNewItem() {
		addNewItem.click();
	}

	public void selectVendorRegistered() {
		vendorRegistered.click();
	}

	public void selectVendorName() {
		WebElement vName = driver.findElement(By.id("react-project_cost-vendors-0-vendor_name"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		vName = wait.until(ExpectedConditions.elementToBeClickable(vName));
		vName.clear();
		vName.sendKeys("Testing");
		wait.until(ExpectedConditions.textToBePresentInElementValue(vName, "Testing"));
	}

	public void uploadSupportingDoc() {
		try {
			Thread.sleep(5000);
			WebElement selectFile = driver
					.findElement(By.xpath("//*[contains(@id,'react-project_cost-vendors-0-attachments-btn')]"));
			selectFile.click();
			Screen screen = new Screen();
			Pattern fileTextBox = new Pattern(System.getProperty("user.dir") + "/src/main/resources//fileName.png");
			Pattern openBox = new Pattern(System.getProperty("user.dir") + "/src/main/resources/open.png");

			screen.wait(fileTextBox, 20);
			screen.type(fileTextBox, System.getProperty("user.dir") + "\\TestData\\ACE_QE_Tech_Challenge_Jun2019.pdf");
			screen.click(openBox);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillEstimatedCost() {
		estimatedCost.sendKeys("25");
	}

	public void clickSave() {
		saveBtn.click();
	}

	public void clickNext() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.id("next-btn")));
		next.click();
	}

	public void fillCostPageForm() {
		fillThirdPartyVendor();
		selectAddNewItem();
		selectVendorRegistered();
		selectVendorName();
		uploadSupportingDoc();
		fillEstimatedCost();
		clickSave();
		clickNext();
	}
}
