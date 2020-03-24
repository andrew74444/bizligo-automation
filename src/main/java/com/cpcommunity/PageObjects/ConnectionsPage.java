package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ConnectionsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@FindBy(xpath="(//*[@class='panel-title pull-right ng-binding'])[2]")
	WebElement NewRequests;
	
	
	@FindBy(xpath="//h1[contains(text(),'My Connections')]")
	WebElement MyConnectionsTitle;	

	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(MyConnectionsTitle);
	}

	 public void AcceptConnectionRequest(String SenderMemberName) throws InterruptedException
	    {
	    	waitForElementToPresent(MyConnectionsTitle);
	    	String TotalRequestsMessage = NewRequests.getText();
	    	String[]  TRS = TotalRequestsMessage.split("\\s");
	    	int TotalRequests=Integer.parseInt(TRS[0]);    	
	    	for(int i=1;i<=TotalRequests;i++)
	    	{
	    		String MemberName = driver.findElement(By.xpath("(//*[@class='ng-binding'])["+i+"]")).getText();
	        	if(MemberName.equalsIgnoreCase(SenderMemberName))
	        	{
	        		driver.findElement(By.xpath("(//*[contains(text(),'Accept')])["+i+"]")).click();
	        	}	        	
	        	else {
	        		AssertionHelper.markFail();
	        	}
	        	}      	
	        }
	    public void RejectConnectionRequest(String SenderMemberName ) throws InterruptedException
	    {
	    	waitForElementToPresent(MyConnectionsTitle);
	    	String TotalRequestsMessage = NewRequests.getText();
	    	String[]  TRS = TotalRequestsMessage.split("\\s");
	    	int TotalRequests=Integer.parseInt(TRS[0]);   	
	    	for(int i=1;i<=TotalRequests;i++)
	    	{  		                                                                                                          
	    		String MemberName = driver.findElement(By.xpath("(//*[@class='ng-binding'])["+i+"]")).getText();
	    		if(MemberName.equalsIgnoreCase(SenderMemberName))
	    		{
	    			driver.findElement(By.xpath("(//*[contains(text(),'Reject')])["+i+"]")).click();
	    		}
	    	}     
	    	Thread.sleep(3000);
	    	waitForElementToPresent(MyConnectionsTitle);
	    	
	    	try {
	    		for(int i=1;i<=TotalRequests;i++)
	        	{  		                                                                                                          
	        		String MemberName = driver.findElement(By.xpath("(//*[@class='ng-binding'])["+i+"]")).getText();
	        		if(MemberName.equalsIgnoreCase(SenderMemberName))
	        		{
	        			AssertionHelper.markFail();
	        		}
	        	}
			} catch (Exception e) {
				AssertionHelper.markPass();
			}
	    	
	    	
	    }
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
