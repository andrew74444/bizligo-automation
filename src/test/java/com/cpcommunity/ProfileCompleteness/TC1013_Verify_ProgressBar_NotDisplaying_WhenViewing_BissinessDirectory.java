package com.cpcommunity.ProfileCompleteness;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.BusinessDirectoryPage;
import com.cpcommunity.PageObjects.DirectoryPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyProfilePage;
import com.cpcommunity.PageObjects.ProfilePage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

import junit.framework.Assert;

public class TC1013_Verify_ProgressBar_NotDisplaying_WhenViewing_BissinessDirectory extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1013(Hashtable<String,String> data) throws Exception {
 
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
		memberdirectory.clickOnsearchByName(data.get("memberName"));
		memberdirectory.gotoProfilePage();
		memberdirectory.profileComplenessViibility();
		
		
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC190 Test Completed");
		
		quit();
		
	}


}