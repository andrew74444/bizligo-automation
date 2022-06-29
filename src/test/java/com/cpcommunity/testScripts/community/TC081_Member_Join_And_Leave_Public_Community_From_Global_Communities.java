package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class TC081_Member_Join_And_Leave_Public_Community_From_Global_Communities extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC081(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC081", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		
		try {
			
			GlobalCommunitesPage.communityJoinWithOutDate(data.get("communityName"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		String T1 = Dashboard_Page.totalCommunitiesCount();
		
		
//		String T2 = Dashboard_Page.totalCommunitiesCount();
//		int TotalCommunities=  Integer.parseInt(T1);
//		TotalCommunities++;
//		AssertionHelper.verifyText(String.valueOf(TotalCommunities), T2);
		
		
	       GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		    GlobalCommunitesPage.leaveCommunityWithoutDate(data.get("communityName"));
		
//		String T3 = EcoSystemPage.totalCommunitiesCount();
//		AssertionHelper.verifyText(T1, T3);	
		
		//Assert.fail("Failing the login test");
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password1"));
		yahoo.joinedCommunity();
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC081 Test Completed");
		
		quit();
		
	}

}
