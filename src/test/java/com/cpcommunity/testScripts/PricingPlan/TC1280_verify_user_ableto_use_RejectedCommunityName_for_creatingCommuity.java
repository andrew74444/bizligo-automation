package com.cpcommunity.testScripts.PricingPlan;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CreateCommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1280_verify_user_ableto_use_RejectedCommunityName_for_creatingCommuity extends BaseTest{

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1280(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1280", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
	    openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage mycommunity1=login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
		CreateCommunityPage CC=mycommunity1.clickOnCreateCommunity();
		CC.Createcommunity(data.get("Name"), data.get("About"), data.get("Category"), data.get("type"));
	    
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1280 Test Completed");
		
		quit();
	}
}
