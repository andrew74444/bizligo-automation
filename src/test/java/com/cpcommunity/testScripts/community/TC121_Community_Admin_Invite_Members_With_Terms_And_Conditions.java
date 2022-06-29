package com.cpcommunity.testScripts.community;



import java.net.PasswordAuthentication;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC121_Community_Admin_Invite_Members_With_Terms_And_Conditions extends BaseTest {

	String TCID = "TC121";
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC121(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC121", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));//+" "+runTime
		CommunityInviteMembersPage CommunityInviteMembersPage = CommunityDashboardPage.navigateToinvitePeople();
		CommunityInviteMembersPage.InviteMembers(data.get("email1"),data.get("email2"),data.get("email3"),data.get("email4"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC121 Test Completed");
		
		quit();
		
	}

}
