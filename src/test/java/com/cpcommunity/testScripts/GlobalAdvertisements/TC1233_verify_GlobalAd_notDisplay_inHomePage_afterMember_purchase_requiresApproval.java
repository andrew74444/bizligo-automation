package com.cpcommunity.testScripts.GlobalAdvertisements;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1233_verify_GlobalAd_notDisplay_inHomePage_afterMember_purchase_requiresApproval extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1233(Hashtable<String,String> data) throws Exception {
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1233", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageAdPlansPage MAPP=tadashoboard.goToManageAdPlansPage();
	//MAPP.GlobalAdByTA(data.get("community"),data.get("name1"),data.get("price1"), data.get("planDetails"),data.get("duration1"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
	quit();
	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));
	 GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	 GCP.searchCommunity(data.get("community1"));
	 SelectPlanPage SPP= GCP.navigatetoselectPlanPage();
	SPP.selectBPlan(data.get("planName"));
	AuthorizeGateway AG=SPP.selectTenantPlan(data.get("AdName"),data.get("path"));
	 AG.makePayment();
	 quit();
	 
	 openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home3 = new HomePage().open(data.get("tenantType"));
		LoginPage login3 = home3.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard3=login3.loginToTADashboard(data.get("email"), data.get("password")); 
		HomePage home2= tadashoboard3.goToHomePage();
		home2.CheckadvertiseNotDisplay();
	   TenantAdminDashboardPage TAP=home2.gotoTenantAdminDashboardPage();
	   ManageAdPlansPage MAPP3=TAP.goToManageAdPlansPage();
	   MAPP3.Inactivate(data.get("planName"));
	     
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1233 Test Completed");
		
		quit();
		
	}
}
