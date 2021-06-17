package com.cpcommunity.testMemberDirectory;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1031_Verify_MemberDirectoryPage extends BaseTest{
	public class TC1031_Verify_ProgressBar_NotDisplaying_WhenViewing_BissinessDirectory extends BaseTest {
		@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
		public void TC1031(Hashtable<String,String> data) throws Exception {
	 
			ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
			DataUtil.checkExecution("master", "TC1013", data.get("Runmode"), excel);
			log.info("Inside Login Test");			
			openBrowser(data.get("browser"));
			logInfo("Launched Browser : "+ data.get("browser"));		
			logInfo("BizLigo Application Opened");
			HomePage home = new HomePage().open(data.get("tenantType"));
			LoginPage login = home.clickOnLOGINBtn();
			MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
			//BusinessDirectoryPage bussinessdirectory= myCommunity.gotoBusinessDirectoryPage();
			MemberDirectoryPage memberdirectory= myCommunity.gotoMemberDirectoryPage();
			memberdirectory.searchFields(data.get("MemberName"), data.get("location"), data.get("ProfileCategory"), data.get("SkillAndInterest"), data.get("OrganisationName"), data.get("Communities"), data.get("BusinessCategory"), data.get("Groups"));
			
			
			
		}			
}
}