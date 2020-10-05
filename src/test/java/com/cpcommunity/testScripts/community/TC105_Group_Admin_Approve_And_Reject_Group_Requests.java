package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
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

		
		
		EcoSystemPage	EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage  = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		ManageGroupMembersPageByGroupAdmin manageGroupMembersPageByGroupAdmin = CommunityDetailsPage.navigateToManageGroupMembers(data.get("groupName")); 
		String email1 = manageGroupMembersPageByGroupAdmin.getMember1();
		String email2 = manageGroupMembersPageByGroupAdmin.getMember2();
		
		home = EcoSystemPage.logout();
		home.clickOnLOGINBtn();
		
		
		 EcoSystemPage = login.loginToApplication(email1, data.get("password"));
		
		 MyCommunitiesPage  = EcoSystemPage.goToMyCommunities();
		 CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.JoinGroups(data.get("groupName"));
		Thread.sleep(6000);
		EcoSystemPage.logout();
		
		
		
		home.clickOnLOGINBtn();		
		EcoSystemPage = login.loginToApplication(email2, data.get("password"));
		
		MyCommunitiesPage  = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.JoinGroups(data.get("groupName"));
		Thread.sleep(6000);
		EcoSystemPage.logout();
		
		
		home.clickOnLOGINBtn();		
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage  = EcoSystemPage.goToMyCommunities();
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
