package com.cpcommunity.testScripts.DuplicateEventRegistration;

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

public class TC1301_verify_guestUser_notAllowed_MultipleEmailReg_ifDuplicateReg_notSelect extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1301(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1301", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage com=login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
        CommunityDashboardPage dash=com.gotoManageCommunity(data.get("community"));
        CommunityEventsPage CEP= dash.navigateToEvents();
        CreateOrEditEvent CEE=CEP.NewEvent();
        CEE.AddDetails(data.get("EventTitle"), data.get("EventCategory"),data.get("location"), data.get("Description"));
        CEE.AddTickets(data.get("ticketName"), data.get("ticketquantity"));
        CEE.AddField1(data.get("Label"), data.get("order"),data.get("type"));
        CEE.publish();
        quit();
        
        openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage dashpage = login.loginToDashboard(data.get("email"), data.get("password"));
		UpcomingEventsPage UEP=dashpage.GoToUpComingEvents();
		UEP.searchevent(data.get("EventTitle"));
		UEP.CannotregisterwithDuplicates(data.get("email"), data.get("fName"), data.get("Lname"));
    	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1301 Test Completed");
		
		quit();
		
	}
}
