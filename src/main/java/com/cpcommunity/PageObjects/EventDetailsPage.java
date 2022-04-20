package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;




public class EventDetailsPage extends BasePage {
	
	@FindBy(xpath = "//span[contains(.,'register')]")
	WebElement RegisterBtn;
	@FindBy(xpath = "//span[contains(text(),'details')]")
	WebElement Details;

//	@FindBy(xpath = "(//*[@class='table']/tbody/tr/td[3])[1]//select")
	@FindBy(xpath = "(//*[@id='selectticketcount'])[1]")
	WebElement Ticket;
	
	
	@FindBy(xpath = "//input[@name='EmailID[]']")
	WebElement AttendeeEmailID;
	@FindBy(xpath = "//*[@name='Phone[]']")
	WebElement AttendeePhone;
	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement NextBtn;
	@FindBy(xpath = "//label[@for=\"IHavePromoCode\"]")
	WebElement iHavePromocode;
	@FindBy(xpath = "//input[@placeholder=\"Enter Promo code\"]")
	WebElement Promocode;
	@FindBy(xpath = "//span[contains(text(),\"APPLY\")]")
	WebElement apply;
	@FindBy(xpath = "//*[@id=\"selectticketcount\"]")
	WebElement selectTicket;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[9]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/h4[1]/select[1]")
	WebElement selectTicket2;
	
	@FindBy(xpath = "//strong[contains(text(),\"Congratulations!\")]")
	WebElement congratulationsMsg;
	@FindBy(xpath = "//span[contains(text(),\"Sorry! The Promo code you have entered is not valid. Please try with a different code.\")]")
	WebElement sorryMsg;
	@FindBy(xpath = "//span[contains(text(),\"Sorry! The Promo code you have entered has exceeded the usage limit. Please try with a different code.\")]")
	WebElement exceedMsg;
	@FindBy(xpath = "//span[contains(text(),\"Sorry! The Promo code you have entered is not valid. Please try with a different code.\")]")
	WebElement inactiveMsg;
	@FindBy(xpath = "//span[contains(text(),\"Sorry! The Promo code you have entered has expired. Please try with a different code.\")]")
	WebElement expiredMsg;
	@FindBy(xpath = "//input[@placeholder=\"Search by Events\"]")
	WebElement searchEvent;
	@FindBy(xpath = "//button[contains(text(),\"Search\")]")
	WebElement searchBtn;
	@FindBy(xpath = "//strong[contains(text(),\"Paid Durga pooja Fest\")]")
	WebElement poojaEvent;
	@FindBy(xpath = "//strong[@class='text-primary book-total-price']//span[@class='ng-binding'][normalize-space()='$10.00']")
	WebElement totalAmount;
	@FindBy(xpath = "//strong[normalize-space()='$5.00']")
	WebElement amountPaid;
	
	@FindBy(xpath = "//input[@name='PayerEmailID']")
	WebElement PayerEmailID;
	@FindBy(xpath = "//input[@name='PayerPhone']")
	WebElement PayerPhone;
	@FindBy(xpath = "//*[contains(text(),'Book Now')]")
	WebElement BookNowBtn;
	@FindBy(xpath = "//input[@id='confirmationEmail']")
	WebElement Email;
	@FindBy(xpath = "//button[contains(.,' Resend Confirmation')]")
	WebElement ResendConfirmationBtn;
	@FindBy(xpath = "//button[contains(.,' Submit')]")
	WebElement SubmitBtn;
	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement OKBtn;

	@FindBy(xpath = "//a[contains(.,'Attendees')]")
	WebElement AttendeesMenu;
	@FindBy(xpath = "//input[contains(@type,'search')]")
	WebElement AttendeesSearch;
	@FindBy(xpath = "//a[contains(.,' Event Details')]")
	WebElement BacktoEventDetailsPage;
	@FindBy(xpath = "//a[contains(.,'View All')]")
	WebElement ViewAll;
	@FindBy(xpath = "//input[@value='1']")
	WebElement BtnPayPal;
	@FindBy(xpath = "//*[@ng-show='data.ShowPaymentPaypal']//*[contains(text(),'Proceed')]")
	WebElement BtnPayment;
//	@FindBy(xpath = "//input[@value='2']")
	@FindBy(xpath = "//*[@class='radio-inline ng-scope']/*[@value='2']")//added on 30/03
	WebElement AuthorizeNet;
	@FindBy(xpath = "//*[@id='Authorizeform']//span[contains(.,'Proceed')]")
	WebElement BtnPaythroughCheckout;
	@FindBy(xpath = "//strong[@ng-bind='Event.EventName'] | //strong[@class='ng-binding']")
	WebElement EventName;
	@FindBy(xpath = "//i[@title='This is Private Event']")
	WebElement PrivateEvent;
	@FindBy(xpath = "//i[@Class='fa fa-clock-o']")
	WebElement EventDate;
	@FindBy(xpath = "//strong[@ng-bind='Video.Title']")
	WebElement VideoTitle;
	@FindBy(xpath = "//p[@ng-bind='Video.Description']")
	WebElement VideoDescription;
	@FindBy(xpath = "//p[@ng-bind='Document.Description']")
	WebElement documentDescription;
	@FindBy(xpath = "//strong[@ng-bind='Document.Title']")
	WebElement documentTitle;
	@FindBy(xpath = "//p[@ng-bind='Album.Description']")
	WebElement AlbumDescription;

	@FindBy(xpath = "//strong[@ng-bind='Album.Title']")
	WebElement albumTitle;
	@FindBy(xpath = "//a[contains(text(),'Albums')]")
	WebElement Albums;
	@FindBy(xpath = "//a[contains(text(),'Documents')]")
	WebElement Documents;
	@FindBy(xpath = "//a[contains(text(),'Videos')]")
	WebElement Videos;
	@FindBy(xpath = "//div[@class='event-venue ng-binding']")
	WebElement EventVenue;

	@FindBy(xpath = "//div[@class='ng-binding']")
	WebElement EventTime;
	@FindBy(xpath = "//div[@class='event-venue ng-binding']")
	WebElement eventvenue;
	@FindBy(xpath = "//div[@class='status-btn']")
	WebElement EventType;
	@FindBy(xpath = "//p[@class='label label-primary']")
	WebElement EventDetailsPageEventType;

	@FindBy(xpath = "//div[@class='text-center']//h1")
	WebElement Eventname;
	@FindBy(xpath = "(//p)[7]")
	WebElement Evdate;
	@FindBy(xpath = "//section[@id='details']//div[@class='container']//div[2]")
	WebElement Eventdetails;
	@FindBy(xpath = "//li[@class='item ng-scope']//strong[@class='text-primary']")
	WebElement AgendaDate;
	@FindBy(xpath = "(//p)[4]")
	WebElement EventAddress;

	@FindBy(xpath = "//p[@ng-if='agenda.Venue']")
	WebElement AgendeVenue;
	@FindBy(xpath = "//div[@id='home']//a")
	WebElement AlbumURL;
	@FindBy(xpath = "//h4[contains(.,'Event Attendees')]")
	WebElement attendeFormView;
	@FindBy(xpath = "//h4[contains(text(),'Booking Information')]")
	WebElement BookingInformation;
	@FindBy(xpath = "//*[@name='FirstName[]']")
	WebElement FirstName;
	@FindBy(xpath = "//*[@name='LastName[]']")
	WebElement LastName;
	@FindBy(xpath = "")
	WebElement Phone;
	@FindBy(xpath = "//*[@name='Company[]']")
	WebElement companyName;
	@FindBy(xpath = "//input[@name='GuestEmailID[]']")
	WebElement GuestEmailID;
	@FindBy(xpath = "//input[@name='GuestFirstName[]']")
	WebElement GuestFirstName;
	@FindBy(xpath = "//input[@name='GuestLastName[]']")
	WebElement GuestLastName;
	@FindBy(xpath = "//input[@name='GuestPhone[]']")
	WebElement GuestPhone;
	@FindBy(xpath = "//button[contains(.,'Invite Guest')]")
	WebElement InviteGuestBtn;
	@FindBy(xpath = "//button[contains(.,'Add Guest')]")
	WebElement AddGuestBtn;	
	@FindBy(xpath = "(//*[@id='PayerInfoForm']//*[@class='panel panel-default'])[1]")
	WebElement payerForm;	
	@FindBy(xpath = "//*[@id='eventAttendeesForm']")
	WebElement eventAttendeesForm;	
	@FindBy(xpath = "//*[@id='header']")
	WebElement header;
//	@FindBy(xpath = "//*[contains(text(),'Your registration has been processed')]")
	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed')] | //*[contains(text(),'Your registration has been processed')]")
	WebElement eventRegistrationProcessed;
	@FindBy(xpath = "(//*[@class='panel panel-default'])[4]")
	WebElement bookingSummary;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(Details);
	}
	@Override
	//protected void getPageScreenSot() {
		//updateClass(header, "");
		//aShot();
		//updateClass(header, "navbar-fixed-top");
	protected void getPageScreenSot() {

		aShot();//

		}	
   
	@FindBy(xpath = "(//*[@id='selectticketcount'])[5]")//added on 30/03
	WebElement paidTicket;
	public void addAttendeeDetailsPaid(Hashtable<String, String> data)
			throws Exception {
		click(RegisterBtn,"Register");
		Thread.sleep(2000);
		selectByVisibleText(paidTicket, "1", "Ticket");//for paid ticket
		Thread.sleep(2000);
		scrollToElement(attendeFormView);
		
		type(AttendeeEmailID,data.get("attendeeEmailID"),"Attendee Email ID");;
		
		type(AttendeePhone,data.get("attendeePhone"),"Attendee Phone");
		type(FirstName,data.get("attendeeFirstName"),"First Name");
		type(LastName,data.get("attendeLastName"),"Last Name");
		type(companyName,data.get("companyName"),"Company Name");
		

	}
	@FindBy(xpath="(//*[@id='selectticketcount'])[2]")
			WebElement Ticket2;
	public void addAttendeeDetails(Hashtable<String, String> data)
			throws Exception {

//		updateClass(header, "");		
		click(RegisterBtn,"Register");
		Thread.sleep(2000);
	//	selectByVisibleText(Ticket, "1", "Ticket");//for free ticket (if it is in first position in list at event page)
		selectByVisibleText(Ticket2, "1", "Ticket");//for free ticket (if it is in second position in list at event page)
		Thread.sleep(2000);
		scrollToElement(attendeFormView);
	//	Thread.sleep(2000);
	//	AttendeeEmailID.clear();
	//	FirstName.clear();
	//	LastName.clear();
	//	this.companyName.clear();
		
		type(AttendeeEmailID,data.get("attendeeEmailID"),"Attendee Email ID");
		type(AttendeePhone,data.get("attendeePhone"),"Attendee Phone");
		type(FirstName,data.get("attendeeFirstName"),"First Name");
		type(LastName,data.get("attendeLastName"),"Last Name");
		type(companyName,data.get("companyName"),"Company Name");
		
		Thread.sleep(2000);
	//	AttendeePhone.click();
	//	Thread.sleep(3000);
	//	updateClass(header, "");
	//	takeScreenshotByShutterBug(eventAttendeesForm, "event Attendees Form");
	//	updateClass(header, "navbar-fixed-top");
	
	}		


	public void registerFreeEvent(Hashtable<String, String> data) throws Exception {
		this.addAttendeeDetails(data);
		waitForElementToPresent(BookNowBtn);//added on 04/04
		clickElementByJavaScript(BookNowBtn);
	//	waitForElementToPresent(eventRegistrationProcessed);//commented on 04/04
	//	updateClass(header, "");
	//	aShot();
	}
	@FindBy(xpath="//*[@ng-click='data.AddGuestToGuestsObj()']")
	WebElement addGuest;
	@FindBy(xpath="//*[@ng-model='Invitee.FirstName']")
	WebElement inviteeFirstName;
	@FindBy(xpath="//*[@ng-model='Invitee.LastName']")
	WebElement inviteeLastName;
	@FindBy(xpath="//*[@ng-model='Invitee.EmailID']")
	WebElement mailID;
	@FindBy(xpath="//*[@type='submit']/*[text()='Invite Guest']")
	WebElement inviteGuest;
	@FindBy(xpath="//*[@class='modal-footer']/*[@class='btn btn-primary']")
	WebElement ok;
	public void inviteMember(String mail) throws InterruptedException {
		scrollDownVertically();
		scrollToElement(addGuest);
		click(addGuest,"add Guest");
		type(inviteeFirstName,"Ram","First Name");
		type(inviteeLastName,"ss","Last Name");
		type(mailID,mail,"MailId");
		Thread.sleep(5000);
		clickElementByJavaScript(inviteGuest);
		waitForElementToPresent(ok);
		click(ok,"ok");
	}
	
	
   @FindBy(xpath="//*[@class='btn btn-primary event-btn']/*[text()='View All']")
	WebElement view;
   @FindBy(xpath="//*[@id='btnResendConfirmation']")
   WebElement resend;
   @FindBy(xpath="//*[@id='confirmationEmail']")
   WebElement mail;
   @FindBy(xpath="//*[@class='col-xs-12 text-right']/*[@type='submit']")
   WebElement submit;
   @FindBy(xpath="//*[@class='modal-body']/*[text()='Confirmation Email has been sent successfully']")
   WebElement text;
   @FindBy(xpath=" //*[@class='modal-footer']/*[@class='btn btn-primary']")
   WebElement okButton;
	public void resendingConfirmationMail(String email) {
		
		waitForElementToPresent(view);
	//	waitForElementToPresent(resend);
		scrollToElement(resend);
	//	click(resend,"resending confirmation mail");
		hardClick(resend);
		waitForElementToPresent(mail);
		type(mail,email,"confirmation mail");
		click(submit,"submitting the mail");
		waitForElementToPresent(text);
		System.out.println(text.getText());
		
		click(okButton,"ok button");
		
		
	}
	
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement promoCodecheckbox;
	
	@FindBy(xpath="//input[@placeholder='Enter Promo code']")
	WebElement promoCode;
	
	@FindBy(xpath="//*[contains(text(),'APPLY')]")
	WebElement applybtn;
	
	@FindBy(xpath="//*[contains(text(),'The Promo code has been applied  and will be refle')]")
	WebElement promoCodeApplied;
	
	
	public void addPayerDetails(Hashtable<String, String> data) throws Exception {
		
		waitForElementToPresent(BookingInformation);
		scrollToElement(BookingInformation);
	//	PayerEmailID.clear();
		type(PayerEmailID, data.get("payerEmailID"), "Payer Email ID");
		PayerPhone.click();
		Thread.sleep(4000);
	//	updateClass(header, "");
//		takeScreenshotByShutterBug(payerForm, "Payer Form");
//		updateClass(header, "navbar-fixed-top");		
		scrollDownVertically();
		
		applyPromoCode(chanageToUpperCase(data.get("promoCode1")).toString(),this.promoCode,applybtn,promoCodeApplied);
		
		
		
	}
//	public void freeEventRegistration() throws Exception {		
//		scrollToElement(BookNowBtn);
//		click(BookNowBtn,"Book Now");		
//				
//		
//		
//		// softAssertion.assertEquals(Bookingsuccessful.getText(),"Your booking
//		// processed successfully");
//		// String screenShotPath = GetScreenShot.capture(driver,
//		// "ScreenShotName");
//		// //logger.//log(//logStatus.PASS,
//		// //logger.addScreenCapture(screenShotPath),"After Booking the Event
//		// Ticket");
//	}

	public void FullPercentPromocodeRegistration(Hashtable<String, String> data) throws Exception {
		this.addAttendeeDetails(data);
		click(NextBtn,"Next");
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(eventRegistrationProcessed);
		updateClass(header, "");
		aShot();
	}
	
	
	public  AuthorizeGateway registerEventbyAuthorizeNet(Hashtable<String, String> data) throws Exception {

		this.addAttendeeDetails(data);
		click(NextBtn,"Next");
		this.addPayerDetails(data);			
		clickElementByJavaScript(BookNowBtn);	
		waitForElementToPresent(AuthorizeNet);
		click(AuthorizeNet,"Selecting AuthorizeNet");
		waitForElementToPresent(BtnPaythroughCheckout);
		click(BtnPaythroughCheckout,"Proceed");		
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}
	public  AuthorizeGateway registerEventbyAuthorizeNet2(Hashtable<String, String> data) throws Exception {

		this.addAttendeeDetailsPaid(data);//for paid tickets
	//	click(NextBtn,"Next");
		this.addPayerDetails(data);			
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(2000);
		waitForElementToPresent(AuthorizeNet);
		click(AuthorizeNet,"Selecting AuthorizeNet");
		waitForElementToPresent(BtnPaythroughCheckout);
		click(BtnPaythroughCheckout,"Proceed");		
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

	public PayPalPayment registerEventByPayPal(Hashtable<String, String> data) throws Exception {

		this.addAttendeeDetails(data);
		//for free event free tickets and paid events free tickets and check in way booking
		
		click(NextBtn,"Next");
		this.addPayerDetails(data);			
		clickElementByJavaScript(BookNowBtn);		
		waitForElementToPresent(BtnPayPal);
		click(BtnPayPal,"Selecting PayPal");
		waitForElementToPresent(BtnPayment);
		click(BtnPayment,"Payment");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}
	public PayPalPayment registerEventByPayPal2(Hashtable<String, String> data) throws Exception {


			this.addAttendeeDetailsPaid(data);//for paid event paid tickets
		//	click(NextBtn,"Next");
			waitForElementToPresent(NextBtn);
			clickElementByJavaScript(NextBtn);
			this.addPayerDetails(data);			
			clickElementByJavaScript(BookNowBtn);	
			Thread.sleep(3000);//for wait purpose wail saving data
			waitForElementToPresent(BtnPayPal);
			click(BtnPayPal,"Selecting PayPal");
			waitForElementToPresent(BtnPayment);
			clickElementByJavaScript(BtnPayment);
			
			return (PayPalPayment) openPage(PayPalPayment.class);
		}
	

	public void registeredEventAttendees(String attendeeFirstName, String attendeelastName, String attendeeCompanyName,
			String webBrowser) throws Exception {
		if (webBrowser.equals("chrome")) {

			String parent = driver.getWindowHandle();
			//// System.out.println("Parent window id is "+parent);
			Set<String> allwindows = driver.getWindowHandles();
			int count = allwindows.size();
			//// System.out.println("Total windows="+count);
			for (String child : allwindows) {
				if (!parent.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
				}
			}
		}

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Attendees')]")));
		Thread.sleep(3000);
		click(AttendeesMenu,"AttendeesMenu");
		Thread.sleep(1000);
		click(ViewAll,"ViewAll");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		String AttendeeName = attendeeFirstName + " " + attendeelastName;
		AttendeesSearch.clear();
		type(AttendeesSearch, AttendeeName, "AttendeeName");
		
		WebElement Scrolldown = driver.findElement(By.xpath("//a[contains(.,'Previous')]"));
		executeScript("arguments[0].scrollIntoView(true);", Scrolldown);
		Thread.sleep(2000);

	}

	public void ResendRegistrationEmailConfirmation(String EmailID) throws Exception {
		

		click(RegisterBtn,"RegisterBtn");
		Thread.sleep(2000);
		click(ResendConfirmationBtn,"ResendConfirmationBtn");
		
		// Vertical scroll - down by 150 pixels
		executeScript("window.scrollBy(0,0)");
		Thread.sleep(2000);
		type(Email, EmailID, "EmailID");
		
		click(SubmitBtn,"SubmitBtn");
		Thread.sleep(3000);
		AssertionHelper.verifyText(driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText(),
				"Confirmation Email has been sent successfully");
		picture();
		click(OKBtn,"OKBtn");
		Thread.sleep(5000);

	}

	public int TABR() throws InterruptedException {
		List<WebElement> NoOfAttendees = driver.findElements(By.xpath("//*[@id='AttendeesTable']/tbody/tr"));
		//// System.out.println("NoOfAttendees"+NoOfAttendees.size());
		Thread.sleep(4000);
		int NoOfAtt = NoOfAttendees.size();
		return NoOfAtt;
	}

	public void BackToEventDetailsPage() throws InterruptedException {
		
		executeScript("arguments[0].click();", BacktoEventDetailsPage);
		// WebElement Backbutton = BacktoEventDetailsPage;
		// executeScript("arguments[0].scrollIntoView(true);",Backbutton);
		// BacktoEventDetailsPage.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Register ')]")));

		Thread.sleep(2000);

	}

	public void RegisteredAttendee(String AFName, String AFname, String ExpectedCompanyName) throws Exception {
		String AttendeeName = "AFName" + " " + "AFname";
		String NameoftheAttendee = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[2]"))
				.getText();
		AssertionHelper.verifyText(NameoftheAttendee, AttendeeName);
		String ActualCompanyName = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[3]"))
				.getAttribute("");
		AssertionHelper.verifyText(ActualCompanyName, ExpectedCompanyName);

		click(BacktoEventDetailsPage,"BacktoEventDetailsPage");
	}

	public void PaymentAbortedAttendee(String AFName, String AFname, String ExpectedCompanyName) throws Exception {
		String AttendeeName = "AFName" + " " + "AFname";
		String NameoftheAttendee = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[2]"))
				.getText();
		AssertionHelper.verifyText(NameoftheAttendee, AttendeeName);
		String ActualCompanyName = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[3]"))
				.getAttribute("");
		AssertionHelper.verifyText(ActualCompanyName, ExpectedCompanyName);
		click(BacktoEventDetailsPage,"BacktoEventDetailsPage");
	}

	public void GuestInvite(String firstName, String lastName, String guestEmailID, String phoneNo) throws Exception {

		
		scrollIntoView(ResendConfirmationBtn);
		click(AddGuestBtn,"AddGuestBtn");
		type(GuestFirstName, firstName, "firstName");
		type(GuestLastName, lastName, "lastName");
		type(GuestEmailID, guestEmailID, "guestEmailID");
		type(GuestPhone, phoneNo, "phoneNo");
		scrollIntoView(InviteGuestBtn);
		picture();
		click(InviteGuestBtn,"InviteGuestBtn");
		waitForElementToPresent(driver.findElement(By.xpath("//*[contains(text(),'Guest Invitation has been sent successfully')]")));
		String text = driver.findElement(By.xpath("//*[contains(text(),'Guest Invitation has been sent successfully')]")).getText();
		AssertionHelper.verifyText(text,"Guest Invitation has been sent successfully");
		picture();
		click(OKBtn,"OKBtn");
		Thread.sleep(5000);

	}

	public void EventinfoPage(String eventName, String isPaidEvent, String Address, String EventDescription,
			String isPrivateEvent, String eventStartTime, String eventEndTime, String AgendaStartDate,
			String AgendaEndDate, String Agendavenue, String AgendaDesc, String SpeakerName, String speakerBio,
			String SpeakerLinkedUrl, String SponsorType, String sponsorUrl, String sponsorName, String albumTitle,
			String AlbumDescription, String AlbumURL, String documentTitle, String documentDescription,
			String VideoTitle, String VideoDescription, String VideoURL) throws Exception {

		SoftAssert st = new SoftAssert();
		String e = Eventname.getText();
		//// System.out.println(e);
		// eventName = "CYBER SECURITY 2019";
		if (isPrivateEvent.equalsIgnoreCase("yes")) {
			eventName = "THIS IS PRIVATE EVENT " + eventName;

		}
		//// System.out.println(eventName);
		//// System.out.println(driver.findElement(By.xpath("//h1")).getText());

		if (eventName.equalsIgnoreCase(e)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Event Name: " + Eventname.getText(), "Event Name: " + eventName);
			//// System.out.println("Fail");
		}
		String EType;
		if (isPaidEvent.equalsIgnoreCase("yes")) {
			EType = "Paid";
		} else {
			EType = "Free";
		}
		String type = EventDetailsPageEventType.getText();
		 System.out.println(type);
		if (type.equalsIgnoreCase(EType)) {
			st.assertTrue(true);
		} else {
			st.assertEquals(type, EType);
		}

		try {
			//log.info("Verifying the location");
			String EventAddress = driver.findElement(By.xpath("//*[contains(text(),'" + Address + "')]")).getText();
			if (EventAddress.equalsIgnoreCase(Address)) {
				st.assertTrue(true);
				//log.info("EventAddress Fail");
			} else {
				st.assertEquals("Event Adress is not saved as the given input, Please check the screenshot",
						"Given Input is " + Address);
				
			}
		} catch (Exception e2) {
		}

		
		//log.info("Verifying the Event Description");
		String EventAbout = Eventdetails.getText();
		System.out.println(EventAbout);
		System.out.println(EventDescription);
		System.out.println(EventAbout);
		System.out.println(EventDescription);
		
		if (EventAbout.equalsIgnoreCase(EventDescription)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Event Description: " + EventAbout, "Event Description: " + EventDescription);
		}
		//log.info("Verifying the Event Date");
		String strStartDate = eventStartTime;
		String strEndDate = eventEndTime;

		// create SimpleDateFormat object with source string date format
		SimpleDateFormat sdfSource = new SimpleDateFormat("MM/dd/yyyy h:m a");

		// parse the string into Date object
		Date Sdate = sdfSource.parse(strStartDate);
		Date Edate = sdfSource.parse(strEndDate);

		// create SimpleDateFormat object with desired date format
		SimpleDateFormat sdfDestination = new SimpleDateFormat("MMM d, yyyy hh:mm a");

		// parse the date into another format
		strStartDate = sdfDestination.format(Sdate);
		strEndDate = sdfDestination.format(Edate);

		// //System.out.println("Date is converted from dd/MM/yy format to
		// MM-dd-yyyy hh:mm a");
		// //System.out.println(strStartDate);
		// //System.out.println(strEndDate); //System.out.println(strEndDate);

		String Date = strStartDate + " - " + strEndDate + " (AUS Central Standard Time)";
		//// System.out.println(Date);
		try {
			//log.info("Verifying the Agenda Date");
			driver.findElement(By.xpath("//p[contains(text(),'" + Date + "')]")).isDisplayed();
			 System.out.println("0");
		} catch (Exception e2) {
			st.assertEquals("Event Date: " + Evdate.getText(), "Event Date: " + Date);
			//log.info("Verified the Agenda Date");
		}

		// create SimpleDateFormat object with source string date format
		sdfSource = new SimpleDateFormat("MM/dd/yyyy h:m a");

		// parse the string into Date object
		Sdate = sdfSource.parse(AgendaStartDate);
		Edate = sdfSource.parse(AgendaEndDate);

		// create SimpleDateFormat object with desired date format
		sdfDestination = new SimpleDateFormat("MMM d, yyyy hh:mm a");

		// parse the date into another format
		strStartDate = sdfDestination.format(Sdate);
		strEndDate = sdfDestination.format(Edate);

		// //System.out.println("Date is converted from dd/MM/yy format to
		// MM-dd-yyyy hh:mm a");
		// //System.out.println(strStartDate);
		// //System.out.println(strEndDate);

		Date = strStartDate + " - " + strEndDate;
		// //System.out.println(Date);
		String ADate = AgendaDate.getText();
		if (ADate.equalsIgnoreCase(Date)) {
			st.assertTrue(true);

		} else {
			st.assertEquals("Agenda Date: " + ADate, "Agenda Date: " + Date);
		}

		String Venue = AgendeVenue.getText();
		if (Venue.equalsIgnoreCase(Agendavenue)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Venue:" + Venue, "Venue:"+"Venue - "  + Agendavenue);
		}

		try {
			//log.info("Verifying the Agenda");
			String Desc = driver.findElement(By.xpath("//div[contains(text(),'" + AgendaDesc + "')]")).getText();
			if (Desc.equalsIgnoreCase(AgendaDesc)) {
				st.assertTrue(true);
				//log.info("Agenda Pass");
			} else {
				st.assertEquals(
						"Description is not saved as per the given input, Please find the attached screen shot in Extent Report",
						"Given Input is " + AgendaDesc);
				//log.info("Agenda Fail");
			}
		} catch (Exception e2) {
		}

		try {
			//log.info("Verifying the Speaker Bio");
			String bio = driver.findElement(By.xpath("//div[contains(text(),'" + speakerBio + "')]")).getText();
			if (bio.equalsIgnoreCase(speakerBio)) {
				st.assertTrue(true);
			} else {
				st.assertEquals("Speaker bio: " + bio, "Speaker bio: " + speakerBio);
			}
		} catch (Exception e2) {
			AssertionHelper.verifyText("Speaker bio is not saved as per the given input, Please find the attached screen shot","Speaker bio: " + speakerBio);
		}

		String speakerName = driver.findElement(By.xpath("//div[@class='client_name']")).getText();

		// //System.out.println(speakerName);

		if (speakerName.equalsIgnoreCase(SpeakerName)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Speaker Name: " + speakerName, "Speaker Name: " + SpeakerName);
		}
		try {
			//log.info("Verifying the Speaker LinkedIn url");
			String SpeakerUrl = driver.findElement(By
					.xpath("//div[@class='row speaker-box bg-primary']//div[@class='col-lg-3 col-sm-3']//div[@class='client_box']//a[@href='"
							+ SpeakerLinkedUrl + "']"))
					.getAttribute("href");
			st.assertEquals("Speaker LinkedIn Url: " + SpeakerUrl, "Speaker LinkedIn Url: " + SpeakerLinkedUrl);
			//// System.out.println("1");
		} catch (Exception e2) {
			st.assertEquals("Speaker LinkedIn Url is not displayed, Please check the screenshot",
					"Speaker LinkedIn Url should be displayed as " + SpeakerLinkedUrl);
			//// System.out.println("0");
		}
		try {
			//log.info("Verifying the Sponsor Type");
			String sponsorType = driver.findElement(By.xpath("//h4[contains(text(),'" + SponsorType + "')]")).getText();
			st.assertEquals(sponsorType, SponsorType);
		} catch (Exception e2) {
			st.assertEquals("Sponsor type is not is displayed", "Sponsor should be displayed as " + SponsorType);
		}
		try {
			//log.info("Verifying the Sponsor name");
			String SponsorName = driver.findElement(By.xpath("//a[@class='ng-binding']")).getText();
			st.assertEquals("Sponsor Name: " + SponsorName, "Sponsor Name: " + sponsorName);
		} catch (Exception e2) {
			st.assertEquals("Sponsor Name LinkedIn Url is not displayed, Please check the screenshot",
					"SponsorName should be displayed as " + sponsorName);
		}
		try {
			//log.info("Verifying the Sponsor Name");
			String Sponsor = driver.findElement(By.xpath("//a[@class='ng-binding']")).getText();
			AssertionHelper.verifyText(Sponsor, sponsorUrl);

		} catch (Exception e2) {
			st.assertEquals("Sponsor url :" + sponsorUrl + " is not displayed",
					"Sponsor Url should be displayed as " + sponsorUrl);
		}
		
		try {
			//log.info("Verifying the Album");
			st.assertTrue(Albums.isDisplayed());

		} catch (Exception e2) {
			st.assertEquals("Album Tab is not displayed, pleas echeck the screenshot", "Album Tab should be displayed");
		}

		try {
			//log.info("Verifying the Album title");
			st.assertEquals(this.albumTitle.getText(), albumTitle);
		} catch (Exception e2) {

			st.assertEquals("Album Title is not displayed. please check the sreen shot",
					"Album Title should be displayed as: " + albumTitle);

		}
		try {
			//log.info("Verifying the Album description");
			st.assertEquals(this.AlbumDescription.getText(), AlbumDescription);
		} catch (Exception e2) {

			st.assertEquals("Album Description is not displayed. please check the sreen shot",
					"Album Description should be displayed as: " + AlbumDescription);
		}
		try {
			//log.info("Verifying the Album Url");
			String Url = this.AlbumURL.getAttribute("href");
			//// System.out.println(Url);
			st.assertEquals(Url, AlbumURL);

		} catch (Exception e2) {
			st.assertEquals("Album Url should be displayed as" + AlbumURL,
					"Album Url:" + AlbumURL + " is not displayed");
		}
		scrollToElement(Documents);
		clickElementByJavaScript(Documents);
		try {
			//log.info("Verifying the document Description");
			st.assertEquals(this.documentDescription.getText(), documentDescription);
		} catch (Exception e2) {

			st.assertEquals("document Description is not displayed. please check the sreen shot",
					"document Description should be displayed as: " + documentDescription);
		}
		try {
			//log.info("Verifying the document Title");
			st.assertEquals(this.documentTitle.getText(), documentTitle);
			//// System.out.println(this.documentTitle.getText());
			// //System.out.println(documentTitle);
		} catch (Exception e2) {

			st.assertEquals("Document Title is not displayed. please check the sreen shot",
					"Document Title should be displayed as: " + documentTitle);
		}
		scrollIntoView(Videos);
		clickElementByJavaScript(Videos);

		try {
			//log.info("Verifying the Video Title");
			st.assertEquals(this.VideoTitle.getText(), VideoTitle);
		} catch (Exception e2) {

			st.assertEquals("Video Title is not displayed. please check the sreen shot",
					"Video Title should be displayed as: " + VideoTitle);
		}
		try {
			//log.info("Verifying the Video Description");
			st.assertEquals(this.VideoDescription.getText(), VideoDescription);
		} catch (Exception e2) {

			st.assertEquals("Video Description is not displayed. please check the sreen shot",
					"Video Description should be displayed as: " + VideoDescription);
		}
		try {
			//log.info("Verifying the Video Url");
			String Url = driver
					.findElement(By.xpath(
							"//div[@class='col-sm-3 ng-scope']//div[@class='ng-scope']//a[@href='" + VideoURL + "']"))
					.getAttribute("href");
			st.assertEquals(Url, VideoURL);

		} catch (Exception e2) {
			st.assertEquals("Video Url :" + VideoURL + " is not displayed",
					"Video Url should be displayed as " + VideoURL);
		}
		st.assertAll();

		// div[contains(text(),'Please check Back Soon....')]
		// p[contains(.,'Oct 20, 2019 10:30 AM - Oct 30, 2019 10:30 PM (AUS Central Standard Time
		// )')]

	}

	public void checkPromoCode(String promoCode)
			throws Exception {

//		updateClass(header, "");		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(congratulationsMsg.getText().contains("Congratulations")) {
			System.out.println("Member was able to use promocode");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	
	}	
	public void checkPromoCodeWhenExhausted(String promoCode)
			throws Exception {	
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(exceedMsg.getText().equalsIgnoreCase("Sorry! The Promo code you have entered has exceeded the usage limit. Please try with a different code.")) {
			System.out.println("Member cannot use exhausted Promocode");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	
	}	
	public void checkPromoCodeWhenNotMember(String promoCode)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(sorryMsg.getText().contains("Sorry")) {
			System.out.println("Member was not able to use promocode if they are part of community");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	
	}	
	public void checkInactivePromoCode(String promoCode)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(inactiveMsg.getText().equals("Sorry! The Promo code you have entered is not valid. Please try with a different code.")) {
			System.out.println("Member was not able to use promocode if promocode is inactive");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	
	}	
	public void checkExpiredPromoCode(String promoCode)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(expiredMsg.getText().equals("Sorry! The Promo code you have entered has expired. Please try with a different code.")) {
			System.out.println("Member was not able to use promocode if promocode has expired");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	
	}	
	public void checkPromoCodeForSpecificEvent(String promoCode,String Event)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(7000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(inactiveMsg.getText().equals("Sorry! The Promo code you have entered is not valid. Please try with a different code.")) {
			System.out.println("Member was not able to use promocode if promocode is for any other specific event");
			Assert.assertTrue(true);  //promocode is for event Paid Durga Pooja 
		}else Assert.assertTrue(false);
		driver.navigate().back();
		Thread.sleep(12000);
		waitForElementToPresent(searchEvent);
		type(searchEvent,Event,Event);
		click(searchBtn,"Search");
		Thread.sleep(5000);
		click(poojaEvent,"Event whose PC is there");
		Thread.sleep(5000);
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket2, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(congratulationsMsg.getText().contains("Congratulations")) {
			System.out.println("Member was able to use promocode for event that is specified");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		
	
	}	
	public void checkDiscountWhenPCinPercentage(String promoCode)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		if(congratulationsMsg.getText().contains("Congratulations")) {
			System.out.println("Member was able to use promocode");		
		}
		System.out.println("Total amount to be paid="+ totalAmount.getText());
		System.out.println("Amount after discount="+ amountPaid.getText());
		if( amountPaid.getText().equals("$5.00")) {
			System.out.println("Discount coupon of percentage is working");
			Assert.assertTrue(true);
			
		}else Assert.assertTrue(false);
	
	}
	public void checkPromoCodeInfoCleared(String promoCode)
			throws Exception {		
		click(RegisterBtn,"Register");
		Thread.sleep(1000);
		selectByVisibleText(selectTicket, "1", "Ticket");
		Thread.sleep(4000);
		scrollToElement(attendeFormView);
		click(NextBtn,"Next");
		Thread.sleep(2000);
		scrollToElement(iHavePromocode);
		click(iHavePromocode,"I have promo code");
		type(Promocode,promoCode,"PromoCode");
		click(apply,"APPLY");
		System.out.println(congratulationsMsg.getText());
		driver.navigate().refresh();
		Thread.sleep(4000);
		if(RegisterBtn.isDisplayed()) {
System.out.println("After refresh promocode details still there");
			
		}else System.out.println("Promo code details deleted after refresh");;		
	
	}	
	
}

