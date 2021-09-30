package com.cpcommunity.Endorsments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EndorsementPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.ProfilePage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC751_Verify_rejected_endorsements_notlisted_if_rejected_by_member extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC751(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC751", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyCommunitiesPage MyCP = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
		MemberDirectoryPage MDP=MyCP.gotoMemberDirectoryPage();
		ProfilePage PP=MDP.MemberWithRejectedEndorsement(data.get("Name"));
		PP.AddEndorsement(data.get("EndorsementMessage"));
		quit();
	try {
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		EcoSystemPage ESP = login1.loginToApplication(data.get("email1"), data.get("password1"));
		EndorsementPage EP=ESP.NaviagtingToMyEndorsements();
		EP.Reject();
		close();
	}catch(Exception e) {
	}
		/*MemberDirect oryPage MDP1=PP.gotoMemberDirectoryPage();
		 PP=MDP1.MemberWithRejectedEndorsement(data.get("Name"));
		//PP.AddEndorsement(data.get("EndorsementMessage"));
		navigateToRefresh();*/
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC751 Test Completed");
		
		quit();
		
	}	

}

