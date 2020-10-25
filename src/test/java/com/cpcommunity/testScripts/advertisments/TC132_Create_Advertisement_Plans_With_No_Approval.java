package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;


public class TC132_Create_Advertisement_Plans_With_No_Approval extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC132(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC132", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime =openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
				
		MyCommunitiesPage myCommunitiesPage=EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageAdPlansPage manageAdPlansPage =communityDashboardPage.goToManageAdPlansPage();
		manageAdPlansPage.createAdPlan(data.get("name1"), data.get("price"), data.get("planDetails"), data.get("duration"), data.get("durationType"), data.get("adLocation1"), data.get("adType"),data.get("approvalType"));
		Thread.sleep(5000);
		manageAdPlansPage.createAdPlan(data.get("name2"), data.get("price"), data.get("planDetails"), data.get("duration"), data.get("durationType"), data.get("adLocation2"), data.get("adType"),data.get("approvalType"));

	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
