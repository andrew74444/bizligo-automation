package com.cpcommunity.testScripts.Member_B2B_SignUp;


import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC234_Verify_Member_Able_To_Signup_For_MembershipPlan_Disabled extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC234(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC234", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		HomePage home = new HomePage().superAdminHomePageOpen();
		LoginPage login = home.clickOnLOGINBtn();
		logInfo("Username entered as "+data.get("superAdminemail")+" and Password entered as "+data.get("superAdminPassword"));
		superAdminDashboardPage sadp = login.superAdminloginToApplication(data.get("superAdminemail"), data.get("superAdminPassword"));
		SuperAdminFeatureConfigurationPage safcp = sadp.goToFeatureConfigurationsPage();
		safcp.disablefeature(data.get("feature"));
		
		
		
		
//		safcp.enableFeature(data.get("feature"));
		
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC234 Test Completed");
		
		quit();
		
	}

	
	

}
