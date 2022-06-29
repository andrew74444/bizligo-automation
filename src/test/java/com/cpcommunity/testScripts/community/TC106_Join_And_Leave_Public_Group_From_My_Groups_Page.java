package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC106_Join_And_Leave_Public_Group_From_My_Groups_Page extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC106(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC106", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
//********************for joining group********************\\	
		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));//+" "+runTime
//
		try {
			CommunityDetailsPage.JoinGroups(data.get("groupName"));
			Thread.sleep(4000);
	} catch (Exception e) {
			// TODO: handle exception	
		}
				
		//** commented below for leaving group**//
		
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		MyGroupsPage MyGroupsPage = EcoSystemPage.goToMyGroups();
		MyGroupsPage.LeaveGroup(data.get("groupName"));	
		
		//Assert.fail("Failing the login test");
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password1"));
//		yahoo.joinedGroup();//member join the group checking mail about it
		yahoo.leaveGroup();//member leave the group checking mail about it

	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC106 Test Completed");
		
		quit();
		
	}

}
