package com.cpcommunity.testScripts.EmailTemplates;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EmailTemplatePage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunityMembersPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1117_Verify_mailTrigger_toMember_ifCA_added_sameMember_in_CC_BCC extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1117(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1117", data.get("Runmode"), excel);
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
	//emailtemplate.SameCCandBCC(data.get("Template"),data.get("Footer"), data.get("Subject"),data.get("Header"), data.get("Email"),data.get("bcc"),data.get("cc"));
	emailtemplate.SameCCandBCC(data.get("bcc"),data.get("cc"));
	
	
	ManageCommunityMembersPage ManageCommunityMembersPage = communityDashboard.navigateToManageCommunityMembers();
	ManageCommunityMembersPage.ManageMembers(data.get("email1"));//in this method admin can make or remove admin  and also member
	
	Yahoo yahoo= new Yahoo().open();

	yahoo.Login(data.get("email2"), data.get("password2"));

	yahoo.removedFromCommunity();//in bcc and cc list member mail ckecking
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1117 Test Completed");
		
		quit();
		
	}
}
