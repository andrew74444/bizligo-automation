package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SelectPlanPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement next;

	@FindBy(xpath = "//button[@id='pricing_plan_20']")
	WebElement selectPlan;
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement Submit;

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
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Select the Plan Page");
		return ExpectedConditions.visibilityOf(next);
	}

	public void selectAPlan(String planName) throws Exception {

		int T = driver.findElements(By.xpath("//*[@class='col-lg-4 col-sm-4 ng-scope']")).size();
		int j = 1;
		for (int i = 1; i <= T; i++) {

			if (i > 3 && i < T) {

				scrollToElement(driver
						.findElement(By.xpath("((//*[@class='col-lg-4 col-sm-4 ng-scope'])[" + j + "])//button")));
				j++;
			}

			String Name = driver
					.findElement(By.xpath("((//*[@class='col-lg-4 col-sm-4 ng-scope'])[" + i + "])//*[@title]"))
					.getText();
			System.out.println(i);
			if (Name.equalsIgnoreCase(planName)) {
				

				driver.findElement(By.xpath("((//*[@class='col-lg-4 col-sm-4 ng-scope'])[" + i
						+ "])//*[contains(text(),'" + planName + "')]")).isDisplayed();
				driver.findElement(By.xpath("((//*[@class='col-lg-4 col-sm-4 ng-scope'])[" + i + "])//button")).click();
				Thread.sleep(5000);
				break;
			}
		}
	}

	//
	public void selectFreePlan(String planName ) throws Exception {
		this.selectAPlan(planName);

		click(Submit, "Submit button");
		Thread.sleep(5000);
		picture();
	}

	public void selectPaidPlan(String planName) throws Exception {
		this.selectAPlan(planName);
		Thread.sleep(2000);		
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(PAYMENTMETHODS);
		

		
				
	}
	
	public PayPalPayment paymentByPayPal() {
		click(payPal, "payPal button");
		waitForElementToPresent(payPalProceedbtn);
		click(payPalProceedbtn,"Proceed button");		
		return (PayPalPayment) openPage(PayPalPayment.class);
	}
	
	public AuthorizeGateway paymentByauthorize() throws Exception {
		waitForElementToPresent(authorize);
		click(authorize, "authorize button");
		waitForElementToPresent(authorizeProccedbtn);
		click(authorizeProccedbtn,"Proceed button");
		Thread.sleep(10000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}
	

	public void proceedToPayment( )
	{
		waitForElementToPresent(proceedToPaymentGateway);
		click(proceedToPaymentGateway, "Proceed To Payment Gateway");
		picture();
	}
	
	
	//
	// public SelectPlan open(String url) {
	//
	// System.out.println("Page Opened");
	// picture();
	// DriverManager.getDriver().navigate().to(url);
	// picture();
	// return (SelectPlan) openPage(SelectPlan.class);
	// }

	public LoginPage clickOnLOGINBtn() {

		// click(LOGINBtn, "LOGIN");
		return (LoginPage) openPage(LoginPage.class);
		// new LoginPage(driver, );

	}

	public UpcomingEventsPage clickOnupComingEvents() {

		Actions action = new Actions(driver);
		// action.moveToElement(Events).build().perform();
		// waitHelper.waitForElementToPresent(UpcomingEvents,
		// ObjectReader.reader.getExplicitWait());

		// new TestBase().captureScreen(, driver);

		// click(UpcomingEvents, "UpcomingEvents");
		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
		// new UpcomingEventsPage(driver, );
	}

	public GlobalCommunitesPage NavigateToCommunities() {
		// click(ClickHere,"ClickHere");
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// new GlobalCommunitesPage(driver, );
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
