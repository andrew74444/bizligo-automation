package com.cpcommunity.testScripts.community;

import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

//commnting code

public class TC1500_Verify_Posting_Discussions_In_Community extends BaseTest

{

@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
public void TC1500(Hashtable<String,String> data) throws Throwable {

ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
DataUtil.checkExecution("master", "TC1500", data.get("Runmode"), excel);
log.info("Inside Login Test");
openBrowser(data.get("browser"));
logInfo("Launched Browser : "+ data.get("browser"));
logInfo("BizLigo Application Opened");
HomePage home = new HomePage().open(data.get("tenantType"));
LoginPage login = home.clickOnLOGINBtn();
EcoSystemPage ecosystem = login.loginToApplication(data.get("email"),data.get("password"));
GlobalCommunitesPage GL = ecosystem.goToGlobalCommunities();
CommunityDetailsPage communityDetails = GL.navigateToCommunityDetailsPage(data.get("communityName"));
communityDetails.postDiscussions(data.get("discussionTitle"),data.get("postContent"), data.get("tagMembers"));

}

@AfterMethod
public void tearDown() {

logInfo("TC1500 Test Completed");

quit();

}

}