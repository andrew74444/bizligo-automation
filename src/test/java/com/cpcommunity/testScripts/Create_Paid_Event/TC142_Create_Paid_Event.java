package com.cpcommunity.testScripts.Create_Paid_Event;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC142_Create_Paid_Event extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC142(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC142", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CreateOrEditEvent CreateOrEditEvent = CommunityEvents.NewEvent();
		CreateOrEditEvent.createEvent(data);
		

	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC142 Test Completed");

		quit();

	}

}
