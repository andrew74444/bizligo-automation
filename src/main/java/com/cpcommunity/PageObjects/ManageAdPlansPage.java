package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cpcommunity.utilities.DriverManager;
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
	CharSequence[] planDetail;
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
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastemessage;
	@FindBy(xpath = "//div[@class='swal-modal']")
	WebElement swalmodal;

	@FindBy(xpath = "//*[@class='dataTables_info']")
	WebElement dataTablesInfo;

	@FindBy(xpath = "//*[@for='chkRequiresApproval']")
	WebElement chkRequiresApproval;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;

	@FindBy(xpath = "//body/p")
	WebElement enterTextInframe;
	                  //body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[9]/div[1]/label[1]/span[1]
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[9]/div[1]/label[1]/span[1]")
	WebElement inactiveStatus;
	@FindBy(xpath = "//small[normalize-space()='Plan name is Required']")
	WebElement allerrors;
	@FindBy(xpath = "//div[10]//div[1]//label[1]//span[1]")
	WebElement statusTA;
	@FindBy(xpath = "//small[contains(text(),'Plan name Should be minimum 2 characters and maxim')]")
	WebElement namefielderrors;
	
	@FindBy(xpath = "//small[normalize-space()='Please enter less than 11 characters']")
	WebElement pricefielderrors;
	
	@FindBy(xpath = "//small[normalize-space()='The value must be greater than 0']")
	WebElement durationerrors;
	
	@FindBy(xpath = "//div[@class='bootstrap-dialog-message']")
	WebElement sameplanerror;
	//button[normalize-space()='×']
	@FindBy(xpath = "//button[normalize-space()='×']")
	WebElement closeerror;
	@FindBy(xpath = "//input[@id='global']")
	WebElement global;
	
	
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
	
		
		return ExpectedConditions.visibilityOf(manageAdvertisementPlans);
	}
	
	public void saveWithoutenteringField() throws InterruptedException {
		 Thread.sleep(5000);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		scrollIntoView(btnSave);
		click(btnSave, "Save button");
		waitForElementToPresent(allerrors);
		String error=allerrors.getText();
		System.out.println("All fields are mandatory");
		Thread.sleep(5000);
		scrollIntoViewAndClick(cancel);
		Thread.sleep(8000);
		
	}
   public void checkFieldValidations(String name,String name1, String price,String price1, String planDetails, String duration,String duration1, String durationType,
			String adLocation, String adType, String approvalType) {
	   scrollUpVertically();
	   //scrollIntoView(btnAddNewPlan);
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		name1=name1+ "" + getDateInDDMMMYYYY();
		type(this.name, name, "name");
		waitForElementToPresent(namefielderrors);
		System.out.println("Plan name Should be minimum 2 characters and maximum 75 characters");
		type(this.name, name1, "name");
		type(this.price, price, "price");
		waitForElementToPresent(pricefielderrors);
		System.out.println("Please enter less than 11 characters");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		waitForElementToPresent(durationerrors);
		System.out.println("The value must be greater than 0");
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toaster);
		//AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		
   }
   
   public void createAdByTA(String name,String name1, String price,String price1, String planDetails, String duration,String duration1, String durationType,
			String adLocation, String adType, String approvalType) {
	   scrollUpVertically();
	   //scrollIntoView(btnAddNewPlan);
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.global);
		click(global, "Global");
		name1=name1+ "" + getDateInDDMMMYYYY();
		type(this.name, name, "name");
		waitForElementToPresent(namefielderrors);
		System.out.println("Plan name Should be minimum 2 characters and maximum 75 characters");
		type(this.name, name1, "name");
		type(this.price, price, "price");
		waitForElementToPresent(pricefielderrors);
		System.out.println("Please enter less than 11 characters");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		waitForElementToPresent(durationerrors);
		System.out.println("The value must be greater than 0");
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toaster);
		AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		
  }
   public void GlobalAdByTA(String community,String name1, String price1, String planDetails, String duration1, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
	   Thread.sleep(5000);
	   scrollUpVertically();
	   //scrollIntoView(btnAddNewPlan);
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.communityradiobtn);
		click(communityradiobtn, "Community");
		selectByVisibleText(communityselect, community, "Community");
		Thread.sleep(5000);
		name1=name1+ "" + getDateInDDMMMYYYY();
		Thread.sleep(2000);
		type(this.name, name1, "name");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toaster);
		//AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(5000);
 }
   
   public void GlobalInactiveAdByTA(String community,String name1, String price1, String planDetails, String duration1, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
	   scrollUpVertically();
	   //scrollIntoView(btnAddNewPlan);
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.communityradiobtn);
		click(communityradiobtn, "Community");
		selectByVisibleText(communityselect, community, "Community");
		Thread.sleep(3000);
		name1=name1+ "" + getDateInDDMMMYYYY();
		type(this.name, name1, "name");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		click(statusTA, "Satus");
		Thread.sleep(5000);
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toaster);
		AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(5000);
}
   
   public void checkRadioButton() {
	   scrollUpVertically();
	   //scrollIntoView(btnAddNewPlan);
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.global);
		click(global, "Global");  
		click(communityradiobtn, "Community");
		click(global, "Global");
		System.out.println("Cannot select two radio button.");
}
	
	public void createAdPlan(String name, String price, String planDetails, String duration, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
		waitForElementToPresent(dataTablesInfo);
		//String str = dataTablesInfo.getText();
		//int T1 = getString(str, 5);
		//int T2 = getString(str, 3);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		name=name+ "" + getDateInDDMMMYYYY();
		type(this.name, name, "name");
		type(this.price, price, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		//type(this.planDetails, "please check soon", "plan Details");
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		Thread.sleep(12000);
		//waitForElementToPresent(this.toaster);
		//AssertionHelper.verifyText(toaster.getText(), "Advertisement plan details saved.");
		//T1++;
//		WebElement ele;
//		if (T2 > 10) {
//			ele = driver.findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T2 + " of " + T1 + " entries')]"));
//		} else {
//			ele = driver.findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T1 + " of " + T1 + " entries')]"));
//		}
//		waitForElement(ele);
		picture();
	}
	
	public void createAdPlanwithsameName(String name, String price, String planDetails, String duration, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
		waitForElementToPresent(dataTablesInfo);
		//String str = dataTablesInfo.getText();
		//int T1 = getString(str, 5);
		//int T2 = getString(str, 3);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		type(this.name, name, "name");
		type(this.price, price, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		//type(this.planDetails, "please check soon", "plan Details");
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		waitForElementToPresent(this.sameplanerror);
		AssertionHelper.verifyText(sameplanerror.getText(), "Can't save this Plan because the specified Name already exists");
		Thread.sleep(5000);
		picture();
	}
	public void createInactiveAdPlan(String name1, String price, String planDetails, String duration, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToPresent(dataTablesInfo);
		//String str = dataTablesInfo.getText();
		//int T1 = getString(str, 5);
		//int T2 = getString(str, 3);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		name1=name1+ "" + getDateInDDMMMYYYY();
		type(this.name, name1, "name");
		type(this.price, price, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		click(inactiveStatus, "Satus");
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toastemessage);
		AssertionHelper.verifyText(toaster.getText(), "Advertisement plan details saved.");
		Thread.sleep(5000);
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
	
	@FindBy(xpath="//input[@id='PlanNameSearch']")
	WebElement plansearch;
	
	@FindBy(xpath="//select[@id='IsActiveSearch']")
	WebElement statussearch;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement search;
	
	@FindBy(xpath="//span[@class='label label-danger']")
	WebElement inactive;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement noplan;
	
	@FindBy(xpath="//span[@class='label label-success']")
	WebElement active;
	
	@FindBy(xpath="//a[@title='Click to edit this page']")
	WebElement edit;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	WebElement editplan;
	
	@FindBy(xpath="//div[9]//div[1]//label[1]//span[1]")
	WebElement status;
	
	@FindBy(xpath="//button[@id='btnSave']")
	WebElement save;
	
	@FindBy(xpath="//input[@id='community']")
	WebElement communityradiobtn;
	
	@FindBy(xpath="//select[@id='CommunityID']")
	WebElement communityselect;
	
	@FindBy(xpath="//div[@class='swal-text']")
	WebElement communityselectmsg;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--Cancel btn-danger']")
	WebElement cancelmsg;
	
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;
	@FindBy(xpath = "//a[normalize-space()='Revenue Reports']")
	WebElement revenuereport;
	
	
	
	public void searchInactivePlan(String plan,String status) throws InterruptedException {
		Thread.sleep(5000);
		scrollUpVertically();
		click(plansearch, "Search");
		type(plansearch, plan, "Plan Name");
		selectByVisibleText(statussearch, status, "Status");
		click(search, "Search");
		Thread.sleep(6000);
		if(inactive.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	public PaymentGatewaysPage verifyCAIsNotAblrToCreateAdPlanWithoutConfiguringPaymentGateways() {

		waitForElementToPresent(dataTablesInfo);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(configurePaymentGatewayToProceed);
		click(configureButton,"configure button");
		return (PaymentGatewaysPage) openPage (PaymentGatewaysPage.class);
	}
  public void checksearchfield(String plan,String plan1, String status) throws InterruptedException {
	  waitForElementToPresent(plansearch);
	  click(plansearch, "Search by plan name");
	  type(plansearch, plan, "PlAn Name");
	  click(search, "Search");
	  Thread.sleep(8000);
	  this.plansearch.clear();
	  click(plansearch, "Search by plan name");
	  type(plansearch, plan1, "PlAn Name");
	  click(search, "Search");
	  Thread.sleep(5000);
	  waitForElementToPresent(noplan);
	  System.out.println("There are currently no plans created. Would you like to create one?");
	  this.plansearch.clear();
	  Thread.sleep(5000);
	  selectByVisibleText(statussearch, status, "Inactive");
	  click(search, "Search");
	   
  }
  public void checkOnlyContainsActive() {
	  waitForElementToPresent(active);
	  if(active.isDisplayed()) {
		  Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	  
  }
  
   public void editPlanCreatedByTACA(String plan) throws InterruptedException {
	   waitForElementToPresent(plansearch);
	   type(plansearch, plan, "Plan Name");
	   click(search, "Search");
	   Thread.sleep(8000);
	   waitForElementToPresent(edit);
	   click(edit, "Edit");
	   scrollDownVertically();
	   click(status, "status");
	   Thread.sleep(7000);
	   click(save, "Save");
	   AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(8000);
	   
   }
   public void Noteditable(String plan) throws InterruptedException {
	   waitForElementToPresent(plansearch);
	   plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   click(search, "Search");
	   Thread.sleep(10000);
	   waitForElementToPresent(edit);
	   click(edit, "Edit");
	   Thread.sleep(4000);
	  
	   WebElement disable= this.durationType;
	   Assert.assertTrue(true, disable.getAttribute("disable"));
       System.out.println("Duration Type is in Disable mode");
       
       WebElement disable2= this.adLocation;
	   Assert.assertTrue(true, disable2.getAttribute("disable"));
       System.out.println("Advertisement location is in Disable mode");
		
       
       WebElement disable3= this.adType;
	   Assert.assertTrue(true, disable3.getAttribute("disable"));
       System.out.println("Advertisement type is in Disable mode");
       
       WebElement disable4= this.chkRequiresApproval;
	   Assert.assertTrue(true, disable3.getAttribute("disable"));
       System.out.println("Requires Approval is in Disable mode");
		   
		   click(save, "Save");
		   Thread.sleep(4000);
   }
       
      	  
   
   
   public void EditPlancreatedByTA(String plan,String name1, String price1, String planDetails, String duration1, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   click(search, "Search");
	   Thread.sleep(8000);
	   waitForElementToPresent(edit);
	   click(edit, "Edit");
	   Thread.sleep(5000);
		name1=name1+ "" + getDateInDDMMMYYYY();
		type(this.name, name1, "name");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");		
		click(btnSave, "Save button");
		//waitForElementToPresent(this.toaster);
		AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(3000);
}
   public void editPlan() throws InterruptedException {
	  Thread.sleep(9000);
	   waitForElementToPresent(edit);
	   click(edit, "Edit");
	   scrollDownVertically();
	  Thread.sleep(5000);
	   click(status, "status");
	   Thread.sleep(2000);
	   click(save, "Save");
	   AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(2000);
	   
   }
   public void inactivatePlanTA(String plan) throws InterruptedException {
	   Thread.sleep(9000);
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   Thread.sleep(4000);
	   click(search, "Search");
	   Thread.sleep(8000);
	   waitForElementToPresent(editplan);
	   click(editplan, "Edit");
	   scrollDownVertically();
	   Thread.sleep(8000);
	   click(statusTA, "Satus");
	   Thread.sleep(6000);
	   click(save, "Save");
	   AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		
	   
   }
   
   public void inactivatePlan(String plan) throws InterruptedException {
	   Thread.sleep(15000);
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   Thread.sleep(4000);
	   click(search, "Search");
	   Thread.sleep(9000);
	   waitForElementToPresent(editplan);
	   click(editplan, "Edit");
	   scrollDownVertically();
	   Thread.sleep(7000);
	   click(inactiveStatus, "Satus");
	   Thread.sleep(5000);
	   click(save, "Save");
	   //AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
   }
   public void Inactivate(String plan) throws InterruptedException {
	   Thread.sleep(3000);
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   //plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   Thread.sleep(4000);
	   click(search, "Search");
	   Thread.sleep(6000);
	   waitForElementToPresent(editplan);
	   click(editplan, "Edit");
	   scrollDownVertically();
	   Thread.sleep(6000);
	   click(inactiveStatus, "Satus");
	   Thread.sleep(5000);
	   click(save, "Save");
	   //AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		
	   
   }
   public void Activate(String plan) throws InterruptedException {
	   Thread.sleep(3000);
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   //plan=plan+ "" + getDateInDDMMMYYYY();
	   type(plansearch, plan, "Plan Name");
	   Thread.sleep(4000);
	   click(search, "Search");
	   Thread.sleep(6000);
	   waitForElementToPresent(editplan);
	   click(editplan, "Edit");
	   scrollDownVertically();
	   Thread.sleep(7000);
	   click(inactiveStatus, "Satus");
	   Thread.sleep(6000);
	   click(save, "Save");
	   //AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		
	   
   }
   
   public void IsPlanInactive(String plan) throws InterruptedException {
	   scrollUpVertically();
	   waitForElementToPresent(plansearch);
	   type(plansearch, plan, "Plan Name");
	   Thread.sleep(2000);
	   click(search, "Search");
	   Thread.sleep(4000);
	   if(inactive.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	   
   }
 public void checkCommunityDropdown() {
	 waitForElementToPresent(dataTablesInfo);
		click(btnAddNewPlan, "Add New Plan"); 
		waitForElementToPresent(communityradiobtn);
		click(communityradiobtn, "Community");
		click(communityselect, "communty");
		String COMMUNITY=communityselect.getText();
		System.out.println(COMMUNITY);
 }
 public void checkCommunityPaymentgatewayMsg(String communityName) throws InterruptedException {
	 waitForElementToPresent(dataTablesInfo);
		click(btnAddNewPlan, "Add New Plan"); 
		waitForElementToPresent(communityradiobtn);
		click(communityradiobtn, "Community");
		//click(communityselect, "communty");
		selectByVisibleText(communityselect, communityName, "Community Nmae");
		waitForElementToPresent(swalmodal);
	     String msg=communityselectmsg.getText();
		String expected="Configure Payment Gateway to proceed";
		Assert.assertEquals(msg, expected);
		System.out.println(msg);
		click(cancelmsg, "Mesage");
 }
  
  
  public void noncommunityPaymentGatewaymsg() throws InterruptedException {
	  click(btnAddNewPlan, "Add New Plan");
	  Thread.sleep(4000);
	  waitForElementToPresent(communityselectmsg);
	 // String communityMsg="communityselectmsg";
		//Assert.assertEquals(communityselectmsg, expected);
		//System.out.println(communityMsg);
		click(cancelmsg, "Mesage");
  }
  
  public void createAdWithoutApproval(String name, String price, String planDetails, String duration, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException {
		waitForElementToPresent(dataTablesInfo);
		//String str = dataTablesInfo.getText();
		//int T1 = getString(str, 5);
		//int T2 = getString(str, 3);
		Thread.sleep(5000);
		click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.name);
		name=name+ "" + getDateInDDMMMYYYY();
		type(this.name, name, "name");
		type(this.price, price, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("yes")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		//click(inactiveStatus, "Satus");
		click(btnSave, "Save button");
		waitForElementToPresent(this.toastemessage);
		AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
		Thread.sleep(5000);
		picture();
	}

  public void CreateAdUsingURL(String community,String name1, String price1, String planDetails, String duration1, String durationType,
			String adLocation, String adType, String approvalType) throws InterruptedException, AWTException{
	  Thread.sleep(5000);
 	 Robot robot = new Robot();                          
      robot.keyPress(KeyEvent.VK_CONTROL); 
      robot.keyPress(KeyEvent.VK_T); 
      robot.keyRelease(KeyEvent.VK_CONTROL); 
      robot.keyRelease(KeyEvent.VK_T);
     Thread.sleep(5000);
      //Switch focus to new tab
      ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      Thread.sleep(3000);
      driver.navigate().to("https://tenant1.bizligotest.com/eventmanager/promotions#");
      //driver.get("https://tenant1.bizligotest.com");
       Thread.sleep(8000);
	  System.out.println("opened");
	   click(btnAddNewPlan, "Add New Plan");
		waitForElementToPresent(this.communityradiobtn);
		click(communityradiobtn, "Community");
		selectByVisibleText(communityselect, community, "Community");
		Thread.sleep(3000);
		name1=name1+ "" + getDateInDDMMMYYYY();
		Thread.sleep(5000);
		type(this.name, name1, "name");
		type(this.price, price1, "price");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(planDetails);
		driver.switchTo().defaultContent();
		type(this.duration, duration1, "duration");
		selectByVisibleText(this.durationType, durationType, "duration Type");
		selectByVisibleText(this.adLocation, adLocation, "ad Location");
		selectByVisibleText(this.adType, adType, "Ad Type");
		if (approvalType.equalsIgnoreCase("no")) {
			click(chkRequiresApproval, "Approval approaval");
		}
		
		click(btnSave, "Save button");
		waitForElementToPresent(this.sameplanerror);
		AssertionHelper.verifyText(sameplanerror.getText(), "Can't save this Plan because the specified Name already exists");
		Thread.sleep(8000);
		String error=this.sameplanerror.getText();
		System.out.println(error);
		
        driver.switchTo().window(tabs.get(0));
         
         
		
}
	   
 
	    
  
    public void windowhandle() throws InterruptedException, AWTException {
    	 Thread.sleep(4000);
    	 Robot robot = new Robot();                          
         robot.keyPress(KeyEvent.VK_CONTROL); 
         robot.keyPress(KeyEvent.VK_T); 
         robot.keyRelease(KeyEvent.VK_CONTROL); 
         robot.keyRelease(KeyEvent.VK_T);

         //Switch focus to new tab
         ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));
         
         driver.get("https://tenant1.bizligotest.com/eventmanager/promotions#");
          Thread.sleep(4000);
  }
    
  
public void GlobalAdWithoutApproval(String community,String name1, String price1, String planDetails, String duration1, String durationType,
		String adLocation, String adType, String approvalType) throws InterruptedException {
   Thread.sleep(5000);
   scrollUpVertically();
   //scrollIntoView(btnAddNewPlan);
   click(btnAddNewPlan, "Add New Plan");
	waitForElementToPresent(this.communityradiobtn);
	click(communityradiobtn, "Community");
	selectByVisibleText(communityselect, community, "Community");
	Thread.sleep(5000);
	name1=name1+ "" + getDateInDDMMMYYYY();
	Thread.sleep(2000);
	type(this.name, name1, "name");
	type(this.price, price1, "price");
	driver.switchTo().frame(0);
	enterTextInframe.clear();
	enterTextInframe.sendKeys(planDetails);
	driver.switchTo().defaultContent();
	type(this.duration, duration1, "duration");
	selectByVisibleText(this.durationType, durationType, "duration Type");
	selectByVisibleText(this.adLocation, adLocation, "ad Location");
	selectByVisibleText(this.adType, adType, "Ad Type");
	if (approvalType.equalsIgnoreCase("yes")) {
		click(chkRequiresApproval, "Approval approaval");
	}
	Thread.sleep(2000);
	click(btnSave, "Save button");
	//waitForElementToPresent(this.toaster);
	AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
	Thread.sleep(5000);
}

public RevenueReportPage goToRevenueReport() {
	//waitForElementToPresent(dashboardreport);
	click(dashboardreport, "Dashboard Reports");
	waitForElementToPresent(revenuereport);
	click(revenuereport, "Revenue Report");
	return (RevenueReportPage) openPage(RevenueReportPage.class);	
}
  
  
  
  
}
  
  

