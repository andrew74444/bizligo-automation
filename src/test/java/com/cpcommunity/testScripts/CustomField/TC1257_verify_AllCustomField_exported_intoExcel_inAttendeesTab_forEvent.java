package com.cpcommunity.testScripts.CustomField;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityEventsPage;
import com.cpcommunity.PageObjects.CreateOrEditEvent;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1257_verify_AllCustomField_exported_intoExcel_inAttendeesTab_forEvent extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1257(Hashtable<String,String> data) throws Exception {
	
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1257", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	CommunityEventsPage commevent=communityDashboard.navigateToEvents();
	CreateOrEditEvent CEE=commevent.NewEvent();
	CEE.AddDetails(data.get("EventTitle"), data.get("EventCategory"),data.get("location"), data.get("Description"));
	CEE.AddTickets(data.get("StartTime"), data.get("endTime"),0,0,data.get("ticketName"), data.get("ticketquantity"));
	CEE.AddField(data.get("Label"), data.get("order"),data.get("type"), data.get("OptionName"), data.get("value"),data.get("order1"), data.get("type1"),data.get("type2"),data.get("type3"),data.get("type4"));
    quit();
    
    openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity1 = login1.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard1 = myCommunity1.gotoManageCommunity(data.get("communityName"));
	CommunityEventsPage commevent1=communityDashboard1.navigateToEvents();
	commevent1.gotoCheckin(data.get("eventname"),data.get("email1"), data.get("NameF"), data.get("NameL"));
	
	
	}
	@AfterMethod
	public void tearDown() {

		logInfo("TC1257 Test Completed");

		quit();

	}
	
}