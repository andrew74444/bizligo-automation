package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class PaymentReceipt extends BasePage {

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	
	@FindBy(xpath = "//*[contains(text(),'Your Payment processed successfully')] | //*[contains(text(),'Your order processed successfully')] ")
	 WebElement Paymentprocessed;
	
	
	@FindBy(xpath = "//*[contains(text(),'Your advertisement will be sent to the Community Admin for review')]")
	WebElement advertisementSentTOAdminForReview;
	
	
	@FindBy(xpath = "//*[contains(text(),'Your advertisement will be published')]")
	WebElement published;
	
	@FindBy(xpath = "//h4[contains(text(),'Success')]")
	 WebElement Success;
	
	@FindBy(xpath = "//*[contains(text(),'View Community')]")
	WebElement viewCommunity;
	
	@FindBy(xpath = "//*[@class='fa fa-arrow-left'] | //*[@class='fa fa-tv']")
	WebElement advertisementsBtn;
	
	@FindBy(xpath = "(//h4[contains(text(),'Success')]/..)//span")
	WebElement processed;
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Payment Receipt");
		
		return ExpectedConditions.visibilityOf(Success);
	}

	
	@FindBy(xpath="(//*[contains(text(),'This is the payment confirmation')]/..)//span[@ng-bind='data.MembershipPaymentSummary.MembershipPlanName']")
	WebElement planName;
	
	
	
	@FindBy(xpath="((//*[contains(text(),'Plan Description')]/..)//span)[2]//*")
	WebElement planDescription;
	
	@FindBy(xpath="((//*[contains(text(),'License valid upto')])/..)//strong")
	WebElement licenseValidUpto;
	
	@FindBy(xpath="((//*[contains(text(),'Amount Paid')])/..)//strong/span")
	WebElement amountPaid;
	
	public void B2CMemberSignupsuccess(String planName, String endDate, String planDescription, String price) {
		SoftAssert st = new SoftAssert();
		st.assertEquals(processed.getText(), "Your Payment processed successfully");
		st.assertEquals(this.planName.getText(),planName);
		st.assertEquals(this.planDescription.getText(),planDescription);
		if(licenseValidUpto.getText().contains(endDate))
		{
			st.assertTrue(true);
		}else {
			st.assertEquals(licenseValidUpto.getText(), endDate);
		}
		
		String actualAmountPaid = amountPaid.getText();
		actualAmountPaid = actualAmountPaid.replace("$", "");
		actualAmountPaid = actualAmountPaid.replace(".00", "");
		st.assertEquals(actualAmountPaid,price);
		st.assertAll();
		
	}

	
	public void paymentSuccess( ) {
		
		waitForElementToPresent(Success);
		Success.isDisplayed();
		picture();
	}
	
	public CommunityDetailsPage viewCommunity() {
		click(viewCommunity,"View Community");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}
	
	
	public void verifyAdSentToAdminReview()
	{
		waitForElementToPresent(advertisementSentTOAdminForReview);
		picture();
		
	}
	
	
	public void verifyPublishedMessageisDisplayed()
	{
		waitForElementToPresent(published);
		picture();		
	}
	
	public CommunityDetailsPage NavigateToCommunityDetailspage() {
		this.clickOnAdvetismentbutton();	
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}
	
	public void clickOnAdvetismentbutton()
	{
		scrollToElement(advertisementsBtn);
		clickElementByJavaScript(advertisementsBtn);
	}
	
	
	public CommunityDetailsPage goToCommunityDetailspage() {
		this.goToAdvetisments();	
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}
	
	public void goToAdvetisments()
	{
		scrollToElement(advertisementsBtn);
		clickElementByJavaScript(advertisementsBtn);
	}
	
	
	
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
