package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class TC081_Member_Join_And_Leave_Public_Community_From_Global_Communities extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC081(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC081", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();	
		String T1 = Dashboard_Page.totalCommunitiesCount();
		GlobalCommunitesPage GlobalCommunitesPage = Dashboard_Page.naviagtingToGlobalCommunities();
		GlobalCommunitesPage.communityJoinWithOutDate(data.get("communityName"));
		Dashboard_Page = Dashboard_Page.navigateToMyDashBoard();
		String T2 = Dashboard_Page.totalCommunitiesCount();
		int TotalCommunities=  Integer.parseInt(T1);
		TotalCommunities++;
		AssertionHelper.verifyText(String.valueOf(TotalCommunities), T2);
		GlobalCommunitesPage = Dashboard_Page.naviagtingToGlobalCommunities();
		GlobalCommunitesPage.leaveCommunityWithoutDate(data.get("communityName"));
		Dashboard_Page = Dashboard_Page.navigateToMyDashBoard();
		String T3 = Dashboard_Page.totalCommunitiesCount();
		AssertionHelper.verifyText(T1, T3);	
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
