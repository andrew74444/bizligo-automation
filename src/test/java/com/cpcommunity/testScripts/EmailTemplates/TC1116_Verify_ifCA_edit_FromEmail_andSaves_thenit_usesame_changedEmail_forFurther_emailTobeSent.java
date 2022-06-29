package com.cpcommunity.testScripts.EmailTemplates;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EmailTemplatePage;
import com.cpcommunity.PageObjects.GroupsPendingRequestsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1116_Verify_ifCA_edit_FromEmail_andSaves_thenit_usesame_changedEmail_forFurther_emailTobeSent extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1116(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1116", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
	//MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));	
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
	CommunityDashboardPage communityDashboard = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
	EmailTemplatePage emailtemplate=communityDashboard.navigateToEmailTemplate();
	emailtemplate.changeFromEmail(data.get("Template"),data.get("Footer"), data.get("Subject"),data.get("Header"), data.get("Email"),data.get("bcc"));
//	emailtemplate.openGuerillamail(data.get("email1"));
	home=emailtemplate.logout();
	home.clickOnLOGINBtn();
	EcoSystemPage EcoSystemPage1 = login.loginToApplication(data.get("email1"), data.get("password"));
	MyCommunitiesPage MyCommunitiesPage1 = EcoSystemPage1.goToMyCommunities();
	CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage1.navigateToCommunityDetailsPage(data.get("communityName"));//+" "+runTime
	CommunityDetailsPage.PrivateGroupJoinedSuccessfully(data.get("groupName"));
	home = CommunityDetailsPage.logout();	
	
	
	home.clickOnLOGINBtn();
	EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
	MyCommunitiesPage = EcoSystemPage.goToMyCommunities();		
	CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));//+" "+runTime		
	GroupsPendingRequestsPage GroupsPendingRequestsPage = CommunityDashboardPage.NavigateToCommunitygroupPendingRequets();
	GroupsPendingRequestsPage.rejectMember(data.get("email1"), data.get("rejectReason"));//Rejected
	
	
	Yahoo yahoo= new Yahoo().open();
	yahoo.Login(data.get("email1"), data.get("password2"));
	yahoo.checkingFromEmailAddress();//when CA Rejected group request member receiving mail checking purpose
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1116 Test Completed");
		
		quit();
}
}