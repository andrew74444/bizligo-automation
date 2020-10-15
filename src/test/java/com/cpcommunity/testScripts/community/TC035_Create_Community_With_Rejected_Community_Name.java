package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC035_Create_Community_With_Rejected_Community_Name extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC035(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC035", data.get("Runmode"), excel);
		log.info("Inside TC035 Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage= EcoSystemPage.goToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC035 Test Completed");
		
		quit();
		
	}

}
