package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC178_Payment_Pending_Is_Displayed_For_Adding_A_Member_By_CA extends BaseTest {

			
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",enabled=true)
	public void TC178(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC178", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		ManageCommunityMembersPage manageCommunityMembersPage = communityDashboardPage.navigateToManageCommunityMembers();
		manageCommunityMembersPage.addmember(data.get("email1"));
		Thread.sleep(6000);
		communityDashboardPage.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage = EcoSystemPage.NaviagtingToMyCommunities();
		MyCommunitiesPage.verifyPaymentPendindDisplayed(data.get("communityName"));
		CommunityDetailsPage communityDetailsPage= MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		communityDetailsPage.verifyPaymentPendingDisplayed();
		
		
		
		
		
		//Assert.fail("Failing the login test");
	}


	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
