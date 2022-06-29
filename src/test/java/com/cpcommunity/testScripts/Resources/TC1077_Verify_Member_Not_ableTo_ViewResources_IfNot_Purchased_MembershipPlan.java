package com.cpcommunity.testScripts.Resources;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.ResourcesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1077_Verify_Member_Not_ableTo_ViewResources_IfNot_Purchased_MembershipPlan extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1077(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1077", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
	    EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));	
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage communityDetailsPage=	GlobalCommunitesPage.checkResource();
		communityDetailsPage.resourceNotdisplaying();
		
//		MyDashboardPage dashpage = login.loginToDashboard(data.get("email"), data.get("password"));
//		ResourcesPage R=dashpage.goToBDMAIResouces(data.get("Community"));
//        R.checkResourceNotDisplaying();
		
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1077 Test Completed");
		
		quit();
		
	}
}
