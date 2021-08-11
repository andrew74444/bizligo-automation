package com.cpcommunity.testScrips.communityWidget;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityPage;
import com.cpcommunity.PageObjects.ManageCommunityWidgets;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1210_verify_Championwidget_notDisplaying_if_Diable extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1210(Hashtable<String,String> data) throws Exception {
		
	//change plan name before running code
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1210", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
    MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
    CommunityDashboardPage dash=MDP.gotoDashboardPage(data.get("community"));
    ManageCommunityWidgets communitywidget=dash.navigateTomanageWidget();
    communitywidget.disableChampion();
    Bizligo1CommunityPage biz=communitywidget.navigateToBizligopage();
    biz.VerifychampionsNotDisplaying();
    ManageCommunityPage MCp=biz.gotoDashboardpage();
    ManageCommunityWidgets CW=MCp.navigateTomanageWidget();
    CW.Enablechampionp();
	
	 
	 
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1210 Test Completed");
		
		quit();
		
	}
}
