   
package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
	
	@FindBy(xpath = "(//*[contains(text(),'advertise your business')])[1]")
	WebElement Business;

	@FindBy(xpath = "//*[contains(text(),'building communities')]")
	WebElement buildingcommunities;
	@FindBy(xpath = "//a[contains(.,'Upcoming Events')]")
	WebElement UpcomingEvents;

	@FindBy(xpath = "//*[contains(text(),'join communities')]")
	WebElement joinCommunities;
	
	@FindBy(xpath = "//span[contains(.,'Events')]")
	WebElement Events;


	@FindBy(xpath = "//h1[normalize-space()='building communities']")

	WebElement home;
	
	@FindBy(xpath = "//span[normalize-space()='Directory']")
	WebElement directory;
	
	@FindBy(xpath = "//a[normalize-space()='Member Directory']")
	WebElement memberDirectory;
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//a[normalize-space()='Global Communities']")
	WebElement GlobalCommunities;
	
	@FindBy(xpath = "//a[normalize-space()='Careers']")
	WebElement careers;
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement toggleDropDown;

	@FindBy(xpath = "//a[normalize-space()='Tenant Admin Module']")
	WebElement tenantadminModule;


	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	WebElement contactUs;
	@FindBy(xpath = "//h2[normalize-space()='Feature Not Available']")
	WebElement featureNotAvailable;
	@FindBy(xpath="//span[contains(text(),'Global Events')]")
	WebElement globalEvents;
	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]")
	WebElement upcomingEvents;
	@FindBy(xpath="//a[normalize-space()='Blogs']")
	WebElement blogs;
	@FindBy(xpath="//div[@class='inner_right']//h4[@ng-hide='IsEM']//a[normalize-space()='advertise your business']")
	WebElement advertiseBussiness;
	@FindBy(xpath="//a[normalize-space()='Menu']")
	WebElement menu;
	@FindBy(xpath="//a[normalize-space()='Contact']")
	WebElement contact;
	@FindBy(xpath="//li[@class='ng-scope']//span[@ng-show='ad.LinkUrl']//img[@class='img-responsive']")
	WebElement image;



	
	
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
	public ContactUsPage NavigateToContactUsPage() {
		click(contactUs, "Contact Us");
		return (ContactUsPage) openPage(ContactUsPage.class);
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
			
			Markup m = MarkupHelper.createLabel("<b>" + "<font color=" + "White>" + "https://tenant1.bizligotest.com/"+ "</font>" + "</b>", ExtentColor.GREEN);
			ExtentListeners2.testReport.get().info(m);
			
			DriverManager.getDriver().navigate().to("https://tenant1.bizligotest.com/");
		}
		else if(tenantType.equalsIgnoreCase("B2C")) {
			
			
			Markup m = MarkupHelper.createLabel("<b>" + "<font color=" + "White>" + "https://tenant2.bizligotest.com/"+ "</font>" + "</b>", ExtentColor.GREEN);
			ExtentListeners2.testReport.get().info(m);
			
			
			DriverManager.getDriver().navigate().to("https://tenant2.bizligotest.com/");
			
		}	
		
		return (HomePage) openPage(HomePage.class);
	}
	
	public LoginPage clickOnLOGINBtn() throws Exception {
		
		waitForElementToPresent(LOGINBtn);
		
		click(LOGINBtn, "LOGIN");
		return (LoginPage) openPage(LoginPage.class);
		// new LoginPage(driver, );

	}
	public HomePage logout() {
		toggleDropDown.click();
		logoutBtn.click();
		return (HomePage) openPage(HomePage.class);
		
	}

	public TenantAdminDashboardPage gotoTAdashbord() {
		toggleDropDown.click();
		tenantadminModule.click();
		return (TenantAdminDashboardPage) openPage(TenantAdminDashboardPage.class);
		
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
	public GlobalCareers NavigateToCareers() throws Exception {
		Thread.sleep(1000);
		click(careers, "careers");
		return (GlobalCareers) openPage(GlobalCareers.class);
	
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
	public TenantAdminDashboardPage gotoTenantAdminDashboardPage() throws Exception {
		waitForElementToPresent(toggleDropDown);
		click(toggleDropDown, "Toggle drop down");
		Thread.sleep(1000);
        click(tenantadminModule, "tenantadminModule");		
		return (TenantAdminDashboardPage) openPage(TenantAdminDashboardPage.class);
	}

  public SelectPlanPage Createadvertise() {
	  
	  waitForElementToPresent(advertiseBussiness);
		click(advertiseBussiness, "advertise your Bussiness");
	  return (SelectPlanPage) openPage(SelectPlanPage.class); 
  }
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
public MemberDirectoryPage goToMemberDirectory() throws InterruptedException {
		
		//click(directory,"directory");
		Thread.sleep(3000);
		moveToElement(directory);
		click(memberDirectory,"member directory");
		//click(memberDirectory,"member directory");
		Thread.sleep(3000);
		return (MemberDirectoryPage) openPage(MemberDirectoryPage.class);
		
	}
public GlobalCommunitesPage NavigateToGlobalCommunities() throws Exception {
	Thread.sleep(5000);
	click(GlobalCommunities, "Global Communities");
	Thread.sleep(3000);
	return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
	
}
public void verifyContactPageWhenSuperAdminDisable() {
	click(contactUs, "Contact Us");
	if(featureNotAvailable.isDisplayed()) {
		Assert.assertTrue(true);
		System.out.println("Contact Us Feature not available when Super Admin Disable it");
	}else Assert.assertTrue(false);
	
}
public UpcomingEventsPage navigateToUpComingEvents() throws InterruptedException {
	clickElementByJavaScript(globalEvents);
	Thread.sleep(2000);
	waitForElementToPresent(upcomingEvents);
	click(upcomingEvents, "Upcoming Events");
	return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
	// new UpcomingEventsPage(driver, );
}

    public LoginPage advertiseBusiness() throws Exception {
	
	waitForElementToPresent(advertiseBussiness);
	click(advertiseBussiness, "advertise your Bussiness");
	return (LoginPage) openPage(LoginPage.class);
	// new LoginPage(driver, );

   }
        public void Checkadvertisebutton() throws InterruptedException {
        	 Thread.sleep(2000);
		System.out.println("Advertisement link is not working");
			
		}
        public void CheckadvertiseNotDisplay() throws InterruptedException {
       	 Thread.sleep(2000);
       	 String img=image.getTagName();
		System.out.println(img);
			
		}
         public void checkAllPages() throws InterruptedException {
        	 Thread.sleep(3000);
        	 this.contact.isDisplayed();
        		clickElementByJavaScript(blogs);
        		Thread.sleep(4000);
        		this.contact.isDisplayed();
        		Assert.assertTrue(true);
        		click(GlobalCommunities, "Global Communities");
        		this.contact.isDisplayed();
        		Assert.assertTrue(true);
        	}
         public void blogSubmenu() {
        	 Actions actions = new Actions(driver);
        	 actions.moveToElement(blogs);

        	// Locating the element from Sub Menu
        	WebElement subMenu = driver.findElement(By.xpath("//a[normalize-space()='subMenu']"));
      String menu=subMenu.getText();
        	//To mouseover on sub menu
        	actions.moveToElement(subMenu);
        	System.out.println(menu);
         }
         public void gotomenu() {
        	 clickElementByJavaScript(menu);
        	 
         }
}
