package com.cpcommunity.testScripts.Event_Registrations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;


public class TC153_Free_Event_Registration_From_Event_CheckIn extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC153(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC153", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CheckInPage checkInPage = CommunityEvents.checkIn(data);
		checkInPage.registerFreeEvent(data);
	}

	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
