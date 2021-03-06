package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC161_Verify_CA_Not_Able_To_Leave_Community_From_M extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC161(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC151", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage= EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		communityDashboardPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		EcoSystemPage.goToMyEcosystem();
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC161 Test Completed");
		
		quit();
		
	}

}
