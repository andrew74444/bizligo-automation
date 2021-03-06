package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cpcommunity.ExtentListeners.ExtentListeners;
import com.cpcommunity.ExtentListeners2.ExtentListeners2;
import com.cpcommunity.utilities.DriverManager;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[contains(.,'Login')]")
	WebElement LOGINBtn;

	@FindBy(xpath = "//*[contains(text(),'building communities')]")
	WebElement buildingcommunities;
	@FindBy(xpath = "//a[contains(.,'Upcoming Events')]")
	WebElement UpcomingEvents;

	@FindBy(xpath = "//*[contains(text(),'join communities')]")
	WebElement joinCommunities;
	
	
	
	@FindBy(xpath = "//span[contains(.,'Events')]")
	WebElement Events;

	@FindBy(xpath = "//*[@id='navbar']//*[contains(text(),'Home')]")
	WebElement home;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(home);
	}

	public HomePage NavigateToHome() {
		click(home, "Home");
		return (HomePage) openPage(HomePage.class);
		// new GlobalCareers(driver, );
	}

//	public HomePage open() throws Exception {
//			
//		DriverManager.getDriver().navigate().to("https://multi1.ezysubscribe.com/");
//		
//		
//		return (HomePage) openPage(HomePage.class);
//	}

	
	
	public HomePage open(String tenantType) {
		
		if(tenantType.equalsIgnoreCase("B2B")) {
			
			Markup m = MarkupHelper.createLabel("<b>" + "<font color=" + "White>" + "https://multi1.ezysubscribe.com/" + "</font>" + "</b>", ExtentColor.GREEN);
			ExtentListeners2.testReport.get().info(m);
			
			DriverManager.getDriver().navigate().to("https://multi1.ezysubscribe.com/");
		}
		else if(tenantType.equalsIgnoreCase("B2C")) {
			
			
			Markup m = MarkupHelper.createLabel("<b>" + "<font color=" + "White>" + "https://multi2.ezysubscribe.com/" + "</font>" + "</b>", ExtentColor.GREEN);
			ExtentListeners2.testReport.get().info(m);
			
			
			DriverManager.getDriver().navigate().to("https://multi2.ezysubscribe.com/");
			
		}
		

		
		
		
		
		return (HomePage) openPage(HomePage.class);
	}
	
	public LoginPage clickOnLOGINBtn() throws Exception {
		
		waitForElementToPresent(LOGINBtn);
		Thread.sleep(1000);
		click(LOGINBtn, "LOGIN");
		return (LoginPage) openPage(LoginPage.class);
		// new LoginPage(driver, );

	}

	public UpcomingEventsPage clickOnupComingEvents() {

		Actions action = new Actions(driver);
		action.moveToElement(Events).build().perform();
		// waitHelper.waitForElementToPresent(UpcomingEvents,
		// ObjectReader.reader.getExplicitWait());
		aShot();
		// new TestBase().captureScreen(, driver);

		click(UpcomingEvents, "UpcomingEvents");
		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
		// new UpcomingEventsPage(driver, );
	}

	public GlobalCommunitesPage NavigateToCommunities() throws Exception {
		Thread.sleep(5000);
		click(joinCommunities, "join Communities");
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class,"Global
		// Communites Page");
		// new GlobalCommunitesPage(driver, );
	}

	@FindBy(xpath = "//*[@id='header']")
	WebElement header;
	@FindBy(xpath = "//*[@class='bx-viewport']")
	WebElement ad;	
	

	public void verifyAdImage(String expectedImgFileName) throws Exception {

		Thread.sleep(5000);
		updateClass(header,"");
		scrollToElement(buildingcommunities);
		takeScreenshotByShutterBug(ad, "HomePageAd");
		Imagediff.check(expectedImgFileName, "\\screenshots\\HomePageAd.png");

	}


	public HomePage superAdminHomePageOpen() throws Exception {
		DriverManager.getDriver().navigate().to("https://admin.ezysubscribe.com/");
		
		
		return (HomePage) openPage(HomePage.class);
	}



	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
