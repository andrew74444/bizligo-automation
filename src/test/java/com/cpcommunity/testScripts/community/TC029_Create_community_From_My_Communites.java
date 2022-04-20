package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC029_Create_community_From_My_Communites extends BaseTest {

	
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC029(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		
		DataUtil.checkExecution("master", "TC029", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		log.info(runTime);
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage= EcoSystemPage.goToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));
//***********below code added for  TA to approve community and also checking mail about the approval****************//

//		HomePage home1 = new HomePage().open(data.get("tenantType"));
//		home1.logout();
//		LoginPage login = home1.clickOnLOGINBtn();	
//		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email1"), data.get("password1"));
//		PendingCommunitiesPage PendingCommunitiesPage = Dashboard_Page.naviagteToPendingCommunities();
//		PendingCommunitiesPage.approveCommunity(data.get("communityName"));
//		
//		Yahoo yahoo= new Yahoo().open();
//		yahoo.Login(data.get("email2"), data.get("password2"));
//		yahoo.tAdminApprovedCommunity();

	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC029 Test Completed");
		
		quit();
		
	}

}
