package com.cpcommunity.PageObjects;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class TotalRevenueReport extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Total Revenue Report']")
	WebElement pageTitle;
	@FindBy(xpath = "//div[@class='col-sm-6 col-md-6']")
	WebElement adRevenue;

    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
		WebElement advertisements;
	    @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
		WebElement manage;
	    @FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
		WebElement managePlans;

	

	
	public int checkTotalRevenuebasedOnTimePeriod() throws InterruptedException {
		
		Thread.sleep(8000);
		//String amt=adRevenue.getText();
		//System.out.println(amt);
		String i=	getSystemCurrentMonth();
		System.out.println(i);
		 WebElement revenue=driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[5]"));
	      String r= revenue.getText();
	      int iTest = Integer.parseInt(r);
	      System.out.println("Revenue is: " + r);
	     
	      return iTest;
	      
	}
	public void Comparerevenue(int previousrev,int afterrev){
		if(previousrev<=afterrev) {
			Assert.assertTrue(true);
		}
	}   
	
	 public ManageAdPlansPage goToManageAdPlansPage() {

	 		this.clickOnAdvertisments();
	 		waitForElementToPresent(managePlans);
	 		click(managePlans, "Manage Plans");
	 		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
	 		// new CommunityPendingRequestsPage(driver);
	 	}
	
	
	 public void clickOnAdvertisments() {
	 		click(advertisements, "advertisements");
	 	}

		
	 	
	}
	
	
	
	

