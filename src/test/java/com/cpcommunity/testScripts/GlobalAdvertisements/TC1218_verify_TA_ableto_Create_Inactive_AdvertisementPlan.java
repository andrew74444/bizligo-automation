package com.cpcommunity.testScripts.GlobalAdvertisements;

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

public class TC1218_verify_TA_ableto_Create_Inactive_AdvertisementPlan extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1218(Hashtable<String,String> data) throws Exception {
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1218", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageAdPlansPage MAPP=tadashoboard.goToManageAdPlansPage();
	MAPP.GlobalInactiveAdByTA(data.get("community"),data.get("name1"),data.get("price1"), data.get("planDetails"),data.get("duration1"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1218 Test Completed");
		
		quit();
		
	}
}
