package com.cpcommunity.testScripts.GlobalAdvertisements;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.RevenueReportPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.PageObjects.TotalRevenueReport;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1231_verify_RevenueReport_updated_when_CA_purchase_AdPlan extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1231(Hashtable<String,String> data) throws Exception {
		
		
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1231", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageAdPlansPage MAPP=tadashoboard.goToManageAdPlansPage();
	MAPP.GlobalAdByTA(data.get("community"),data.get("name1"),data.get("price1"), data.get("planDetails"),data.get("duration1"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
	RevenueReportPage revenue= MAPP.goToRevenueReport();
	TotalRevenueReport totalrevenue=revenue.goToTotalReport();
	totalrevenue.checkTotalRevenuebasedOnTimePeriod();
	quit();
	
	 openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage myCommunity = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
	GlobalCommunitesPage GCP=myCommunity.naviagtingToGlobalCommunities();
	GCP.searchCommunity(data.get("community1"));
	SelectPlanPage SPP= GCP.navigatetoselectPlanPage();
	SPP.selectBPlan(data.get("planName"));
	AuthorizeGateway AG=SPP.selectTenantPlan(data.get("AdName"),data.get("path"));
	AG.makePayment();
	quit();
	
	 openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		LoginPage login2 = home2.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email"), data.get("password"));
		RevenueReportPage revenue2= tadashoboard2.goToRevenueReport();
		TotalRevenueReport totalrevenue2=revenue2.goToTotalReport();
		totalrevenue2.checkTotalRevenuebasedOnTimePeriod();
		ManageAdPlansPage MAPP2=totalrevenue2.goToManageAdPlansPage();
		MAPP2.inactivatePlanTA(data.get("planName"));
		}
		@AfterMethod
		public void tearDown() {
			
			logInfo("TC1231 Test Completed");
			
			quit();
			
		}
	}

