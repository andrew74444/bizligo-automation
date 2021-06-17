package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;

import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC031_Create_community_From_Global_Communities_page extends BaseTest {
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC031 (Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC031", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		//logInfo("Launched Browser : "+data.get("browser"));
		//logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();	
		CreateCommunityPage CreateCommunityPage = GlobalCommunitesPage.clickOnCreateCommunity();
		GlobalCommunitesPage = CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));

//		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
//		MyCommunitiesPage myCommunitiesPage= EcoSystemPage.goToMyCommunities();
//		myCommunitiesPage.verifyWaitForReviewIsDisplayed(data.get("communityName"));
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC031 Test Completed");
		
		quit();
		
	}

}
