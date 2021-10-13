package com.cpcommunity.testScripts.Promocodes;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PromoCodePage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2151_Verify_community_name_displayed_in_disable_mode_when_TA_edits_community extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2151(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2151", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
		PromoCodePage PCP=TDP.navigateToPromocodePage();
		PCP.communityDisabledWhenEdit();

}

}//
