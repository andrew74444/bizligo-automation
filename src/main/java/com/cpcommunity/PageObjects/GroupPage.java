package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GroupPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Groups);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
	}
	@FindBy(xpath = "//strong[normalize-space()='Groups']")
    WebElement Groups;
	@FindBy(xpath = "//div[@class='col-lg-12 user-menu']")
    WebElement header;
	@FindBy(xpath = "//input[@placeholder='Search by Groups']")
	WebElement searchgroup;
	@FindBy(xpath="//span[@ng-bind='group.GroupName']")
	WebElement bizligogroup;
	@FindBy(xpath = "//a[@class='btn btn-default top-btn1 btn-sm dropdown-toggle']")
	WebElement Toggledropdownmenu;
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	@FindBy(xpath = "//div[@class='row text-center my-eco-page']//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//button[2]")
	WebElement MANAGE;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchbtn;
	@FindBy(xpath = "//a[@class='edit-page ng-scope']")
	WebElement manageBtn;
	@FindBy(xpath = "//span[@ng-if='data.TrendingGroupsWidgetConfigured.CommunityWidgetEditedName.length == 0']")
	List<WebElement> trendinggroup;
	@FindBy(xpath = "//span[@ng-if='data.IsAdvertisementsWidgetConfigured.CommunityWidgetEditedName.length == 0']")
	List<WebElement> advertisement;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	WebElement TrendingGroup;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]/strong[1]/span[1]")
	WebElement Advertisement;
	
	
	
	 public void searchGroup(String groupName) throws Exception{
		 searchgroup.clear();
	    	log.info(groupName);
	    	type( searchgroup, groupName,"Search by Group Name");
	    	click(searchbtn,"search btn");
	    	Thread.sleep(6000); 
	    	
	    }
	    
	    public void verifyGroupNamechange() {
			waitForElementToPresent(bizligogroup);
			String changed=this.bizligogroup.getText();
			String expected="GroupBizligo";
			System.out.println(changed);
	        Assert.assertEquals(changed, expected);		
			
		}
	    
	    public CommunityDashboardPage gotocommunitydashPage() throws Exception {
	    	Thread.sleep(5000);
			waitForElementToPresent(Toggledropdownmenu);
			click(Toggledropdownmenu,"Toggledropdownmenu");
			Thread.sleep(500);
			waitForElementToPresent(ecosystem);
			click(ecosystem,"Ecosystem");
			Thread.sleep(15000);
			click(MANAGE, "Manage");
			return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		}	
	    public void VerifyTrendingGroupNotDisplaying() throws InterruptedException {
			Thread.sleep(500);
			Assert.assertEquals(0, trendinggroup.size());
			System.out.println("Trending groups is Not Displaying");
			
		}
	    public void VerifyAdNotDisplaying() throws InterruptedException {
			Thread.sleep(500);
			Assert.assertEquals(0, advertisement.size());
			System.out.println("Advertisement is Not Displaying");
			
		}
		
		public ManageCommunityPage gotoDashboardpage() {
			waitForElementToPresent(manageBtn);
			click(manageBtn, "Manage Button");
			return (ManageCommunityPage) openPage(ManageCommunityPage.class);		
		}
	
		public void verifyGroupnameChanged() throws InterruptedException {
			waitForElementToPresent(TrendingGroup);
			String changeevent=this.TrendingGroup.getText();
			System.out.println(changeevent);
		    String Expected="LATEST GROUP";
		   Assert.assertEquals(changeevent, Expected); 
		}
		
		public void verifyAdtitleChanged() throws InterruptedException {
			waitForElementToPresent(Advertisement);
			String changead=this.Advertisement.getText();
			System.out.println(changead);
		    String Expected="LATEST ADS";
		    Assert.assertEquals(changead, Expected);
		    
		}
		
}
