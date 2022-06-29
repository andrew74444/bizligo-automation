package com.cpcommunity.testScripts.Event_Registrations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC148_Free_Event_Registration_From_Event_Details_Page extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC148(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC148", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		String runTime =openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		UpcomingEventsPage UpcomingEventsPage = EcoSystemPage.goToUpComingEvents();
		EventDetailsPage eventDetailsPage = UpcomingEventsPage.goToEventDetailsPage(data);
		eventDetailsPage.registerEvent(data);
		
		Yahoo yahoo= new Yahoo().open();
		yahoo.Login(data.get("email1"), data.get("password1"));
		yahoo.EventRegsNotification();
	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC148 Test Completed");

		quit();

	}

}
