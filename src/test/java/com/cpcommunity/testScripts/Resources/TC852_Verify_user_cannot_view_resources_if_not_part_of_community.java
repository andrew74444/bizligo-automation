package com.cpcommunity.testScripts.Resources;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC852_Verify_user_cannot_view_resources_if_not_part_of_community extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC852(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC852", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
		GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
		GCP.checkResources();

}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC852 Test Completed");
		
		quit();
		
	}

}
