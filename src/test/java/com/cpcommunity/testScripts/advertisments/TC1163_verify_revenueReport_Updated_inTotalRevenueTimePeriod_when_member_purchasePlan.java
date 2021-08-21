package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.RevenueReportPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.TotalRevenueReport;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1163_verify_revenueReport_Updated_inTotalRevenueTimePeriod_when_member_purchasePlan extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1163(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1163", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login = home1.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	 GlobalCommunitesPage GCP=myCommunity.naviagtingToGlobalCommunities();
	 GCP.searchCommunity(data.get("community"));
	 SelectPlanPage SPP= GCP.navigatetoselectPlanPage();
	 AuthorizeGateway AG=SPP.selectPlan1(data.get("planName"),data.get("AdName"),data.get("path"));
	 AG.makePayment();
	 RevenueReportPage RRP=AG.navigateToRevenueReport();
	 TotalRevenueReport TRR=RRP.goToTotalReport();
	   TRR.checkTotalRevenuebasedOnTimePeriod();
	 
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1163 Test Completed");
		
		quit();
}
}
