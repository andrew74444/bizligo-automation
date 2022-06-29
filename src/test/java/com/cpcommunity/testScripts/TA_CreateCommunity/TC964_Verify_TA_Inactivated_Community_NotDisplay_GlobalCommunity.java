package com.cpcommunity.testScripts.TA_CreateCommunity;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC964_Verify_TA_Inactivated_Community_NotDisplay_GlobalCommunity extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC964(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC964", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GCP=EcoSystemPage.goToGlobalCommunities();
		GCP.searchInactiveCommunityTA(data.get("InactiveCommunity"));

}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC964 Test Completed");
		
		quit();
		
	}

}
