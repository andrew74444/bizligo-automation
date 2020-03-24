package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageGroupMembersPageByGroupAdmin;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyGroupsPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC058_Group_Admin_Manage_Group_Members extends BaseTest {

	String TCID= "TC058";	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC058(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC058", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+getAndrew()+" and Password entered as "+getPassword());
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyGroupsPage MyGroupsPage = Dashboard_Page.NavigatingToMyGroups();
		ManageGroupMembersPageByGroupAdmin ManageGroupMembersPageByGroupAdmin = MyGroupsPage.manageGroupMembers(data.get("groupName"));
		ManageGroupMembersPageByGroupAdmin.ManageMembers(data.get("email1"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
