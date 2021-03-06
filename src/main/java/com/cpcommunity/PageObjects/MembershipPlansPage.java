package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class MembershipPlansPage extends BasePage {
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@FindBy(xpath = "//*[contains(text(),'MEMBERSHIP PLANS')]")
	WebElement membershipPlansTitle;

	@FindBy(xpath = "//*[contains(text(),'SELECT PAYMENT METHODS')]")
	WebElement PAYMENTMETHODS;

	@FindBy(xpath = "//*[@value='1']")
	WebElement payPal;

	@FindBy(xpath = "(//*[@class='fa fa-paypal'])")
	WebElement payPalProceedbtn;

	@FindBy(xpath = "//*[@value='2']")
	WebElement authorize;

	@FindBy(xpath = "//*[@type='submit']//*[@class='fa fa-credit-card']")
	WebElement authorizeProccedbtn;

	@FindBy(xpath = "(//button[@type='submit'])[1] | (//button[@type='submit'])[2]")
	WebElement proceedToPaymentGateway;

	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement Next;

	@FindBy(xpath = "(((((//*[@class='features-popup membership-plan ng-scope main-plan-cont'])[1])//*[@class='pop-icon-card'])[2]))//*[@class='pop-feature-icon-green fa fa-bullhorn fa-3x']")
	WebElement advertisementEnable;


	@FindBy(xpath="//*[contains(text(),'RENEW')]")
	WebElement renew;
	
	
	public void renewThePurchasedMembershipPlan() throws Exception
	{
		click(renew,"selecting the same Plan");
		Thread.sleep(3000);
		click(Next,"Next");
		Thread.sleep(2000);
	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Membership Plans Page");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExpectedConditions.visibilityOf(membershipPlansTitle);
	}

	public void selectMemberShipPlan(String membershipPlan) throws Exception {
		int t = driver.findElements(By.xpath("//*[@class='pop-plan-title ng-binding']")).size();
		for (int i = 1; i <= t; i++) {
			String Name = driver.findElement(By.xpath("(//*[@class='pop-plan-title ng-binding'])[" + i + "]"))
					.getText();
			if (Name.contains(membershipPlan)) {
				WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'SELECT')])[" + i + "]"));

				if (membershipPlan.contains("Advertisements")) {
					WebElement ele1 = driver.findElement(
							By.xpath("(((((//*[@class='features-popup membership-plan ng-scope main-plan-cont'])[" + i
									+ "])//*[@class='pop-icon-card'])[2]))//*[@class='pop-feature-icon-green fa fa-bullhorn fa-3x']"));
					ele1.isDisplayed();
				}
				if (membershipPlan.contains("Groups")) {
					WebElement ele1 = driver.findElement(By.xpath("(((((//*[@class='features-popup membership-plan ng-scope main-plan-cont'])["+i+"])//*[@class='pop-icon-card'])[2]))//*[@class='pop-feature-icon-green fa fa-users fa-3x']"));
					ele1.isDisplayed();
				}
				
				if (membershipPlan.contains("Carrers")) {
					WebElement ele1 = driver.findElement(By.xpath("(((((//*[@class='features-popup membership-plan ng-scope main-plan-cont'])["+i+"])//*[@class='pop-icon-card'])[2]))//*[@class='pop-feature-icon-green fa fa-briefcase fa-3x']"));
					ele1.isDisplayed();
				}
				
				click(ele, "Select button");
				Thread.sleep(4000);
				break;
			}
		}

	}

	public void purchaseMembershipPlan(String membershipPlan) throws Exception {
		this.selectMemberShipPlan(membershipPlan);
		
		click(Next, "Next");
	}

	public PayPalPayment paymentByPayPal() {
		waitForElementToPresent(payPal);
		click(payPal, "payPal button");
		click(payPalProceedbtn, "Proceed button");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	public AuthorizeGateway paymentByauthorize() throws Exception {
		waitForElementToPresent(authorize);
		click(authorize, "authorize button");
		click(authorizeProccedbtn, "Proceed button");
		Thread.sleep(10000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

	public void proceedToPayment() {
		waitForElementToPresent(proceedToPaymentGateway);
		click(proceedToPaymentGateway, "Proceed To Payment Gateway");
		picture();
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
