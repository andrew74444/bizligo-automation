package com.cpcommunity.testScripts.Create_Free_Event;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC141_Create_Free_Event extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC141(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC141", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CreateOrEditEvent CreateOrEditEvent = CommunityEvents.NewEvent();
		CreateOrEditEvent.createEvent(data);
	}

	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
