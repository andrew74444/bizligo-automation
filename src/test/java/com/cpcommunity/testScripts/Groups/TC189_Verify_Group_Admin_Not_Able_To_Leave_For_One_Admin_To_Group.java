package com.cpcommunity.testScripts.Groups;



import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC189_Verify_Group_Admin_Not_Able_To_Leave_For_One_Admin_To_Group extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC058(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC189", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyGroupsPage MyGroupsPage = EcoSystemPage.goToMyGroups();
		ManageGroupMembersPageByGroupAdmin ManageGroupMembersPageByGroupAdmin = MyGroupsPage.manageGroupMembers(data.get("groupName"));
		ManageGroupMembersPageByGroupAdmin.checkMakeAnotherMemberAsAdmin(data.get("email"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC189 Test Completed");
		
		quit();
		
	}

}
