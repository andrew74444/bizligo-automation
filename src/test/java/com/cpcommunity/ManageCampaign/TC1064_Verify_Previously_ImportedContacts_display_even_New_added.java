package com.cpcommunity.ManageCampaign;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.ComposeCampaign;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.ImportContactsPage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

import junit.framework.Assert;

public class TC1064_Verify_Previously_ImportedContacts_display_even_New_added extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1064(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1064", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	ComposeCampaign CC=communityDashboard.navigateToComposeCampaignPage();
    CC.CheckMember(data.get("importedContacts"),data.get("Member"));
    ImportContactsPage ICP=CC.navigateToImportContactsPagePage();
    ICP.uploadFile(data.get("Filepath"));
    ComposeCampaign CC1=ICP.navigateToComposeCampaignPage();
    CC1.VerifyAddedContacts(data.get("importedContacts"), data.get("Email2"));

	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1064 Test Completed");
		
		quit();
		
	}
}
