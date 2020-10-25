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

public class TC152_Paid_Event_Registration_With_Cash_From_Event_CheckIn extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC152(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC152", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage
				.gotoManageCommunity(data.get("communityName")+" "+runTime);
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CheckInPage checkInPage = CommunityEvents.checkIn(data);
		checkInPage.cashPayment(data);
	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC152 Test Completed");

		quit();

	}

}
