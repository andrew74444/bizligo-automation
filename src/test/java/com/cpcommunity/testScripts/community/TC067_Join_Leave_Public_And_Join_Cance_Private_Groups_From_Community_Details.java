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

public class TC067_Join_Leave_Public_And_Join_Cance_Private_Groups_From_Community_Details extends BaseTest {

	String TCID= "TC067";	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC067(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC067", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
//		int T1 = Dashboard_Page.totalGroupsCount();
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.PublicGroupJoinedSuccessfully(data.get("name1"));
		
//		int T2 = Dashboard_Page.totalGroupsCount();
//		T1++;		
//		AssertionHelper.verifyText(String.valueOf(T1), String.valueOf(T2));
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));		
		CommunityDetailsPage.LeaveGroup(data.get("name1"));
		CommunityDetailsPage.PrivateGroupJoinedSuccessfully(data.get("name2"));
		CommunityDetailsPage.cancelRequest(data.get("name2"));
		Thread.sleep(5000);
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC067 Test Completed");
		
		quit();
		
	}

}
