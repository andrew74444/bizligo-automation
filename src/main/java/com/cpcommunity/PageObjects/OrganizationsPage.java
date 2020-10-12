package com.cpcommunity.PageObjects;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.cpcommunity.utilities.DriverManager;

public class OrganizationsPage extends BasePage {

	@FindBy(xpath = "//*[@id='btnAddNew']")
	WebElement addNew;

	// @FindBy(xpath = "//*[contains(text(),'Click here')]")
	// WebElement ;
	@FindBy(xpath = "//*[@id='Name']")
	WebElement orgName;

	@FindBy(xpath = "(//*[@class='select2-search__field'])[2]")
	WebElement businessCategories;

	@FindBy(xpath = "//*[@id='NumberOfEmployeesID']")
	WebElement numberOfEmployeesID;

	@FindBy(xpath = "//*[@name='BusinessDescription']")
	WebElement businessDescription;

	@FindBy(xpath = "//*[@name='Website']")
	WebElement website;
	@FindBy(xpath = "//*[@name='Email']")
	WebElement email;
	@FindBy(xpath = "//*[@name='Phone']")
	WebElement phone;
	@FindBy(xpath = "//*[@name='Extension']")
	WebElement extension;
	@FindBy(xpath = "//*[@name='Fax']")
	WebElement fax;
	@FindBy(xpath = "//*[@name='MembershipPlan']")
	WebElement membershipPlan;
	@FindBy(xpath = "//*[@name='CompanyLogoImage']")
	WebElement companyLogoImage;

	@FindBy(xpath = "//*[@id='EntityStatusID']")
	WebElement EntityStatusID;

	@FindBy(xpath = "//*[@name='btnSave']")
	WebElement btnSave;
	@FindBy(xpath = "//*[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "//*[@class='fa fa-users']")
	WebElement manageMembers;

	@FindBy(xpath = "//*[@id='firstname']")
	WebElement firstname;
	@FindBy(xpath = "//*[@id='lastname']")
	WebElement lastname;

	@FindBy(xpath = "//*[@id='username']")
	WebElement username;
	@FindBy(xpath = "//*[@id='password']")
	WebElement password;
	@FindBy(xpath = "//*[@id='confirmpassword']")
	WebElement confirmpassword;
	@FindBy(xpath = "//*[@id='AddMemberlocation']")
	WebElement addMemberlocation;
	@FindBy(xpath = "//*[@name='IsContactPrimary']")
	WebElement contactType;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement save;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okBtn; 

	@FindBy(xpath = "//*[@id='CompanyNameSearch']")
	WebElement companyNameSearch;

	@FindBy(xpath = "//*[@id='btnSearch']")
	WebElement btnSearch;

	@FindBy(xpath = "//*[@class='fa fa-location-arrow']")
	WebElement manageLocation;

	@FindBy(xpath = "//*[contains(text(),'Add Location')]")
	WebElement addLocation;

	@FindBy(xpath = "//*[@name='LocationName']")
	WebElement locationName;

	@FindBy(xpath = "//*[@name='LocationType']")
	WebElement locationType;

	@FindBy(xpath = "//*[@name='LocationAddress']")
	WebElement locationAddress;

	@FindBy(xpath = "//*[@name='LocationPhone']")
	WebElement locationPhone;

	@FindBy(xpath = "//*[@name='LocationPhoneExtention']")
	WebElement locationPhoneExtention;

	@FindBy(xpath = "//*[@name='LocationFax']")
	WebElement locationFax;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement savebtn;

	@FindBy(xpath = "//*[@class='panel panel-primary']")
	WebElement locationPanel;

	@FindBy(xpath = "//*[contains(text(),'Showing 1 to 1 of 1 entries')]")
	WebElement showing1To1Of1Entries;

	@FindBy(xpath = "//*[@title='Approve this membership']")
	WebElement approve;
	
	
	@FindBy(xpath = "//*[@class='modal-content']//*[contains(text(),' Yes, Proceed')]")
	WebElement YesProceed;
	
	 @FindBy(xpath = "//*[@id='orgTable']/tbody/tr[1]/td[8]//*[contains(text(),'Active')]")
	 WebElement active;
	// @FindBy(xpath = "")
	// WebElement ;
	// @FindBy(xpath = "")
	// WebElement ;

	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(addNew);
	}

	public void createOrganization(String name, String noOfEmp, String description, String Categories, String email,
			String phone, String extension, String fax, String membershipPlan, String companyLogoImage)
			throws Exception {

		name = name + getSystemCurrentDate() + getSystemCurrentMonth();
		String website = "https://pamten" + getSystemCurrentDate() + getSystemCurrentMonth() + ".com";
		click(addNew, "add New Organizations");
		waitForElementToPresent(orgName);
		type(orgName, name, "org Name");
		type(businessDescription, description, "business Description");
		selectByVisibleText(numberOfEmployeesID, noOfEmp, "noOfEmp");
		type(businessCategories, Categories, "business Categories");
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);

		type(this.website, website, "website");
		type(this.email, email, "email");
		type(this.phone, phone, "phone");
		type(this.extension, extension, "extension");
		type(this.fax, fax, "fax");
		selectByVisibleText(this.membershipPlan, membershipPlan, "membership Plan");

		Thread.sleep(8000);
		this.companyLogoImage.sendKeys(companyLogoImage);
		// type(this.companyLogoImage, companyLogoImage, "company Logo Image");
		selectByVisibleText(this.EntityStatusID, "Active", "Status");
		click(btnSave, "Save");
		waitForElementToPresent(toastMessage);
		Thread.sleep(1000);
		System.out.println(toastMessage.getText());
		Thread.sleep(3000);
		picture();
	}

	public void addMember(String companyNameSearch, String firstName, String LastName, String username, String password,
			String confirmpassword, String location, String isContactPrimary) throws Exception {
		companyNameSearch = companyNameSearch + getSystemCurrentDate() + getSystemCurrentMonth();
		organizationSearch(companyNameSearch);

		click(manageMembers, "manage Members");
		waitForElementToPresent(addNew);
		Thread.sleep(5000);

		click(addNew, "Add");
		waitForElementToPresent(firstname);
		Thread.sleep(1000);
		type(firstname, firstName, "last Name");
		type(lastname, LastName, "last Name");
		if (username.length() == 0) {
			username = "andrew74444+a" + getSystemCurrentDate() + getSystemCurrentMonth() + "@gmail.com";
		}
		System.out.println(username);
		type(this.username, username, "Email");
		type(this.password, password, "password");
		type(this.confirmpassword, confirmpassword, "confirm Password");

		selectByVisibleText(this.addMemberlocation, location, location);

		System.out.println(getAllDropDownData(contactType));

		if (isContactPrimary.equalsIgnoreCase("Yes")) {
			selectByVisibleText(this.contactType, " Primary Contact ", "Primary Contact");
		} else {
			selectByVisibleText(this.contactType, " Secondary Contact ", "Secondary Contact");
		}
		picture();
		click(save, "save");
		waitForElementToPresent(okBtn);
		click(okBtn, "Ok Button");
		picture();
	}

	public void addLocation(String companyNameSearch, String locationName, String locationType, String address,
			String ph, String ext, String fax) throws Exception {

		organizationSearch(companyNameSearch);
		waitForElementToPresent(this.manageLocation);
		Thread.sleep(5000);

		click(manageLocation, "manageLocation");
		waitForElementToPresent(this.addLocation);
		click(addLocation, "addLocation");
		waitForElementToPresent(this.locationName);
		Thread.sleep(1000);
		type(this.locationName, locationName, "location Name");
		selectByVisibleText(this.locationType, locationType, locationType);
		type(locationAddress, address, "Address");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);

		type(locationPhone, ph, "ph");
		type(locationPhoneExtention, ext, "ext");
		type(locationFax, fax, "fax");
		click(savebtn, "Save");
		waitForElementToPresent(locationPanel);
		picture();
	}

	// table[@id='orgTable']//td[3]

	public void organizationSearch(String companyNameSearch) throws Exception {
		
		type(this.companyNameSearch, companyNameSearch, "company Name Search");
		click(btnSearch, "Search");
		waitForElementToPresent(showing1To1Of1Entries);
		Thread.sleep(3000);

	}

	public void approveOrganization(String orgName) throws Exception {
		type(this.companyNameSearch, orgName, "Org Name Search");
		click(btnSearch, "Search");
		picture();
		waitForElementToPresent(showing1To1Of1Entries);
		Thread.sleep(3000);
		click(approve, "approve");
		waitForElementToPresent(YesProceed);
		picture();
		click(YesProceed, "Yes Proceed");
		picture();
		waitForElementToPresent(okBtn);
		click(okBtn, "Ok");
		waitForElementToPresent(active);
		picture();
		// this.organizationSearch(orgName);

	}

	// https://gwcuat.bizligo.com/event/details/2020-IBA-Golf-Outing/6635
	// https://gwcuat.bizligo.com/event/details/Senator-Tom-Kean-Virtual-Town-Hall/6631
	// https://gwcuat.bizligo.com/event/details/2016-Small-Business-Economic-Outlook-Luncheon/6106

}
