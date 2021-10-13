package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.testng.Assert;


import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class ManageResourcesPage  extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
				return ExpectedConditions.visibilityOf(panelTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//h2[normalize-space()='Manage Resources']")
	WebElement panelTitle;
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//button[normalize-space()='Add Resource']")
	WebElement addResource;
	@FindBy(xpath = "//input[@id='ResourceTitle']")
	WebElement enterTitle;
	@FindBy(xpath = "//small[@data-fv-validator='stringLength'][contains(text(),'Title')]")
	WebElement titleError;
	@FindBy(xpath = "//input[@ng-value='data.UploadResourceType.Video']")
	WebElement resourceVedio;
	@FindBy(xpath = "//input[@ng-value='data.UploadResourceType.Image']")
	WebElement resourceImage;
	@FindBy(xpath = "//input[@value='3']")
	WebElement resourceDocument;
	@FindBy(xpath = "//input[@value='4']")
	WebElement resourceAudio;

	@FindBy(xpath = "//input[@class='select2-search__field'][@placeholder='Select Groups']")

	@FindBy(xpath = "//input[@placeholder='Select Groups']")

	WebElement selectGroup;
	@FindBy(xpath = "//input[@type='radio'][@name='UploadType'][@value='1']")
	WebElement internal;
	@FindBy(xpath = "//input[@type='radio'][@name='UploadType'][@value='2']")
	WebElement external;
	@FindBy(xpath = "//input[@id='FileURL']")
	WebElement URL;
	@FindBy(xpath = "//input[@placeholder='Add Keywords']")
	WebElement addkeywords;
	@FindBy(xpath = "//textarea[@id='Description']")
	WebElement description;
	@FindBy(xpath = "//div[@class='toggle btn btn-success']")
	WebElement Active;
	@FindBy(xpath = "//div[@class='toggle btn btn-danger off']")
	WebElement Inactive;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search;
	@FindBy(xpath = "//label[normalize-space()='Paid']")
	WebElement paid;
	@FindBy(xpath = "//label[normalize-space()='Free']")
	WebElement free;
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement toastMessage;
	@FindBy(xpath = "//td[@ng-bind='resource.Title']")
	WebElement title;
	@FindBy(xpath = "//select[@name='Community']")
	WebElement Community;
	@FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement Toggledropdownmenu;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement Logout;
	@FindBy(xpath = "//th[@aria-label='Title : activate to sort column ascending']")
	WebElement titleable;
	@FindBy(xpath = "//th[@aria-label='Title : activate to sort column ascending']")
	WebElement resourcesName;
	@FindBy(xpath = "//li[@class='select2-results__option'][3]")
	List<WebElement> GroupName;


	@FindBy(xpath = "//button[normalize-space()='Add Resource']")
	WebElement addBtn;
	@FindBy(xpath = "//input[@id='ResourceTitle']")
	WebElement title1;
	@FindBy(xpath = "//input[@class='ng-pristine ng-valid ng-empty ng-touched']")
	WebElement imageResource;
	@FindBy(xpath = "//input[@value='3']")
	WebElement document;
	@FindBy(xpath = "//label[normalize-space()='Free']")
	WebElement freeBtn;
	@FindBy(xpath = "//select[@name='Community']")
	WebElement selectCommuntiy;
	@FindBy(xpath = "//input[@class='ng-pristine ng-valid ng-not-empty ng-touched']")
	WebElement internalBtn;
	@FindBy(xpath = "//tbody/tr[2]/td[2]/p[1]")
	WebElement editSecond;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement updateBtn;
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;

	
	
	
	//a[normalize-space()='Logout']
	public void AddFields(String Title, String Title1, String Group, String Description, String url) throws InterruptedException {
		waitForElementToPresent(addResource);
		click(addResource, "Add Resource");
		waitForElementToPresent(enterTitle);
		this.enterTitle.clear();
		type(enterTitle, Title, "Resource Title");
		waitForElementToPresent(titleError);
		if(titleError.isDisplayed()) {
			this.enterTitle.clear();
			type(this.enterTitle, Title1, "Resource Title");
			waitForElementToPresent(free);
			click(free, "Free");
			//waitForElementToPresent(GroupName);

		
			waitForElementToPresent(selectGroup);
			this.selectGroup.sendKeys("test123");
			//type(this.selectGroup,Group,"Group");
			//waitForElementToPresent(GroupName);
			//click(GroupName,"Test123");
			//selectUsingIndex(selectGroup,3,"Test123");
			//selectByVisibleText(this.selectGroup,Group,"Group");
            Thread.sleep(2000);
			waitForElementToPresent(description);
			type(this.description, Description, "Description");
			waitForElementToPresent(external);
			click(external, "External");

			waitForElementToPresent(external);
			click(external, "External");
			waitForElementToPresent(description);
			type(this.description, Description, "Description");

			waitForElementToPresent(URL);
			type(this.URL, url, "Url");
			waitForElementToPresent(resourceImage);
			click(resourceImage, "Image");
			waitForElementToPresent(Active);
			click(Active, "Inactive It");


			waitForElementToPresent(selectGroup);
			type(this.selectGroup,Group,"Group");
			//waitForElementToPresent(GroupName);
			//click(GroupName,"Test123");
			//selectUsingIndex(selectGroup,3,"Test123");
	
			

			waitForElementToPresent(save);
			click(save, "Save");
			AssertionHelper.verifyText(toastMessage.getText(), "Success! Resources saved");
		}
		}
	private void click(List<WebElement> groupName2, String elementName) {
		// TODO Auto-generated method stub
		
	}

	private void waitForElementToPresent(List<WebElement> groupName2) {
		// TODO Auto-generated method stub
		
	}

	public void checkResouces() {
		scrollUpVertically();
		waitForElementToPresent(title);
		String value=this.title.getText();
		AssertionHelper.verifyText(title.getText(), "Resource1");
			
	}
	public void AddFieldswithoutGroup(String Title, String Title1,String Description, String url) throws InterruptedException {
		waitForElementToPresent(addResource);
		click(addResource, "Add Resource");
		waitForElementToPresent(enterTitle);
		this.enterTitle.clear();
		type(enterTitle, Title, "Resource Title");
		waitForElementToPresent(titleError);
		if(titleError.isDisplayed()) {
			this.enterTitle.clear();
			type(this.enterTitle, Title1, "Resource Title");
			waitForElementToPresent(free);
			click(free, "Free");
			Thread.sleep(2000);
			waitForElementToPresent(description);
			type(this.description, Description, "Description");
			waitForElementToPresent(external);
			click(external, "External");
			waitForElementToPresent(URL);
			type(this.URL, url, "Url");
			waitForElementToPresent(resourceImage);
			click(resourceImage, "Image");
			waitForElementToPresent(Active);
			click(Active, "Inactive It");
			waitForElementToPresent(save);
			click(save, "Save");
			AssertionHelper.verifyText(toastMessage.getText(), "Success! Resources saved");


		Thread.sleep(3000);

		}
		}


	public void AddFieldswithCommunity( String Title1, String community, String Description, String url) throws InterruptedException {
		waitForElementToPresent(addResource);
		click(addResource, "Add Resource");
		waitForElementToPresent(enterTitle);
		this.enterTitle.clear();
			type(this.enterTitle, Title1, "Resource Title");
			waitForElementToPresent(free);
			click(free, "Free");
			Thread.sleep(2000);
			waitForElementToPresent(Community);
			selectByVisibleText(this.Community,community,"Community");
			Thread.sleep(2000);
			waitForElementToPresent(description);
			type(this.description, Description, "Description");
			waitForElementToPresent(external);
			click(external, "External");
			waitForElementToPresent(URL);
			type(this.URL, url, "Url");
			waitForElementToPresent(resourceImage);
			click(resourceImage, "Image");
			waitForElementToPresent(save);
			click(save, "Save");
			AssertionHelper.verifyText(toastMessage.getText(), "Success! Resources saved");
		}
	
		public HomePage logout() throws InterruptedException{
			Thread.sleep(4000);
			waitForElementToPresent(Toggledropdownmenu);
			click(Toggledropdownmenu,"Toggledropdownmenu");
			Thread.sleep(1000);
			waitForElementToPresent(Logout);
			click(Logout,"Logout");
			return (HomePage) openPage(HomePage.class);
			// new HomePage(driver, );
		}
	
	public void checkResources() {
		waitForElementToPresent(titleable);
		String Value=this.titleable.getText();
	    
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public void createResources(String Title) {
		waitForElementToPresent(addBtn);
		click(addBtn,"add button");
		type(title,Title,Title);
		click(document,"document");
		click(freeBtn,"free");
		
	}
	
	public void updateResources(String Title,String Description) throws InterruptedException {
		waitForElementToPresent(editSecond);
		click(editSecond,"edit");
		type(title1,Title,Title);
		type(description,Description,Description);
		click(updateBtn,"updateBtn");
		Thread.sleep(3000);
		System.out.println(SuccessPopup.getText());
		if(SuccessPopup.getText().equalsIgnoreCase("Resources saved")) {
			Assert.assertTrue(true);
			System.out.println("Admin able to update resource");
		}
	}


	
	
	}	

