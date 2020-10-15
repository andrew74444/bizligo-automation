package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC168_Verify_InActivated_Community_Is_Not_Displayed_In_Global_Communities extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC168(Hashtable<String,String> data) throws Exception {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC168", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));

		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		GlobalCommunitesPage.checkInActivatedCommunityIsNotDisplayed(data.get("communityName"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC168 Test Completed");
		
		quit();
		
	}

}
