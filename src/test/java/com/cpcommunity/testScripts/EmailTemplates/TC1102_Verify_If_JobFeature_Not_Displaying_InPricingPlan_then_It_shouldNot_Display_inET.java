package com.cpcommunity.testScripts.EmailTemplates;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EmailTemplatePage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.PricingPlanDetailsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1102_Verify_If_JobFeature_Not_Displaying_InPricingPlan_then_It_shouldNot_Display_inET  extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1102(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1102", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));	
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
	CommunityDashboardPage communityDashboard =MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
	PricingPlanDetailsPage PPDP=communityDashboard.navigateToPricingPlanDetailsPage();
	PPDP.checkJobsPresent();
	EmailTemplatePage ET=PPDP.navigateToEmailTemplate();
	ET.checkJobsNotPresent();
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1102 Test Completed");
		
		quit();
		
	}
}