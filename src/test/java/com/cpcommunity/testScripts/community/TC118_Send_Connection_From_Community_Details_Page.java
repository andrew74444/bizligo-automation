package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC118_Send_Connection_From_Community_Details_Page extends BaseTest {

	String TCID="TC118";
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC118(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC118", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPageWithoutDate(data.get("communityName"));
	//	CommunityDetailsPage.sendconnection();//commented on 06/05

		CommunityDetailsPage.sendconnection(data.get("name"));//added on 06/05
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC118 Test Completed");
		
		quit();
		
	}

}
