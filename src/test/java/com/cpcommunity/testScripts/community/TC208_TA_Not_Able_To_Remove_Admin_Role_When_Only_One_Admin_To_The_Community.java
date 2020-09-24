package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityMembersPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.TACommunitiesPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC208_TA_Not_Able_To_Remove_Admin_Role_When_Only_One_Admin_To_The_Community extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC207(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC207", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
		ManageCommunityMembersPage manageCommunityMembersPage =tACommunitiesPage.navigateTomanageMembers(data.get("communityName"));
		manageCommunityMembersPage.addmember(data.get("makeAdminMemberEmail"));
		manageCommunityMembersPage.makeAdmin(data.get("makeAdminMemberEmail"));
		manageCommunityMembersPage.checkNotAbleToRemoveAdminOnlyOneAdmin(data.get("makeAdminMemberEmail"));
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC205 Test Completed");
		
		quit();
		
	}

}
