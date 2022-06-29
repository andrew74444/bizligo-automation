package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cpcommunity.utilities.DriverManager;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class AccountSelectPlansPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		updateClass(pageheader, "");

		aShot();

	}

	@FindBy(xpath = "(//*[contains(text(),'Select')])[1]")
	WebElement Select;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement next;
	@FindBy(xpath = "(//*[@ng-click='OnPlanSelected(plan)'])[1]")
			WebElement selectBtn;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
waitForElementToPresent(selectBtn);//added on 27/04
		return ExpectedConditions.visibilityOf(Select);
	}

	@FindBy(xpath = "//*[@type='radio'][@value='1']")
	WebElement payPal;

	@FindBy(xpath = "(//*[@class='fa fa-paypal'])")
	WebElement payPalProceedbtn;

	@FindBy(xpath = "//*[@type='radio'][@value='2']")
	WebElement authorize;

	@FindBy(xpath = "//*[contains(text(),'Pay through Checkout')]")
	WebElement authorizeProccedbtn;

	@FindBy(xpath = "(//*[contains(text(),'Submit')])[1]")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id='confirmationModal']//*[contains(text(),'Ok')]")
	WebElement okBtn;
	public int selectPlan(String plan) throws Exception {

		plan=plan;
		
		
		
		WebElement ele = driver
				.findElement(By.xpath("((((//*[@class='panel panel-warning panel-pricing']//*[contains(text(),'" + plan
						+ "')])/..)/..)/..)//a"));

		click(ele, "Select");
		
		WebElement priceElement =driver.findElement(By.xpath(
				"(((((//*[@class='panel panel-warning panel-pricing']//*[contains(text(),'"+plan+"')])/..)/..)/..)//span)[2]"));
		String price = priceElement.getText().replace("$", "");
		price = price.replace(".00", "");
		int p = stringToInt(price);
//(//*[contains(text(),'Duration')]/..)//*[@ng-bind="CurrentPlanDurationText"]
//		assertEquals(duration, duration.getText());
//		(//*[contains(text(),'Details')]/..)//*[@ng-bind-html="CurrentPlanDetails"]
//				assertEquals(CurrentPlanDetails, CurrentPlanDetails.getText());
		if(p>0) {
		waitForElementToPresent(next);
		scrollToElement(next);
		click(next, "next");
		} else {
			waitForElementToPresent(submit);
			scrollToElement(submit);
		
			click(submit, "submit");
			waitForElementToPresent(okBtn);
			click(okBtn, "Ok");
		}
		return stringToInt(price);
	}

	public AccountSelectPlansPage open(String url) {
		DriverManager.getDriver().navigate()
				.to("https://multi2.ezysubscribe.com/Account/selectplans?Datas=5SC+FOvhhityHefomQGVhQ==");

		return (AccountSelectPlansPage) openPage(AccountSelectPlansPage.class);

	}

	public PayPalPayment paymentByPayPal() {
		click(payPal, "payPal button");
		click(payPalProceedbtn, "Proceed button");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	public AuthorizeGateway paymentByauthorize() throws Exception {
		waitForElementToPresent(authorize);
		click(authorize, "authorize button");
		waitForElementToPresent(authorizeProccedbtn);
		click(authorizeProccedbtn, "Proceed button");
		Thread.sleep(10000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

}
