package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.cpcommunity.utilities.DriverManager;

public class EcoSystemPage extends BasePage {

	
	@FindBy(xpath = "//*[contains(text(),'My Communities')]")
	WebElement myCommunitiesTab;

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
		
		return ExpectedConditions.visibilityOf(myCommunitiesTab);
	}

	@FindBy(xpath="//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	
	@FindBy(xpath="//a[contains(.,' Dashboard')]")
	WebElement Dashboard;

	public MyDashboardPage goToDashBoardPage() {
	
			click(Toggledropdownmenu,"Toggledropdownmenu");
			waitForElementToPresent(Dashboard);
			click(Dashboard,"Dashboard");		
			return (MyDashboardPage) openPage(MyDashboardPage.class);
//			new MyDashboardPage(driver, );
		}
	

	
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
