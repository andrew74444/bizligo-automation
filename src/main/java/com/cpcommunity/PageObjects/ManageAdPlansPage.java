package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class ManageAdPlansPage extends BasePage {

	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}

	
	@FindBy(xpath = "//h2[contains(text(),'Manage Advertisement Plans')]")
	WebElement manageAdvertisementPlans;

	@FindBy(xpath = "//*[@id='btnAddNewPlan']")
	WebElement btnAddNewPlan;

	@FindBy(xpath = "//*[@name='Name']")
	WebElement name;

	@FindBy(xpath = "//*[@name='Price']")
	WebElement price;

	@FindBy(tagName = "body")
	WebElement planDetails;

	@FindBy(xpath = "//*[@name='DurationValue']")
	WebElement duration;

	@FindBy(xpath = "//*[@id='DurationTypeID']")
	WebElement durationType;

	@FindBy(xpath = "//*[@id='AdLocation']")
	WebElement adLocation;

	@FindBy(xpath = "//*[@id='ViewType']")
	WebElement adType;

	@FindBy(xpath = "//*[@id='IsNotify']")
	WebElement isNotify;

	@FindBy(xpath = "//*[@id='btnSave']")
	WebElement btnSave;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement toaster;

	@FindBy(xpath = "//*[@class='dataTables_info']")
	WebElement dataTablesInfo;

	@FindBy(xpath = "//*[@for='chkRequiresApproval']")
	WebElement chkRequiresApproval;

	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
	
		
		return ExpectedConditions.visibilityOf(manageAdvertisementPlans);
	}

	public void createAdPlan(String name, String price, String planDetails, String duration, String durationType,
			String adLocation, String adType, String approvalType) {
		waitForElementToPresent(dataTablesInfo);
		String str = dataTablesInfo.getText();
		int T1 = getString(str, 5);
		int T2 = getString(str, 3);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		type(this.name, name, "name");
		type(this.price, price, "price");
		driver.switchTo().frame(0);
		type(this.planDetails, "please check soon", "plan Details");
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		waitForElementToPresent(this.toaster);
		AssertionHelper.verifyText(toaster.getText(), "Advertisement plan details saved.");
		T1++;
//		WebElement ele;
//		if (T2 > 10) {
//			ele = driver.findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T2 + " of " + T1 + " entries')]"));
//		} else {
//			ele = driver.findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T1 + " of " + T1 + " entries')]"));
//		}
//		waitForElement(ele);
		picture();
	}

	public void updateAdPlandetails() {
	}

	public void verifythedatasavedinDB() {
		String query = "SELECT TOP 10 ID,Name,Price,DurationValue,DurationTypeID,Adlocation,RequiresApproval,createddate,Createdby,isactive,Viewtype,Communityid FROM PromotionPlans ORDER BY ID desc";
	}
	
	@FindBy(xpath="//*[contains(text(),'Configure Payment Gateway to proceed')]")
	WebElement configurePaymentGatewayToProceed;
	
	@FindBy(xpath="//button[contains(text(),'Configure')]")
	WebElement configureButton;
	
	
	
	
	

	public PaymentGatewaysPage verifyCAIsNotAblrToCreateAdPlanWithoutConfiguringPaymentGateways() {

		waitForElementToPresent(dataTablesInfo);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(configurePaymentGatewayToProceed);
		click(configureButton,"configure button");
		return (PaymentGatewaysPage) openPage (PaymentGatewaysPage.class);
	}

}
