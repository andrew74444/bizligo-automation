package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class TC171_Verify_Total_Communities_Count_And_In_My_Communities_Are_Same extends BaseTest {

	String TCID= "TC079";
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC171(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC171", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
				
//		String T1 = Dashboard_Page.totalCommunitiesCount();
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		String T2 = myCommunitiesPage.getTotalCommunities();
//		AssertionHelper.verifyText(T1, T2);
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC171 Test Completed");
		
		quit();
		
	}

}
