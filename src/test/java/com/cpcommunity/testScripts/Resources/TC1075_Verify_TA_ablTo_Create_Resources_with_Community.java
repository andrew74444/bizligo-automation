package com.cpcommunity.testScripts.Resources;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageResourcesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.ResourcesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1075_Verify_TA_ablTo_Create_Resources_with_Community extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1075(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1075", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
		ManageResourcesPage manageres=tadashoboard.navigateToManageResourcesPage();
		manageres.AddFieldswithCommunity(data.get("Title1"),data.get("community"), data.get("Description"),data.get("url"));
		HomePage home1= manageres.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyDashboardPage dashpage = login.loginToDashboard(data.get("email11"), data.get("password11"));
		ResourcesPage resource=dashpage.gotoResourcesPage();
		resource.checkResources1();
	    
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1075 Test Completed");
		
		quit();
		
	}
}
