
package com.cpcommunity.testScripts.myprofiletestcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyProfilePage;
import com.cpcommunity.PageObjects.ProfessionalServicesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC315_Verify_whether_an_message_is_displaying_in_Professional_matches_page_after_removing_organization_services_you_offer_and_need extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC315(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC315", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		MyDashboardPage dashboard = login.loginToMemberdashboard(data.get("email"), data.get("password"));
		MyProfilePage profile = dashboard.NaviagtingToMyProfilePage();
		profile.professionalMatchesPage();
		profile.removingProfessionalMatches(data.get("actualServices"), data.get("actualInterested"));
		GlobalCommunitesPage globalcommunities= profile.NavigateToGlobalcommunities();
		CommunityDetailsPage detailspage = globalcommunities.navigateToCommunityDetailsPage(data.get("communityName"));
		detailspage.memberDetailsPage(data.get("memberSearch"),data.get("actualServices") , data.get("actualInterested"));
		
		
		
	
		
		
		
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
