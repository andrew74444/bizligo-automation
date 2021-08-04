package com.cpcommunity.testScripts.TA_CreateCommunity;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityMembersPage;
import com.cpcommunity.PageObjects.TACommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC967_Verify_TA_able_add_member_into_community extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC967(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC967", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
		TACommunitiesPage TCP = TDP.navigateToCommunitiesPage();
		ManageCommunityMembersPage MCMP =TCP.navigateToManageMembers(data.get("Name"));
		MCMP.addmemberByTA(data.get("Email"));
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC967 Test Completed");
		
		quit();
		
	}


}