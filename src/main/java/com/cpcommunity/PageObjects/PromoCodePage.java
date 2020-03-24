package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.cpcommunity.utilities.DriverManager;

public class PromoCodePage extends BasePage {

	protected void getPageScreenSot() {

		aShot();

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(managePromoCodes);
	}

	@FindBy(xpath = "//*[contains(text(),'Manage Promo Codes')]")
	WebElement managePromoCodes;
	@FindBy(xpath = "//*[contains(text(),'Add New')]")
	WebElement addNew;
	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement btnSearch;
	@FindBy(xpath = "//input[@id='PromoCodeName']")
	WebElement promoCodeName;
	@FindBy(xpath = "//div[@class='radio radio-primary']//input[@name='ExpiryBy']")
	WebElement expiryFrom;

	@FindBy(xpath = "//input[@id='ExpiryStartDate']")
	WebElement openCalendar;
	@FindBy(xpath = "//div[contains(@class,'daterangepicker dropdown-menu ltr show-calendar openscenter')]//input[contains(@name,'daterangepicker_start')]")
	WebElement expiryStartDate;
	@FindBy(xpath = "//div[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//input[@name='daterangepicker_end']")
	WebElement expiryEndDate;
	@FindBy(xpath = "//label[@class='radio-inline']//input[@name='ExpiryBy']")
	WebElement noExpiry;
	@FindBy(xpath = "//*[contains(text(),'Discount')]/following-sibling::div//*[@value='1']")
	WebElement discountPercentBtn;
	@FindBy(xpath = "//*[contains(text(),'Discount')]/following-sibling::div//*[@value='2']")
	WebElement DiscountAmountBtn;
	@FindBy(xpath = "//*[contains(text(),'Discount')]/following-sibling::div//*[@name='DiscountByPercentage']")
	WebElement DiscountByPercentageValue;
	@FindBy(xpath = "//*[contains(text(),'Discount')]/following-sibling::div//*[@name='DiscountByValue']")
	WebElement discountByValue;
	@FindBy(xpath = "//input[contains(@placeholder,'Max Number of Uses')]")
	WebElement maxNumberofUses;
	@FindBy(xpath = "//*[contains(text(),'Advertisement Plans')]/..//input")
	WebElement advertisementPlansBtn;
	@FindBy(xpath = "//div[contains(@class,'col-md-2 col-xs-12 radio radio-primary m-pull-left')]//input[contains(@name,'AdvertisementsTypes')]")
	WebElement allAdvertisementsPlans;
	@FindBy(xpath = "//body[contains(@class,'nav-md')]/div[contains(@class,'container body')]/div[contains(@class,'main_container')]/div[contains(@class,'right_col')]/div/div/div[contains(@class,'ng-scope')]/div[@id='DiscountController']/div[@id='editorRow']/div[contains(@class,'col-md-12 col-sm-12 col-xs-12')]/div[contains(@class,'x_panel')]/div[contains(@class,'x_content')]/form[@id='DiscountForm']/fieldset/div[contains(@class,'AppliesToContainer')]/div[contains(@class,'col-md-10 col-sm-5 col-xs-12 form-group has-feedback')]/div[contains(@class,'form-group')]/div[contains(@class,'col-md-4 col-xs-12 radio radio-primary m-pull-left')]/div[1]")
	WebElement AdvertisementsPlansChooseBtn;
	@FindBy(xpath = "//input[contains(@placeholder,'Select advertisement plans or search...')]")
	WebElement selectAdvertisementPlans;
	@FindBy(xpath = "//div[contains(@class,'applies-to-events form-group ng-scope')]//div[contains(@class,'col-md-3 col-xs-12 checkbox checkbox-primary')]//input[contains(@name,'AppliesTo[]')]")
	WebElement eventsBtn;
	@FindBy(xpath = "//div[contains(@class,'col-md-2 col-xs-12 radio radio-primary')]//input[contains(@name,'EventTypes')]")
	WebElement allEvents;
	@FindBy(xpath = "(//body[contains(@class,'nav-md')]/div[contains(@class,'container body')]/div[contains(@class,'main_container')]/div[contains(@class,'right_col')]/div/div/div[contains(@class,'ng-scope')]/div[@id='DiscountController']/div[@id='editorRow']/div[contains(@class,'col-md-12 col-sm-12 col-xs-12')]/div[contains(@class,'x_panel')]/div[contains(@class,'x_content')]/form[@id='DiscountForm']/fieldset/div[contains(@class,'AppliesToContainer')]/div[contains(@class,'col-md-10 col-sm-5 col-xs-12 form-group has-feedback')]/div[contains(@class,'applies-to-events form-group ng-scope')]/div[contains(@class,'col-md-4 col-xs-12 radio radio-primary')]/div[1]/*)[1]")
	WebElement chooseEventsBtn;
	@FindBy(xpath = "//div[contains(@class,'applies-to-membership ck-checkbox')]//div[contains(@class,'col-md-3 col-xs-12 checkbox checkbox-primary')]//input[contains(@name,'AppliesTo[]')]")
	WebElement membershipPlansBtn;
	@FindBy(xpath = "//input[@placeholder='Select events or search...']")
	WebElement selectEvent;

	@FindBy(xpath = "//div[contains(@class,'col-md-2 col-xs-12 radio radio-primary m-pull-left')]//input[contains(@name,'MembershipTypes')]")
	WebElement allMemberships;
	@FindBy(xpath = "//input[@placeholder='Select membership plans or search...']")
	WebElement chooseMemberships;
	@FindBy(xpath = "//div[@class='form-group has-feedback']//input[@name='MembershipTypes']")
	WebElement selectMembership;
	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement save;
	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElement toastMessage;
	@FindBy(xpath = "//*[@class='calendar left']")
	WebElement calendarLeft;
	@FindBy(xpath = "//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//*[@class='calendar right']")
	WebElement calendarRight;
	@FindBy(xpath = "//div[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//button[@class='applyBtn btn btn-sm btn-success'][contains(text(),'Apply')]")
	WebElement applyButton;

	public void createPromocode(String promoCode, String promoCodeExpiry, String discountByPercent,
			String discountByValue, String discountByPercentageValue, String maxNumberofUses, String appliesToAd,
			String appliesToMembership, String appliesToEvents, String allAds, String allEvents, String allMemberships,
			String advertisementPlan, String event, String memberShipPlan) throws Exception {

		click(addNew, "Add New button");
		waitForElementToPresent(promoCodeName);
		String y = getSystemCurrentYear();
		
		String date = getSystemCurrentDate();
		String month = getSystemCurrentMonth();
		type(promoCodeName, promoCode + month + date + y, "promo Code");
		if (promoCodeExpiry.equalsIgnoreCase("No Expiry")) {
			click(noExpiry, "No Expiry");
		} else {
			click(openCalendar, "Calendar");
			waitForElementToPresent(expiryStartDate);

			String promoCodeExpiryDate = month + "/" + date + "/" + y;
			type(expiryStartDate, promoCodeExpiryDate, promoCodeExpiryDate);
			type(expiryEndDate, promoCodeExpiryDate, promoCodeExpiryDate);
			click(applyButton, "applyButton");
		}
		int d = stringToInt(discountByPercentageValue);
		if (d > 0) {
			click(discountPercentBtn, "discount Percent ");
			type(this.DiscountByPercentageValue, discountByPercentageValue, discountByPercentageValue);
		} else {
			click(DiscountAmountBtn, "discount value ");
			type(this.discountByValue, discountByValue, discountByValue);
		}
		type(this.maxNumberofUses, maxNumberofUses, maxNumberofUses);
		if (appliesToAd.equalsIgnoreCase("yes")) {
			click(advertisementPlansBtn, "advertisement Plans");
			if (allAds.equalsIgnoreCase("yes")) {
				click(allAdvertisementsPlans, "All Advertisements Plans");
			} else {
				click(AdvertisementsPlansChooseBtn, "AdvertisementsPlansChooseBtn");
				type(selectAdvertisementPlans, advertisementPlan, advertisementPlan);
			}

		}
		if (appliesToMembership.equalsIgnoreCase("yes")) {
			click(membershipPlansBtn, "membership Plans");
			if (allMemberships.equalsIgnoreCase("yes")) {
				click(this.allMemberships, "All Memberships Plans");
			} else {
				click(chooseMemberships, "choose Memberships");
				type(selectMembership, memberShipPlan, memberShipPlan);
			}
		}
		if (appliesToEvents.equalsIgnoreCase("yes")) {
			click(eventsBtn, "events");
			if (allEvents.equalsIgnoreCase("yes")) {
				click(this.allEvents, "All Events");
			} else {
				click(chooseEventsBtn, "choose Events");
				type(this.selectEvent, event, event);
			}
		}		
		click(save,"save");
		waitForElementToPresent(toastMessage);
		Thread.sleep(5000);
		picture();
	}
}

// Promo code info saved.

// public ZohoCRMPage gotoCRM() {
//
// click(crm,"CRM Link");
// return () openPage(.class);
// }
//
// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
