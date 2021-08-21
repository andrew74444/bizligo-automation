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

public class TC1062_Verify_already_ExistEmail_ifUpdated_with_NewFirstName_get_Updated extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1062(Hashtable<String,String> data) throws Exception {
 //
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1062", data.get("Runmode"), excel);
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
        ImportContactsPage ICP=communityDashboard.navigateToImportContactsPage();
        ICP.uploadFile(data.get("Filepath"));
        ComposeCampaign CC1=ICP.navigateToComposeCampaignPage();
        CC1.VerifyAddedContacts(data.get("importedContacts"), data.get("Email2"));
		
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1062 Test Completed");
		
		quit();
		
	}
}
