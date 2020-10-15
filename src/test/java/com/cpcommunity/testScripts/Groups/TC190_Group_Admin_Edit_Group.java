package com.cpcommunity.testScripts.Groups;



import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;

public class TC190_Group_Admin_Edit_Group extends BaseTest {

		
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC190(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC190", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyGroupsPage MyGroupsPage = EcoSystemPage.goToMyGroups();
		Create_UpdateGroupPage Create_UpdateGroupPage=MyGroupsPage.navigateToEditGroupPage(data.get("groupName"));
		Create_UpdateGroupPage.updateGroup(data.get("groupName"), data.get("description"), data.get("city"), data.get("state"), data.get("groupType"), data.get("logoImagePath"),data.get("newGroupName"));
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC190 Test Completed");
		
		quit();
		
	}

}
