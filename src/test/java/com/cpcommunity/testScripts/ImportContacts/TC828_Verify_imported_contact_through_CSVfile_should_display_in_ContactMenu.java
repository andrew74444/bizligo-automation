package com.cpcommunity.testScripts.ImportContacts;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.ComposeCampaignPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.ImportContactsPage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC828_Verify_imported_contact_through_CSVfile_should_display_in_ContactMenu extends BaseTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC828(Hashtable<String,String> data) throws Exception {

	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC828", data.get("Runmode"), excel);
	log.info("Inside Login Test");
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage MyCP = login.loginToApplicationMcp(data.get("email"), data.get("password"));
	CommunityDashboardPage CDP= MyCP.gotoManageCommunity(data.get("communityName"));
	ImportContactsPage ICP=CDP.NavigatetoImportContactsPage();
	ICP.csvFileWithDuplicateRecords(data.get("path"));
	ComposeCampaignPage CCP=ICP.NavigatetoComposeCampaignPage();
	CCP.checkImportContacts(data.get("Community"),data.get("typeName"));
}

}
