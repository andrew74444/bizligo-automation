package com.cpcommunity.testScripts.Endorsments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalMembersPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyProfilePage;
import com.cpcommunity.PageObjects.ProfilePage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1041_Verify_Member_ableTo_Endorse_OtherMember extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1041(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1041", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
//		//BusinessDirectoryPage bussinessdirectory= myCommunity.gotoBusinessDirectoryPage();
//		MemberDirectoryPage memberdirectory= myCommunity.gotoMemberDirectoryPage();
//		memberdirectory.clickOnsearchByName(data.get("Name"));
//		ProfilePage profilep = memberdirectory.goToProfilePage();
//		profilep.AddEndorsement(data.get("Endorsement"),data.get("Endorsement2"),data.get("Endorsement3"),data.get("Endorsement4"));
	
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		GlobalMembersPage GlobalMembersPage = EcoSystemPage.goToMembersPage();
	
		ProfilePage page=	GlobalMembersPage.NavigateToMemberProfile(data.get("Name"));
		
		page.AddEndorsement(data.get("Endorsement"));
		
		
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email1"), data.get("password1"));
		yahoo.endorsementVerfication();
	}
	//@AfterMethod
	//public void tearDown() {
		
	//	logInfo("TC1041 Test Completed");
		
	//	quit();
		
	//}
}
