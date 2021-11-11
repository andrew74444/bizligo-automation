package com.cpcommunity.testScripts.configureAttendees;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityEventsPage;
import com.cpcommunity.PageObjects.CreateOrEditEvent;
import com.cpcommunity.PageObjects.EventsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1309_verify_AttendeesDetail_Not_displaying_ifNot_selectingOption_whileCreating extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1309(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1309", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageCommunitiesPage MC=tadashoboard.navigatetomanageCommunities();
	MC.searchCommunity(data.get("Community"));
	CommunityEventsPage CEP=MC.clickcommunity();
	CreateOrEditEvent CEE=CEP.NewEvent();
	CEE.AddDetails(data.get("EventTitle"), data.get("EventCategory"),data.get("location"), data.get("Description"));
    CEE.AddTickets(data.get("ticketName"), data.get("ticketquantity"));
    CEE.AddField1(data.get("Label"), data.get("order"),data.get("type"));
    CEE.publish();
    HomePage home1=CEE.gotohome();
    UpcomingEventsPage event=home1.clickOnupComingEvents();
	event.searchevent(data.get("EventTitle"));
	event.AttendeesDetailNotDisplaying();
	
	
	}
	@AfterMethod
	public void tearDown() {

		logInfo("TC1309 Test Completed");

		quit();

	}
    
}
