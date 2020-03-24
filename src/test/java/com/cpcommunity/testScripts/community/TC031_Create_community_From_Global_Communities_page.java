package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CreateCommunityPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC031_Create_community_From_Global_Communities_page extends BaseTest {
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC031 (Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC031", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		GlobalCommunitesPage GlobalCommunitesPage = myDashboardPage.naviagtingToGlobalCommunities();	
		CreateCommunityPage CreateCommunityPage = GlobalCommunitesPage.clickOnCreateCommunity();
		GlobalCommunitesPage = CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));
		myDashboardPage = myDashboardPage.navigateToMyDashBoard();
		MyCommunitiesPage myCommunitiesPage= myDashboardPage.NaviagtingToMyCommunities();
		myCommunitiesPage.verifyWaitForReviewIsDisplayed(data.get("communityName"));
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
