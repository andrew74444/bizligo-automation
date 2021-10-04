package com.cpcommunity.testScripts.Connections;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2189_Verify_connection_note_displaying_New_Connection_Requests_of_connection_page extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2189(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2189", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage MDP= login.loginToMemberdashboard(data.get("email"), data.get("password"));
		Bizligo1CommunityPage BCP=MDP.goToMyCommunity();
		BCP.sendingConnectionWithNotes(data.get("Name"),data.get("Notes"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		home1.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyDashboardPage MDP1 = login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));		
		MDP1.checkConnectionMsg(data.get("Notes"));
		MDP1.cancelConnectionRequest();
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		home2.logout();
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC2189 Test Completed");
		
		quit();
		
	}
}