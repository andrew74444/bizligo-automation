package com.cpcommunity.ManageCampaign;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.ComposeCampaign;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1044_Verify_TOfield_Validation extends BaseTest{
	
		@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
		public void TC1044(Hashtable<String,String> data) throws Exception {
			
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1044", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage ecosystemp = login.loginToApplication(data.get("email"), data.get("password"));
		CommunityDashboardPage communityDashboard=ecosystemp.navigateToManageCommunityPage();
		ComposeCampaign composecp= communityDashboard.navigateToComposeCampaignPage();
		composecp.Addcontact(data.get("Communities"));
		}
		@AfterMethod
		public void tearDown() {
			
			logInfo("TC1044 Test Completed");
			
			quit();
			
		}
}

