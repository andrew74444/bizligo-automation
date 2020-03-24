package com.cpcommunity.testScripts.Event_Registrations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.CheckInPage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityEventsPage;
import com.cpcommunity.PageObjects.CreateOrEditEvent;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EventDetailsPage;
import com.cpcommunity.PageObjects.EventTicketPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PayPalPayment;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC151_Paid_Event_Registration_With_Cheque_From_Event_CheckIn extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC151(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC151", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage myCommunitiesPage = myDashboardPage.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage
				.NaviagtetoManageCommunity(data.get("communityName"));
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CheckInPage checkInPage = CommunityEvents.checkIn(data);
		checkInPage.chequePayment(data);

	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC144 Test Completed");

		quit();

	}

}
