package com.cpcommunity.testScripts.ComposeTemplate;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CampaignTemplatePage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.ImportContactsPage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC831_Verify_CA_TA_create_newCampaignTemplate_is_Display_CampaignPage extends BaseTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC831(Hashtable<String,String> data) throws Exception {

	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC831", data.get("Runmode"), excel);
	log.info("Inside Login Test");
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage MyCP = login.loginToApplicationMcp(data.get("email"), data.get("password"));
	CommunityDashboardPage CDP= MyCP.gotoManageCommunity(data.get("communityName"));
	CampaignTemplatePage CTP=CDP.NavigatetoCampaignTemplatePage();
    CTP.addingTemplate(data.get("Template Name"),data.get("Description"),data.get("Name"),data.get("Email Header"),data.get("Email Subject"),data.get("From Email"),data.get("Template"),data.get("Footer"));
    LoginPage login1 = home.clickOnLOGINBtn();
    TenantAdminDashboardPage TADP = login1.loginToApplicationTADP(data.get("email1"), data.get("password1"));
	CTP=TADP.NavigatetoCampaignTemplatePage();
    CTP.addingTemplate(data.get("Template Name1"),data.get("Description"),data.get("Name"),data.get("Email Header"),data.get("Email Subject"),data.get("From Email"),data.get("Template"),data.get("Footer"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC831 Test Completed");
		
		quit();
		
	}
	
}
