package com.cpcommunity.Endorsments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.ProfilePage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC750_Verify_approval_pending_endorsements_not_listed_in_memberprofile extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC750(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC750", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyCommunitiesPage MyCP = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
		MemberDirectoryPage MDP=MyCP.gotoMemberDirectoryPage();
		ProfilePage PP=MDP.MemberWithPendingEndorsement(data.get("Name"));
	    PP.IsEndoremsnetNotDisplayed(data.get("EndorsementMessage"));

}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC750 Test Completed");
		
		quit();
		
	}
}
