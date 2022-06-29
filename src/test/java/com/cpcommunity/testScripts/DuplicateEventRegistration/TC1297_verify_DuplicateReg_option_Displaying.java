package com.cpcommunity.testScripts.DuplicateEventRegistration;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityEventsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1297_verify_DuplicateReg_option_Displaying extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1297(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1297", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		MyCommunitiesPage com=login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
//        CommunityDashboardPage dash=com.gotoManageCommunity(data.get("community"));

		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));	
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();	
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
      
		CommunityEventsPage CEP= CommunityDashboardPage.navigateToEvents();
        CEP.NewEvent();
        CEP.checkDuplicateRegDisplaying();
        
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1297 Test Completed");
		
		quit();
		
	}
	}
