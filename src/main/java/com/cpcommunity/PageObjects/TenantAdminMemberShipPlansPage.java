package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TenantAdminMemberShipPlansPage extends BasePage {

	@FindBy(xpath = "//h2[contains(text(),'Manage Membership Plans')]")
	WebElement manageMembershipPlans;

	@FindBy(xpath = "//*[@id='btnAddNewPlan']")
	WebElement addNewPlan;

	@FindBy(xpath = "//*[@id='Name']")
	WebElement planName;

	@FindBy(xpath = "//*[@id='Price']")
	WebElement price;

	@FindBy(xpath = "//*[@id='DurationValue']")
	WebElement durationPeriod;
	@FindBy(xpath = "//*[@id='DurationTypeID']")
	WebElement durationType;
	@FindBy(xpath = "//*[@id='btnSave']/i")
	WebElement btnSave;
	@FindBy(xpath = "//*[@id='btn-ok']")
	WebElement btnOk;
	@FindBy(xpath = "//*[contains(text(),'Membership plan details updated successfully')]")
	WebElement success;
	@FindBy(xpath = "//*[@type='search']")
	WebElement search;
	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	WebElement firstPlan;
	@FindBy(xpath = "//*[contains(text(),'Showing 1 to 1 of 1 entries')]")
	WebElement showing;
	@FindBy(tagName = "body")
	WebElement planDetails;
	@FindBy(tagName = "iframe")
	WebElement iframe;

	public void createMembershipPlan(String name, String planDetails) throws Exception

	{
		click(addNewPlan, "add New Plan");
		waitForElementToPresent(planName);
		name = name + " " + getDateInDDMMMYYYY();
		scrollToElement(planName);
		type(planName, name, "Name");
		type(price, intToString(getnumber()), "price");
		switchToFrameByID(0);

		// driver.switchTo().frame(iframe);
		this.planDetails.clear();
		planDetails = planDetails + " " + getDateInDDMMMYYYY();
		type(this.planDetails, planDetails, "planDetails");

		driver.switchTo().defaultContent();

		type(durationPeriod, intToString(getnumber()/10), "durationPeriod");
		int DurationTypeID = getnumber() / 1000;
		if (DurationTypeID >= 1 && DurationTypeID <= 3) {
			DurationTypeID = 1;
		} else if (DurationTypeID >= 4 && DurationTypeID <= 6) {
			DurationTypeID = 2;
		} else if (DurationTypeID >= 7 && DurationTypeID <= 9) {
			DurationTypeID = 3;
		} else {
			DurationTypeID = 4;
		}

		selectUsingIndex(durationType, DurationTypeID, "duration Type");
		picture();
		click(btnSave, "btn Save");
		waitForElementToPresent(btnOk);
		waitForElementToPresent(success);
		picture();
		click(btnOk, "btn Ok");
		scrollUpVertically();

		searchPlan(name);

	}

	public void searchPlan(String name) throws Exception {
		type(search, name, "search");
		waitForElementToPresent(showing);
		picture();
		Thread.sleep(2000);
		assertEquals(firstPlan.getText(), name);
	}

	@FindBy(xpath = "//tbody/tr/td[2]/a")
	WebElement editPlan;

	public HashMap<String, String> getMembershipPlanDetails(String planName) throws Exception {

		HashMap<String, String> Planfeatures = new HashMap<String, String>();

		planName = planName + " " + getDateInDDMMMYYYY();
		searchPlan(planName);

		click(editPlan, "edit Plan");
		waitForElementToPresent(this.planName);

		Planfeatures.put("planName", planName);

		Planfeatures.put("price", getValueFromInputFiled(price));

		int dr = stringToInt(getValueFromInputFiled(durationPeriod));
		log.info("duration---> "+dr);
		String dt = getValueFromInputFiled(durationType);
		log.info("durationType---> "+dt);
		Planfeatures.put("startDate", addDaysToCurrentDate(0, 0, 0, 0));

		if (dt.equalsIgnoreCase("1")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(0, 0, 0, dr));
		}
		if (dt.equalsIgnoreCase("2")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(0, 0, dr, 0));
		}
		if (dt.equalsIgnoreCase("3")) {

			Planfeatures.put("endDate", addDaysToCurrentDate(0, dr, 0, 0));
		}
		if (dt.equalsIgnoreCase("4")) {
			Planfeatures.put("endDate", addDaysToCurrentDate(dr, 0, 0, 0));
		}

		log.info(Planfeatures);
		return Planfeatures;

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(manageMembershipPlans);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();

	}

}
