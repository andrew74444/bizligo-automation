package com.cpcommunity.testScripts.Blogs;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.BlogsSummary;
import com.cpcommunity.PageObjects.CategoriesPage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1181_Verify_CA_ableTo_Create_Categories extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1181(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1181", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
	
	MyCommunitiesPage mycommunities = EcoSystemPage.goToMyCommunities();
	CommunityDashboardPage communityDashboard = mycommunities.gotoManageCommunity(data.get("communityName"));
	CategoriesPage categories=communityDashboard.gotoCategories();
	BlogsSummary BS=categories.navigateToBlogsSummarypage();
	CategoriesPage C=BS.categorycounts();
	C.checkCancel();
	C.createCategorie(data.get("categoryName"),data.get("Statusis"),data.get("Description"));
	BlogsSummary BS1=C.navigateToBlogsSummarypage();
	CategoriesPage C1=BS1.categorycounts();
	
	
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}	
}
