package com.cpcommunity.testScripts.Connections;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2184_Verify_what_happens_when_member_reject_connection_request extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2184(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2184", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage MDP= login.loginToMemberdashboard(data.get("email"), data.get("password"));
		Bizligo1CommunityPage BCP=MDP.goToMyCommunity();
		BCP.connectionRequestToMember(data.get("Name"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		home1.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyCommunitiesPage MyCP = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
		MyDashboardPage MDP1=MyCP.gotoMyDashboardPage();
		MDP1.cancelConnectionRequest();
		HomePage home2 = new HomePage().open(data.get("tenantType"));
		home2.logout();
		LoginPage login2 = home2.clickOnLOGINBtn();
		MyDashboardPage MDP2= login2.loginToMemberdashboard(data.get("email"), data.get("password"));
		Bizligo1CommunityPage BCP1=MDP2.goToMyCommunity();
		BCP1.checkStatusWhenMemberCancel(data.get("Name"));
		
		
	       

}
}