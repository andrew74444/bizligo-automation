package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class PlansPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@FindBy(xpath = "//button[@id='btnAddNew']")
	WebElement btnAddNew;

	@FindBy(xpath = "//input[@id='Name']")
	WebElement name;

	@FindBy(xpath = "//*[@id='Name']/..//*[@disabled='disabled']")
	WebElement nameDisabled;

	@FindBy(xpath = "//input[@id='Price']")
	WebElement price;

	@FindBy(xpath = "//input[@id='Price']/..//*[@disabled='disabled']")
	WebElement priceDisabled;

	@FindBy(xpath = "//input[@id='Duration']")
	WebElement duration;

	@FindBy(xpath = "//input[@id='Duration']/..//*[@disabled='disabled']")
	WebElement durationDisabled;

	@FindBy(xpath = "//select[@id='DurationType'] | //select[@id='DurationTypeID']")
	WebElement durationType;

	@FindBy(xpath = "//select[@id='DurationType']/..//*[@disabled='disabled'] | //select[@id='DurationTypeID']/..//*[@disabled='disabled']")
	WebElement durationTypeDisabled;

	@FindBy(xpath = "//input[@id='NumberOfAdmins']")
	WebElement NumberOfAdmins;

	@FindBy(xpath = "//input[@id='NumberOfGroups']")
	WebElement NumberOfGroups;

	@FindBy(xpath = "//input[@id='NumberOfMembers']")
	WebElement NumberOfMembers;

	@FindBy(xpath = "//input[@id='NumberOfAdmins']/..//*[@disabled='disabled']")
	WebElement NumberOfAdminsDisabled;

	@FindBy(xpath = "//input[@id='NumberOfGroups']/..//*[@disabled='disabled']")
	WebElement NumberOfGroupsDisabled;

	@FindBy(xpath = "//input[@id='NumberOfMembers']/..//*[@disabled='disabled']")
	WebElement NumberOfMembersDisabled;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement eventsCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement adsCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	WebElement manageCampaignCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	WebElement paymentGatewaysCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[5]")
	WebElement groupsCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[6]")
	WebElement zoomCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	WebElement surveysCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	WebElement jobBoardCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[9]")
	WebElement promoCodesCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[10]")
	WebElement membershipPlansCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[11]")
	WebElement crmCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[12]")
	WebElement blogCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[13]")
	WebElement memberActivityReportCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[14]")
	WebElement communityMembersCheckbox;

	@FindBy(xpath = "(//input[@type='checkbox'])[15]")
	WebElement communityDiscussionsCheckbox;

	@FindBy(xpath = "//select[@id='Storage']")
	WebElement Storage;

	@FindBy(xpath = "//div[@id='editorRow']//label[2]//input[1]	")
	WebElement Email;

	@FindBy(xpath = "//label[2]//input[1]")
	WebElement FullTime;

	@FindBy(xpath = "//label[3]//input[1]")
	WebElement Calls;

	@FindBy(xpath = "//label[contains(text(),'No')]")
	WebElement AllowRenewalsNo;

	@FindBy(xpath = "//label[contains(text(),'Yes')]")
	WebElement AllowRenewalsYes;

	@FindBy(xpath = "//label[contains(text(),'In-Active')]")
	WebElement InActive;

	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement btnSave;

	@FindBy(xpath = "//label[@class='btn btn-success toggle-on'][contains(text(),'Active')]")
	WebElement Active;

	@FindBy(xpath = "//*[@name='Description']")
	WebElement description;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastmessage;

	@FindBy(xpath = "//*[@class='dataTables_info']")
	WebElement TotalMembershiplans;

	@FindBy(xpath = "//*[@name='btnSave']")
	WebElement save;

	@FindBy(xpath = "//input[@id='PlanName']")
	WebElement planName;
	@FindBy(xpath = "//input[@id='DurationNumber']")
	WebElement durationNumber;
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement isActiveSearch;
	@FindBy(xpath = "//*[@id='btnSearch']")
	WebElement btnSearch;
	@FindBy(xpath = "//tbody/tr/td[2]")
	WebElement editPlan;
	@FindBy(xpath = "//tbody/tr/td[7]")
	WebElement MembershipPlanStatus;

	@FindBy(xpath = "//label[contains(text(),'Status')]/..//label[@class='btn btn-success toggle-on']")
	WebElement toggleOn;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(btnAddNew);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public void selectFeaturePlan() {

	}

	@FindBy(xpath = "//*[contains(text(),'Configure Payment Gateway to proceed')]")
	WebElement configurePaymentGatewayToProceed;
	@FindBy(xpath = "//button[contains(text(),'Configure')]")
	WebElement configureButton;

	public PaymentGatewaysPage verifyCANotAbleToCreatePaidPlanForPayMentGatewayNotConfigured(String price) {

		click(btnAddNew, "Add Paln");
		waitForElementToPresent(this.name);
		type(this.price, price, "Price");
		waitForElementToPresent(configurePaymentGatewayToProceed);
		click(configureButton, "configure Button");
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
	}

	public void MembershipPlanCreate(String name, String price, String duration, String durationType,
			String description) throws Exception {
		click(btnAddNew, "Add Paln");
		waitForElementToPresent(this.name);
		// int ID1 = this.getFeatureID();
		// String feature = this.selectMembershipPlan(ID1);

		type(this.name, name, "Name");
		type(this.price, price, "Price");
		type(this.duration, duration, "duration");

		selectByVisibleText(this.durationType, durationType, "durationType");
		type(this.description, description, "description");
		click(save, "save button");
		Thread.sleep(4000);

		// WebElement ele = driver
		// .findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T1 + " of " + T1
		// + " entries')]"));
		// waitHelper.waitForElement(ele, expTime);
		picture();
		Thread.sleep(4000);
	}

	public String createMembershipPlan(String name, String price, String duration, String durationType,
			String description) throws Exception {
		waitForElementToPresent(btnAddNew);
		String str = TotalMembershiplans.getText();
		click(btnAddNew, "Add Paln");
		waitForElementToPresent(this.name);
		int ID1 = this.getFeatureID();
		String feature = this.selectMembershipPlan(ID1);
		int T1 = getString(str, 5);
		type(this.name, feature + " " + T1, "Name");
		type(this.price, price, "Price");
		type(this.duration, duration, "duration");

		selectByVisibleText(this.durationType, durationType, "durationType");
		type(this.description, description, "description");
		click(save, "save button");
		Thread.sleep(4000);
		T1++;
		// WebElement ele = driver
		// .findElement(By.xpath("//*[contains(text(),'Showing 1 to " + T1 + " of " + T1
		// + " entries')]"));
		// waitHelper.waitForElement(ele, expTime);
		picture();
		return feature;
	}

	public String selectMembershipPlan(int ID) {
		String Membership = null;
		if (ID < 4) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")),
					"Selecting the Advertisements Feature");
			Membership = "Advertisements";

		}

		else if (ID > 3 && ID < 7) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")), "Selecting the Groups Feature");
			Membership = "Groups";

		}

		else if (ID > 6) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")), "Selecting the Job Board Feature");
			Membership = "Careers";

		}
		return Membership;
	}

	public void selectFeature(int ID1) {

		if (ID1 == 1) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")), "");
		}

		else if (ID1 == 2) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")), "");
		}

		else if (ID1 == 3) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")), "");
		}

		else if (ID1 == 4) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")), "");
		}

		else if (ID1 == 5) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")), "");
		}

		else if (ID1 == 6) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")), "");
		}

		else if (ID1 == 7) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")), "");
		}

		else if (ID1 == 8) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")), "");
		}

		else if (ID1 == 9) {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")), "");
		}

		else {
			click(driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")), "");

		}

	}

	public int getFeatureID() {

		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 0809190355
		String number = dateFormat.format(date);
		int result = Integer.valueOf(number);
		System.out.println(result);
		int num = result;
		int sum = 0;
		while (num > 0) {
			sum = (sum + num) % 10;
			num = num / 10;
		}
		// System.out.println(sum);
		return sum;

	}

	public void CreatePlan(String PlanName, String PlanPrice, String PlanDuration, String NumberOfAdmins,
			String NumberOfGroups, String NumberOfMembers) {

		// Feature1
		click(btnAddNew, "AddNew");
		waitForElementToPresent(name);
		PlanName = PlanName + " " + getDateInDDMMMYYYY();
		type(name, PlanName, "Name");
		type(price, PlanPrice, "Price");
		type(duration, PlanDuration, "Duration");
		type(this.NumberOfAdmins, NumberOfAdmins, "NumberOfAdmins");
		type(this.NumberOfGroups, NumberOfGroups, "NumberOfGroups");
		type(this.NumberOfMembers, NumberOfMembers, "NumberOfMembers");

		int DurationTypeID = this.getFeatureID();
		if (DurationTypeID >= 1 && DurationTypeID <= 3) {
			DurationTypeID = 1;
		} else if (DurationTypeID >= 4 && DurationTypeID <= 6) {
			DurationTypeID = 2;
		} else if (DurationTypeID >= 7 && DurationTypeID <= 9) {
			DurationTypeID = 3;
		} else {
			DurationTypeID = 4;
		}

		System.out.println(DurationTypeID);

		selectUsingIndex(durationType, DurationTypeID, "duration Type");

		if (getRandomBoolean()) {
			click(adsCheckbox, "ads Check box");
		}
		if (getRandomBoolean()) {
			click(manageCampaignCheckbox, "manage Campaign Check box");
		}
		if (getRandomBoolean()) {
			click(paymentGatewaysCheckbox, "payment Gateways Check box");
		}
		if (getRandomBoolean()) {
			click(groupsCheckbox, "groups Check box");
		}
		if (getRandomBoolean()) {
			click(zoomCheckbox, "zoom Check box");
		}
		if (getRandomBoolean()) {
			click(surveysCheckbox, "surveys Check box");
		}
		if (getRandomBoolean()) {
			click(jobBoardCheckbox, "job Board Check box");
		}
		if (getRandomBoolean()) {
			click(promoCodesCheckbox, "promo Codes Check box");
		}
		if (getRandomBoolean()) {
			click(membershipPlansCheckbox, "membership Plans Check box");
		}
		if (getRandomBoolean()) {
			click(crmCheckbox, "crm Check box");
		}
		if (getRandomBoolean()) {
			click(blogCheckbox, "blog Check box");
		}
		if (getRandomBoolean()) {
			click(memberActivityReportCheckbox, "member Activity Report Check box");
		}
		if (getRandomBoolean()) {
			click(communityMembersCheckbox, "community Members Check box");
		}
		if (getRandomBoolean()) {
			click(communityDiscussionsCheckbox, "community Discussions Check box");
		}

		int StorageID = this.getFeatureID();
		if (StorageID >= 1 && StorageID <= 3) {
			StorageID = 1;
			click(Email, "Email");
		} else if (StorageID >= 4 && StorageID <= 6) {
			StorageID = 2;
			click(FullTime, "FullTime");
		} else {
			StorageID = 3;
			click(Calls, "Calls");
		}
		DurationTypeID = 3;
		selectUsingIndex(Storage, DurationTypeID, "duration Type");
		click(btnSave, "Save");

		waitForElementToPresent(toastmessage);
		AssertionHelper.verifyText(toastmessage.getText(), "Pricing plan details saved successfully");

	}

	// public void CreatePlan(String PlanName, String PlanPrice, String
	// PlanDuration, String NumberOfAdmins,
	// String NumberOfGroups, String NumberOfMembers) {
	//
	// // Feature1
	// click(btnAddNew, "AddNew");
	// waitForElementToPresent(name);
	// int ID1 = this.getFeatureID();
	// int ID2 = this.getFeatureID();
	// while (ID1 == ID2) {
	// ID2 = this.getFeatureID();
	// if (ID1 == 2 && ID2 == 4) {
	// ID2 = this.getFeatureID();
	// } else if (ID1 == 6 && ID2 == 1 || ID1 == 7 && ID2 == 1) {
	// ID2 = this.getFeatureID();
	// } else if (ID1 == 6 && ID2 == 1 || ID1 == 7 && ID2 == 1) {
	// ID2 = this.getFeatureID();
	// }
	// }
	// this.selectFeature(ID1);
	// this.selectFeature(ID2);
	// type(name, PlanName + ID1 + ID2, "Name");
	// type(price, PlanPrice, "Price");
	// type(duration, PlanDuration, "Duration");
	// type(this.NumberOfAdmins, NumberOfAdmins, "NumberOfAdmins");
	// type(this.NumberOfGroups, NumberOfGroups, "NumberOfGroups");
	// type(this.NumberOfMembers, NumberOfMembers, "NumberOfMembers");
	//
	// int DurationTypeID = this.getFeatureID();
	// if (DurationTypeID >= 1 && DurationTypeID <= 3) {
	// DurationTypeID = 1;
	// } else if (DurationTypeID >= 4 && DurationTypeID <= 6) {
	// DurationTypeID = 2;
	// } else if (DurationTypeID >= 7 && DurationTypeID <= 9) {
	// DurationTypeID = 3;
	// } else {
	// DurationTypeID = 4;
	// }
	//
	// System.out.println(DurationTypeID);
	//
	// selectUsingIndex(durationType, DurationTypeID,"duration Type");
	//
	// int StorageID = this.getFeatureID();
	// if (StorageID >= 1 && StorageID <= 3) {
	// StorageID = 1;
	// click(Email, "Email");
	// } else if (StorageID >= 4 && StorageID <= 6) {
	// StorageID = 2;
	// click(FullTime, "FullTime");
	// } else {
	// StorageID = 3;
	// click(Calls, "Calls");
	// }
	// DurationTypeID = 3;
	// selectUsingIndex(Storage, DurationTypeID,"duration Type");
	// click(btnSave, "Save");
	//
	// waitForElementToPresent(toastmessage);
	// AssertionHelper.verifyText(toastmessage.getText(), "Pricing plan details
	// saved successfully");
	//
	// }

	public void checkPurchasedMembershipPlanIsNotEditable() throws Exception {

		waitForElementToPresent(editPlan);
		click(editPlan, "edit MembershipPlan");
		waitForElementToPresent(nameDisabled);
		nameDisabled.isDisplayed();
		priceDisabled.isDisplayed();
		durationDisabled.isDisplayed();
		durationTypeDisabled.isDisplayed();

	}

	public void InActivateTheMembershipPlan() throws Exception {
		waitForElementToPresent(editPlan);
		click(editPlan, "edit MembershipPlan");
		waitForElementToPresent(toggleOn);
		click(toggleOn, "Status Active");
		click(save, "save");
		Thread.sleep(3000);
		waitForElementToPresent(editPlan);
		AssertionHelper.verifyText(MembershipPlanStatus.getText(), "In-Active");
	}

	@FindBy(xpath = "//*[contains(text(),'Membership Plan duration cannot exceed the Pricing Plan duration of your community')]")
	WebElement MembershipPlanDurationCannotExceedThePricingPlanDuration;

	public void checkMembershipPlanDurationCannotExceedThePricingPlanDuration() {
		waitForElementToPresent(MembershipPlanDurationCannotExceedThePricingPlanDuration);
		picture();

	}

	@FindBy(xpath = "//*[contains(text(),'Plan name already exists. Please enter a new plan name')]")
	WebElement planNameAlreadyExists;

	public void planNameAlreadyExsits() {
		planNameAlreadyExists.isDisplayed();
	}

	public int getTotalActivePlansCount() throws Exception {

		selectByVisibleText(isActiveSearch, "Active", "Status");
		click(btnSearch, "btn Search");
		Thread.sleep(10000);
		String str = TotalMembershiplans.getText();
		return getString(str, 5);

	}

	public HashMap<String, String> getPricingPlanFeatures(String planName) throws Exception {

		// create a HashMap and print
		HashMap<String, String> Planfeatures = new HashMap<String, String>();

		planName = planName + " " + getDateInDDMMMYYYY();
		searchPlan(planName);

		click(editPlan, "edit Plan");
		waitForElementToPresent(name);

		int dr = stringToInt(getValueFromInputFiled(duration));
		String dt = getValueFromInputFiled(durationType);

			
		if (dt.equalsIgnoreCase("number:4")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(dr, 0, 0));
		}
		if (dt.equalsIgnoreCase("number:1")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(0, 0, dr));
		}
		if (dt.equalsIgnoreCase("number:2")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(0, dr, 0));
		}
		if (dt.equalsIgnoreCase("number:3")) {
			dr = dr * 7;
			Planfeatures.put("endDate", addDaysToCurrentDate(dr, 0, 0));
		}
		
		
		
		if (adsCheckbox.isSelected()) {
			Planfeatures.put("Advertisments", "Yes");
			log.info("Advertisments - Yes");
		}
		if (manageCampaignCheckbox.isSelected()) {
			Planfeatures.put("Bulk mail", "Yes");
			log.info("Bulk mail - Yes");
		}
		if (paymentGatewaysCheckbox.isSelected()) {
			Planfeatures.put("Payment Gateway", "Yes");
			log.info("Payment Gateway - Yes");
		}
		if (groupsCheckbox.isSelected()) {
			Planfeatures.put("Groups", "Yes");
			log.info("Groups - Yes");
		}
		if (eventsCheckbox.isSelected()) {
			Planfeatures.put("Events", "Yes");
			log.info("Events - Yes");
		}
		if (zoomCheckbox.isSelected()) {
			Planfeatures.put("Zoom", "Yes");
			log.info("Zoom - Yes");
		}
		if (surveysCheckbox.isSelected()) {
			Planfeatures.put("Serveys", "Yes");
			log.info("Serveys - Yes");
		}
		if (jobBoardCheckbox.isSelected()) {
			Planfeatures.put("Job", "Yes");
			log.info("Job - Yes");
		}
		if (promoCodesCheckbox.isSelected()) {
			Planfeatures.put("Promo code", "Yes");
			log.info("Promo code - Yes");
		}
		if (membershipPlansCheckbox.isSelected()) {
			Planfeatures.put("Memberships", "Yes");
			log.info("Memberships - Yes");
		}
		if (crmCheckbox.isSelected()) {
			Planfeatures.put("CRM", "Yes");
			log.info("CRM - Yes");
		}
		if (blogCheckbox.isSelected()) {
			Planfeatures.put("Blog", "Yes");
			log.info("Blog - Yes");
		}
		if (memberActivityReportCheckbox.isSelected()) {
			Planfeatures.put("Report", "Yes");
			log.info("Report - Yes");
		}
		if (communityMembersCheckbox.isSelected()) {
			Planfeatures.put("Members", "Yes");
			log.info("Members - Yes");
		}
		if (communityDiscussionsCheckbox.isSelected()) {
			Planfeatures.put("Discussions", "Yes");
			log.info("Discussions - Yes");
		}

		log.info(Planfeatures);
		
		return Planfeatures;
	}

	public void searchPlan(String planName) throws Exception {

		type(this.planName, planName, " plan Name");
		click(btnSearch, "btn Search");
		Thread.sleep(10000);

	}

}
