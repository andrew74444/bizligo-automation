package com.cpcommunity.testScripts.Connections;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalMembersPage;
import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2180_Verify_member_able_send_connection_requests_from_Community_and_group extends BaseTest{
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
		BCP.sendConnectionToMember(data.get("Name"));
		
	
//******************************for yahoo mail *********************\\	
	//	Yahoo yahoo= new Yahoo().open();

	//	yahoo.Login(data.get("email1"), data.get("password1"));
	//	yahoo.connectionVerfication();
		
//**************************************for G Mail **************\\
		Gmail gmail= new Gmail().open("https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		gmail.Login(data.get("email2"), data.get("password2"));
		
		gmail.newConnectionMail();
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC2180 Test Completed");
		
		quit();
		
	}
}