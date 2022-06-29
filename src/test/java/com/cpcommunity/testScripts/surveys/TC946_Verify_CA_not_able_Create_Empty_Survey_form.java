package com.cpcommunity.testScripts.surveys;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.ServeysPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC946_Verify_CA_not_able_Create_Empty_Survey_form extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC946(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC946", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		/*
		 * MyCommunitiesPage MyCP = login.loginToMyCommunitiesPage(data.get("email"),
		 * data.get("password")); CommunityDashboardPage CDP=
		 * MyCP.gotoManageCommunity(data.get("communityName")); ServeysPage
		 * SP=CDP.GoToServeysPage();
		 * 
		 */		
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));	
			MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
			CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		ServeysPage SP=CommunityDashboardPage.GoToServeysPage();
		SP.emptyFormSubmission();


}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}

}
