package com.cpcommunity.Groups;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageGroupsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyEcosystemPage;
import com.cpcommunity.PageObjects.MyGroupsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1027_Verify_Proper_LeaveErrorMessage_DisplayedTo_OnlyGroupAdmin extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1027(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1027", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	MyDashboardPage mydash=myCommunity.gotoMyDashboardPage();
	//MyEcosystemPage myeco=ecosystemp.gotoMyEcosystemPage();
	MyGroupsPage mygroup=mydash.NavigatingToMyGroups();
	//mygroup.checkProperAlertDisplayedWhenOnlyOneAdmin(data.get("communityName"));
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1027 Test Completed");
		
		quit();
		
	}

}
