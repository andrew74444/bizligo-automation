package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1134_Verify_CA_ableto_create_adPlans_With_sameName_InAnotherCommunity extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1134(Hashtable<String,String> data) throws Exception {
		
	//change plan name before running code
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1134", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	login.login(data.get("email"), data.get("password"));
	Bizligo1CommunityPage biz=login.goToMyCommunity(data.get("communityName"));
	ManageAdPlansPage MAPP=biz.gotoManageAdsplan();
	MAPP.createAdPlan(data.get("name"),data.get("price"), data.get("planDetails"),data.get("duration"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
	//MAPP.inactivatePlan(data.get("plan"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1134 Test Completed");
		
		quit();
		
	}
}
