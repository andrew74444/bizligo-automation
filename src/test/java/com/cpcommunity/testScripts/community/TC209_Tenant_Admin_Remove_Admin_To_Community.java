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

public class TC209_Tenant_Admin_Remove_Admin_To_Community extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC209(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC209", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
		ManageCommunityMembersPage manageCommunityMembersPage =tACommunitiesPage.navigateTomanageMembers(data.get("communityName"));
		manageCommunityMembersPage.addmember(data.get("removeAdminEMail"));
		manageCommunityMembersPage.makeAdmin(data.get("removeAdminEMail"));
		manageCommunityMembersPage.removeAdmin(data.get("removeAdminEMail"));
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC209 Test Completed");
		
		quit();
		
	}

}
