package com.cpcommunity.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

import junit.framework.Assert;


public class SelectPlanPage extends BasePage {

	@FindBy(xpath = "//button[normalize-space()='Next']")
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
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "(//button[@type='submit'])[1] | (//button[@type='submit'])[2]")
	WebElement proceedToPaymentGateway;
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//input[@id='DisplayStartDate']")
	WebElement adStartDate;
	
	@FindBy(xpath = "//*[@name='DisplayEndDate']")
	WebElement adEndDate;
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")//
	WebElement  adStartDatecalendar;
	@FindBy(xpath = "//body[1]/div[2]/div[3]/table[1]/tbody[1]/tr[4]/td[2]")
	WebElement  date1;
	@FindBy(xpath = "//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[4]/td[7]")
	WebElement  enddate;
	@FindBy(xpath = "//body/div[3]")
	WebElement  adEndDatecalendar;
	@FindBy(xpath = "//button[normalize-space()='Proceed to Payment']")
	WebElement proceedTopayment;
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement adname;
	@FindBy(xpath = "//tbody//tr[3]//td[@class='day'][6]")
	WebElement dateselect;
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement choosefile;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath= "//ng-repeat[2]//div[1]//div[1]//div[1]//div[3]//a[1]")
	WebElement selectGold2;
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement createGlobalAd;
	@FindBy(xpath = "//input[@value='2']")
	WebElement Authorised;
	@FindBy(xpath = "//button[@ng-click=\"OnPaymentSubmitBtnClick($event,'')\"]")
	WebElement proceed;
	@FindBy(xpath = "//a[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//div[@class='datetimepicker-days']//th[@class='next']")
	WebElement nextMonth;
	@FindBy(xpath = "//*[@ng-repeat='promotionPlan in PromotionPlans']")
	List<WebElement> Selectpanels;
	@FindBy(xpath = "//ng-repeat//div[1]//div[1]//div[1]//div[1]//h3[1]")
	List<WebElement> plansName;
	
	
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
	
	public void selectBPlan(String planName) throws Exception {

		int T = this.Selectpanels.size();
		planName=planName+ "" + getDateInDDMMMYYYY();
		int j = 1;
		int V = driver.findElements(By.xpath("//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@class='purchasepage']/div[@id='PurchasePromotionsController']/div[@class='reg_cont']/div[@class='row']/div[@id='msform']/fieldset[@class='ng-pristine ng-valid']/div[@ng-show='PromotionPlans.length']/div[@class='row']/ng-repeat/div[1]")).size();
		for (int i = 1; i <= V; i++) {
			System.out.println(i);
			
			if (i > 3 && i <= V) {
          
				scrollToElement(driver
						.findElement(By.xpath("//ng-repeat[" + j + "]//div[1]//div[1]//div[1]//div[3]//a[1]")));
				j++;
			
		     String Name = driver.findElement(By.xpath("//ng-repeat[" + i + "]//div[1]//div[1]//div[1]//div[1]//h3")).getText();
			System.out.println(Name);
			if(Name.matches(planName)) {
			//if (Name.equalsIgnoreCase(planName)) {			
				driver.findElement(By.xpath("//*//ng-repeat[" + i + "]//div[1]//div[1]//div[1]//div[3]//a[1]")).click();
				Thread.sleep(5000);
				System.out.println("plan selected");
			}
			}
		}
	}
	
	public void PlanNotDisplaying(String planName) throws Exception {
		int T = this.Selectpanels.size();
		planName=planName+ "" + getDateInDDMMMYYYY();
		int j = 1;
		int V = driver.findElements(By.xpath("//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@class='purchasepage']/div[@id='PurchasePromotionsController']/div[@class='reg_cont']/div[@class='row']/div[@id='msform']/fieldset[@class='ng-pristine ng-valid']/div[@ng-show='PromotionPlans.length']/div[@class='row']/ng-repeat/div[1]")).size();
		for (int i = 1; i <= V; i++) {
			System.out.println(i);
			if (i > 0 && i < T) {

				scrollToElement(driver
						.findElement(By.xpath("//ng-repeat[" + j + "]//div[1]//div[1]//div[1]//div[3]//a[1]")));
				j++;
				
				String Name = driver.findElement(By.xpath("//ng-repeat[" + i + "]//div[1]//div[1]//div[1]//div[1]//h3")).getText();
				System.out.println(Name);
				
				Assert.assertNotSame( planName, Name);
				
			   }	
			}
		System.out.println(" " + planName +" is not present.");
		}
	

	//
	private void selectStartAndEndDates() throws Exception {
		click(this.adStartDate, "Ad Start Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(1000);
		click(date, "Date");
		DateManager d = new DateManager(driver);
		String date = d.getCurrentDateString();
	    d.selectDate("TableName",date);
		Thread.sleep(1000);
		
		click(this.adEndDate, "Ad End Date");
		waitForElementToPresent(adEndDatecalendar);
		Thread.sleep(1000);
		click(enddate, "EndDate");
		String selectDate=String.valueOf(d.getCurrentDate()+1);
		d.selectDate("((//*[@class='datetimepicker-days'])[2])",selectDate);
	}
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
		
		//waitForElementToPresent(PAYMENTMETHODS);
		
	}
	
	public AuthorizeGateway selectPlan(String planName, String AdName, String path ) throws Exception {
		//this.createGlobalAd.click();
        Thread.sleep(2000);
		//this.selectAPlan(planName);
          clickElementByJavaScript(selectGold2);
        Thread.sleep(3000);		
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(2000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
		//click(this.adEndDate, "Ad End Date");
		//waitForElementToPresent(adEndDatecalendar);
		//Thread.sleep(1000);
		//click(enddate, "EndDate");
		Thread.sleep(4000);
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(proceedTopayment, "Proceed To Payment");
		waitForElementToPresent(Authorised);
		click(Authorised, "Authorised.Net");
	    waitForElementToPresent(proceed);
		click(proceed, "Proceed");
		Thread.sleep(4000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}
	public AuthorizeGateway selectTenantPlan( String AdName, String path ) throws Exception {
		//this.createGlobalAd.click();
        Thread.sleep(2000);
		//this.selectAPlan(planName);
          //clickElementByJavaScript(selectGold2);
        Thread.sleep(3000);		
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(2000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
		//click(this.adEndDate, "Ad End Date");
		//waitForElementToPresent(adEndDatecalendar);
		//Thread.sleep(1000);
		//click(enddate, "EndDate");
		Thread.sleep(4000);
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(proceedTopayment, "Proceed To Payment");
		waitForElementToPresent(Authorised);
		click(Authorised, "Authorised.Net");
	    waitForElementToPresent(proceed);
		click(proceed, "Proceed");
		Thread.sleep(4000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}
	
	public AuthorizeGateway TenantPlan(String planName, String AdName, String path ) throws Exception {
		//this.createGlobalAd.click();
        Thread.sleep(2000);
		//this.selectAPlan(planName);
          clickElementByJavaScript(selectGold2);
        Thread.sleep(5000);		
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(2000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
		//click(this.adEndDate, "Ad End Date");
		//waitForElementToPresent(adEndDatecalendar);
		//Thread.sleep(1000);
		//click(enddate, "EndDate");
		Thread.sleep(4000);
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(proceedTopayment, "Proceed To Payment");
		waitForElementToPresent(Authorised);
		click(Authorised, "Authorised.Net");
	    waitForElementToPresent(proceed);
		click(proceed, "Proceed");
		Thread.sleep(5000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}
	
	public AuthorizeGateway selectPlan1(String planName, String AdName, String path ) throws Exception {
		//this.createGlobalAd.click();
        Thread.sleep(4000);
		//this.selectAPlan(planName);
          clickElementByJavaScript(selectGold2);
        Thread.sleep(5000);		
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(2000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
		//click(this.adEndDate, "Ad End Date");
		//waitForElementToPresent(adEndDatecalendar);
		//Thread.sleep(1000);
		//click(enddate, "EndDate");
		Thread.sleep(4000);
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(proceedTopayment, "Proceed To Payment");
		waitForElementToPresent(Authorised);
		click(Authorised, "Authorised.Net");
		Thread.sleep(2000);
	    waitForElementToPresent(proceed);
		click(proceed, "Proceed");
		Thread.sleep(4000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
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
	
	public void checkNextbtnError() throws InterruptedException {
		Thread.sleep(2000);
		scrollDownVertically();
		click(next, "Next btn");
		click(next, "Next btn");
		AssertionHelper.verifyText(toastMessage.getText(), "Please select a plan.");
		Thread.sleep(4000);
	

		System.out.println("Multiple error Not Displaying when double clicking Next Button");
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

		// new TestBase().captureScreen(, driver)

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
