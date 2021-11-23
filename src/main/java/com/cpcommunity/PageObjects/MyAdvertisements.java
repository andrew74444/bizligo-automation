
package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;


public class MyAdvertisements extends BasePage {

	@FindBy(xpath = "//h3[normalize-space()='My Advertisements']")
	WebElement title;
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement createGlobalAd;
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement next;
	@FindBy(xpath = "//label[@class='glyphicon glyphicon-info-sign']")
	WebElement information;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement noAds;
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement adname;
	@FindBy(xpath = "//tbody//tr[2]//td[@class='day'][7]")
	WebElement dateselect;
	@FindBy(xpath = "//div[@class='datetimepicker-days']//th[@class='next']")
	WebElement nextMonth;
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement choosefile;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//input[@id='PlanNameSearch']")
	WebElement searchPlan;
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement inactiveerror;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement ok;
	@FindBy(xpath = "//button[normalize-space()='Proceed to Payment']")
	WebElement proceedTopayment;
	@FindBy(css = "input[value='2'][name='selectedPaymentMethod']")
	WebElement Authorised;
	@FindBy(xpath = "//button[@ng-click=\"OnPaymentSubmitBtnClick($event,'')\"]")
	WebElement proceed;
	@FindBy(xpath= "//ng-repeat[2]//div[1]//div[1]//div[1]//div[3]//a[1]")
	WebElement selectGold2;
	@FindBy(xpath="//input[@id='PlanNameSearch']")
	WebElement plansearch;
	@FindBy(xpath="//a[@title='Click to edit this page']")
	WebElement edit;
	@FindBy(xpath="//a[@title='Click to purchase this Advertisement']")
	WebElement editp;
	@FindBy(xpath="//tr[@class='odd']//a[@title='Click to purchase this Advertisement']")
	WebElement editO;
	@FindBy(xpath="//tr[@class='even']//a[@title='Click to purchase this Advertisement']")
	WebElement editE;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastemessage;
	@FindBy(xpath="//div[9]//div[1]//label[1]//span[1]")
	WebElement status;
	@FindBy(xpath = "//span[@id='inbox-id']")
	WebElement boxId;
	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement emailName;
	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement setBtn;
	@FindBy(xpath = "//select[@id='ApprovalStatusText']")
	WebElement searchbyStatus;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		log.info("---> MyAdvertisements");
		return ExpectedConditions.visibilityOf(title);
	}

	public AdvertismentPurchasePage createAd() {
		click(createGlobalAd,"createGlobalAd");
		return(AdvertismentPurchasePage) openPage(AdvertismentPurchasePage.class);
	}
	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement pageheader;
	@FindBy(xpath = "//tr[@class='odd']//a[@title='Click to purchase this Advertisement']")
	WebElement editPP;

	//@FindBy(xpath = "//a[@title='Click to purchase this Advertisement']")
	//WebElement editt;
	@FindBy(xpath = "//span[@title='This Advertisement plan is In-Activated.']")
	WebElement editinactive;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/span[1]")
	WebElement editt1;

	
	@FindBy(xpath = "//div[@class='well well-sm']//div[@class='col-sm-12']")
	WebElement allplan;
	
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")//
	WebElement  adStartDatecalendar;
	
	@FindBy(xpath = "//a[@class='btn btn-default top-btn1 btn-sm dropdown-toggle']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	
	@FindBy(xpath = "//div[@class='row text-center my-eco-page']//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//button[2]")
	WebElement MANAGE;
	
	@FindBy(xpath = "//input[@id='DisplayStartDate']")
	WebElement adStartDate;
	
	@FindBy(xpath = "//*[@name='DisplayEndDate']")
	WebElement adEndDate;
	
	@FindBy(xpath = "//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[4]/td[7]")
	WebElement  enddate;

	@FindBy(xpath = "//body/div[3]")
	WebElement  adEndDatecalendar;
	
	@FindBy(xpath="//tr[@class='odd']//span[@title='For this plan payment is pending'][normalize-space()='PAYMENT PENDING']")
	WebElement inactivestatus ;
	
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	public void NonCommunityMemberCannotSeeAds() throws InterruptedException {
		waitForElementToPresent(information);
	Thread.sleep(1000);
		click(information, "Non Member Information");
		AssertionHelper.verifyText(information.getText(), "To Post Advertisements in Community, go to respective community page");
		System.out.println("To Post Advertisements in Community, go to respective community page");
		
	}
	
	  public void editPlanCreatedByTACA(String plan) throws InterruptedException {
		  Thread.sleep(4000);
		   waitForElementToPresent(plansearch);
		   type(plansearch, plan, "Plan Name");
		   click(search, "Search");
		   Thread.sleep(4000);
		   waitForElementToPresent(edit);
		   click(edit, "Edit");
		   scrollDownVertically();
		   click(status, "status");
		   Thread.sleep(1000);
		   click(save, "Save");
		   AssertionHelper.verifyText(toastemessage.getText(), "Advertisement plan details saved.");
			Thread.sleep(2000);

		  // 
	   }

	public UpdateADPage gotoUpdateAdpage(String planName) throws InterruptedException {

		//Thread.sleep(2000);
		 //waitForElementToPresent(plansearch);
		  // type(plansearch, planName, "Plan Name");
		   //click(search, "Search");
		   Thread.sleep(4000);
		waitForElementToPresent(editPP);
		click(editPP, "Edit");
		Thread.sleep(5000);
		return (UpdateADPage) openPage(UpdateADPage.class);

	}

	

	
	
	public void checkInactivePlanNotDisplay() {
		waitForElementToPresent(allplan);
		String plan= this.allplan.getText();
		String inactive="Inactive";
		Assert.assertNotSame(plan, inactive, "Inactive plan are not displaying");
		
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
	
	public void createGlobalAd( String planName,String AdName, String path) throws Exception {
		Thread.sleep(2000);
		 waitForElementToPresent(plansearch);
		   type(plansearch, planName, "Plan Name");
		   click(search, "Search");
		   Thread.sleep(6000);
		   waitForElementToPresent(edit);
		   click(edit, "Edit");
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(1000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		//waitForElementToPresent(dateselect);
		click(dateselect, "Date 17 july");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(save, "Save");
		
	}
	public void createAd( String planName,String AdName, String path) throws Exception {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		  click(createGlobalAd, "Creat global Ad");
		picture();
		waitForElementToPresent(selectGold2);
		 clickElementByJavaScript(selectGold2);
		 driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);		
			click(next, "Next button");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			picture();
			waitForElementToPresent(adname);
			type(adname, AdName, "Advertisement name");
			click(date, "Select Date");
			waitForElementToPresent(adStartDatecalendar);
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			click(nextMonth, "Next");
			click(nextMonth, "Next");
			waitForElementToPresent(dateselect);
			click(dateselect, "Date");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			//click(this.adEndDate, "Ad End Date");
			//Thread.sleep(1000);
			type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(save, "Save");
		Thread.sleep(12000);
		
	}
	public void createGlobalAd2( String planName,String AdName, String path) throws Exception {
		Thread.sleep(2000);
		 waitForElementToPresent(plansearch);
		   type(plansearch, planName, "Plan Name");
		   click(search, "Search");
		   Thread.sleep(8000);
		   waitForElementToPresent(editp);
		   click(editp, "Edit");
		   Thread.sleep(4000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(1000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		//waitForElementToPresent(dateselect);
		click(dateselect, "Date ");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(save, "Save");
		
	}
	public void createGlobalAd1( String planName,String AdName, String path) throws Exception {
		Thread.sleep(2000);
		 waitForElementToPresent(plansearch);
		   type(plansearch, planName, "Plan Name");
		   click(search, "Search");
		   Thread.sleep(9000);
		   waitForElementToPresent(editp);
		   click(editp, "Edit");
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		//waitForElementToPresent(dateselect);
		click(dateselect, "Date ");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		Actions act = new Actions(driver);
		//Double click on element
		WebElement ele = save; 
		act.doubleClick(ele).perform();
		//click(save, "Save");
		System.out.println("Duplicate Detail; not Displaying");
		
	}
	public void openGuerillamail(String emailName) throws InterruptedException, AWTException {
		// Thread.sleep(5000);
	     //((JavascriptExecutor)driver).executeScript("window.open()");
	    // Thread.sleep(2500);
	    // ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
	     //driver.switchTo().window(wins.get(1));
	     driver.get("https://www.guerrillamail.com/");
	     Thread.sleep(5000);
	     click(boxId,"BoxID");
	     Thread.sleep(5000);
	     this.emailName.clear();
	     Thread.sleep(2000);
	     type(this.emailName, emailName, "emailName");
	     Thread.sleep(5000);
	     click(setBtn,"set Button");
	     Thread.sleep(180000);
	     Actions ac = new Actions(driver);
	     ac.contextClick().build().perform();
	     Thread.sleep(5000);
	     Robot r = new Robot();
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_ENTER);
	    // Thread.sleep(1000);
	    // click(emailVerify,"passwordVerify");
	   //  Thread.sleep(1500);
	    // String password = passWord.getText();
	   //  Thread.sleep(2000);
	    // ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
	    // driver.switchTo().window(wins1.get(0));
	     Thread.sleep(8000);
	 }
	
	public AuthorizeGateway createPaidGlobalAd(String planName, String AdName, String path) throws Exception {
		this.createGlobalAd.click();
        Thread.sleep(2000);
		//this.selectAPlan(planName);
          clickElementByJavaScript(selectGold2);
        //click(selectGold2, "Gold2");	
		click(next, "Next button");
		Thread.sleep(5000);
		picture();
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		Thread.sleep(1000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date 17 july");
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
	
	public void searchplan(String planName1) throws InterruptedException {
		Thread.sleep(3000);
		scrollUpVertically();
		waitForElementToPresent(searchPlan);

		//click(searchPlan, "Search Plan");
		type(searchPlan, planName1, "Plan Name");
		click(search, "Search");
		Thread.sleep(7000);
		
	}
	public void searchinactiveplan(String planName1) throws InterruptedException {
		Thread.sleep(3000);
		scrollUpVertically();
		waitForElementToPresent(searchPlan);
		click(searchPlan, "Search Plan");
		type(searchPlan, planName1, "Plan Name");
		selectUsingIndex(searchbyStatus, 5, "Select Inactive ");

		click(searchPlan, "Search Plan");
		type(searchPlan, planName1, "Plan Name");

		click(search, "Search");
		Thread.sleep(4000);
		
	}
	public void checkplanstatus() throws InterruptedException {
		Thread.sleep(6000);
		this.inactivestatus.isDisplayed();
		String status=inactivestatus.getText();
		System.out.println(status);
		
	}
	

	public void checkerrorMsg() {
		
		waitForElementToPresent(editinactive);
		click(editinactive, "Edit");
		waitForElementToPresent(inactiveerror);
		System.out.print(inactiveerror);
		click(ok, "OK");
	}

	public void checkIsplanInactive() {
		
		waitForElementToPresent(edit);
		click(edit, "Edit");
		waitForElementToPresent(inactiveerror);
		System.out.print(inactiveerror);
		click(ok, "OK");
	
	}
  
	public MyDashboardPage gotoMyDashboardPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
	
		waitForElementToPresent(ecosystem);
		click(ecosystem,"DashBoard");
		driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
		return (MyDashboardPage) openPage(MyDashboardPage.class);
	
	}
	
		
}


