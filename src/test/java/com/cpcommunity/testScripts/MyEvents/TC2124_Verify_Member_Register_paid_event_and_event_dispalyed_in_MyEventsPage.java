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

public class TC2124_Verify_Member_Register_paid_event_and_event_dispalyed_in_MyEventsPage extends BaseTest{
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC2124(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2124", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));		
		UpcomingEventsPage UpcomingEventsPage = EcoSystemPage.navigateToUpComingEvents();		
		UpcomingEventsPage.registerToPaidEvent(data.get("UpcomingEvent"),data.get("email"),data.get("Fname"),data.get("Lname"));
		MyEventsPage MEP=UpcomingEventsPage.goToMyEventsPage();
	//	MEP.registeredEventPresentInMyevents(data.get("UpcomingEvent"));
		MEP.searchByEventDate(data.get("Start Date"),data.get("End Date"),data.get("UpcomingEvent"));//added on 12/05
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC2124 Test Completed");
		
		quit();
}

}
