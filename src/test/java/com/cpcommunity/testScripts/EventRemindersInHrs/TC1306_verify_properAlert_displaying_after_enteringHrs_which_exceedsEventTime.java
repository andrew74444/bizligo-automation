package com.cpcommunity.testScripts.EventRemindersInHrs;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityEventsPage;
import com.cpcommunity.PageObjects.CreateOrEditEvent;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1306_verify_properAlert_displaying_after_enteringHrs_which_exceedsEventTime extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1306(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1306", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage com=login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
       CommunityDashboardPage dash=com.gotoManageCommunity(data.get("community"));
        CommunityEventsPage CEP= dash.navigateToEvents();
        /*CEP.SearchEvent(data.get("eventname"));
        CreateOrEditEvent CEE=CEP.clickonEvent();
        CEE.editDetail();
        CEE.Addtickets(data.get("ticketName"), data.get("ticketquantity"));
        CEE.ReminderError(data.get("Reminder"));*/
        CreateOrEditEvent CEE=CEP.NewEvent();
    	CEE.AddDetails(data.get("EventTitle"), data.get("EventCategory"),data.get("location"), data.get("Description"));
    	 CEE.Addtickets(data.get("ticketName"), data.get("ticketquantity"));
         CEE.ReminderError(data.get("Reminder"));
    	
	}
}
