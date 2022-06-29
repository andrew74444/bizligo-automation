package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyAdvertisements;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1140_Verify_DuplicateDetails_Notto_Display_when_Member_doubleClick extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1140(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1140", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	// MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email"), data.get("password"));
	//MyAdvertisements myad=MDP.NaviagtingToMyAdvertisements();
	 EcoSystemPage EcoSystemPage = login1.loginToApplication(data.get("email"), data.get("password"));	
		 MyAdvertisements myad=EcoSystemPage.NaviagtingToMyAdvertisements();
	 
	 myad.createGlobalAd1(data.get("planName"),data.get("AdName"),data.get("path"));
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1140 Test Completed");
		
		quit();
}
}