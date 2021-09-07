package com.cpcommunity.testScrips.communityWidget;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.GlobalCareers;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1176_Verify_Guest_askTo_login_to_applyJob extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1176(Hashtable<String,String> data) throws Exception {
			//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1176", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	GlobalCommunitesPage GCP=home.NavigateToGlobalCommunities();
	GCP.searchCommunity(data.get("community"));
    GlobalCareers GC= GCP.gotoGuestCareerPage();
    GC.GuestMessage();
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1176 Test Completed");
		
		quit();
		
	}	
}
