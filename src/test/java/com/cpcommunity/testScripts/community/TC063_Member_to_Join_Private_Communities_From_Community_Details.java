package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC063_Member_to_Join_Private_Communities_From_Community_Details extends BaseTest {

	String TCID= "TC063";	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC063(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC063", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		GlobalCommunitesPage.communityJoinWithOutDate(data.get("communityName"));
//***********************commented below  lines for joining to one community only***********************\\on 22/03	
		
//		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
//		CommunityDetailsPage.joinCommunity();
//		Thread.sleep(4000);
//		home = EcoSystemPage.logout();
	//	login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		
	
//		EcoSystemPage = login.loginToApplication(data.get("email1"),data.get("password"));
//		
//		GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
//		CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
//		CommunityDetailsPage.joinCommunity();
		
		
		//Assert.fail("Failing the login test");
		
		Yahoo yahoo= new Yahoo().open();

	//	yahoo.Login(data.get("email1"), data.get("password1"));//for member checking mail
	//	yahoo.requestCommunity();//for member checking mail purpose
		yahoo.Login(data.get("email2"), data.get("password2"));//for community admin checking mail
		yahoo.memberRequestChecking();//for CA checking mail
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC063 Test Completed");
		
		quit();
		
	}

}
