package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC104_Manage_Community_Type extends BaseTest {

	
	String TCID="TC104";
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",enabled = false)
	public void loginTest(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();

		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));//+" "+runTime
		EditCommunityPage EditCommunityPage = CommunityDashboardPage.navigateToEditCommunityPage();
		EditCommunityPage.editcommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("OtherName"), data.get("About"), data.get("Category"), data.get("type"), data.get("StateName"), data.get("CityName"), data.get("FacebookUrl"), data.get("TwitterUrl"), data.get("LinkedInUrl"), data.get("LogoImagePath"), data.get("website"),data.get("ImagePath"), data.get("CommunityUpdate"), data.get("communityNameUpdate"));
		//+" "+runTime
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC104 Test Completed");
		
		quit();
		
	}

}
