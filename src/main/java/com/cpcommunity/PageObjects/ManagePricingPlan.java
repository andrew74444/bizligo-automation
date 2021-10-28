package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ManagePricingPlan extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(managepricingplan);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
		updateClass(pageheader, "nav_menu");
	}
	@FindBy(xpath="//h2[normalize-space()='Manage Pricing Plans']")
	WebElement managepricingplan;
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath="//button[@id='btnAddNew']")
	WebElement btnaddNew;
	@FindBy(xpath = "//input[@id='Name']")
	WebElement planName;
	@FindBy(xpath="//input[@id='Price']")
	WebElement price;
	@FindBy(xpath = "//input[@id='Duration']")
	WebElement duration;
	@FindBy(xpath="//select[@id='DurationType']")
	WebElement durationType;
	@FindBy(xpath = "//input[@id='NumberOfAdmins']")
	WebElement NoAdmin;
	@FindBy(xpath="//input[@id='NumberOfGroups']")
	WebElement NoGroup;
	@FindBy(xpath = "//input[@id='NumberOfMembers']")
	WebElement NoMember;
	@FindBy(xpath = "//select[@id='Storage']")
	WebElement storage;
	@FindBy(xpath="//label[1]//input[1]")
	WebElement email;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement create;
	@FindBy(xpath = "//input[@id='PlanName']")
	WebElement searchbyPlan;
	@FindBy(xpath="//input[@id='DurationNumber']")
	WebElement searchByDuration;
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement searchbyStatus;
	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement search;
	@FindBy(xpath = "//small[contains(text(),'Plan name already exists. Please enter a new plan ')]")
	WebElement sameplanError;
	@FindBy(xpath = "//label[@class='btn btn-danger active toggle-off'][contains(text(),'In-Active')]")
	WebElement inactive;
	@FindBy(xpath = "//tr[@class='odd']//a[@title='Click to edit this page']")
	WebElement edit;
	@FindBy(xpath = "//div[@id='editorRow']//div[@class='x_panel']")
	WebElement panel;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//div[@class='col-sm-9 col-xs-12']//div[2]//div[1]//input[1]")
	WebElement AdCheckbox;
	@FindBy(xpath = "//div[@class='col-sm-9 col-xs-12']//div[3]//div[1]//input[1]")
	WebElement managecapCheckbox;
	@FindBy(xpath = "//div[@id='editorRow']//div[@class='row']//div[4]//div[1]//input[1]")
	WebElement PGcheckbox;
	@FindBy(xpath = "//div[@id='editorRow']//div[@class='row']//div[6]//div[1]//input[1]")
	WebElement zoomCheckbox;
	@FindBy(xpath = "//div[@id='editorRow']//div[@class='row']//div[5]//div[1]//input[1]")
	WebElement groupscheckbox;
	@FindBy(xpath = "//div[7]//div[1]//input[1]")
	WebElement surveycheckbox;
	@FindBy(xpath = "//div[8]//div[1]//input[1]")
	WebElement JBcheckbox;
	@FindBy(xpath = "//div[10]//div[1]//input[1]")
	WebElement MPcheckbox;
	@FindBy(xpath = "//div[9]//div[1]//input[1]")
	WebElement PCcheckbox;
	@FindBy(xpath = "//div[11]//div[1]//input[1]")
	WebElement CRMcheckbox;
	@FindBy(xpath = "//div[12]//div[1]//input[1]")
	WebElement blogscheckbox;
	@FindBy(xpath = "//div[13]//div[1]//input[1]")
	WebElement MARcheckbox;
	@FindBy(xpath = "//div[14]//div[1]//input[1]")
	WebElement CMcheckbox;
	@FindBy(xpath = "//div[15]//div[1]//input[1]")
	WebElement CDcheckbox;
	@FindBy(xpath = "(//input[@ng-click='data.ToggleFeaturesSelection(feature)'])")
	List<WebElement> checkbox;
	
	
	
	
	public String createPlan(String Name, String Price, String Duration, String  adminNo, String groupNo, String memberNo ) throws InterruptedException {
		 Name=Name+" " + getDateInDDMMMYYYY();
		 waitForElementToPresent(btnaddNew);
		 click(btnaddNew, "Add plan");
		waitForElementToPresent(planName);
		type(planName, Name, "plan Name");
		type(price, Price, "Price");
		type(duration, Duration, "Duration");
		//selectUsingIndex(duration, 1, "Duration");
		selectUsingIndex(durationType, 4, "Duration type");
		type(NoAdmin, adminNo, "Number of admin");
		type(NoGroup, groupNo, "Number of group");
		type(NoMember, memberNo, "Number of member");
		selectUsingIndex(storage, 1, "Storage");
		click(email, "email");
		
		click(create, "Create");
		Thread.sleep(3000);
		return Name;
	
		
	}
	public String createPlanwithoutonefeatue(String feature,String Name, String Price, String Duration, String  adminNo, String groupNo, String memberNo ) throws InterruptedException {
		 Name=Name+" " + getDateInDDMMMYYYY();
		 waitForElementToPresent(btnaddNew);
		 click(btnaddNew, "Add plan");
		waitForElementToPresent(planName);
		type(planName, Name, "plan Name");
		type(price, Price, "Price");
		type(duration, Duration, "Duration");
		//selectUsingIndex(duration, 1, "Duration");
		selectUsingIndex(durationType, 4, "Duration type");
		type(NoAdmin, adminNo, "Number of admin");
		type(NoGroup, groupNo, "Number of group");
		type(NoMember, memberNo, "Number of member");
		selectUsingIndex(storage, 1, "Storage");
		click(email, "email");
		//WebElement element= driver.findElement(By.xpath("//label[@ng-bind='feature.Name'][contains(text(),'"+feature+"')]"));
		int T=checkbox.size();
		System.out.println(T);
		//scrollToElement(element);
	for(int i=2;i<=T;i++) {
		WebElement element= driver.findElement(By.xpath("(//input[@ng-click='data.ToggleFeaturesSelection(feature)'])["+i+"]"));
		click(element, "Features");
	}
	for(int j=1;j<=T;j++) {
		String element1= driver.findElement(By.xpath("(//div[@class='col-sm-4 col-xs-12 checkbox checkbox-primary checkbox-inline'])["+j+"]")).getText();
	if(element1.equals(feature)) {
		WebElement element2= driver.findElement(By.xpath("(//input[@ng-click='data.ToggleFeaturesSelection(feature)'])["+j+"]"));
			click(element2, "Feature");
			break;
		}
	}
		click(create, "Create");
		Thread.sleep(3000);
		return Name;
	
		
	}
	
	private void click(List<WebElement> element, String elementName) {
		// TODO Auto-generated method stub
		
	}

	public void searchPricingPlan(String plan, String duration, String status) throws InterruptedException {
		
		waitForElementToPresent(searchbyPlan);
		type(searchbyPlan, plan, "Plan Name");
		click(search, "Search");
		Thread.sleep(3000);
		searchbyPlan.clear();
		type(searchByDuration, duration, "duration");
		click(search, "Search");
		Thread.sleep(3000);
		searchByDuration.clear();
		selectUsingIndex(searchbyStatus, 1, "Status");
		click(search, "Search");
		
	}
	public void createsameplan(String Name, String Price) {
		
		 waitForElementToPresent(btnaddNew);
		 click(btnaddNew, "Add plan");
		waitForElementToPresent(planName);
		type(planName, Name, "plan Name");
		type(price, Price, "Price");
		String error=sameplanError.getText();
		System.out.println(error);
		this.create.isDisplayed();
		
	}
	
	public void inactivate(String plan) throws InterruptedException {
		Thread.sleep(5000);
		plan=plan+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchbyPlan);
		type(searchbyPlan, plan, "Plan Name");
		click(search, "Search");
		Thread.sleep(8000);
		click(edit, "Edit");
		click(inactive, "Inactive");
		Thread.sleep(2000);
		
	}
	
	public void configuration(String plan) throws InterruptedException {
		Thread.sleep(5000);
		plan=plan+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchbyPlan);
		type(searchbyPlan, plan, "Plan Name");
		click(search, "Search");
		Thread.sleep(8000);
		click(edit, "Edit");
		waitForElementToPresent(panel);
		System.out.println(panel.getText());
		
	}
	public String UpdatePlan(String Name, String Price, String Duration, String  adminNo, String groupNo, String memberNo ) throws InterruptedException {
		Name=Name+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchbyPlan);
		type(searchbyPlan, Name, "Plan Name");
		click(search, "Search");
		Thread.sleep(8000);
		click(edit, "Edit");
		waitForElementToPresent(planName);
		type(planName, Name, "plan Name");
		type(price, Price, "Price");
		type(duration, Duration, "Duration");
		//selectUsingIndex(duration, 1, "Duration");
		selectUsingIndex(durationType, 4, "Duration type");
		type(NoAdmin, adminNo, "Number of admin");
		type(NoGroup, groupNo, "Number of group");
		type(NoMember, memberNo, "Number of member");
		selectUsingIndex(storage, 1, "Storage");
		click(email, "email");
		click(inactive, "Inactive");
		click(create, "Create");
		Thread.sleep(3000);
		return Name;
	
		
	}
	public void readOnlyField(String Name) throws InterruptedException {
		
		waitForElementToPresent(searchbyPlan);
		type(searchbyPlan, Name, "Plan Name");
		click(search, "Search");
		Thread.sleep(8000);
		click(edit, "Edit");
		Assert.assertTrue(true, planName.getAttribute("disable"));
	    System.out.println("Plan name is read only mode");
	    Assert.assertTrue(true, NoAdmin.getAttribute("disable1"));
	    System.out.println("No of admin is read only mode");
	    click(cancel, "Cancel");   
	}
}
