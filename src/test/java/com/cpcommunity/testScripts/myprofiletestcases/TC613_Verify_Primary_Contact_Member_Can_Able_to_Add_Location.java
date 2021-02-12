
package com.cpcommunity.testScripts.myprofiletestcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyProfilePage;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC613_Verify_Primary_Contact_Member_Can_Able_to_Add_Location extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC613(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC613", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		MyDashboardPage dashboard = login.loginToMemberdashboard(data.get("email"),data.get("password"));
		MyProfilePage profile = dashboard.NaviagtingToMyProfilePage();
		profile.additionalInformation(data.get("locationName"),data.get("locationAddress"),data.get("addressLine1"),data.get("locationStreetAddress2"),data.get("locationCity"),data.get("locationState"),data.get("locationZip"),data.get("country"),data.get("Phone"),data.get("fax"));
		//GlobalCommunitesPage globalcommunities = profile.NavigateToGlobalcommunities();
		//CommunityDetailsPage community = globalcommunities.navigateToCommunityDetailsPage(data.get("communityName"));
		
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
