package com.cpcommunity.testScripts.Event_Registrations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EventDetailsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC3007_Verify_Member_Able_To_Invite_Member_Or_Non_Member_For_Event extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC3007(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3007", data.get("Runmode"), excel);
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
		eventDetailsPage.inviteMember(data.get("attendeeEmailID"),data.get("attendeeFirstName"),data.get("attendeLastName"));
		
		Yahoo yahoo= new Yahoo().open();
		yahoo.Login(data.get("email"), data.get("password"));
		yahoo.invitation();
	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC3007 Test Completed");

		quit();

	}

}


