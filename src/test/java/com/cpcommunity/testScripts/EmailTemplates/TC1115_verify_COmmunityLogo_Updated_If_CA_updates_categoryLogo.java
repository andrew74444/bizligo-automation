package com.cpcommunity.testScripts.EmailTemplates;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1115_verify_COmmunityLogo_Updated_If_CA_updates_categoryLogo extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1115(Hashtable<String,String> data) throws Exception {
		
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1115", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	ManageCommunityPage managecomm=communityDashboard.goToManagecommunityPage();
	managecomm.editCommunityLogo(data.get("about"),data.get("updatecommunity"),data.get("termandcond"),data.get("logoImagePath"));
	quit();
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	 MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));
	 GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	 GCP.searchCommunity(data.get("community"));
	 quit();
	 openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		LoginPage login2 = home2.clickOnLOGINBtn();
		MyCommunitiesPage myCommunity2 = login2.loginToMyCommunitiesPage(data.get("email2"), data.get("password2"));
		CommunityDashboardPage communityDashboard2 = myCommunity2.gotoManageCommunity(data.get("communityName"));
		ManageCommunityPage managecomm2=communityDashboard2.goToManagecommunityPage();
		managecomm2.editCommunityLogo(data.get("about2"),data.get("updatecommunity2"),data.get("termandcond2"),data.get("logoImagePath2"));
	}
}
