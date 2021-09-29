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

public class TC1221_Verify_MailTriggers_toMember_after_purchasing_plan_which_Riquires_NO_approval extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1221(Hashtable<String,String> data) throws Exception {
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1221", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageAdPlansPage MAPP=tadashoboard.goToManageAdPlansPage();
	MAPP.GlobalAdWithoutApproval(data.get("community"),data.get("name1"),data.get("price1"), data.get("planDetails"),data.get("duration1"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
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
	 AG.openGuerillamail(data.get("email2"));
	 quit();
	 
	 openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		LoginPage login2 = home2.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email"), data.get("password"));
		ManageAdPlansPage MAPP2=tadashoboard2.goToManageAdPlansPage();
		MAPP2.inactivatePlanTA(data.get("planName"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1221 Test Completed");
		
		quit();
		
	}
}