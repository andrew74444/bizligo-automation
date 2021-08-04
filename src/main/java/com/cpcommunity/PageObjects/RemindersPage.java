package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

public class RemindersPage extends BasePage{
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(Reminders);
	}

	@FindBy(xpath = "//h3[normalize-space()='My Reminders']")
	WebElement Reminders;
	
	
	
	@FindBy(xpath = "//a[normalize-space()='View History']")
	WebElement viewHistory;
	/*
	@FindBy(xpath = "//input[@placeholder='Enter Title Here']")
	WebElement title;
	
	@FindBy(xpath = "//input[@id='TaskStartDate']")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@id='TaskDueDate']")
	WebElement dueDate;
	
	@FindBy(xpath = "//input[@id='ReminderDate']")
	WebElement reminderDate;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//span[@ng-show='reminder.IsTaskSaveMode']")
	WebElement saveButton;*/
	
	@FindBy(xpath = "//*[contains(text(),'Create')]")
	WebElement createTask;
	
	@FindBy(xpath = "//input[@name = 'Title'] ")
	WebElement title;
	
	@FindBy(xpath = "/html/body/div[7]/div[3]")
	WebElement startDays;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement save;

	@FindBy(xpath = "//*[@id = 'TaskStartDate']")
	WebElement select;
	
	@FindBy(xpath = "//*[@id = 'TaskStartDate']")
	WebElement startDate;
	
	@FindBy(xpath = "//*[@name = 'TaskDueDate']")
	WebElement startDueDate;
	
	@FindBy(xpath = "/html/body/div[8]/div[3]/table")
	WebElement endDays;
	
	@FindBy(xpath = "/html/body/div[9]/div[3]/table")
	WebElement selectReminder;
	
	@FindBy(xpath = "//*[@id = 'ReminderDate']")
	WebElement reminderDate;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement submit;
	
	@FindBy(xpath = "//body[1]/div[9]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[@class=\"hour active\"]")
	WebElement currentHour;
	
	@FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr/td/span[@class=\"minute\"]")
	WebElement currentMinutes;
	
	@FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr/td/span[@class=\"minute\"]")
	List<WebElement> CurrentMinutes;
	
	@FindBy(xpath="//div[@class='toast toast-success']")
	WebElement toastMsg;
	
	
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-top-left dropdown-menu']//div[@class='datetimepicker-minutes']//th[@class='next']")
	WebElement arrowButton;
	
	@FindBy(xpath="//div[@class='row reminders-cards']")
	WebElement reminderCards;
	
	@FindBy(xpath = "//div[@id='removeinnercss']//div[1]//div[1]//div[1]//div[1]//div[1]//a[1]")
	WebElement toggleDropdown;
	
	@FindBy(xpath = "//div[@class='btn-group pull-right post_menu open']//span[contains(text(),'Edit')]")
	WebElement editBtn;
	
	@FindBy(xpath = "//div[@class='btn-group pull-right post_menu open']//span[contains(text(),'Delete')]")
	WebElement delete;
	
	@FindBy(xpath="//button[normalize-space()='Yes, Proceed']")
	WebElement yesToProceed;
	
	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement noToProceed;
	
	@FindBy(xpath = "//span[@ng-hide='reminder.IsTaskSaveMode']")
	WebElement update;
	
	@FindBy(xpath = "//*[@id=\"ReminderHistoryController\"]/div[3]")
	WebElement historyData;
	
	
	
	public void addNewReminder(String Title) throws Exception{
		//click(myReminders,"MyReminders");
		//Thread.sleep(2000);
		click(createTask,"CreateTask");
		title.sendKeys(Title);
		click(this.startDate, "startDate");
		waitForElementToPresent(startDays);
		DateManager d = new DateManager(driver);
	    String date = d.getCurrentDateString();
		d.selectDate("/html/body/div[7]/div[3]",date); 
		Thread.sleep(2000);
		click(this.startDueDate, "startDueDate");
		waitForElementToPresent(endDays);
		DateManager d1 = new DateManager(driver);
	    String date1 = d1.getCurrentDateString();
	    d1.selectDate("/html/body/div[8]/div[3]/table",date1); 
	    Thread.sleep(2000);
	    click(this.reminderDate, "reminderDate");
	    waitForElementToPresent(selectReminder);
	    
	    DateManager d3 = new DateManager(driver);
	    String date3 = d3.getCurrentDateString();
	    //date3=date3+1;
	    d3.selectDate("/html/body/div[9]/div[3]/table",date3);
	    Thread.sleep(2000);
	    click(currentHour,"current hour");
	    if(CurrentMinutes.size()>0) {
	    click(currentMinutes,"current time");
	    }else {
	    	click(arrowButton,"Click next");
	    	click(currentMinutes,"current time");
	    }	    
	    Thread.sleep(2000);
	    click(save,"Save");
	    Thread.sleep(3000);
	    //System.out.println(toastMsg.getText());
	    if(toastMsg.getText().equalsIgnoreCase("Success! Task created")) {
	    	System.out.println("New Reminder Created!!");
	    	Assert.assertTrue(true);
	    }else {
	    	System.out.println("Unable to create new reminder");
	    	Assert.assertTrue(false);
	    }	    
	}
	public void checkReminderAddedInDashboard(String Title) {
		System.out.println(reminderCards.getText());
		if(reminderCards.getText().contains(Title)) {
			System.out.println("Added Reminders Visible In Dashboard");
			Assert.assertTrue(true);
		}else {System.out.println("Added Reminders not visible in dashboard");
		Assert.assertTrue(false);}
		
	}
	public void deleteReminder() throws InterruptedException {
		click(toggleDropdown,"Toggle drop down of reminder");
		click(delete,"Delete Reminder");
		click(yesToProceed,"Yes, Proceed");
		Thread.sleep(3000);
		System.out.println(toastMsg.getText());
		if(toastMsg.getText().equalsIgnoreCase("Success! Task deleted")) {
			System.out.println("Task deleted successfully");
			Assert.assertTrue(true);
		}else {System.out.println("Task not deleted");
		Assert.assertTrue(false);
		}
	}
	
	public void editReminder(String NewTitle) throws Exception {
		Thread.sleep(3000);
		click(toggleDropdown,"Toggle drop down of reminder");
		click(editBtn,"edit Reminder");
		type(title,NewTitle,NewTitle);
		click(this.startDueDate, "startDueDate");
		//waitForElementToPresent(endDays);
		DateManager d1 = new DateManager(driver);
	    String date1 = d1.getCurrentDateString();
	    date1=date1+1;
	    System.out.println(date1);
	    d1.selectDate("/html/body/div[8]/div[3]/table",date1); 
	    Thread.sleep(2000);
	    click(update,"Update");
	    Thread.sleep(3000);
		System.out.println(toastMsg.getText());
		if(toastMsg.getText().equalsIgnoreCase("Success! Task updated")) {
			System.out.println("Task updated successfully");
			Assert.assertTrue(true);
		}else {System.out.println("Task not updated");
		Assert.assertTrue(false);
		}
		
	}
	public void checkReminder(String CompletedTask) {
		click(viewHistory,"View History");
		waitForElementToPresent(historyData);
		System.out.println("Tasks Completed and In View History are:");
		System.out.println(historyData.getText());
		if(historyData.getText().contains(CompletedTask)) {
			System.out.println("\n Completed Tasks are visible in view history ");
			Assert.assertTrue(true);
		}else {System.out.println("Completed Tasks are not visible in view history ");
		Assert.assertTrue(false);}		
	}
	public void checkNoteAddedDisplay(String TitleOfNote) {
		System.out.println(reminderCards.getText());
		if(reminderCards.getText().contains(TitleOfNote)) {
			System.out.println("Added notes with reminder in a member's profile visible in Dashboard");
			Assert.assertTrue(true);
		}else {System.out.println("Added notes with reminder in a member's profile not visible in Dashboard");
		Assert.assertTrue(false);}
		
		
	}
	
	
	
	
}
