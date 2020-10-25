package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

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
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage= EcoSystemPage.goToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		CreateCommunityPage.CreateCommunity(data.get("communityName")+" "+runTime, data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC029 Test Completed");
		
		quit();
		
	}

}
