package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1139_Verify_CommunityName_displayed_AlphabaticOrder_IfTA_Click_Communitydropdown_InAdplan extends BaseTest{

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1139(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1139", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
		ManageAdPlansPage MAPP=tadashoboard.goToManageAdPlansPage();	
		MAPP.checkCommunityDropdown();
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1139 Test Completed");
		
		quit();
}
}
