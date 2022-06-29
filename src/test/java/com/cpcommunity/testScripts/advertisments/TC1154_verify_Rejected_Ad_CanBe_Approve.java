package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageMemberAdvertisementsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1154_verify_Rejected_Ad_CanBe_Approve extends BaseTest  {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1154(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1154", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
	//MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage1 = login.loginToApplication(data.get("email"), data.get("password"));
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage1.goToMyCommunities();
	CommunityDashboardPage communityDashboard = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
	ManageMemberAdvertisementsPage MMAP= communityDashboard.navigateToMemberAdvertisements();
	MMAP.approveRejectedAd(data.get("plan"), data.get("adImage"),data.get("linkUrl"),data.get("status"));
	
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC154 Test Completed");
		
		quit();
}
}
