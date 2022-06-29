package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC047_Community_Admin_Able_To_Manage_Community_Members extends BaseTest {

	String TCID= "TC047";	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC047(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC047", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//	logInfo("Username entered as "+getAndrew()+" and Password entered as "+getPassword());
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		ManageCommunityMembersPage ManageCommunityMembersPage = CommunityDashboardPage.navigateToManageCommunityMembers();
		ManageCommunityMembersPage.ManageMembers(data.get("email1"));//in this method admin can make or remove admin  and also member
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password"));
		
	//	yahoo.adminNow();//when CA make as admin checking mail purpose
	//	yahoo.removedCAdmin();//when CA removed as admin checking mail purpose
		//	yahoo.addedToCommunity();//when CA added to community checking mail purpose
		yahoo.removedFromCommunity();//when CA removed from Community member mail ckecking
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC047 Test Completed");
		
		quit();
		
	}

}
