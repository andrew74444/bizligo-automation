package com.cpcommunity.testScrips.communityWidget;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.GlobalCareers;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1180_verify_recentlyApplied_5Jobs_displaying_in_yourApplied_widget extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	
	//
	public void TC1180(Hashtable<String,String> data) throws Exception {
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1180", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
	GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	GCP.searchCommunity(data.get("community"));
	GlobalCareers career=GCP.gotoCareerPage();
	
	}
}
