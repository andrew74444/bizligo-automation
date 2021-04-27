package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.log4j.Logger;


public class UpcomingEventsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	@FindBy(xpath = "//input[@id='eventNameSearch']")
	WebElement EventNameSearch;

	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement Search;
	
	@FindBy(xpath="//strong[@ng-bind='Event.EventName'] | //strong[@class='ng-binding']")
	WebElement EventName;
	
	@FindBy(xpath="//div[@class='ng-binding']")
	WebElement EventTime;
	
	@FindBy(xpath="//div[@class='status-btn']")
	WebElement EventType;
	
	@FindBy(xpath="//*[@class='event-venue']")
	WebElement EventVenue;	

		
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Search);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public void searchEvent(Hashtable<String, String> data) throws Exception {
		EventNameSearch.clear();
		type(EventNameSearch, data.get("eventName")+" "+getDateInDDMMMYYYY(), "eventName");
		click(Search,"Search");
		Thread.sleep(5000);
	}
	
	
	public EventDetailsPage goToEventDetailsPage(Hashtable<String, String> data) throws Exception {
		this.searchEvent(data);
		
		
		WebElement element = driver.findElement(By.xpath("(//div[@ng-app='EventsApp']//*[@class='row']//a[@target='_self'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('target','_self');", element);
		String hrefUrl = element.getAttribute("href");
		log.info(hrefUrl);
		driver.get(hrefUrl);
		
		return (EventDetailsPage) openPage(EventDetailsPage.class);
	}

//	public EventDetailsPage navigateToEventDetailsPage(String EventName) throws Exception {
//
//		
////		this.searchEvent(EventName);
//		WebElement element = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('target','_self');", element);
//		String hrefUrl = element.getAttribute("href");
//		System.out.println(hrefUrl);
//		driver.get(hrefUrl);
////		WebElement we = driver.findElement(By.cssSelector("a[href='" + hrefUrl + "']"));
////		we.click();
//		
//		return (EventDetailsPage) openPage(EventDetailsPage.class);
////				new EventDetailsPage(driver, );
//		
//	}

	
	public void VerifyEventDetails(String eventName, String isPrivateEvent, String eventStartTime,
			String eventEndTime, String isPaidEvent, String Address) throws Exception {

//		this.searchEvent(eventName);
		SoftAssert st = new SoftAssert();
		String e = EventName.getText();
		
		
		String EType;
		String EventDate = EventTime.getText();
		if (isPaidEvent.equalsIgnoreCase("yes")) {
			EType = "Paid";
		} else {
			EType = "Free";			
		}
		String type = EventType.getText();
		// System.out.println(type);
		if (type.equalsIgnoreCase(EType)) {
			st.assertTrue(true);
		} else {
			st.assertEquals(type, EType);
		}
		String strStartDate = eventStartTime;
		String strEndDate = eventEndTime;
		// create SimpleDateFormat object with source string date format
		SimpleDateFormat sdfSource = new SimpleDateFormat("MM/dd/yyyy h:m a");
		// parse the string into Date object
		Date Sdate = sdfSource.parse(strStartDate);
		Date Edate = sdfSource.parse(eventEndTime);
		// create SimpleDateFormat object with desired date format
		SimpleDateFormat sdfDestination = new SimpleDateFormat("MMM d, yyyy hh:mm a");
		// parse the date into another format
		strStartDate = sdfDestination.format(Sdate);
		strEndDate = sdfDestination.format(Edate);
		// System.out.println("Date is converted from dd/MM/yy format to
		// MM-dd-yyyy hh:mm a");
		// System.out.println(strStartDate);
		// System.out.println(strEndDate);
		String Date = strStartDate + " To " + strEndDate + ", AUS Central Standard Time";
		// System.out.println(Date);
		// System.out.println(EventDate);
		if (EventDate.equalsIgnoreCase(Date)) {
			st.assertTrue(true);
		} else {
			st.assertEquals(EventDate, Date);
		}
//		if (isPrivateEvent.equalsIgnoreCase("yes")) {
//			if (PrivateEvent.isDisplayed()) {
//				st.assertTrue(true);
//
//			} else {
//				st.assertEquals("Private Event Lock Symbol is not displayed",
//						"Private Event Lock Symbol is should be displayed");
//				// System.out.println("Fail");
//			}//
//		}
		String Location = EventVenue.getText();
		if (Location.equalsIgnoreCase(Address)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Location :" + Location, "Location :" + Address);
		}
		// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// String textObtained= (String) jsExecutor.executeScript("return
		// arguments[0].innerHTML;",
		// driver.findElement(By.xpath("//div[@class='ng-binding']")));
		// System.out.println("----"+textObtained+"****");
		// System.out.println("----"+date+"****");
		// = EventDate.getText();
		// System.out.println(date);
		st.assertAll();

	}
	
	
	
}
