package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyAdvertisements;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.UpdateADPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1124_Verify_Member_ableto_Edit_AdPlan_when_Status_Is_paymentPending extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1124(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1124", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	 MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email"), data.get("password"));
	 MyAdvertisements MAP=MDP.NaviagtingToMyAdvertisements();
	UpdateADPage upp= MAP.gotoUpdateAdpage(data.get("planName"));
	 upp.editPaymentpendingAD(data.get("AdName"),data.get("path"));
	 
	 
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1124 Test Completed");
		
		quit();
		
	}
	}


