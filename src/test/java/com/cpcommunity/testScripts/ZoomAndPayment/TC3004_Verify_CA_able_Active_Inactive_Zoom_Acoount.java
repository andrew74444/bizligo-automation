package com.cpcommunity.testScripts.ZoomAndPayment;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MeetingAccountsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC3004_Verify_CA_able_Active_Inactive_Zoom_Acoount extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC3004(Hashtable<String,String> data ) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3004", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));	
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		
	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboard = myCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		MeetingAccountsPage MAP=communityDashboard.navigateToMeetingAccounts();
	//	MAP.inActivateZoom();
		MAP.activateZoom();
		
		Yahoo yahoo= new Yahoo().open();
	//	yahoo.Login(data.get("email1"), data.get("password1"));//CA created community mail checking purpose
		yahoo.Login(data.get("email2"), data.get("password2"));//other CA mail checking purpose
		
	//	yahoo.meetingAccountInActive();//when account is InActivated checking mail purpose
		yahoo.meetingAccountActive();//when account is Activated checking mail purpose
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC3004 Test Completed");
		
		quit();
		}
		 
}


