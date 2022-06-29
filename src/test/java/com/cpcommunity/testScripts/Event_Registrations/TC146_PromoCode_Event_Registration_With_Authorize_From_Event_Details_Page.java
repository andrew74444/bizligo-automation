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

public class TC146_PromoCode_Event_Registration_With_Authorize_From_Event_Details_Page extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC146(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC146", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
//		UpcomingEventsPage UpcomingEventsPage = EcoSystemPage.goToUpComingEvents();
//		EventDetailsPage eventDetailsPage =UpcomingEventsPage.goToEventDetailsPage(data);
//		AuthorizeGateway authorizeGateway = eventDetailsPage.registerEventbyAuthorizeNet(data);
//		EventTicketPage eventTicket = authorizeGateway.MakePaymentToEvent();
//		eventTicket.successfulRegistration();


		MyCommunitiesPage MyCommunitiesPage1 = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage1.navigateToCommunityDetailsPage(data.get("communityName"));
		EventsPage event=CommunityDetailsPage.gotoevents();	
		AuthorizeGateway authorizeGateway = event.registerEventbyAuthorizeNetWithPromo(data);
		EventTicketPage eventTicketPage = authorizeGateway.MakePaymentToEvent();
		eventTicketPage.successfulRegistration();
	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC146 Test Completed");

		quit();

	}

}
