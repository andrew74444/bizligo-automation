package com.cpcommunity.PageObjects;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cpcommunity.utilities.DriverManager;

import junit.framework.Assert;

public class Yahoo extends BasePage {
	
	
	public void openAndGoToNewTab() {
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
}
	public void backToOldTab() {
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		}
	@FindBy(xpath="//*[@class='logo ']")
	WebElement yahooLogo;
	@FindBy(xpath="//*[@name='username']")
	WebElement yahooMail;
	@FindBy(xpath="//*[@id='login-signin']")
	WebElement nextbutton;
	
	@FindBy(xpath="//*[@id='login-passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='logo']")
	WebElement logo;
	
	@FindBy(xpath="//*[@class='icon mail']")
	WebElement mailIcon;
	
	@FindBy(xpath="(//*[@title='no-replyqa@bizligotest.com']/*[text()='Bizligo'])[1]")
	WebElement bizligo;
	
	@FindBy(xpath="//span[contains(text(),\"You're almost there!\")]")
	WebElement almost;
	
	@FindBy(xpath="//*[text()='Payment Confirmation']")
	WebElement payment;
	
	@FindBy(xpath="//*[text()='You have a new connection request.']")
	WebElement connection;
	
	@FindBy(xpath="(//*[contains(text(),'Endorsement Received from')])[1]")
			WebElement endorsement;
	
	@FindBy(xpath="//*[text()='Job Application Successful']")
	WebElement jobAppMail;
	
	@FindBy(xpath="//*[text()='You have Successfully Joined Community']")
	WebElement communityMail;
	
	@FindBy(xpath="//*[text()='Your Request to Join Private Community']")
	WebElement privateCommunity;
	
	@FindBy(xpath="//*[text()='You have Successfully Joined Group']")
	WebElement join;
	
	@FindBy(xpath="//*[text()='You are successfully left from the group']")
	WebElement leave;
	
	@FindBy(xpath="//*[text()='You have been added to Group']")
	WebElement add;
	
	@FindBy(xpath="(//*[text()='You have been removed from Group'])[1]")
	WebElement remove;
	
	@FindBy(xpath="(//*[text()='Your Request to Join Private Group'])[1]")
	
	WebElement joinPrivate;
	
	@FindBy(xpath="//*[text()='You are Group Admin now']")
	WebElement madeAdmin;
	@FindBy(xpath="//*[text()='You are removed as Group Admin']")
	WebElement removedAdmin;
	
	@FindBy(xpath="//*[text()='Your Request to Join Private Community  is Approved']")
	WebElement approve;
	@FindBy(xpath="//*[contains(text(),'New Event Announcement:')]")
	WebElement newEvent;
	
	@FindBy(xpath="(//*[text()='Event Registration Notification'])[1]")
			WebElement eventRegs;
	
	@FindBy(xpath="(//*[text()='Event Ticket Purchase Details'])[1]")
			WebElement purchase;
	@FindBy(xpath="(//*[text()='Resending Event Registration Notification'])[1]")
			WebElement resendingmail;
	@FindBy(xpath="(//*[text()='Job Application Received'])[1]")
			WebElement application;
	@FindBy(xpath="(//*[text()='Meeting Account Configured'])[1]")
			WebElement meeting;
	@FindBy(xpath="(//*[text()='Payment Gateway Configured'])[1]")
			WebElement paymentGateway;
	@FindBy(xpath="(//*[text()='You are Community Admin now'])[1]")
			WebElement CAdminNow;
	@FindBy(xpath="(//*[text()='You are removed as Community Admin'])[1]")
	WebElement removedCAdmin;
	@FindBy(xpath="(//*[text()='Payment Gateway Activated'])[1]")
			WebElement cash;
	
	@FindBy(xpath="(//*[text()='Meeting Account Inactivated'])[1]")
			WebElement meetingAcInactive;
	@FindBy(xpath="(//*[text()='Meeting Account Activated'])[1]")
			WebElement meetingAcActive;
	@FindBy(xpath="(//*[text()='Community join invitation'])[1]")
			WebElement invitation;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		DriverManager.getDriver().navigate().to(
				"https://login.yahoo.com/?.src=search&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr&pspid=2114723002&activity=header-signin");
	
		return ExpectedConditions.visibilityOf(yahooLogo);
	}

	

	public Yahoo open() {

		DriverManager.getDriver().navigate().to(
				"https://login.yahoo.com/?.src=search&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr&pspid=2114723002&activity=header-signin");
		return (Yahoo) openPage(Yahoo.class);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}	public void Login(String email, String password) throws Exception {

	Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	String browserName = caps.getBrowserName();
	String browserVersion = caps.getVersion();
	System.out.println(browserName);
	System.out.println(browserVersion);

	// Get OS name.
	String os = System.getProperty("os.name").toLowerCase();
	System.out.println(os);

	waitForElementToPresent(this.yahooMail);
	type(this.yahooMail, email, "Yahoo Mail");
//	clickElementByJavaScript(nextbutton);
	click(nextbutton,"next");	
	
	waitForElementToPresent(this.password);
	type(this.password, password, "password");
	
//	waitForElementToPresent(nextbutton);
//	clickElementByJavaScript(nextbutton);
	click(nextbutton,"next");	
	
	//waitForElementToPresent(mailIcon);
	//click(logo,"logo");
	click(mailIcon,"mailIcon");	
	
	}
	
	
	
	 
	 
	 @FindBy(xpath="//*[text()='Password Reset']")
	 
	 WebElement reset;
	 
	 @FindBy(xpath="//*[text()='Reset Your Password']")
	
	 WebElement clickReset;

	 
	 @FindBy(xpath="//*[text()='Reset Password']")
	 WebElement passwordRestConfirmation;

	 @FindBy(xpath = "//input[@name='Password']")
		WebElement Password;

		@FindBy(xpath = "//input[@name='ConfirmPassword']")
		WebElement ConfirmPassword;

		@FindBy(xpath = "//button[contains(text(),'Reset')]")
		WebElement ResetButton;
		
		@FindBy(xpath = "//*[@class='btn btn-success btn-sm']")
		WebElement clickLogin;
	 
	public void reset() throws InterruptedException {
		
		Thread.sleep(5000);
		click(reset,"Password Reset Mail");
		
		Thread.sleep(2000);
		click(clickReset,"Reset link");

		
		String currentHandle= driver.getWindowHandle();

		
		Thread.sleep(2000);

		
		//Get all the handles currently available
		Set<String> handles=driver.getWindowHandles();
		for(String actual: handles) {
		
		//Switch to the opened tab
			
		driver.switchTo().window(actual);

		}
		
		
		
		
		
		Thread.sleep(2000);
		 String text=passwordRestConfirmation.getText();
		 System.out.println(text);
		 
		 Thread.sleep(2000);
	type(Password,"Pamten@123","password");
		 
		 Thread.sleep(2000);
		type(ConfirmPassword,"Pamten@123","confirm password");
		 
		 Thread.sleep(2000);
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", Reset)
		 

		 
		 click(ResetButton,"resetting the password");
		 Thread.sleep(2000);
		 
		// click(clickLogin,"for login page");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", clickLogin);
		 
		 }
	@FindBy(xpath="(//*[@valign='top']/div/p)[3]")
	WebElement code;
	public void emailVerfication() throws InterruptedException {
	
		
		
		
			waitForElementToPresent(almost);
			click(almost,"account verfication mail");
			Thread.sleep(2000);
			String text=code.getText();
			System.out.println(text);
			Thread.sleep(1000);
		String text2=text.replaceAll("Please use this verification code to verify your email address: ","");
		Thread.sleep(1000);
		System.out.println(text2);
		
		String text3=text2.substring(0,6);
		
			System.out.println(text3);
			
		
//			String currentHandle= driver.getWindowHandle();
//			Thread.sleep(2000);	
//			//Get all the handles currently available
//			Set<String> handles=driver.getWindowHandles();
//			for(String actual: handles) {
//			
//			//Switch to the opened tab
//				driver.switchTo().window(actual);}
	} 
	public void paymentVerification() {
		waitForElementToPresent(payment);
		click(payment,"payment confirmation mail");
	}
	public void connectionVerfication() {
		waitForElementToPresent(connection);
		click(connection,"new connection request mail");
	}
	public void endorsementVerfication() {
		waitForElementToPresent(endorsement);
		click(endorsement,"endorsement mail");
	}
	public void jobMailVerfication() {
		waitForElementToPresent(jobAppMail);
		click(jobAppMail,"job application mail");
	}
	public void joinedCommunity() {
		waitForElementToPresent(communityMail);
		click(communityMail,"joined community mail");
	}
	public void requestCommunity() {
		waitForElementToPresent(privateCommunity);
		click(privateCommunity,"Request to join the private community mail");
	}
	@FindBy(xpath="(//*[text()='Member Request to Join a Private Community'])[1]")
			WebElement requestToJoin;
			public void memberRequestChecking() {
				waitForElementToPresent(requestToJoin);
				click(requestToJoin,"Member Request to join the private community mail");
			}
	public void joinedGroup() {
		waitForElementToPresent(join);
		click(join,"succesfully joined the public group mail");
	}
	@FindBy(xpath="(//*[text()='You are successfully left from the group'])[1]")
			WebElement leavee;
	public void leaveGroup() {
		waitForElementToPresent(leavee);
		click(leavee,"succesfully left from the group mail");
	}
	public void left() {
		waitForElementToPresent(leave);
		click(leave,"leaved the public group");
	}
	public void added() {
		waitForElementToPresent(add);
		click(add,"added to the group");
	}
	public void removed() {
		waitForElementToPresent(remove);
		click(remove,"removed from the group");
	}
	public void requestedPrivateGroup() {
		waitForElementToPresent(joinPrivate);
		click(joinPrivate,"requested to join the private group");
	}
	@FindBy(xpath="(//*[text()='Member Request to Join a Private Group'])[1]")
			WebElement memberRequest;
	public void memberRequestedJoinPrivateGroup() {
		waitForElementToPresent(memberRequest);
		click(memberRequest,"Member Requested to join the private group");
	}
	@FindBy(xpath="	(//*[text()='You are successfully left from the group'])[1]")
			WebElement cancelRequest;
	public void cancelRequestPrivateGroup() {
		waitForElementToPresent(cancelRequest);
		click(cancelRequest,"You are successfully left from the group mail");
	}
	public void caMadeAdmin() {
		waitForElementToPresent(madeAdmin);
		click(madeAdmin,"Group admin");
	}
	public void caRemovedAdmin() {
		waitForElementToPresent(removedAdmin);
		click(removedAdmin,"removed as a group admin");
	}
	public void appovedByCA() {
		waitForElementToPresent(approve);
		click(approve,"request is approved by CA to join community");
	}
	@FindBy(xpath="(//*[text()='Your Request to Join Private Community is not Approved'])[1]")
			WebElement notApproved;
	public void notAppovedByCA() {
		waitForElementToPresent(notApproved);
		click(notApproved,"request is not approved by CA to join community");
	}
	public void newEventMail() {
		waitForElementToPresent(newEvent);
		click(newEvent,"New event notification");
	}
	public void EventRegsNotification() {
		waitForElementToPresent(eventRegs);
		click(eventRegs,"Event Registation notification Mail");
	}
	@FindBy(xpath="(//*[text()='Complimentary Ticket Rejected'])[1]")
			WebElement rejected;
	public void complimentryTicketRejected() {
		waitForElementToPresent(rejected);
		click(rejected,"Complimentary Ticket Rejected mail");
	}
	public void purchaseNotification() {
		waitForElementToPresent(purchase);
		click(purchase,"Purchase Details notification Mail");
	}
	public void resendingConfirmMail() {
		waitForElementToPresent(resendingmail);
		click(resendingmail,"resending confirmation Mail");
	}
	public void jobApplicationMail() {
		waitForElementToPresent(application);
		click(application,"job application received Mail");
	}
	public void meetingAccount() {
		waitForElementToPresent(meeting);
		click(meeting,"meeting account configured Mail");
	}
	public void paymentGateway() {
		waitForElementToPresent(paymentGateway);
		click(paymentGateway,"payment gateway configured Mail");
	}
	public void cashPaymentGateway() {
		waitForElementToPresent(cash);
		click(cash," cash payment gateway activated Mail");
	}
	public void adminNow() {
		waitForElementToPresent(CAdminNow);
		click(CAdminNow,"you are community admin now Mail");
	}
	public void removedCAdmin() {
		waitForElementToPresent(removedCAdmin);
		click(removedCAdmin,"you are removed as community admin Mail");
	}
	@FindBy(xpath="(//*[text()='Community Admin Added you to Community'])[1]")
			WebElement addedTo;
	public void addedToCommunity() {
		waitForElementToPresent(addedTo);
		click(addedTo,"Community Admin added to community Mail");
	}
	@FindBy(xpath="(//*[text()='Community Admin Removed you from Community'])[1]")
			WebElement removedFrom;
	public void removedFromCommunity() {
		waitForElementToPresent(removedFrom);
		click(removedFrom,"Community Admin removed from to community... Mail");
	}
	public void meetingAccountInActive() {
		waitForElementToPresent(meetingAcInactive);
		click(meetingAcInactive,"Meeting Account InActivated confirmation Mail");
	}public void meetingAccountActive() {
		waitForElementToPresent(meetingAcActive);
		click(meetingAcActive,"Meeting Account Activated confirmation Mail");
	}
@FindBy(xpath="(//*[text()='Payment Gateway Inactivated'])[1]")
			WebElement gatewayInActive;

public void paymentGatewayInActive() {
	waitForElementToPresent(gatewayInActive);
	click(gatewayInActive,"Payment Gateway Account InActivated confirmation Mail");
}
public void paymentGatewayActive() {
	waitForElementToPresent(cash);
	click(cash,"Payment gateway Account Activated confirmation Mail");
}
@FindBy(xpath="(//*[text()='Your Request to Join Private Group is not Approved'])[1]")
		WebElement notapproved;
public void notApproved() {
	waitForElementToPresent(notapproved);
	click(notapproved,"Your Request to Join Private Group is not Approved Mail");
}
@FindBy(xpath="(//*[text()='Your Request to Join Private Group is rejected'])[1]")
WebElement check;
@FindBy(xpath="(//*[@data-test-id='message-from'])[1]")
WebElement fromEmail;
public void checkingFromEmailAddress() {
waitForElementToPresent(check);
click(check,"Your Request to Join Private Group is rejected Mail");
waitForElementToPresent(fromEmail);
String text=fromEmail.getText();
if(text.contains("venkatakodi7@gmail.com")) {
	Assert.assertTrue(true);
	System.out.println("Group Email Template is updated successfully!");
}
}
@FindBy(xpath="(//*[text()='Your Request to Join Private Group is Approved'])[1]")
WebElement approved;
      public void Approved() {
waitForElementToPresent(approved);
click(approved,"Your Request to Join Private Group is Approved Mail");
}
    public void communityInvitation() {
	waitForElementToPresent(invitation);
	click(invitation,"community admin invited to join community Mail");
}
    @FindBy(xpath=" (//*[text()='Community join invitation'])[1]")
    		WebElement joinInvite;
    public void communityJoinInvitation() {
    	waitForElementToPresent(joinInvite);
    	click(joinInvite,"Community join invitation Mail");
    }
    @FindBy(xpath="   (//*[text()='Invitation to join community is accepted by you'])[1]")
    		WebElement accepted;
    @FindBy(xpath="   (//*[text()='Invitation to join community is rejected by you'])[1]")
	WebElement rejected2;
    public void communityJoinInvitationAccepted() {
    	waitForElementToPresent(accepted);
    	click(accepted,"Community join invitation accepted by member Mail");
    }
    public void communityJoinInvitationRejected() {
    	waitForElementToPresent(rejected2);
    	click(rejected2,"Community join invitation rejected by member Mail");
    }
    
    @FindBy(xpath="  (//*[text()='Member Left from the Community'])[1]")
    		WebElement memberLeft;
    public void memberLeftCommunity() {
    	waitForElementToPresent(memberLeft);
    	click(memberLeft,"Member left community Mail");
    }
    @FindBy(xpath="  (//*[text()='Community Inactivated'])[1]")
    		WebElement inactivated;
    public void communityInActivated() {
    	waitForElementToPresent( inactivated);
    	click( inactivated,"community inactivated Mail");
    }
    @FindBy(xpath="  (//*[text()='Community Activated'])[1]")
	WebElement activated;
public void communityActivated() {
waitForElementToPresent( activated);
click( activated,"community Activated Mail");
}
    @FindBy(xpath="   (//*[text()='Congratulations and Welcome!'])[1]")
    		WebElement congrts;
    public void tAdminApprovedCommunity() {
    	waitForElementToPresent(congrts);
    	click(congrts,"Congratulations and Welcome! Mail");
    }
    @FindBy(xpath="  (//*[text()='Your Community is Rejected'])[1]")
    		WebElement rej;
    public void tAdminRejectedCommunity() {
    	waitForElementToPresent(rej);
    	click(rej,"Community Rejected Mail");
    }
    @FindBy(xpath="  (//*[text()='Event Invitation'])[1]")
    		WebElement invite;
    public void invitation() {
    	waitForElementToPresent(invite);
    	click(invite,"Event Invitation Mail");
    }
    @FindBy(xpath="  (//*[text()='Contact us request from Website'])[1]")
    		WebElement contact;
    public void tAdminEnqiryMail() {
    	waitForElementToPresent(contact);
    	click(contact,"Enquiry Mail");
    
    }
    @FindBy(xpath="   (//*[text()='New Testimonial is submitted for Approval'])[1]")
    WebElement testi;
    public void newTestimonials() {
    	waitForElementToPresent(testi);
    	click(testi," New Testimonial is submitted for Approval Mail");
    	
    }
    @FindBy(xpath="   (//*[text()='Testimonial is approved'])[1]")
    		WebElement testApproved;
    public void testimonialsApproved() {
    	waitForElementToPresent(testApproved);
    	click(testApproved," Testimonial is Approved Mail");
    }
    @FindBy(xpath=" (//*[text()='Testimonial is rejected'])[1]")
    WebElement testRejected;
    public void testimonialsRejected() {
    	waitForElementToPresent(testRejected);
    	click(testRejected," Testimonial is Rejected Mail");
    }
    @FindBy(xpath=" (//*[text()='Testimonial is pending'])[1]")
    		WebElement testiPending;
	
public void testimonialsPending() {
	waitForElementToPresent(testiPending);
	click(testiPending," Testimonial is pending Mail");
}
@FindBy(xpath="(//*[text()='New Member Registration Notification'])[1]")
		WebElement newMember;
public void tAdminRegsNotification() {
	waitForElementToPresent(newMember);
	click(newMember,"New Member Registration Notification");
}
@FindBy(xpath="(//*[text()='Event Survey Notification'])[1]")
WebElement survey;
public void surveyNotification() {
waitForElementToPresent(survey);
click(survey,"Event Survey Notification");
}
@FindBy(xpath="(//*[text()='Pricing Plan Purchase Successful Notification'])[1]")
		WebElement pricingplan;
       public void pricingPlanNotificationToCA() {
waitForElementToPresent(pricingplan);
click(pricingplan,"Pricing Plan Purchase Successful Notification mail");
}
          @FindBy(xpath="(//*[text()='Community Admin Purchased Pricing Plan'])[1]")
		WebElement purchased;
          
          public void pricingPlanNotificationToTA() {
        	  waitForElementToPresent(purchased);
        	  click(purchased,"Community Admin Purchased Pricing Plan mail");
        	  }
          @FindBy(xpath="  (//*[text()='Pricing Plan upgraded for your Community'])[1]")
        		  WebElement upgraded;
          public void planUpgradedMailToCA() {
        	  waitForElementToPresent(upgraded);
        	  click(upgraded,"Pricing Plan upgraded for your Community mail");
        	  
          }
          @FindBy(xpath="    (//*[text()='Pricing Plan renewed your Community'])[1]")
        		  WebElement renewed;
                  public void planRenewedMailToCA() {
                	  waitForElementToPresent(renewed);
                	  click(renewed,"Pricing Plan renewed for your Community mail");
                	  
                  }
                  @FindBy(xpath="      (//*[text()='Pricing Plan changed for your Community'])[1]")
                		  WebElement changed;
                          public void planChangedMailToCA() {
                        	  waitForElementToPresent(changed);
                        	  click(changed,"Pricing Plan changed for your Community mail");
                        	  
                          }
                  @FindBy(xpath="         (//*[text()='Community Admin upgraded the Pricing Plan'])[1]") 
                        		  WebElement upgradedByCA;
                  public void planUpgradedMailToTA() {
                	  waitForElementToPresent(upgradedByCA);
                	  click(upgradedByCA,"Community Admin upgraded the Pricing Plan mail");
                	  
                  }
                  @FindBy(xpath="(//*[text()='Community Admin renewed the Pricing Plan'])[1]")
        		  WebElement renewedByCA;
                  public void planRenewedMailToTA() {
                	  waitForElementToPresent(renewedByCA);
                	  click(renewedByCA,"Community Admin renewed the Pricing Plan");
                	  
                  }
                  @FindBy(xpath="(//*[text()='Community Admin changed the Pricing Plan'])[1]")
        		  WebElement changedByCA;
                  public void planChangedMailToTA() {
                	  waitForElementToPresent(changedByCA);
                	  click(changedByCA,"Community Admin changed the Pricing Plan mail");
                	  
                  }
                  @FindBy(xpath="     (//*[text()='Member Purchased Membership Plan'])[1]")
                		  WebElement membershipPurchased;
                  public void membershipPlanMailToCA() {
                	  waitForElementToPresent(membershipPurchased);
                	  click(membershipPurchased,"Member Purchased Membership Plan mail");
                	  
                  }
                  @FindBy(xpath="      (//*[text()='Member changed Membership Plan'])[1]")
                		  WebElement membershipChanged;
                          public void membershipPlanChangedMailToCA() {
                        	  waitForElementToPresent(membershipChanged);
                        	  click(membershipChanged,"Member changed Membership Plan mail");
                        	  
                          }
                          @FindBy(xpath="(//*[text()='Member renewed Membership Plan'])[1]")
                		  WebElement membershipRenewed;
                          public void membershipPlanRenewedMailToCA() {
                        	  waitForElementToPresent(membershipRenewed);
                        	  click(membershipRenewed,"Member Renewed Membership Plan mail");
                        	  
                          }
                          @FindBy(xpath="(//*[text()='Member upgraded the Membership Plan'])[1]")
                		  WebElement membershipUpgraded;
                          public void membershipPlanUpgradedMailToCA() {
                        	  waitForElementToPresent(membershipUpgraded);
                        	  click(membershipUpgraded,"Member upgraded Membership Plan mail");
                        	  
                          }
                          @FindBy(xpath="    (//*[text()='You have successfully Joined in the Community'])[1]")
                        		  WebElement	  membershipPlan;
                        		  
                                  public void membershipPlanMail() {
                                	  waitForElementToPresent(membershipPlan);
                                	  click(membershipPlan,"You have successfully Joined in the Community mail");
                                	  
                                  }
                                  @FindBy(xpath="(//*[text()='You have changed your Membership Plan'])[1]")
                        		  WebElement memPlanChanged;
                                  public void membershipPlanChangedMail() {
                                	  waitForElementToPresent(memPlanChanged);
                                	  click(memPlanChanged,"You have changed your Membership Plan mail");
                                	  
                                  }
                                  @FindBy(xpath="(//*[text()='You have renewed your Membership Plan'])[1]")
                        		  WebElement memPlanRenewed;
                                  public void membershipPlanRenewedMail() {
                                	  waitForElementToPresent(memPlanRenewed);
                                	  click(memPlanRenewed,"You have renewed your Membership Plan mail");
                                	  
                                  }
    @FindBy(xpath="(//*[text()='You have upgraded your Membership Plan'])[1]")
     WebElement memPlanUpgraded;
        public void membershipPlanUpgradedMail() {
                                	  waitForElementToPresent(memPlanUpgraded);
                                	  click(memPlanUpgraded,"You have upgraded your Membership Plan mail");
                                	  
                                  }   
        @FindBy(xpath="  (//*[text()='Donation payment confirmation'])[1]")
        		WebElement donation;
        public void donationMail() {
        	waitForElementToPresent(donation);
      	  click(donation,"Donation payment confirmation mail");
        	
        }
        @FindBy(xpath="    (//*[text()='New Advertisement Plan Publish Notification'])[1]")
        		WebElement ad;
        public void newAdNotificationToMember() {
        	waitForElementToPresent(ad);
        	  click(ad,"New Advertisement Plan Publish Notification mail");
        	
        }
        @FindBy(xpath="  (//*[text()='Advertisement Publish Notification'])[1]")
        		WebElement adpublish;
        public void AdPublishedNotification() {
        	waitForElementToPresent(adpublish);
        	  click(adpublish,"Advertisement Publish Notification mail");
        	
        }
        @FindBy(xpath="   (//*[text()='Advertisement Purchase Successful Notification'])[1]")
        		WebElement adPurchase;
        public void AdPurchasedNotification() {
        	waitForElementToPresent(adPurchase);
        	  click(adPurchase,"Advertisement Purchase Successful Notification mail");
        	
        }
        @FindBy(xpath="  (//*[text()='Advertisement Rejected Notification'])[1]")
        		WebElement adReject;
        public void AdRejectedNotification() {
        	waitForElementToPresent(adReject);
        	  click(adReject,"Advertisement Rejected Notification mail");
        	
        }
}
