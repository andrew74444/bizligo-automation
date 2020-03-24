package com.cpcommunity.testScripts.Groups;



import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC188_Verify_InActive_Group_Is_Accessible_To_Members extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC188(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC188", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyGroupsPage MyGroupsPage = myDashboardPage.NavigatingToMyGroups();
		MyGroupsPage.goToInActivegroup(data.get("groupName"));		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
