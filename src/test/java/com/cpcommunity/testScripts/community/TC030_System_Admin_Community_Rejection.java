package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CreateCommunityPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC030_System_Admin_Community_Rejection extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC030 (Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC030", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email1"), data.get("password1"));
		
		MyCommunitiesPage MyCommunitiesPage= EcoSystemPage.goToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));

		HomePage home1 = new HomePage().open(data.get("tenantType"));
		home1.logout();
		
		LoginPage login1 = home1.clickOnLOGINBtn();
	//	logInfo("Username entered as "+data.get("email")+" and Password entered as "+ data.get("password"));
		SystemAdminDashboardPage Dashboard_Page = login1.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		PendingCommunitiesPage PendingCommunitiesPage = Dashboard_Page.naviagteToPendingCommunities();
		PendingCommunitiesPage.rejectCommunity(data.get("communityName"), data.get("rejectReason"));
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password1"));//member mail checking
		yahoo.tAdminRejectedCommunity();
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC030 Test Completed");
		
		quit();
		
	}

}
