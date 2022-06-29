package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MembershipPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC3015_Verify_Member_Able_To_Change_Membership_Plan extends BaseTest {


	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC3015(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3015", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage communityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
				
		MembershipPlansPage membershipPlansPage = communityDetailsPage.changeMemberShipPlan();
		membershipPlansPage.changeFreeMembershipPlan(data.get("membershipPlan"));
		
	
	
		
		//***********To check member mail*******************************//	
	      Yahoo yahoo= new Yahoo().open();
	      
			yahoo.Login(data.get("email2"), data.get("password2"));//member
			yahoo.membershipPlanChangedMail();
			
			
	//***********To check community admin mail*******************************//	
//			yahoo.openAndGoToNewTab();
//			Yahoo yahoo1= new Yahoo().open();
//			yahoo1.Login(data.get("email3"), data.get("password3"));//community admin
//			yahoo1.membershipPlanChangedMailToCA();
//		
			
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC3015 Test Completed");

		quit();

	}



}
