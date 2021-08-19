package com.cpcommunity.ManageCampaign;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CampaignTemplatePage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.ComposeCampaign;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1067_Verify_CA_ableto_Inactivate_CampaignTemplate_and_shouldNot_display_InSelectTemplate_CompaseCamp extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1067(Hashtable<String,String> data) throws Exception {
		
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1067", data.get("Runmode"), excel);
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
	campTemp.inactivate();
	ComposeCampaign CC=campTemp.navigateToComposeCampaignPage();
	CC.checkTemplatenotDisplay();
	CampaignTemplatePage CT=CC.navigateToCampaignTemplate();
	CT.activate();
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1067 Test Completed");
		
		quit();
		
	}
}
