package com.cpcommunity.testScripts.MyEvents;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyEventsPage;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2123_Verify_Events_registered_from_other_members_displaying_in_MyEventsPage_for_Registered_member extends BaseTest{
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC2123(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2123", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));		
		UpcomingEventsPage UpcomingEventsPage = EcoSystemPage.navigateToUpComingEvents();
		UpcomingEventsPage.registerToAnEventThroughOtherMember(data.get("UpcomingEvent"),data.get("email1"),data.get("Fname"),data.get("Lname"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
        home1.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage1 = login1.loginToApplication(data.get("email1"), data.get("password1"));
		MyEventsPage MEP=EcoSystemPage1.goToMyEventsPage();
		MEP.registeredEventPresentInMyevents(data.get("UpcomingEvent"));
		
		
	
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC2123 Test Completed");
		
		quit();
}
		
		

}
