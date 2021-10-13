package com.cpcommunity.testScripts.FeatureConfigurationByTA;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.SuperAdminFeatureConfigurationPage;
import com.cpcommunity.PageObjects.superAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1270_verify_SuperAdmin_canAbleto_EnableDisable_ImportContact extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1270(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1270", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	AdminHomePage home= new AdminHomePage().open("https://admin.bizligotest.com");
	AdminLogin login=home.navigateToAdminLogin();
	superAdminDashboardPage SADP=login.superAdminloginToApplication(data.get("email"), data.get("password"));
	SuperAdminFeatureConfigurationPage SAFC=SADP.goToFeatureConfigurationsPage();
	SAFC.disablefeature(data.get("feature"));
	//SAFC.clickfeature(data.get("feature"));
	SAFC.enablefeature(data.get("feature"));
	

	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1270 Test Completed");
		
		quit();
		
	}
}
