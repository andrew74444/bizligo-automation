package com.cpcommunity.testScripts.PricingPlan;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.CreateCommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MakePaymentPage;
import com.cpcommunity.PageObjects.ManageCommunitiesPage;
import com.cpcommunity.PageObjects.ManageCommunityPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.SekectPricingPlan;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1292_Verify_when_ZoomFeature_NotAvailable_CA_notAbleto_perform_related_actions extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1292(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1292", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
	   openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage com=login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
		MyDashboardPage dash=com.gotoMyDashboardPage();
		CreateCommunityPage CC=dash.createcommunity();	
		CC.Createcommunity(data.get("Name"), data.get("About"), data.get("Category"), data.get("type"));
		quit();
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		LoginPage login2 = home2.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email"), data.get("password"));
	    PendingCommunitiesPage PC2=tadashoboard2.navigatetopendingCommunities();
	    PC2.approveCommunity(data.get("Name"));
	    quit();
		
	    openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home3 = new HomePage().open(data.get("tenantType"));
		LoginPage login3 = home3.clickOnLOGINBtn();
		MyCommunitiesPage com3=login3.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
		MyDashboardPage dash3=com3.gotoMyDashboardPage();
		dash3.searchcommunity(data.get("Name"));
		SekectPricingPlan SPP=dash3.completesetup();
		MakePaymentPage MP=SPP.selectplan(data.get("planName"));
		AuthorizeGateway AG=MP.payment();
		AG.makePayment();
		ManageCommunityPage MC=AG.navigateManageCommunities();
		MC.checkMenuNotPresent(data.get("menu"));
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home4 = new HomePage().open(data.get("tenantType"));
		LoginPage login4 = home4.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard4=login4.loginToTADashboard(data.get("email"), data.get("password"));
		ManageCommunitiesPage Mcom=tadashoboard4.navigatetomanageCommunities();
		Mcom.EditCommunities(data.get("Name"),data.get("About"), data.get("Category"));
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1292 Test Completed");
		
		quit();
		
	}
}
