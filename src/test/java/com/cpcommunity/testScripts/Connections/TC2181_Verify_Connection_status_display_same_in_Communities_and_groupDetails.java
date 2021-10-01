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

public class TC2181_Verify_Connection_status_display_same_in_Communities_and_groupDetails extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2181(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2181", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage MDP= login.loginToMemberdashboard(data.get("email"), data.get("password"));
		Bizligo1CommunityPage BCP=MDP.goToMyCommunity();
		BCP.checkConnectionStatus(data.get("Name"));
		

}
}