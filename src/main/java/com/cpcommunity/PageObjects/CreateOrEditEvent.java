package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class CreateOrEditEvent extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	@FindBy(xpath = "//input[@name='EventTitle']")
	WebElement EventName;
	@FindBy(xpath = "//*[@name='EventCategoryID']")
	WebElement EventCategoryID;

	@FindBy(xpath = "//*[@name='EventMode'][@value='1']")
	WebElement inPerson;
	@FindBy(xpath = "//*[@name='EventMode'][@value='2']")
	WebElement Online;
	@FindBy(xpath = "//*[@name='EventMode'][@value='3']")
	WebElement Both;

	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement Okbtn;
	@FindBy(xpath = "//input[@id='startdatetime']")
	WebElement startdatetime;
	@FindBy(xpath = "html/body/div[2]/div[1]/div[2]/table/thead/tr[1]/th[2]")
	WebElement DatePickerFirstMonth;
	@FindBy(xpath = "//button[contains(.,'Apply')]")
	WebElement ApplyBtn;
	@FindBy(xpath = "//input[@name='daterangepicker_start']")
	WebElement EventStartDate;
	@FindBy(xpath = "//input[@name='daterangepicker_end']")
	WebElement EventEndtdate;
	@FindBy(xpath = "//input[@id='EventLocation']")
	WebElement EventLocation;
	@FindBy(xpath = "//*[@name='EventCountry']")
	WebElement EventCountry;
	@FindBy(xpath = "//*[@name='Timezone']")
	WebElement Timezone;
	@FindBy(xpath = "//input[@id='country']")
	WebElement Country;
	@FindBy(tagName = "body")
	WebElement EventDescription;
	@FindBy(tagName = "body")
	WebElement CommunityAbout;
	@FindBy(xpath = "//*[@id='changeImageLink']")
	WebElement changeImageLink;

	@FindBy(xpath = "//button[contains(text(),'Browse')]")
	WebElement browse;

	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	WebElement upload;

	@FindBy(xpath = "//*[@class='btn btn-primary'][contains(text(),'Save & Continue')]")
	WebElement SaveEventdetailsBtn;

	@FindBy(xpath = "//span[contains(.,'  Add Ticket ')]")
	WebElement AddTicketBtn;
	@FindBy(xpath = "//input[@name='TicketName']")
	WebElement Ticket;
	@FindBy(xpath = "//input[@name='TicketQunatity']")
	WebElement TicketQunatity;
	@FindBy(xpath = "//select[@name='TicketType']")
	WebElement TicketType;
	@FindBy(xpath = "//input[@name='MaxNumbersOfTKTPerGroup']")
	WebElement TicketsperTable;
	@FindBy(xpath = "//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//*[@name='daterangepicker_start']") ////////
	WebElement TicketStartTime;

	@FindBy(xpath = "//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//*[@name='daterangepicker_end']")
	WebElement TicketEndTime;
	@FindBy(xpath = "//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//*[contains(text(),'Apply')]")
	WebElement TicketCalendarApplyBtn;
	@FindBy(xpath = "//*[@id='TicketInfoForm']//button[contains(text(),'Save')]")
	WebElement SaveTicketInfoBtn;
	@FindBy(xpath = "//button[@ng-click='EditTicketInfo(ticket)']")
	WebElement EditTicketInfoBtn;
	@FindBy(xpath = "//*[@id='TicketInfoForm']/div[3]/div/div[3]/button")
	WebElement UpdateTicketInfoBtn;
	@FindBy(xpath = "//*[@id='msform']/div[2]/button[1]")
	WebElement TicketDetailsSavePageBtn;
	@FindBy(xpath = "//input[@id='AvailableDates']")
	WebElement AvailableDates;
	@FindBy(xpath = "//button[@ng-click='PublishChanges=false;SubmitTicketDetails(true)']")
	WebElement TicketsSaveAndContinueBtn;
	@FindBy(xpath = "//span[contains(.,'  Add Reminder ')]")
	WebElement AddReminderBtn;
	@FindBy(xpath = "//select[@id='NotificationTypeDLL']")
	WebElement NotificationType;
	@FindBy(xpath = "//input[@placeholder='Reminder 0']")
	WebElement Reminder0;
	@FindBy(xpath = "//input[@placeholder='Reminder 1']")
	WebElement Reminder1;
	@FindBy(xpath = "//textarea[@name='SmsTemplate[]']")
	WebElement SmsTemplate;
	@FindBy(xpath = "//span[contains(.,'  Add Speaker ')]")
	WebElement AddSpeakerBtn;
	@FindBy(xpath = "//input[@name='SpeakerName']")
	WebElement Speaker_Name;
	@FindBy(xpath = "//input[@name='SpeakerEmail']")
	WebElement SpeakerEmail;
	
	@FindBy(xpath = "//input[@id='SpeakerImage']")
	WebElement Speaker_Image;
	@FindBy(xpath = "//textarea[@name='SpeakerBIO']")
	WebElement Speaker_BIO;
	@FindBy(xpath = "//input[@id='SpeakerLinkedUrl']")
	WebElement SpeakerLinked_Url;
	@FindBy(xpath = "//*[@id='SpeakersInfoForm']/div[3]/div/div[2]/button")
	WebElement SaveSpeakerDetails;

	@FindBy(xpath = "//span[contains(.,'  Add Sponsor Type')]")
	WebElement AddSponsorType;
	@FindBy(xpath = "//input[@name='SponsorTypes[]']")
	WebElement SponsorTypeName;
	@FindBy(xpath = "//*[@id='SponsorTypesInfoForm']/div[3]/div[2]/button")
	WebElement SponsorTypeSaveBtn;
	@FindBy(xpath = "//select[@name='sponsorType']")
	WebElement sponsorTypeDropDown;
	@FindBy(xpath = "//button[contains(.,'  Add Sponsors ')]")
	WebElement AddSponsorsBtn;
	@FindBy(xpath = "//input[@name='sponsorName']")
	WebElement Sponsor_Name;
	@FindBy(xpath = "//input[@id='SponsorUrl']")
	WebElement Sponsor_Url;
	@FindBy(xpath = "//input[@id='sponsorImage']")
	WebElement Sponsor_Image;
	@FindBy(xpath = "//*[@id='SponsorsInfoForm']/div[3]/div/div[2]/button")
	WebElement SaveSponsorBtn;
	@FindBy(xpath = "//span[contains(.,'  Add Agenda ')]")
	WebElement AddAgendaBtn;
	@FindBy(xpath = "//input[@id='AgendaDates']")
	WebElement AgendaDates;
	@FindBy(xpath = "(//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//*[@name='daterangepicker_start'])[2]")
	WebElement AgendaStartingTime;
	@FindBy(xpath = "(//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//*[@name='daterangepicker_end'])[2]")
	WebElement AgendaEndingTime;
	@FindBy(xpath = "(//*[@class='daterangepicker dropdown-menu ltr show-calendar openscenter']//*[contains(text(),'Apply')])[2]")
	WebElement AgendaApplyBtn;
	@FindBy(xpath = "//input[@name='AgendaVenue']")
	WebElement Agenda_Venue;
	@FindBy(xpath = "//textarea[@name='AgendaDescription']")
	WebElement Agenda_Description;
	@FindBy(xpath = "//*[@id='AgendaInfoForm']//*[@class='fa fa-floppy-o']")
	WebElement AgendaInfoFormSave;

	// form[@id='AgendaInfoForm']//button[contains(.,'Save')]
	@FindBy(xpath = "//span[@ng-hide='IsAgendaSaveMode']")
	WebElement saveAgenda;

	@FindBy(xpath = "//*[@id='AdditionalInformationForm']/div[4]/div[2]/div/button[1]")
	WebElement AddtionalinfomationSaveAndContinueBtn;
	@FindBy(xpath = "//span[contains(.,'  Add Album ')]")
	WebElement AddAlbumBtn;
	@FindBy(xpath = "//input[@id='AlbumTitle']")
	WebElement Album_Title;
	@FindBy(xpath = "//textarea[@id='AlbumDescription']")
	WebElement Album_Description;
	@FindBy(xpath = "//input[@id='AlbumURL']")
	WebElement Album_URL;
	@FindBy(xpath = "//*[@id='AlbumForm']/div[3]/div/div[2]/button")
	WebElement AlbumFormSaveBtn;
	@FindBy(xpath = "//span[@ng-click='ShowAddDocumentModel()']")
	WebElement AddDocumentBtn;
	@FindBy(xpath = "//input[@id='DocumentTitle']")
	WebElement Document_Title;
	@FindBy(xpath = "//textarea[@id='DocumentDescription']")
	WebElement Document_Description;
	@FindBy(xpath = "//input[@id='DocumentUploadedDocument']")
	WebElement DocumentUpload;
	@FindBy(xpath = "//*[@id='DocumentForm']/div[3]/div/div[2]/button")
	WebElement DocumentFormSaveBtn;
	@FindBy(xpath = "//span[@ng-click='ShowAddVideoModel()']")
	WebElement AddVideoBtn;
	@FindBy(xpath = "//input[@id='VideoTitle']")
	WebElement Video_Title;
	@FindBy(xpath = "//textarea[@id='VideoDescription']")
	WebElement Video_Description;
	@FindBy(xpath = "//input[@id='VideoURL']")
	WebElement Video_URL;
	@FindBy(xpath = "//*[@id='VideoForm']/div[3]/div/div[2]/button")
	WebElement VideoFormSaveBtn;
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Publish')]")
	WebElement Publishbtn;

	@FindBy(xpath = "//*/tbody/tr[1]/td[4]/i")
	WebElement EditEvent;
	@FindBy(xpath = "//*[@id='EventInfoForm']/div[10]/div[2]/div/button[1]")
	WebElement EventDetilsPublishContinueBtn;

	@FindBy(xpath = "//*[@id='AdditionalInformationForm']/div[4]/div[2]/div/button[2]")
	WebElement AdditionalInformationFormDetilsPublishContinueBtn;

	@FindBy(xpath = "html/body/div[4]/div[1]/div[1]/input")
	WebElement EditEventStartDate;

	@FindBy(xpath = "html/body/div[4]/div[2]/div[1]/input")
	WebElement EditEventEndtdate;
	@FindBy(xpath = "html/body/div[4]/div[3]/div/button[1]")
	WebElement EditApplyBtn;
	@FindBy(xpath = "//button[@ng-click='EditAgenda(agenda,true)']")
	WebElement EditAgendaBtnInEventDetailsPage;
	@FindBy(xpath = "(//input[@name='daterangepicker_start'])[2]")
	WebElement EditAgendaStartTime;
	@FindBy(xpath = "(//input[@name='daterangepicker_end'])[2]")
	WebElement EditAgendaEndTime;
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[2]")
	WebElement EditAgendaApplyBtn;

	@FindBy(xpath = "//button[@ng-click='SaveEventsDates()']")
	WebElement SaveEventsDates;
	@FindBy(xpath = "//button[@ng-click='EditTicketInfo(ticket, false)']")
	WebElement EditTicketFalse;
	@FindBy(xpath = "//button[@ng-click='EditTicketInfo(ticket, true)']")
	WebElement EditTicketTrue;

	@FindBy(xpath = "//div[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//input[@name='daterangepicker_start']")
	WebElement EditTicketStartTime;

	@FindBy(xpath = "//div[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//input[@name='daterangepicker_end']")
	WebElement EditTicketEndTime;
	@FindBy(xpath = "//div[@class='daterangepicker dropdown-menu ltr show-calendar openscenter dropup']//button[@type='button'][contains(text(),'Apply')]")
	WebElement EditTicketCalendarApplyBtn;

	@FindBy(xpath = "//*[@id='msform']/div[2]/div[3]/div[2]/div/button[2]")
	WebElement TicketDetilsPublishContinueBtn;
	@FindBy(xpath = "//button[@ng-click='EditSpeaker(speaker)']")
	WebElement EditSpeakerBtn;
	@FindBy(xpath = "//*[@id='AdditionalInformationForm']/div[1]/div[3]/div[2]/div/div/div/table/tbody/tr/td[4]/button[1]")
	WebElement EditAgendaBtnInAdditionalInformation;

	@FindBy(xpath = "//button[@ng-click='EditSponsor(sponsor)']")
	WebElement EditSponsorBtn;

	@FindBy(xpath = "//*[@id='AdditionalInformationForm']/div[4]/div[2]/div/button[2]")
	WebElement AdditionalInformationPublishContinueBtn;
	@FindBy(xpath = "//button[@ng-click='EditAlbum(Album)']")
	WebElement EditAlbumBtn;
	@FindBy(xpath = "//button[@ng-click='EditDocument(Document)']")
	WebElement EditDocumentBtn;
	@FindBy(xpath = "//button[@ng-click='EditVideo(Video)']")
	WebElement EditVideoBtn;
	@FindBy(xpath = "//*[@id='msform']/div[4]/div[3]/div[2]/div/button[4]")
	WebElement PublishChangesBtn;

	@FindBy(xpath = "//*/tbody/tr[1]/td[3]/span/span")
	WebElement EventStatus;

	@FindBy(xpath = "//input[@ng-value='true']")
	WebElement paidEvent;
	@FindBy(xpath = "//*[@class='form-group has-success']//*[@value='2']")
	WebElement privateEvent;
	@FindBy(xpath = "//input[@id='ForActiveCommunities']")
	WebElement CommunityEvent;
	@FindBy(xpath = "//input[@id='ForActiveGroups']")
	WebElement GroupsEvent;
	@FindBy(xpath = "//input[@type='search']")
	WebElement GroupNames;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement PrivateEventsSaveBtn;
	@FindBy(xpath = "//input[@name='TicketPrice']")
	WebElement TicketPrice;

	@FindBy(xpath = "//*[@id='validate-dates-form']/div[1]/div[2]/div[1]/div/table/tbody/tr/td[3]/button")
	WebElement EditAgendaBtnInEventDetails;

	public CommunityEventsPage createEvent(Hashtable<String, String> data) throws Exception {
		String h = getSystemCurrentHourIn12Hour();
		String m = getSystemCurrentMintues();

		// String m = "55";
		String y = getSystemCurrentYear();
		String date = getSystemCurrentDate();
		String month = getSystemCurrentMonth();
		int hour = stringToInt(h);

		int i = stringToInt(m);
		if (i >= 00 && i <= 15) {
			m = intToString(30);
		} else if (i >= 15 && i <= 30) {
			m = intToString(45);
		} else if (i >= 30 && i <= 45) {
			m = "00";
			hour = stringToInt(h) + 1;

		} else {
			m = intToString(15);
			hour = stringToInt(h) + 1;

		}
		String AmPm = getPositionAt(getAmPm(), 1);

		// if (m.equalsIgnoreCase("30") || m.equalsIgnoreCase("45")) {
		// hour = stringToInt(h)+1;
		// }

		String StartTime = month + "/" + date + "/" + y + " " + hour + ":" + m + " " + AmPm;
		System.out.println(StartTime);
		// 11/05/2019 7:45 PM
		// String t = getPositionAt(StartTime, 1);
		// System.out.println(t);

		// https://www.javatpoint.com/java-char-to-int
		int endHour = stringToInt(h) + 4;
		if (stringToInt(h) > 8) {
			endHour = 11;
		}
		String endTime = month + "/" + date + "/" + y + " " + "11" + ":" + m + " " + "PM";
		// String endTime = month + "/" + date + "/" + y + " " + endHour + ":" + m + " "
		// + AmPm;

		this.FillEventDetails(data, StartTime, endTime, hour, m, AmPm, endHour);
		clickElementByJavaScript(SaveEventdetailsBtn);
		this.AddTicketDetails(data, StartTime, endTime, hour, m, AmPm, endHour);
		click(TicketsSaveAndContinueBtn, "Save And Continue");
		this.AdditionalInformationDetails(data, StartTime, endTime, hour, m, AmPm, endHour);
		this.EventResources(data);
		return (CommunityEventsPage) openPage(CommunityEventsPage.class);
	}

	public void eventAvailableTo(String isPrivateCommunityEvent, String isPrivateGroupEvent, String publicGroupName,
			String privateGroupName) throws Exception {

		if (isPrivateCommunityEvent.equalsIgnoreCase("Yes")) {
			click(privateEvent, "Private Event");
			// waitForElement(PrivateEventsSaveBtn);
			Thread.sleep(1000);

			if (isPrivateGroupEvent.equalsIgnoreCase("Yes")) {
				click(GroupsEvent, "Groups Event");
				Thread.sleep(300);
				type(GroupNames, publicGroupName, "Public Group Name");
				Thread.sleep(300);
				GroupNames.sendKeys(Keys.ENTER);
				type(GroupNames, privateGroupName, "Private Group Name");
				Thread.sleep(300);
				GroupNames.sendKeys(Keys.ENTER);
				Thread.sleep(500);
			}
			click(PrivateEventsSaveBtn, "Private Events Save");
		}
	}

	public void FillEventDetails(Hashtable<String, String> data, String StartTime, String endTime, int hour, String m,
			String AmPm, int endHour) throws Exception {

		enterLocation(data.get("location"));

		type(EventName, data.get("eventTitleName") + " " + getDateInDDMMMYYYY(), "Event Name");
		selectEventType(data.get("isPaidEvent"));
		selectEventMode(data.get("eventModeTo"));
		selectByVisibleText(EventCategoryID, data.get("eventCategory"), "Event Category");
		eventAvailableTo(data.get("isPrivateCommunityEvent"), data.get("isPrivateGroupEvent"),
				data.get("publicGroupName"), data.get("privateGroupName"));
		Thread.sleep(1000);
		selectByVisibleText(Timezone, data.get("timeZone"), "Timezone");
		selectEventDates(StartTime, endTime, hour, m, AmPm, endHour);
		Thread.sleep(2000);
		// try {
		// String s = startdatetime.getAttribute("value");
		// System.out.println(s);
		// } catch (Exception e) {
		//
		// }

		scrollToElement(EventCountry);
		switchToFrameByID(1);
		Thread.sleep(1000);
		EventDescription.click();
		Thread.sleep(1000);
		type(EventDescription, data.get("eventDescription"), "Description");
		switchTodefaultContent();
		click(changeImageLink, "change Image Link");

		waitForElementToPresent(browse);
		click(browse, "browse");
		uploadImage("D:\\workspace\\bizligo-automation\\src\\test\\resources\\testImages\\ExeFiles\\ChromeImage8.exe");
		click(upload, "upload");
		// type(Event_img, data.get("imagePath"), "Description");

		Thread.sleep(5000);
		// Runtime.getRuntime().exec(ImagePath);

	}

	private void selectEventDates(String EventStartTime, String EventEndTime, int hour, String m, String AmPm,
			int endHour) throws InterruptedException {
		click(startdatetime, "Start Date Time");
		Thread.sleep(1000);

		EventStartDate.sendKeys((Keys.CONTROL + "a"));

		type(EventStartDate, EventStartTime, "Event Start Time");
		// type(EventStartDate, EventStartTime, "Event Start Time");
		EventEndtdate.sendKeys((Keys.CONTROL + "a"));

		WebElement h1 = driver.findElement(By.xpath("(//*[@class='hourselect'])[1]"));
		selectByVisibleText(h1, intToString(hour), "hourselect");

		WebElement min = driver.findElement(By.xpath("(//*[@class='minuteselect'])[1]"));
		selectByVisibleText(min, m, "hourselect");

		WebElement ampmselect = driver.findElement(By.xpath("(//*[@class='ampmselect'])[1]"));
		selectByVisibleText(ampmselect, AmPm, "ampmselect");

		// type(EventEndtdate, EventEndTime, "Event End Date");
		type(EventEndtdate, EventEndTime, "Event End Date");
		EventStartDate.sendKeys((Keys.CONTROL + "a"));
		// intToString(endHour);
		WebElement h2 = driver.findElement(By.xpath("(//*[@class='hourselect'])[2]"));
		selectByVisibleText(h2, "10", "Selecting Event End hour");
		WebElement m2 = driver.findElement(By.xpath("(//*[@class='minuteselect'])[2]"));
		selectByVisibleText(m2, m, "hour selecting");

		WebElement ampmselect2 = driver.findElement(By.xpath("(//*[@class='ampmselect'])[2]"));
		selectByVisibleText(ampmselect2, "PM", "PM");

		click(ApplyBtn, "ApplyBtn");
	}

	private void selectEventType(String isPaidEvent) throws InterruptedException {
		if (isPaidEvent.equalsIgnoreCase("Yes")) {
			click(paidEvent, "Paid Event");
			Thread.sleep(500);
		}
	}

	private void enterLocation(String Location) throws InterruptedException {
		type(EventLocation, Location, "Location");
		Thread.sleep(1000);
		EventLocation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		EventLocation.sendKeys(Keys.ENTER);
	}

	public void AddTicketDetails(Hashtable<String, String> data, String StartTime, String endTime, int hour, String m,
			String AmPm, int endHour) throws AWTException, Exception {

		waitForElementToPresent(AddTicketBtn);
		Thread.sleep(7000);
		click(AddTicketBtn, "Add Ticket");
		Thread.sleep(1000);
		type(Ticket, data.get("ticketName"), "Ticket");

		if (data.get("isPaidEvent").equalsIgnoreCase("Yes")) {
			type(TicketPrice, data.get("ticketValue"), "TicketPrice");
		}

		executeScript("arguments[0].value='" + data.get("totalTickets") + "';", TicketQunatity);
		TicketQunatity.click();
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		selectByVisibleText(TicketType, data.get("ticketType"), "Ticket Type");

		int TableTicket = Integer.parseInt(data.get("noOfTicketPerTable"));
		if (data.get("ticketType").contains("Table")) {
			for (int T = 1; T <= TableTicket; T++) {
				if (TableTicket != 1) {
					robot.keyPress(KeyEvent.VK_UP);
					Thread.sleep(500);
				}
			}
		}
		Thread.sleep(3000);
		click(AvailableDates, "Available Dates");
		waitForElementToPresent(TicketCalendarApplyBtn);
		TicketStartTime.click();
		TicketStartTime.sendKeys(Keys.CONTROL + "a");
		type(TicketStartTime, StartTime, "Ticket Start Time");
		TicketEndTime.click();
		TicketEndTime.sendKeys(Keys.CONTROL + "a");
		type(TicketEndTime, endTime, "Ticket End Time");
		picture();
		click(TicketCalendarApplyBtn, "Calendar Apply");
		click(SaveTicketInfoBtn, "Save button in the pop up");
		Thread.sleep(2000);

	}

	public void selectEventMode(String eventMode) {
		if (eventMode.equalsIgnoreCase("In-Person")) {
			click(inPerson, "In-Person");
		}
		if (eventMode.equalsIgnoreCase("Online")) {
			click(Online, "Online");
		}
		if (eventMode.equalsIgnoreCase("Both")) {
			click(Both, "Both");
		}

	}

	public void AdditionalInformationDetails(Hashtable<String, String> data, String StartTime, String endTime, int hour,
			String m, String AmPm, int endHour) throws Exception {

		waitForElementToPresent(AddReminderBtn);

		Thread.sleep(7000);
		click(AddReminderBtn, "Add Reminder");
		selectByVisibleText(NotificationType, "SMS", "Notification Type");
		click(AddReminderBtn, "Add Reminder");
		click(AddSpeakerBtn, "Add Speaker");
		waitForElementToPresent(Speaker_Name);
		type(Speaker_Name, data.get("speakerName"), "Speaker_Name");
		type(Speaker_Image, System.getProperty("user.dir") + "/src/test/resources/testImages/Files/ChromeImage8.jpg",
				"Speaker Image");

		type(SpeakerEmail,"andrew74444@gmail.com","Speaker Email");
		
		Thread.sleep(2000);
		// Runtime.getRuntime().exec(SpeakerImagePath);
		// Thread.sleep(5000);

		type(SpeakerLinked_Url, data.get("speakerLinkedUrl"), "Speaker Linked Url");
		type(Speaker_BIO, data.get("speakerBio"), "speakerBio");
		click(SaveSpeakerDetails, "Save Speaker Details");
		scrollToElement(AddAgendaBtn);
		Thread.sleep(2000);
		click(AddAgendaBtn, "Add Agenda");
		Thread.sleep(1000);
		this.AddAgendadetails(StartTime, endTime, hour, m, AmPm, endHour, data.get("agendaVenue"),
				data.get("agendaDescription"));
		clickElementByJavaScript(AddSponsorType);
		Thread.sleep(1000);
		type(SponsorTypeName, data.get("sponsorType"), "Sponsor Type");

		click(SponsorTypeSaveBtn, "Sponsor Type Save");
		Thread.sleep(1000);
		clickElementByJavaScript(AddSponsorsBtn);

		selectByVisibleText(sponsorTypeDropDown, data.get("sponsorType"), "SponsorType");
		type(Sponsor_Name, data.get("sponsorName"), "Sponsor Name");
		type(Sponsor_Url, data.get("sponsorUrl"), "Sponsor Url");
		type(Sponsor_Image, data.get("sponsorImage"), "Sponsor Image");

		// Thread.sleep(3000);
		//
		// Runtime.getRuntime().exec(SponsorImage);
		Thread.sleep(2000);
		click(SaveSponsorBtn, "Save Sponsor");
		Thread.sleep(1000);
		clickElementByJavaScript(AddtionalinfomationSaveAndContinueBtn);

	}

	public void AddAgendadetails(String AgendaStartTime, String AgendaEndTime, int hour, String m, String AmPm,
			int endHour, String AgendaVenue, String AgendaDescription) throws Exception {
		Thread.sleep(4000);
		waitForElementToPresent(Agenda_Venue);
		Agenda_Venue.clear();
		Agenda_Description.clear();
		click(AgendaDates, "Agenda Dates");
		waitForElementToPresent(AgendaStartingTime);
		AgendaStartingTime.click();
		AgendaStartingTime.sendKeys((Keys.CONTROL + "a"));
		type(AgendaStartingTime, AgendaStartTime, "Agenda Start Time");
		AgendaEndingTime.click();
		AgendaEndingTime.sendKeys((Keys.CONTROL + "a"));
		type(AgendaEndingTime, AgendaEndTime, "Agenda End Time");
		click(AgendaApplyBtn, "Apply");
		type(Agenda_Venue, AgendaVenue, "Agenda Venue");
		type(Agenda_Description, AgendaDescription, "Agenda Description");
		scrollToElement(saveAgenda);
		clickElementByJavaScript(saveAgenda);
		Thread.sleep(2000);

	}

	public void EventResources(Hashtable<String, String> data) throws Exception {

		waitForElementToPresent(AddAlbumBtn);
		Thread.sleep(7000);
		click(AddAlbumBtn, "AddAlbumBtn");
		waitForElementToPresent(Album_Title);
		type(Album_Title, data.get("albumTitle"), "Album Title");
		type(Album_Description, data.get("albumDescription"), "Album Description");
		type(Album_URL, data.get("albumURL"), "Album URL");
		click(AlbumFormSaveBtn, "Album Form Save");
		Thread.sleep(2000);
		click(AddDocumentBtn, "Add Document ");
		waitForElementToPresent(Document_Title);
		type(Document_Title, data.get("documentTitle"), "Document Title");
		type(Document_Description, data.get("documentDescription"), "Document Description");
		DocumentUpload.sendKeys(data.get("uploadDocumentPath"));
		// Thread.sleep(3000);
		// Runtime.getRuntime().exec(UploadDocumentPath);
		// Thread.sleep(5000);
		click(DocumentFormSaveBtn, "Document Form Save");
		Thread.sleep(2000);
		scrollToElement(AddVideoBtn);
		click(AddVideoBtn, "Add Video");
		waitForElementToPresent(Video_Title);

		type(Video_Title, data.get("videoTitle"), "Video Title");
		type(Video_Description, data.get("videoDescription"), "Video Description");
		type(Video_URL, data.get("videoURL"), "Video URL");
		click(VideoFormSaveBtn, "VideoFormSaveBtn");
		clickElementByJavaScript(Publishbtn);

	}

	public void EditEvent(String isPrivateCommunityEvent, String isPrivateGroupEvent, String publicGroupName,
			String privateGroupName, String eventTitleName, String isPaidEvent, String eventStartTime,
			String eventEndTime, String location, String description, String imagePath, String ticketName,
			String ticketValue, String totalTickets, String type, String noOfTicketPerTable,
			String ticketAvailablityStartsFrom, String ticketAvailablityEndson, String speakerName,
			String speakerImagePath, String speakerLinkedUrl, String sponsorType, String sponsorName, String sponsorUrl,
			String sponsorImage, String agendaStartTime, String agendaEndTime, String agendaVenue,
			String agendaDescription, String albumTitle, String albumDescription, String albumURL, String documentTitle,
			String documentDescription, String uploadDocumentPath, String videoTitle, String videoDescription,
			String videoURL) throws Exception {

		int i = this.UpdateEventDetails(eventTitleName, eventStartTime, eventEndTime, location, description, imagePath,
				agendaStartTime, agendaEndTime, agendaVenue, agendaDescription, ticketName, totalTickets, type,
				noOfTicketPerTable, ticketAvailablityStartsFrom, ticketAvailablityEndson);
		this.UpdateTicketDetails(ticketName, totalTickets, type, noOfTicketPerTable, ticketAvailablityStartsFrom,
				ticketAvailablityEndson);
		this.UpdateAdditionalInformationDetails(speakerName, speakerImagePath, speakerLinkedUrl, sponsorType,
				sponsorName, sponsorUrl, sponsorImage, i, agendaStartTime, agendaEndTime, agendaVenue,
				agendaDescription);
		this.UpdateEventResources(albumTitle, albumDescription, albumURL, documentTitle, documentDescription,
				uploadDocumentPath, videoTitle, videoDescription, videoURL);

	}

	public int UpdateEventDetails(String EventTitleName, String EventStartTime, String EventEndTime, String Location,
			String Description, String imagePath, String AgendaStartTime, String AgendaEndTime, String AgendaVenue,
			String AgendaDescription, String TicketName, String TotalTickets, String Type, String NoOfTicketPerTable,
			String TicketAvailablityStartsFrom, String TicketAvailablityEndson) throws Exception {

		EventName.clear();
		EventLocation.clear();
		Thread.sleep(1000);
		scrollIntoView(Country);
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		EventDescription.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(2000);
		EventDescription.sendKeys(" ");
		driver.switchTo().defaultContent();
		scrollIntoView(EventName);

		EventLocation.sendKeys(Location);
		EventLocation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);

		EventName.sendKeys(EventTitleName);

		startdatetime.click();
		Thread.sleep(3000);
		EditEventStartDate.sendKeys(Keys.CONTROL + "a");

		EditEventStartDate.sendKeys(EventStartTime);
		EditEventEndtdate.sendKeys((Keys.CONTROL + "a"));
		;

		EditEventEndtdate.sendKeys(EventEndTime);

		EditApplyBtn.click();
		Thread.sleep(2000);

		int i = 0;

		try {

			Okbtn.click();
		} catch (Exception e) {

		}

		try {

			this.UpdateTicketDetails(TicketName, TotalTickets, Type, NoOfTicketPerTable, TicketAvailablityStartsFrom,
					TicketAvailablityEndson);
		} catch (Exception e) {

		}

		try {
			try {

				EditAgendaBtnInEventDetailsPage.click();
			} catch (Exception e) {

				EditAgendaBtnInEventDetails.click();

			}

			Thread.sleep(1000);
			// this.AddAgendadetails(AgendaStartTime, AgendaEndTime, AgendaVenue,
			// AgendaDescription);

			Thread.sleep(2000);
			SaveEventsDates.click();
			i = 1;

			try {

				EditTicketInfoBtn.click();
				Thread.sleep(3000);

			} catch (Exception e) {

			}
		} catch (Exception e) {
		}

		scrollIntoView(Country);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		EventDescription.sendKeys(Keys.CONTROL + "a");
		EventDescription.sendKeys(Description);
		driver.switchTo().defaultContent();
		//

		click(changeImageLink, "change Image Link");

		waitForElementToPresent(browse);
		click(browse, "browse");
		uploadImage("D:\\workspace\\bizligo-automation\\src\\test\\resources\\testImages\\ExeFiles\\ChromeImage8.exe");
		click(upload, "upload");

		// Runtime.getRuntime().exec(ImagePath);
		Thread.sleep(2000);

		this.GotoTicketDetails();
		return i;

	}

	public void GotoTicketDetails() {
		try {
			clickElementByJavaScript(EventDetilsPublishContinueBtn);
		} catch (Exception e) {
			clickElementByJavaScript(SaveEventdetailsBtn);
		}

	}

	public void UpdateTicketDetails(String TicketName, String TotalTickets, String Type, String NoOfTicketPerTable,
			String TicketAvailablityStartsFrom, String TicketAvailablityEndson) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(8000);

		try {

			EditTicketFalse.click();
		} catch (Exception e) {

			EditTicketTrue.click();
		}

		Thread.sleep(1000);
		Ticket.clear();
		Select Cat = new Select(TicketType);

		Cat.selectByVisibleText("-- Select Ticket Type--");

		Robot robot = new Robot();
		Thread.sleep(3000);
		TicketQunatity.click();
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(300);

		js.executeScript("arguments[0].value='" + TotalTickets + "';", TicketQunatity);

		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);

		Ticket.sendKeys(TicketName);
		Cat.selectByVisibleText(Type);
		if (Type.contains("Table")) {
			js.executeScript("arguments[0].value='" + TicketsperTable + "';", NoOfTicketPerTable);
			TicketsperTable.sendKeys(NoOfTicketPerTable);
		}

		AvailableDates.click();
		Thread.sleep(3000);

		try {
			waitForElementToPresent(EditTicketStartTime);

			EditTicketStartTime.click();
			EditTicketStartTime.sendKeys(Keys.CONTROL + "a");

			EditTicketStartTime.sendKeys(TicketAvailablityStartsFrom);
			EditTicketEndTime.click();
			EditTicketEndTime.sendKeys(Keys.CONTROL + "a");
			EditTicketEndTime.sendKeys(TicketAvailablityEndson);

			EditTicketCalendarApplyBtn.click();

			// SaveTicketInfoBtn.click();

			UpdateTicketInfoBtn.click();
			Thread.sleep(3000);

		} catch (Exception e) {

			EditTicketStartTime.click();
			EditTicketStartTime.sendKeys(Keys.CONTROL + "a");

			EditTicketStartTime.sendKeys(TicketAvailablityStartsFrom);
			EditTicketEndTime.click();
			EditTicketEndTime.sendKeys(Keys.CONTROL + "a");

			EditTicketEndTime.sendKeys(TicketAvailablityEndson);

			EditTicketCalendarApplyBtn.click();
			Thread.sleep(1000);

			UpdateTicketInfoBtn.click();
		}

		Thread.sleep(3000);
		this.GoToAddtionalInformation();

	}

	public void UpdateTicketDetailsPage(String TicketName, String TotalTickets, String Type, String NoOfTicketPerTable,
			String TicketAvailablityStartsFrom, String TicketAvailablityEndson) throws AWTException, Exception {

		waitForElementToPresent(AddTicketBtn);
		Thread.sleep(2000);
		this.UpdateTicketDetails(TicketName, TotalTickets, Type, NoOfTicketPerTable, TicketAvailablityStartsFrom,
				TicketAvailablityEndson);
		Thread.sleep(6000);
		this.GoToAddtionalInformation();
	}

	public void GoToAddtionalInformation() {
		try {
			TicketDetilsPublishContinueBtn.click();
		} catch (Exception e) {
			TicketsSaveAndContinueBtn.click();
		}
	}

	public void UpdateAddAgenda(String AgendaStartTime, String AgendaEndTime, String AgendaVenue,
			String AgendaDescription) throws Exception {
		Thread.sleep(2000);

		AgendaDates.click();
		waitForElementToPresent(EditAgendaStartTime);
		EditAgendaStartTime.click();
		EditAgendaStartTime.sendKeys((Keys.CONTROL + "a"));
		EditAgendaStartTime.sendKeys(AgendaStartTime);
		EditAgendaEndTime.click();
		EditAgendaEndTime.sendKeys((Keys.CONTROL + "a"));
		;
		EditAgendaEndTime.sendKeys(AgendaEndTime);

		EditAgendaApplyBtn.click();
		Thread.sleep(1000);
		Agenda_Venue.clear();
		Agenda_Description.clear();

		Thread.sleep(1000);
		Agenda_Venue.sendKeys(AgendaVenue);

		Thread.sleep(1000);
		Agenda_Description.sendKeys(AgendaDescription);
		AgendaInfoFormSave.click();
		scrollToElement(AddAgendaBtn);
	}

	public void UpdateAdditionalInformationDetails(String SpeakerName, String SpeakerImagePath, String SpeakerLinkedUrl,
			String SponsorType, String SponsorName, String SponsorUrl, String SponsorImage, int i,
			String AgendaStartTime, String AgendaEndTime, String AgendaVenue, String AgendaDescription)
			throws Exception {

		waitForElementToPresent(AddReminderBtn);

		Thread.sleep(7000);

		for (int j = 3; j > 0; j--) {
			System.out.println(j);
			try {

				driver.findElement(By.xpath("//*[@id='AdditionalInformationForm']/div[1]/div[1]/div[2]/div/div/div[" + j
						+ "]/div[1]/div[3]/div/div[2]/button")).click();

				// driver.findElement(By.xpath("//div//div//div//div//div[@class='col-sm-12']//div["+j+"]//div[1]//div[3]//div[1]//div[2]//button[1]")).click();
			} catch (Exception e) {

			}

		}
		AddReminderBtn.click();
		Select SMS = new Select(NotificationType);
		SMS.selectByVisibleText("SMS");
		AddReminderBtn.click();

		EditSpeakerBtn.click();
		Thread.sleep(2000);
		Speaker_Name.clear();
		SpeakerLinked_Url.clear();

		Thread.sleep(2000);

		Speaker_Name.sendKeys(SpeakerName);
		Speaker_Image
				.sendKeys("D:\\Workspace\\CPCommunityQA\\src\\main\\resources\\configfile\\Files\\ChromeImage8.jpg");
		// Thread.sleep(4000);
		// Runtime.getRuntime().exec(SpeakerImagePath);
		Thread.sleep(2000);
		SpeakerLinked_Url.sendKeys(SpeakerLinkedUrl);

		SaveSpeakerDetails.click();
		System.out.println("Agenda= " + i);
		Thread.sleep(2000);
		if (i == 0) {
			EditAgendaBtnInAdditionalInformation.click();
			this.UpdateAddAgenda(AgendaStartTime, AgendaEndTime, AgendaVenue, AgendaDescription);
		}

		scrollToElement(AddAgendaBtn);
		Thread.sleep(2000);
		AddSponsorType.click();

		Thread.sleep(1000);
		SponsorTypeName.clear();
		SponsorTypeName.sendKeys(SponsorType);
		SponsorTypeSaveBtn.click();
		Thread.sleep(1000);
		EditSponsorBtn.click();
		waitForElementToPresent(Sponsor_Name);
		Select sponsorTypeDD = new Select(sponsorTypeDropDown);
		Sponsor_Name.clear();
		Sponsor_Url.clear();
		sponsorTypeDD.selectByVisibleText("-- Choose sponsor --");

		Thread.sleep(1000);
		Sponsor_Name.sendKeys(SponsorName);
		Sponsor_Url.sendKeys(SponsorUrl);
		sponsorTypeDD.selectByVisibleText(SponsorType);

		Sponsor_Image
				.sendKeys("D:\\Workspace\\CPCommunityQA\\src\\main\\resources\\configfile\\Files\\ChromeImage9.jpg");
		// Thread.sleep(4000);
		// Runtime.getRuntime().exec(SponsorImage);
		Thread.sleep(2000);

		SaveSponsorBtn.click();
		Thread.sleep(4000);

		try {
			scrollToElement(AddtionalinfomationSaveAndContinueBtn);

			AddtionalinfomationSaveAndContinueBtn.click();
		} catch (Exception e) {
			scrollToElement(AdditionalInformationPublishContinueBtn);

			AdditionalInformationPublishContinueBtn.click();
		}

	}

	public void UpdateEventResources(String AlbumTitle, String AlbumDescription, String AlbumURL, String DocumentTitle,
			String DocumentDescription, String UploadDocumentPath, String VideoTitle, String VideoDescription,
			String VideoURL) throws Exception {

		waitForElementToPresent(AddAlbumBtn);

		// Thread.sleep(7000);
		EditAlbumBtn.click();
		Thread.sleep(2000);

		Album_Title.clear();
		Album_Description.clear();
		Album_URL.clear();

		Thread.sleep(1000);

		Album_Title.sendKeys(AlbumTitle);
		Album_Description.sendKeys(AlbumDescription);
		Album_URL.sendKeys(AlbumURL);

		AlbumFormSaveBtn.click();
		Thread.sleep(2000);

		EditDocumentBtn.click();
		Thread.sleep(1000);
		Document_Title.clear();
		Document_Description.clear();

		Document_Title.sendKeys(DocumentTitle);
		Document_Description.sendKeys(DocumentDescription);
		// Document_Description.sendKeys(Keys.TAB);
		// Robot r = new Robot();
		// Thread.sleep(2000);
		// r.keyPress(KeyEvent.VK_ENTER);
		//
		DocumentUpload
				.sendKeys("D:\\Workspace\\CPCommunityQA\\src\\main\\resources\\configfile\\Files\\ChromePDF1.pdf");
		Thread.sleep(2000);
		// Runtime.getRuntime().exec(UploadDocumentPath);
		// Thread.sleep(6000);

		DocumentFormSaveBtn.click();
		Thread.sleep(2000);

		EditVideoBtn.click();
		Thread.sleep(1000);

		Video_Title.clear();
		Video_Description.clear();
		Video_URL.clear();

		type(Video_Title, VideoTitle, "Video Title");
		type(Video_Description, VideoDescription, "Video Description");
		type(Video_URL, VideoURL, "Video_URL");
		click(VideoFormSaveBtn, "Video Save Button");

		try {
			clickElementByJavaScript(Publishbtn);

		} catch (Exception e) {
			clickElementByJavaScript(PublishChangesBtn);

		}

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(EventName);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
