 package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CreateAdPage;
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

public class TC1135_Verify_saved_AdDetails_Notbeen_Displayed extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1135(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1135", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
//	 MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email"), data.get("password"));
//	 GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
//	 GCP.searchCommunity(data.get("community"));
	 
	 EcoSystemPage EcoSystemPage1 = login1.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GCP = EcoSystemPage1.goToGlobalCommunities();
		 GCP.searchCommunity(data.get("community"));
		 GCP.goTocommunityPage(data.get("community"));
	 CreateAdPage CAP=GCP.gotoCreateAdPage();
	// CAP.createandsaveAd(data.get("adtitle"), data.get("path"));
	 CAP.createAdandSave(data.get("adtitle"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1135 Test Completed");
		
		quit();
		
	}
}
