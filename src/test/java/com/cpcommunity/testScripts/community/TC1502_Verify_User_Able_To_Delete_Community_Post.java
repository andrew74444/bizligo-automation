package com.cpcommunity.testScripts.community;

import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.Discussions;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1502_Verify_User_Able_To_Delete_Community_Post extends BaseTest

{

@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
public void TC1502(Hashtable<String,String> data) throws Throwable {

ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
DataUtil.checkExecution("master", "TC1502", data.get("Runmode"), excel);
log.info("Inside Login Test");
openBrowser(data.get("browser"));
logInfo("Launched Browser : "+ data.get("browser"));
logInfo("BizLigo Application Opened");
HomePage home = new HomePage().open(data.get("tenantType"));
LoginPage login = home.clickOnLOGINBtn();
EcoSystemPage ecosystem = login.loginToApplication(data.get("email"),data.get("password"));
GlobalCommunitesPage GL = ecosystem.goToGlobalCommunities();
CommunityDetailsPage communityDetails = GL.navigateToCommunityDetailsPage(data.get("communityName"));
//Discussions Discussions = communityDetails.postDiscussions(data.get("discussionTitle"),data.get("postContent"), data.get("tagMembers"));
Discussions Discussions = communityDetails.searchDiscussions(data.get("discussionTitle"));//added on 09/05
Discussions.deleteCommunitydiscussion();

}

@AfterMethod
public void tearDown() {

logInfo("TC1501 Test Completed");

quit();

}

}