package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageCommunityWidgets extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(title);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
	}
	
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement header;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	
	@FindBy(xpath = "//h2[normalize-space()='Manage Community Widgets']")
	WebElement title;
	
	@FindBy(xpath = "//a[normalize-space()='Discussions']")
	WebElement discussion;
	
	@FindBy(xpath = "//span[normalize-space()='Careers']")
	WebElement career;
	
	@FindBy(xpath = "//span[normalize-space()='Events']")
	WebElement events;
	
	@FindBy(xpath = "//div[@role='main']//div[3]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disablepopularDiscussion;

	@FindBy(xpath = "//body//div[@class='container body']//div[@role='main']//div//div//div[4]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disableLikeddiscussion;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement BDMAIHomePage;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement Bizligopage;
	
	@FindBy(xpath = "//body//div[@class='container body']//div[@role='main']//div//div//div[4]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enablelikedDiscussion;
	
	@FindBy(xpath = "//div[@role='main']//div[3]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enablepopularDiscussion;

	@FindBy(xpath = "//div[8]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disablemostappliedJob;
	
	@FindBy(xpath = "//div[9]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disableyourappliedJob;
	
	@FindBy(xpath = "//div[8]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enablemostappliedJob;
	
	@FindBy(xpath = "//div[9]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enableyourappliedJob;
	
	@FindBy(xpath = "//div[11]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disablesuggestevents;
	
	@FindBy(xpath = "//div[12]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disableeventCalender;
	
	@FindBy(xpath = "//div[11]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enablesuggestedevent;
	
	@FindBy(xpath = "//div[12]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enableeventcalender;
	
	@FindBy(xpath = "//div[6]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disableSAI;
	
	@FindBy(xpath = "//div[6]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enableSAI;

	@FindBy (xpath = "//span[normalize-space()='Groups']")
    WebElement Groups; 
	
	@FindBy (xpath = "//span[normalize-space()='Members']")
    WebElement member; 
	
	@FindBy (xpath = "//input[@placeholder='Suggested Events']")
    WebElement suggestedEvents; 
	
	@FindBy (xpath = "//input[@placeholder='Most Applied Jobs']")
    WebElement typemostappliedJob;
	
	@FindBy (xpath = "//input[@placeholder='Trending Groups']")
    WebElement typegroup;
	
	@FindBy (xpath = "//input[@placeholder='Most Popular Discussions']")
    WebElement typediscussion;
	
	@FindBy (xpath = "//input[@placeholder='Advertisements']")
    WebElement typeAd;

	@FindBy (xpath = "//input[@placeholder='Champions']")
    WebElement typechampion;

	@FindBy (xpath = "//input[@placeholder='Membership Plan Details']")
    WebElement typemembership;
	
	@FindBy(xpath = "//div[15]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enabletrendinggroupt;
	
	@FindBy(xpath = "//div[15]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disabletrendinggroup;
	
	@FindBy(xpath = "//div[13]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disableAd;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/toggle[1]/div[1]/div[1]/label[2]")
	WebElement enablemembership;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/toggle[1]/div[1]/div[1]/label[1]")
	WebElement disablemembership;
	
	@FindBy(xpath = "//div[@id='WizdetsInfo']//div[2]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enablechamp;
	
	@FindBy(xpath = "//div[@id='WizdetsInfo']//div[2]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[1]")
	WebElement disablechamp;
	
	@FindBy(xpath = "//div[13]//div[1]//div[1]//div[1]//toggle[1]//div[1]//div[1]//label[2]")
	WebElement enableAd;
	
	@FindBy(xpath = "//input[@placeholder='Similar Interests and Skills']")
	WebElement skillinteresttype;
	
     public void disablediscussion() throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(disablepopularDiscussion);
    	 click(disablepopularDiscussion, "Disable popular discussion");
    	 click(disableLikeddiscussion, "Disable liked discussion");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void Enablediscussion() throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(enablepopularDiscussion);
    	 click(enablepopularDiscussion, "Disable popular discussion");
    	 click(enablelikedDiscussion, "Disable liked discussion");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public Discussions navigateToDiscussionPage() throws InterruptedException {
    	 Thread.sleep(4000);
 		waitForElementToPresent(BDMAIHomePage);
 		click(BDMAIHomePage, "HomePage");
 		waitForElementToPresent(discussion);
 		click(discussion, "Discussions");
 		Thread.sleep(8000);
 		return (Discussions) openPage(Discussions.class);	
 	} 
     public void disableJob() throws InterruptedException {
    	 Thread.sleep(8000);
    	//scrollIntoView(disablemostappliedJob);
    	// waitForElementToPresent(disablemostappliedJob);
    	 click(disablemostappliedJob, "Disable most applied Jobs");
    	 click(disableyourappliedJob, "Disable your Applied Jobs");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void EnableJobs() throws InterruptedException {
    	 Thread.sleep(8000);
    	//scrollIntoView(enablemostappliedJob);
    	// waitForElementToPresent(enablemostappliedJob);
    	 click(enablemostappliedJob, "Enable most applied Jobs");
    	 click(enableyourappliedJob, "Enable your Applied Jobs");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public GlobalCareers navigateTocareerPage() throws InterruptedException {
    	 Thread.sleep(4000);
 		waitForElementToPresent(BDMAIHomePage);
 		click(BDMAIHomePage, "HomePage");
 		waitForElementToPresent(career);
 		click(career, "Careers");
 		
 		return (GlobalCareers) openPage(GlobalCareers.class);	
 	} 
     
     public void disableMembershipplan() throws InterruptedException {
    	 Thread.sleep(4000);
    	 waitForElementToPresent(disablemembership);
    	 click(disablemembership, "Disable Membership plan");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void EnableMembershipPlanp() throws InterruptedException {
    	 Thread.sleep(6000);
    	waitForElementToPresent(enablemembership);
    	 click(enablemembership, "Enable Membership plan");
    	
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     
     public void disableChampion() throws InterruptedException {
    	 Thread.sleep(4000);
    	 waitForElementToPresent(disablechamp);
    	 click(disablechamp, "Disable Champions");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void Enablechampionp() throws InterruptedException {
    	 Thread.sleep(4000);
    	waitForElementToPresent(enablechamp);
    	 click(enablechamp, "Enable Champions");
    	
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public EventsPage navigateToEventPage() throws InterruptedException {
    	 Thread.sleep(5000);
 		waitForElementToPresent(BDMAIHomePage);
 		click(BDMAIHomePage, "HomePage");
 		waitForElementToPresent(events);
 		click(events, "Events");
 		
 		return (EventsPage) openPage(EventsPage.class);	
 	} 
     public void disableTrendingGroup() throws InterruptedException {
    	 Thread.sleep(10000);
    	 //scrollIntoView(disablemembership);
    	 click(disabletrendinggroup, "Disable Membership plan");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void EnableTrendingGroup() throws InterruptedException {
    	 Thread.sleep(10000);
    	//scrollIntoView(enablemembership);
    	 click(enabletrendinggroupt, "Enable Membership plan");
    	
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public Bizligo1CommunityPage navigateToBizligopage() throws InterruptedException {
    	 Thread.sleep(8000);
 		waitForElementToPresent(Bizligopage);
 		click(Bizligopage, "HomePage");
 		
 		return (Bizligo1CommunityPage) openPage(Bizligo1CommunityPage.class);	
 	} 
     public void disableEvents() throws InterruptedException {
    	  Thread.sleep(8000);
    	 //scrollIntoView(disablesuggestevents);
    	 click(disablesuggestevents, "Disable suggested events");
    	 click(disableeventCalender, "Disable calender");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void EnableEvents() throws InterruptedException {
          Thread.sleep(8000);
    	// scrollIntoView(enablesuggestedevent);
    	 click(enablesuggestedevent, "Enable suggested events ");
    	 click(enableeventcalender, "Enable event calender");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public GroupPage navigateToGroupPage() throws InterruptedException {
 		Thread.sleep(5000);
 		waitForElementToPresent(BDMAIHomePage);
 		click(BDMAIHomePage, "HomePage");
 		waitForElementToPresent(Groups);
 		click(Groups, "Groups");
 		
 		return (GroupPage) openPage(GroupPage.class);	
 	}
     public void disableAdvertisement() throws InterruptedException {
    	Thread.sleep(8000);
    	//scrollIntoView(disableAd);
    	 click(disableAd, "Disable Advertisement");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void EnableAdvertisemenrt() throws InterruptedException {
    	Thread.sleep(8000);
    	//scrollIntoView(enableAd);
    	 click(enableAd, "Enable Advertisement ");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
     } 
     public void RenameEventsWidget(String event) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(suggestedEvents);
    	 type(suggestedEvents, event, "Rename Event");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     
     public void RenameJobWidget(String Job) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(typemostappliedJob);
    	 type(typemostappliedJob, Job, "Rename Event");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameGroupWidget(String groupname) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(typegroup);
    	 type(typegroup,groupname, "Rename Group");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameSkillandIntersetWidget(String skill) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(skillinteresttype);
    	 type(skillinteresttype,skill, "Rename skill");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameDiscussionWidget(String discussion) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(typediscussion);
    	 type(typediscussion,discussion, "Rename Group");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameAdWidget(String ad) throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(typeAd);
    	 type(typeAd,ad, "Rename Group");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameChampionWidget(String champ) throws InterruptedException {
    	 Thread.sleep(4000);
    	 waitForElementToPresent(typechampion);
    	 type(typechampion,champ, "Rename Group");
    	 Thread.sleep(4000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void RenameMembershipWidget(String name) throws InterruptedException {
    	 Thread.sleep(4000);
    	 waitForElementToPresent(typemembership);
    	 type(typemembership,name, "Rename Group");
    	 Thread.sleep(6000);
    	 click(save, "Save");
    	 Thread.sleep(4000);
    	 
     }
     public void disableSkillandInterest() throws InterruptedException {
    	 Thread.sleep(8000);
    	 waitForElementToPresent(disableSAI);
     	 click(disableSAI, "Disable Skill and Interest");
     	 
     	 Thread.sleep(6000);
     	 click(save, "Save");
     	 Thread.sleep(4000);
      } 
      public void EnableSkillandInterest() throws InterruptedException {
           Thread.sleep(8000);
     	 waitForElementToPresent(enableSAI);
     	 click(enableSAI, "Enable Skill and Interest ");
     	
     	 Thread.sleep(6000);
     	 click(save, "Save");
     	 Thread.sleep(4000);
      } 
      public MembersPage navigateToMemberPage() throws InterruptedException {
  		Thread.sleep(5000);
  		waitForElementToPresent(BDMAIHomePage);
  		click(BDMAIHomePage, "HomePage");
  		waitForElementToPresent(member);
  		click(member, "Member");
  		
  		return (MembersPage) openPage(MembersPage.class);	
  	}
    	 
     }