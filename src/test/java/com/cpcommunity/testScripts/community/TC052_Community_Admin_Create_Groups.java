package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC052_Community_Admin_Create_Groups extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC052(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC052", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		System.out.println(getAndrew());
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();		
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageGroupsPage ManageGroupsPage = CommunityDashboardPage.navigateToManageGroupsPage();
		Create_UpdateGroupPage Create_UpdateGroupPage = ManageGroupsPage.clickOnCreateBtn();
		ManageGroupsPage = Create_UpdateGroupPage.createGroup(data.get("Name"), data.get("Description"), data.get("CityName"), data.get("StateName"), data.get("CategoryName"), data.get("GroupTypeName"),data.get("ImagePath"));
//		Create_UpdateGroupPage = ManageGroupsPage.clickOnCreateBtn();
//		ManageGroupsPage = Create_UpdateGroupPage.createGroup(data.get("privateGroupName"), data.get("privateGroupDescription"), data.get("privateCityName"), data.get("privateStateName"), data.get("privateCategoryName"), data.get("privateGroupTypeName"),data.get("privateImagePath"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC052 Test Completed");
		
		quit();
		
	}

}
