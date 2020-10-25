package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC162_Verify_Member_Able_To_Access_Manage_Community_When_The_CA_Role_Is_Assigned extends BaseTest {

		
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC162(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC162", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageCommunityMembersPage ManageCommunityMembersPage = CommunityDashboardPage.navigateToManageCommunityMembers();
		ManageCommunityMembersPage.addmember(data.get("email1"));
		ManageCommunityMembersPage.makeAdmin(data.get("email1"));
		Thread.sleep(2000);
		home = CommunityDashboardPage.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email1"), data.get("password"));
		
		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		MyCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC162 Test Completed");
		
		quit();
		
	}

}
