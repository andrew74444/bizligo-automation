package com.cpcommunity.testScripts.Groups;



import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC191_Verify_Back_Button_Is_Redirected_To_Respective_Page_From_Manage_Group_Members_Page extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC191(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC191", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyGroupsPage MyGroupsPage = EcoSystemPage.goToMyGroups();
		ManageGroupMembersPageByGroupAdmin ManageGroupMembersPageByGroupAdmin = MyGroupsPage.manageGroupMembers(data.get("groupName"));
		MyGroupsPage = ManageGroupMembersPageByGroupAdmin.backToMyGroups();
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage =MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		ManageGroupMembersPageByGroupAdmin = CommunityDetailsPage.navigateToManageGroupMembers(data.get("groupName"));
		CommunityDetailsPage = ManageGroupMembersPageByGroupAdmin.backToCommunityDetailsPage();
		EditCommunityPage editCommunityPage= CommunityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage = editCommunityPage.saveCommunity();
		ManageGroupsPage ManageGroupsPage = communityDashboardPage.navigateToManageGroupsPage();
		ManageGroupMembersPage ManageGroupMembersPage =ManageGroupsPage.navigateToManageGroupMembers(data.get("groupName"));
		ManageGroupMembersPage.backToManageGroupsPage();
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC191 Test Completed");
		
		quit();
		
	}

}
