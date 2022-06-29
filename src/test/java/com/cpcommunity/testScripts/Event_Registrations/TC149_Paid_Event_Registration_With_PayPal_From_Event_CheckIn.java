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

public class TC149_Paid_Event_Registration_With_PayPal_From_Event_CheckIn extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC149(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC149", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage
				.gotoManageCommunity(data.get("communityName"));//+" "+runTime
		CommunityEventsPage CommunityEvents = communityDashboardPage.navigateToEvents();
		CheckInPage checkInPage = CommunityEvents.checkIn(data);
		PayPalPayment payPalPayment = checkInPage.registerEventByPayPal(data);
		EventTicketPage eventTicketPage = payPalPayment.MakePayment();
		eventTicketPage.successfulRegistration();
	}

	@AfterMethod
	public void tearDown() {
//
		logInfo("TC149 Test Completed");
//
		quit();

	}

}
