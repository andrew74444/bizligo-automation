package com.cpcommunity.testScripts.Connections;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2186_verify_details_except_contact_email_visible_memberCard_when_profile_private extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2180(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2180", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage MDP= login.loginToMemberdashboard(data.get("email"), data.get("password"));
		Bizligo1CommunityPage BCP=MDP.goToMyCommunity();
		BCP.memberIsPrivate(data.get("Name"));
	

}
}
