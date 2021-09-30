package com.cpcommunity.ManageCampaign;

import com.cpcommunity.testScripts.community.BaseTest;

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


public class TC826_Verify_error_message_with_rowId_if_CSVfile_uploaded_with_emptyEmailrecords extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC826(Hashtable<String,String> data) throws Exception {

	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC826", data.get("Runmode"), excel);
	log.info("Inside Login Test");
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	ImportContactsPage importcontact=communityDashboard.navigateToImportContactsPage();
	importcontact.errorMsgWhenEmptyEmailRecords(data.get("path"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC826 Test Completed");
		
		quit();
		
	}
}


