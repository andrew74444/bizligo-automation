package com.cpcommunity.ManageCampaign;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CampaignTemplatePage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1066_Verify_TA_CA_ableTo_edit_CamplaignTemplate extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1066(Hashtable<String,String> data) throws Exception {
	//	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1066", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	String runTime = openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));		
	log.info(runTime);		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	CampaignTemplatePage campTemp=communityDashboard.navigateToCampaignTemplate();
	campTemp.edittemplate(data.get("Description"),data.get("Name"), data.get("Subject"), data.get("Header"), data.get("Email"), data.get("Template"));
	HomePage home1=campTemp.logout();
	LoginPage login1 = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email1"), data.get("password1"));
	CampaignTemplatePage campTemp1=tadashoboard.navigateToCampaignTemplate();
   campTemp1.edittemplate(data.get("Description1"),data.get("Name1"), data.get("Subject1"), data.get("Header1"), data.get("Email1"), data.get("Template1"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1066 Test Completed");
		
		quit();
		
	}
}