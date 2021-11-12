package com.cpcommunity.testScripts.configureAttendees;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.UpcomingEventsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1313_verify_GuestUser_notAbleTo_access_InviteGuestOption_ifCA_notselected_whileCreating extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1313(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1313", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	 UpcomingEventsPage event=home.clickOnupComingEvents();
		event.searchevent(data.get("EventTitle"));
		event.InviteGuestNotDisplaying();
	}
	@AfterMethod
	public void tearDown() {

		logInfo("TC1313 Test Completed");

		quit();

	}
	}

