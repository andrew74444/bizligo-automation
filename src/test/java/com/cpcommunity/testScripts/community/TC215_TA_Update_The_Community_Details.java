package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.TACommunitiesPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC215_TA_Update_The_Community_Details extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC215(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC215", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
		tACommunitiesPage.UpdateCommunity(data.get("communityName")+" "+runTime, data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("OtherName"), data.get("About"), data.get("Category"), data.get("type"), data.get("StateName"), data.get("CityName"), data.get("FacebookUrl"), data.get("TwitterUrl"), data.get("LinkedInUrl"), data.get("LogoImagePath"), data.get("websiteUrl"), data.get("ImagePath"), data.get("CommunityUpdate"),data.get("updateCommunityName")+" "+runTime);
		
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC215 Test Completed");
		
		quit();
		
	}

}
