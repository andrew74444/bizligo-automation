package com.cpcommunity.testScripts.advertisments;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC133_Create_Advertisement_Plans_With_Required_Approval extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC133(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC133", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
			
		MyCommunitiesPage myCommunitiesPage=EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageAdPlansPage manageAdPlansPage =communityDashboardPage.goToManageAdPlansPage();
		manageAdPlansPage.createAdPlan(data.get("name1"), data.get("price"), data.get("planDetails"), data.get("duration"), data.get("durationType"), data.get("adLocation1"), data.get("adType"), data.get("approvalType"));
		Thread.sleep(5000);
		manageAdPlansPage.createAdPlan(data.get("name2"), data.get("price"), data.get("planDetails"), data.get("duration"), data.get("durationType"), data.get("adLocation2"), data.get("adType"), data.get("approvalType"));
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
