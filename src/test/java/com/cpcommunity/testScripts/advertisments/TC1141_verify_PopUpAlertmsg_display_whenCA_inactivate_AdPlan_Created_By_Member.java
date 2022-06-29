package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyAdvertisements;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.UpdateADPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1141_verify_PopUpAlertmsg_display_whenCA_inactivate_AdPlan_Created_By_Member extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1141(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1141", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
//
	 EcoSystemPage EcoSystemPage1 = login.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GCP = EcoSystemPage1.goToGlobalCommunities();
		 GCP.searchCommunity(data.get("community"));
		 GCP.goTocommunityPage(data.get("community"));
	 SelectPlanPage SPP= GCP.navigatetoselectPlanPage();
	 SPP.selectPlan(data.get("planName"),data.get("AdName"),data.get("path"));
 

	HomePage home1 = new HomePage().open(data.get("tenantType"));
	home1.logout();
	LoginPage login1 = home1.clickOnLOGINBtn();
	EcoSystemPage EcoSystemPage = login1.loginToApplication(data.get("email1"), data.get("password1"));
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
	CommunityDashboardPage communityDashboard = MyCommunitiesPage.gotoManageCommunity(data.get("community"));
	 ManageAdPlansPage MApP=communityDashboard.goToManageAdPlansPage();
	 MApP.Inactivate(data.get("plan"));
	
	 HomePage home2 = new HomePage().open(data.get("tenantType"));	
	 home2.logout();
	 LoginPage login2 = home2.clickOnLOGINBtn();

	 EcoSystemPage EcoSystemPage2 = login2.loginToApplication(data.get("email"), data.get("password"));	
		 MyAdvertisements Map=EcoSystemPage2.NaviagtingToMyAdvertisements();
	 Map.searchplan(data.get("planName1"));
	 Map.checkIsplanInactive(); 
	 

		HomePage home3= new HomePage().open(data.get("tenantType"));
		home3.logout();
		LoginPage login3 = home3.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage3 = login3.loginToApplication(data.get("email1"), data.get("password1"));
		MyCommunitiesPage MyCommunitiesPage3 = EcoSystemPage3.goToMyCommunities();
		CommunityDashboardPage communityDashboard3 = MyCommunitiesPage3.gotoManageCommunity(data.get("community"));
		ManageAdPlansPage MApP3=communityDashboard3.goToManageAdPlansPage();
		 MApP3.Activate(data.get("plan3"));
	//	 quit();
	}
	
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1141 Test Completed");
		
		quit();
}
}
