package com.cpcommunity.testScripts.Resources;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.ResourcesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1078_Verify_Member_ableTo_view_Resources_IfJoins_Group_whichIs_Configured_withResources extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1078(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1078", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		  EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		  MyCommunitiesPage MyCommunitiesPage=	  EcoSystemPage.goToMyCommunities();
		  CommunityDetailsPage CommunityDetailsPage=  MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		  CommunityDetailsPage.  JoinGroups(data.get("name"));
		  CommunityDetailsPage.  checkingResources2();
		  CommunityDetailsPage.  LeaveGroup(data.get("name"));
//		  MyDashboardPage dashpage = login.loginToDashboard(data.get("email"), data.get("password"));
//		dashpage.joinGroup(data.get("Community"));
//		ResourcesPage RP=dashpage.gotoResource();
//		RP.checkResources2();
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1078 Test Completed");
		
		quit();
		
	}
}
