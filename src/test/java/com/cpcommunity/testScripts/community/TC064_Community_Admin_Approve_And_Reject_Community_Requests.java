package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC064_Community_Admin_Approve_And_Reject_Community_Requests extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC064(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC064", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		CommunityPendingRequestsPage CommunityPendingRequestsPage = CommunityDashboardPage.navigateToPendingRequests();
	//	CommunityPendingRequestsPage.approveMember(data.get("email3"));
		
		CommunityPendingRequestsPage.rejectMember(data.get("email3"), data.get("rejectReason"));
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email3"), data.get("password3"));
	//	yahoo.appovedByCA();//when ca approved member checking mail
		yahoo.notAppovedByCA();//when ca not approved member checking mail
		
		
	
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC064 Test Completed");
		
		quit();
		
	}

}
