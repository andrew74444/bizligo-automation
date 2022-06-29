package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class AdvertismentPurchasePage extends BasePage {

	
	@FindBy(xpath = "//*[@class='main-plan-headings']")
	List<WebElement> planNames;

	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement next;

	@FindBy(xpath = "//*[@name='AdName']")
	WebElement adName;

	@FindBy(xpath = "//*[@name='AdStartDate']")
	WebElement adStartDate;

	@FindBy(xpath = "(//thead/tr/th[2][@class='switch'])[3]")
	WebElement calendarMonth;

	@FindBy(xpath = "(//table//tbody)[4]//*[@class='day active']")
	WebElement currentDate;

	@FindBy(xpath = "(//*[@class='next'])[3]")
	WebElement calNext;

	@FindBy(xpath = "//strong[contains(text(),'Select Plan')]")
	WebElement selectPlan;

	@FindBy(xpath = "//*[@name='AdImage']")
	WebElement adImage;

	@FindBy(xpath = "//*[@name='LinkUrl']")
	WebElement linkUrl;

	@FindBy(xpath = "//*[@name='AdditionalInstructions']")
	WebElement additionalInstructions;
	@FindBy(xpath = "//*[contains(text(),'Proceed to Payment')]")
	WebElement proceedtoPayment;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
			
		return ExpectedConditions.visibilityOf(selectPlan);
	}
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//input[@id='DisplayStartDate']")
	WebElement adStartDate1;
	
	@FindBy(xpath = "//*[@name='DisplayEndDate']")
	WebElement adEndDate;
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")//
	WebElement  adStartDatecalendar;
	public PaymentOptionsPage SelectPlan(String planName, String adImage, String linkUrl,
			String additionalInstructions) throws Exception {
		int i = planNames.size();
		for (int j = 1; j <= i; j++) {
			WebElement ele1 = driver.findElement(By.xpath("(//*[@class='main-plan-headings']//*)[" + j + "]"));
			String name = ele1.getAttribute("title");
//			System.out.println(planName);
//			System.out.println(name);
			
//			System.out.println(j);
			if (name.length()==0) {
				j++;
				System.out.println("--->"+j);
				ele1=driver.findElement(By.xpath("(//*[@class='main-plan-headings']//*)[" + j + "]"));
				
				name = ele1.getAttribute("title");
				System.out.println(name);
				j--;
				System.out.println(j+"<---");
			}
			if (name.equalsIgnoreCase(planName)) {
				WebElement ele = driver.findElement(By.xpath(
						"(//*[@class='panel panel-warning panel-pricing']//*[contains(text(),'Select')])[" + j + "]"));
				click(ele, "Select");
				scrollDownVertically();
				waitForElementToPresent(next);
				click(next, "next");
				waitForElementToPresent(adName);
				scrollDownVertically();
				type(this.adName, planName, "adName");
Thread.sleep(2000);
			//	selectCurrentDate();//commented on 23/05
				waitForElementToPresent(date);
				click(date, "Select Date");
				Thread.sleep(2000);
				waitForElementToPresent(adStartDatecalendar);
				Thread.sleep(2000);
				waitForElementToPresent(today);
				click(today, "Date");
				adImage="\\src\\test\\resources\\testImages\\Files\\ChromeImage3.jpeg";
				type(this.adImage, projectFloder(adImage), "Ad Image");
				type(this.linkUrl, linkUrl, "Link Url");
				type(this.additionalInstructions, additionalInstructions, "Additional Instructions");
				click(proceedtoPayment, "Proceed to Payment");
				Thread.sleep(5000);
				return (PaymentOptionsPage) openPage(PaymentOptionsPage.class);
			}
//			System.out.println(j);
			if (j > i) {
				AssertionHelper.markFail("Plan not Found--->" + planName);
				log.info("Plan not Found--->" + planName);
				return (PaymentOptionsPage) openPage(PaymentOptionsPage.class);
			}
		}
		return null;
		
		
		// DateManager date = new DateManager();
		// String MMYYYY = date.getMonthYearNameFromString(adStartDate);
		// String calMMYYYY=calendarMonth.getText();
		//
		// while(true) {
		// if(MMYYYY.equalsIgnoreCase(calMMYYYY)) {
		// break;
		// }
		// else {
		// click(calNext,"next month");
		// Thread.sleep(1000);
		// }
		// }

		// type(this.adStartDate, adStartDate, "Ad Start Date");
		

	}
	@FindBy(xpath="//tbody/*/td[@class='day active']")
	WebElement today;

	private void selectCurrentDate() {
		click(this.adStartDate, "Ad Start Date");
		waitForElementToPresent(calendarMonth);
		click(currentDate, "Selecting Date");
	}

	

}
