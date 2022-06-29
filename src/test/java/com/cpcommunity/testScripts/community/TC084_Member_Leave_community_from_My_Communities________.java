package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC084_Member_Leave_community_from_My_Communities________ extends BaseTest {


	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC084(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC084", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
//		Dashboard_Page.verifySuccessLogin();
		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		try {
			GlobalCommunitesPage.communityJoinWithOutDate(data.get("communityName"));	
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		MyCommunitiesPage.leaveCommunityWithName(data.get("communityName"));
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password1"));
		yahoo.memberLeftCommunity();//CA  checking confirmation mail about member left community 
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC084 Test Completed");
		
		quit();
		
	}

}
