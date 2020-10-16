package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC039_Edit_Community extends BaseTest {	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC039(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC039", data.get("Runmode"), excel);
		log.info("TC039 Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));

		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		EditCommunityPage EditCommunityPage = CommunityDashboardPage.navigateToEditCommunityPage();
		EditCommunityPage.editcommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("OtherName"), data.get("About"), data.get("Category"), data.get("type"), data.get("StateName"), data.get("CityName"), data.get("FacebookUrl"), data.get("TwitterUrl"), data.get("LinkedInUrl"), data.get("LogoImagePath"),data.get("website"), data.get("ImagePath"), data.get("CommunityUpdate"),data.get("communityName"));
		home.open();
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.verifycommunityDetails(data.get("communityName"), data.get("About"), data.get("StateName"), data.get("CityName"), data.get("FacebookUrl"), data.get("LinkedInUrl"), data.get("TwitterUrl"), data.get("type"));
//		CommunityDetailsPage.clickonLogo();
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC039 Test Completed");
		
		quit();
		
	}

}
