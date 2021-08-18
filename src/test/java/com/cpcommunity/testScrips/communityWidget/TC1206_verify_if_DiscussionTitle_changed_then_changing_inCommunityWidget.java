package com.cpcommunity.testScrips.communityWidget;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.Discussions;
import com.cpcommunity.PageObjects.GroupPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityPage;
import com.cpcommunity.PageObjects.ManageCommunityWidgets;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1206_verify_if_DiscussionTitle_changed_then_changing_inCommunityWidget extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1206(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1206", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	ManageCommunityWidgets managewidget=communityDashboard.navigateTomanageWidget();
	managewidget.RenameDiscussionWidget(data.get("disc"));
	Discussions D=managewidget.navigateToDiscussionPage();
	D.verifyDiscussiontitleChanged();
	ManageCommunityPage MC=D.gotoDashboardpage();
	ManageCommunityWidgets communitywidget=MC.navigateTomanageWidget();
	communitywidget.RenameDiscussionWidget(data.get("disc1"));
	
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1199 Test Completed");
		
		quit();
		
	}
}
