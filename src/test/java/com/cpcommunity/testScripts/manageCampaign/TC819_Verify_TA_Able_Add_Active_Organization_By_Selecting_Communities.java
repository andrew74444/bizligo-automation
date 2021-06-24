package com.cpcommunity.testScripts.manageCampaign;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.ComposeCampaignPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC819_Verify_TA_Able_Add_Active_Organization_By_Selecting_Communities extends BaseTest {
   
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC819(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC819", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage TDP = login.loginToApplicationTADP(data.get("email"), data.get("password"));
        ComposeCampaignPage CCP=TDP.NavigatetoComposeCampaignPage();
        CCP.addSelectCommunity(data.get("community"), data.get("community2"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC819 Test Completed");
		
		quit();
		
	}
}
