package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class Create_Category extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC193(Hashtable<String,String> data) throws Exception
	{

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC193", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginpage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginpage.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage mycommunities = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = mycommunities.gotoManageCommunity(data.get("communityName"));
		CategoriesPage categoriesPage = communityDashboardPage.gotoCategories();
		categoriesPage.createCategorie(data);

		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
