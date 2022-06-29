package com.cpcommunity.testScripts.Loyalty;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.LoyaltyPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2131_Verify_tooltip_message_added_towards_each_feature_messages_are_externalized extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2131(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2131", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
		LoyaltyPage LP=TDP.navigateToLoyaltyPage();
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC2131 Test Completed");
		
		quit();
		
	}

}
