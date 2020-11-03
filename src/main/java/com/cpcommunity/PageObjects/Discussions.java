package com.cpcommunity.PageObjects;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussions extends BasePage {

	@Override
	protected void getPageScreenSot() {

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(discussions);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	@FindBy(xpath="//*[@class='post-date ng-binding']")
	WebElement postDate;
	
	@FindBy(xpath = "//*[@class='header active']")
	WebElement header;

	@FindBy(xpath = "//*[@id='header']")
	WebElement groupPageHeader;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement iframe;
	@FindBy(tagName = "iframe")
	WebElement iframe2;

	@FindBy(tagName = "body")
	WebElement Postfield;

	@FindBy(xpath = "(//*[contains(text(),'Discussions')])[1]")
	WebElement discussions;

	@FindBy(xpath = "//input[@placeholder='Search Discussion...']")
	WebElement searchDiscussion;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement Searchbtn;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	WebElement reset;

	@FindBy(xpath = "//button[contains(text(),'Post')]")
	WebElement postBtn;

	@FindBy(xpath = "//a[contains(.,'File')]")
	WebElement Filetab;

	@FindBy(xpath = "//label[@name='FileUploadLabel']")
	WebElement FileUploadBtn;

	@FindBy(xpath = "//*[@id='NewPostForm']//button[contains(text(),'Post')]")
	WebElement PostBtn;

	@FindBy(xpath = "//a[contains(.,'Link')]")
	WebElement LinkTab;

	@FindBy(xpath = "//input[@name='HyperlinkURL']")
	WebElement HyperlinkURL;

	@FindBy(xpath = "//input[@id='HyperlinkName']")
	WebElement HyperlinkName;

	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OKBtn;

	@FindBy(xpath = "//a[contains(.,'Add Photo')]")
	WebElement AddPhotoBtn;

	@FindBy(xpath = "//label[@id='ImageUploadLabel']")
	WebElement ImageUploadLabel;

	@FindBy(xpath = "(//*[@data-placeholder='Write a comment...'])[1]")
	WebElement FirstPostComment;

	@FindBy(xpath = "(//*[@class='btn btn-default']/i)[1]")
	WebElement SendCommentBtn;

	@FindBy(xpath = "(//*[@class='post-box discussions-panel ng-scope'])[1]//*[@class='pull-left like-section']//span[2]")
	WebElement NoOfPostLikes;

	@FindBy(xpath = "(//*[contains(text(),'Like')])[1]")
	WebElement clickFirstPostLike;

	@FindBy(xpath = "//*[contains(text(),'Join this community to participate in the discussion')]")
	WebElement JoinThisCommunityPopUp;

	@FindBy(xpath = "//*[contains(text(),'Join this community to participate in the discussion')]/..//*//*[contains(text(),'Cancel')]")
	WebElement JoinThisCommunityCancelButton;

	@FindBy(xpath = "(//*[contains(text(),'Like')])[2]")
	WebElement clickFirstCommentLike;

	@FindBy(xpath = "(//*[@class='post-box discussions-panel ng-scope'])[1]//*[@class='comments-box']//*[@class='for-likes']//a/span[2]")
	WebElement NoOfFirstCommmentLikes;

	@FindBy(xpath = "(//i[@title='Menu'])[1]")
	WebElement commentMenu;
	@FindBy(xpath = "(//span[@title='Menu'])[1]")
	WebElement postMenu;

	@FindBy(xpath = "((//*[@class='post-box ng-scope'])[1]//*[contains(text(),'Delete')])[2]")
	WebElement deleteComment;

	@FindBy(xpath = "((//*[@class='post-box ng-scope'])[1]//*[contains(text(),'Delete')])[1]")
	WebElement deletePost;

	@FindBy(xpath = "//*[@class='modal-content']//*[contains(text(),'OK')]")
	WebElement okBtn;

	@FindBy(xpath = "//*[contains(text(),'No results found matching your search criteria')]")
	WebElement noResultsFound;

	@FindBy(xpath = "//*[@id='discussionTitle']")
	WebElement discussionTitle;

	@FindBy(xpath = "//*[@id='copsDisable']")
	WebElement tagInPost;

	@FindBy(xpath = "//*[contains(text(),'Create New Post')]")
	WebElement	createNewPost;
	
	//*[@id='discussionTitle']
	
	
	
	
	// String TCID;
	// //public HomePage(WebDriver driver,ExtentTest test) throws IOException {
	// public Discussions(WebDriver driver) {
	// this.driver = driver;
	// this.TCID=TCID;
	// PageFactory.initElements(driver, this);

	// String imagePath = new TestBase().captureScreen("tcid",driver);
	// System.out.println("imagePath = " + imagePath);
	// test.addScreenCaptureFromPath(imagePath);

	// }

	public void addPosts(String postMessage, String postComment) throws Exception {
		
		addPost(postMessage);

//		click(, "Post");
		clickElementByJavaScript(PostBtn);
		Thread.sleep(20000);
		
		
		type(searchDiscussion, postMessage, "searchDiscussion");
		click(Searchbtn, "Search");
		Thread.sleep(2000);
		scrollIntoView(PostBtn);
		waitForElementToPresent(FirstPostComment);

		type(FirstPostComment, postComment, "First Post Comment");
		click(SendCommentBtn, "Send Comment");
		Thread.sleep(10000);

		// String Comment = driver.findElement(new
		// ByAll(By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[5]/div[2]/div/div/div"),By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[4]/div[2]/div/div/div"),By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/div"))).getText();
		WebElement ele = driver.findElement(
				By.xpath("(//*[@class='comments-box'])[1]//*[contains(text(),'" + postComment + "')]"));
		if (ele.isDisplayed()) {
			// log.info(postComment+" Displayed");
		} else {
			// log.info(postComment+" Not Displayed");
		}

		String L = NoOfPostLikes.getText();
		System.out.println("Total No of Like = " + L);
		int likes;
		if (L.equals("")) {
			likes = 0;
		} else {
			likes = Integer.parseInt(L);
		}
		likes = likes + 1;
		clickFirstPostLike.click();
		Thread.sleep(2000);
		L = NoOfPostLikes.getText();
		String UpdatedL = NoOfPostLikes.getText();
		// log.info(UpdatedL);
		System.out.println(UpdatedL);
		int Updatedlikes = Integer.parseInt(UpdatedL);
		if (Updatedlikes == likes) {
			// log.info("Like Count Increased");
		} else {
			// log.info("Like Count not Increased");
		}

		L = NoOfPostLikes.getText();
		// System.out.println("Total No of Like = "+L);
		int UpdatedlL = Integer.parseInt(L);
		if (UpdatedlL == 1) {
			L = "";
		} else {
			UpdatedlL = UpdatedlL - 1;
			L = Integer.toString(UpdatedlL);
		}

		click(clickFirstPostLike, "unliking First Post "); // Unlikng the Post
		Thread.sleep(2000);

		String UpdatedLikes = NoOfPostLikes.getText();

		if (L.equals(UpdatedLikes)) {
			// // log.info("Post Like Count Decreased");
		} else {
			// // log.info("Post Like Count not Decreased");
		}

//		L = NoOfFirstCommmentLikes.getText();
//		// System.out.println("Total No of Like = "+L);
//
//		if (L.equals("")) {
//			likes = 0;
//		} else {
//			likes = Integer.parseInt(L);
//		}
//		likes = likes + 1;
		click(clickFirstCommentLike, "FirstCommentLike"); // liking first comment
		Thread.sleep(2000);
//		L = NoOfFirstCommmentLikes.getText();
//		UpdatedL = NoOfFirstCommmentLikes.getText();
//		Updatedlikes = Integer.parseInt(UpdatedL);
//		if (Updatedlikes == likes) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Fail");
//		}
//
//		L = NoOfFirstCommmentLikes.getText();
//		// System.out.println("Total No of Like = "+L);
//		UpdatedlL = Integer.parseInt(L);
//		if (UpdatedlL == 1) {
//			L = "";
//		} else {
//			UpdatedlL = UpdatedlL - 1;
//			L = Integer.toString(UpdatedlL);
//		}

		click(clickFirstCommentLike, "unliking the comment");// unliking the comment
		Thread.sleep(2000);

//		UpdatedLikes = NoOfFirstCommmentLikes.getText();
//
//		if (L.equals(UpdatedLikes)) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Fail");
//		}
//
//		Thread.sleep(2000);

		clickElementByJavaScript(commentMenu);
		Thread.sleep(1000);

		// Comment =
		// driver.findElement(By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/div")).getText();

//		clickElementByJavaScript(deleteComment);
		Thread.sleep(6000);

		try {

			if (ele.isDisplayed())
			// if(Comment.equals(Comment1))
			{
				// // log.info("Comment not deleted");
			}

			else {
				// // log.info("Comment deleted");
			}

		} catch (Exception e) {
			// // log.info("Comment deleted");
		}

		clickElementByJavaScript(postMenu);
//		Thread.sleep(1000);

//		clickElementByJavaScript(deletePost);
		Thread.sleep(2000);

//		click(okBtn, "OK");
//		Thread.sleep(7000);
//		waitForElementToPresent(noResultsFound);
//		noResultsFound.isDisplayed();
	}

	public void CheckNonMemberIsNotAbleToPostLikeComment() throws Exception {
		
		
		click(discussions, "discussions");

		waitForElementToPresent(searchDiscussion);
		waitForElementToPresent(createNewPost);
		click(createNewPost, "create New Post");
		waitForElementToPresent(PostBtn);
		try {
			updateClass(header, "");
		} catch (Exception e) {
			updateClass(groupPageHeader, "");
		}

		scrollIntoView(Searchbtn);

		type(discussionTitle, "discussion Title", "discussion Title");

		driver.switchTo().frame(iframe);
		try {
			Thread.sleep(10000);
			click(Postfield, "Post field");
		} catch (Exception e) {
			
		}
		
		
		driver.switchTo().defaultContent();

		waitForElementToPresent(JoinThisCommunityCancelButton);
		click(JoinThisCommunityCancelButton, "Cancel Button");
		Thread.sleep(2000);

		click(clickFirstPostLike, "First Post Like");
		waitForElementToPresent(JoinThisCommunityCancelButton);
		click(JoinThisCommunityCancelButton, "Cancel Button");
		Thread.sleep(2000);

		click(FirstPostComment, "Post field");
		waitForElementToPresent(JoinThisCommunityCancelButton);
		click(JoinThisCommunityCancelButton, "Cancel Button");
		Thread.sleep(1000);

	}

	public void tagMemberInComment(String postComment,String memberName) throws Exception {

		type(FirstPostComment, postComment, "First Post Comment");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='list-group-item pointer ng-scope ng-isolate-scope active'])[2]")).click();
		Thread.sleep(2000);
		click(SendCommentBtn, "Send Comment");
		Thread.sleep(10000);
	}

	public void addPost(String postMessage) throws Exception {

		click(discussions, "discussions");
		waitForElementToPresent(searchDiscussion);
		waitForElementToPresent(createNewPost);
		click(createNewPost, "create New Post");
		waitForElementToPresent(PostBtn);
		try {
			updateClass(header, "");
		} catch (Exception e) {
			updateClass(groupPageHeader, "");
		}

		scrollIntoView(Searchbtn);

		type(discussionTitle, "discussion Title", "discussion Title");

		driver.switchTo().frame(iframe);
		Thread.sleep(10000);
		Postfield.clear();

		type(Postfield, postMessage, "Post");
		driver.switchTo().defaultContent();

	}

	public void tagMemberInPost(String postMessage, String memberName, String comment) throws Exception {

		addPost(postMessage);
		memberName = "@"+memberName;
		type(tagInPost, memberName, "Tag");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("((//*[@class='list-group user-search'])[1])//li")).click();
		Thread.sleep(2000);
		click(PostBtn, "Post");
		Thread.sleep(20000);
	}
	
	@FindBy(xpath="//*[contains(text(),'View All')]")
	WebElement viewAll;
	
	
	@FindBy(xpath="//*[@class='fa fa-bell']")
	WebElement bell;
	
	
	
	public String getPostDate() {
		String d =postDate.getText();
		System.out.println(d);
		String[] arr1 = splitStringBy(d, "\\s");
		String[] arr2 = splitStringBy(d, "/");
		int month = stringToInt(arr2[0]);
		int day = stringToInt(arr2[1]);
		
		String[] arr3 = splitStringBy(arr1[0], ":");
		int hr = stringToInt(arr3[0]);
		
		d=month+"/"+day+"/"+arr2[2]+" "+hr+":"+arr3[1];
		log.info(d);

		return d;
	}
	
	public NotificationsPage goToAllNotifications() {
		click(bell, "bell");
		waitForElementToPresent(viewAll);
		click(viewAll, "View All");
		return (NotificationsPage) openPage(NotificationsPage.class);
	}
	
	
	

}
