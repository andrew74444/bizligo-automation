package com.cpcommunity.testScripts.CustomField;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CreateOrEditEvent;
import com.cpcommunity.PageObjects.EventDetailsPage;
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

public class TC1254_verify_TACA_ceatedField_displaying_inEventRegistration extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1254(Hashtable<String,String> data) throws Exception {
	
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1254", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	MyDashboardPage dash=myCommunity.gotoMyDashboardPage();
	UpcomingEventsPage UE=dash.GoToUpComingEvents();
	UE.registerTt(data.get("Eventname"));
	//CEE.UpdateDetails(data.get("eventTitleName"),  data.get("Location"));
	//CEE.checkFieldvalidation(data.get("lengthm"), data.get("lengthM"), data.get("label"), data.get("lengthM1"),data.get("lengthM2"));
	
	}
	@AfterMethod
	public void tearDown() {

		logInfo("TC1254 Test Completed");

		quit();

	}
}
