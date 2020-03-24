package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GroupDetailsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyGroupsPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC105_Group_Admin_Approve_And_Reject_Group_Requests extends BaseTest {	
	
	String TCID="TC105";	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC105(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC105", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email1"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		
		MyCommunitiesPage MyCommunitiesPage  = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.JoinGroups(data.get("groupName"));
		Thread.sleep(6000);
		Dashboard_Page.logout();
		
		
		
		home.clickOnLOGINBtn();		
		EcoSystemPage = login.loginToApplication(data.get("email2"), data.get("password"));
		Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		
		MyCommunitiesPage  = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.JoinGroups(data.get("groupName"));
		Thread.sleep(6000);
		Dashboard_Page.logout();
		
		
		home.clickOnLOGINBtn();		
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage  = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		GroupDetailsPage GroupDetailsPage = CommunityDetailsPage.navigateToGroupDetailsPage(data.get("groupName")); 
		GroupDetailsPage.approveMember();
		GroupDetailsPage.rejectMember();
		Thread.sleep(3000);
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
