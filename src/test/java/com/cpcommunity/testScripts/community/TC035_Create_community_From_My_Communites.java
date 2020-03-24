package com.cpcommunity.testScripts.community;
//package com.cpcommunity.testcases;
//
//
//
//import java.util.Hashtable;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.cpcommunity.utilities.Constants;
//import com.cpcommunity.utilities.DataUtil;
//import com.cpcommunity.PageObjects.CreateCommunityPage;
//import com.cpcommunity.PageObjects.HomePage;
//import com.cpcommunity.PageObjects.LoginPage;
//import com.cpcommunity.PageObjects.MyCommunitiesPage;
//import com.cpcommunity.PageObjects.MyDashboardPage;
//import com.cpcommunity.utilities.DataProviders;
//import com.cpcommunity.utilities.ExcelReader;
//
//public class TC035_Create_community_From_My_Communites extends BaseTest {
//
//	
//	
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void Community(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
//		log.info("Inside Login Test");
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));
//		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
//		LoginPage login = home.clickOnLOGINBtn();
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
//		MyDashboardPage Dashboard_Page = login.loginToApplication(getCurator(), getPassword());
//		MyCommunitiesPage MyCommunitiesPage= Dashboard_Page.NaviagtingToMyCommunities();
//		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
//		CreateCommunityPage.CreateCommunity(data.get("Name"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"));
//		
//		//Assert.fail("Failing the login test");
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		
//		logInfo("Login Test Completed");
//		
//		quit();
//		
//	}
//
//}
