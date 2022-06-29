package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BlogsPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(Searchs);
	}

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement pageheader;
	@FindBy(xpath = "//select[@id='CategoryID']")
	WebElement selectCategories;
	@FindBy(xpath = "//select[@id='CategoryID']")
	List<WebElement> Categories;
	@FindBy(xpath = "//select")
	WebElement selectCommuntiy;
	@FindBy(xpath = "//*[@id='term']")
	WebElement blogsPostName;
	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement SearchBtn;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Searchs;
	@FindBy(xpath = "//input[@id='term']")
	WebElement search;
	@FindBy(xpath = "//*[text()='No Posts found']")
	WebElement verifyBlog;
	@FindBy(xpath = "//article[1]//header[1]//div[1]//div[1]//div[1]")
	WebElement verifyname;
	@FindBy(xpath = "//div[@class='panel panel-warning']//div[@class='panel-body']")
	WebElement checkname;
	@FindBy(xpath = "(//*[contains(text(),'Blogs')])[1]")
	WebElement blogs;

	@FindBy(xpath = "(//*[contains(text(),'Categories')])[1]")
	WebElement categories;

	@FindBy(xpath = "(//*[contains(text(),'Tags')])[1]")
	WebElement tags;

	@FindBy(xpath = "//*[contains(text(),'No Posts found')]")
	WebElement noPosts;
	
	@FindBy(xpath = "(//*[contains(text(),'This page isn’t working')])[1]")
	WebElement blogpageisnotWorking;
	
	@FindBy(xpath = "//*[contains(text(),'No Posts found')]")
	WebElement noPost;
	
	@FindBy(xpath = "//div[@class='col-md-8']//article//header//h3")
	WebElement categoryName;

	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	
	@FindBy(css = "div[class='panel panel-primary'] a:nth-child(1)")
	WebElement firstpost;
	
	@FindBy(css = "/html[1]/body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/article[1]/header[1]/h3[1]/a[1]")
	WebElement post;
	
	 @FindBy(xpath = "//*[contains(text(),'MANAGE')]")
	WebElement MANAGEbtn;
	 
	 @FindBy(xpath = "//a[@class='edit-page ng-scope']")
		WebElement manageBtn;
	 
	 
	public void searchPost(String communityName, String blogName) {
		communityName = communityName + " " + getDateInDDMMMYYYY();
		selectByVisibleText(selectCommuntiy, communityName, "selecting Communtiy");
		type(blogsPostName, blogName, "Post Name to search");
		click(SearchBtn, "Search");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + blogName + "')]"));
		waitForElementToPresent(ele);
		ele.isDisplayed();
	}
	
	
	
	public void searchPostByMember(String search) throws Throwable
	{
	//	String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.search,search,"Search");//+date
		Thread.sleep(1000);
		click(SearchBtn,"searchbutton");
		String expected = verifyBlog.getText();
		String actual="No Posts found";
		if(actual.equalsIgnoreCase(expected))
		{
			Assert.assertTrue(true);
			System.out.println("Blog post is In-Active");	
		}
	}
	
	
	public void inactiveBlogPost(String Search) throws Throwable
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.search,search+date,"Search");
		Thread.sleep(1000);
		waitForElementToPresent(noPosts);	
	}
	public void inactiveBlog(String Search) throws Throwable
	{ Thread.sleep(5000);
		Select dropdown = new Select(selectCategories);
	 //Get all options
      List<WebElement> dd = dropdown.getOptions();
      System.out.println(dd.size());
      for (int j = 0; j < dd.size(); j++) {
          System.out.println(dd.get(j).getText());

      }
      String biz="Bizligo";
		Assert.assertNotSame(biz, dd);
		System.out.println("Bizligo is InActive");
	}
	
	private void waitForElementToPresent(List<WebElement> categories2) {
		// TODO Auto-generated method stub
		
	}

	private void click(String search2, String elementName) {
		// TODO Auto-generated method stub
		
	}

	public void pageIsNotWorking()
	{
		waitForElementToPresent(blogpageisnotWorking);
	}
	
	
	public void searchPost(Hashtable<String,String> data) throws InterruptedException {
		waitForElementToPresent(selectCommuntiy);
		selectByVisibleText(selectCommuntiy, data.get("communityName"), "selecting Communtiy");
		type(blogsPostName, data.get("title"), "Post Name to search");
		
		click(SearchBtn, "Search");
	//	Thread.sleep(15000);
		
		try {
			WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + data.get("title") + "')]"));
			waitForElementToPresent(ele);
			ele.isDisplayed();
		} catch (Exception e) {
			log.info("Post is not displayed");

		}

	}
	
	public void searchPost(String category) throws InterruptedException {
				Thread.sleep(5000);
		Select dropdown = new Select(selectCategories);
		 //Get all options
	      List<WebElement> dd = dropdown.getOptions();
	      System.out.println(dd.size());
	      for (int j = 0; j < dd.size(); j++) {
	          System.out.println(dd.get(j).getText());

	      }
	      String biz="Bizligo";
	if(dd.contains(biz)) {
			System.out.println("Category is active and present");
			Assert.assertTrue(true);
		}
	}
	
 public CommunityDashboardPage gotoCommunityDashboard() throws InterruptedException {
	// Thread.sleep(10000);
	 waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
	//	Thread.sleep(3000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
	//	Thread.sleep(18000);
	//	waitForElementToPresent(MANAGEbtn);
	//	click(MANAGEbtn, "Manage");
	// Thread.sleep(5000);
	 return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);	 
 }
 public void gotoMyEcoSystem() throws InterruptedException {
	// Thread.sleep(10000);
	 waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
	//	Thread.sleep(3000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");

		 
 }

 
  public void verifychanges(String newName,String oldName) throws InterruptedException {
		Thread.sleep(5000);
		Select dropdown = new Select(selectCategories);
		 //Get all options
	      List<WebElement> dd = dropdown.getOptions();
	      System.out.println(dd.size());
	      for (int j = 0; j < dd.size(); j++) {
	          System.out.println(dd.get(j).getText());

	      }
	   //   String biz="NewCat001";
	   //   String notpresent="Atest";
	      if(dd.contains(newName)) {
			System.out.println("Category is present");
			Assert.assertNotSame(oldName, dd);
		}
	  
  }
  public void verifytagchanges() {
	  waitForElementToPresent(checkname);
	  
	  String Name=this.checkname.getText();
	  System.out.println(Name);
	 
  }
  
  public void CheckFirstPost(String title) {
  	waitForElementToPresent(firstpost);
  	String Post=this.firstpost.getText();
  	System.out.println("First line of Latest post section showing Post is " +Post);
  	String date =getDateInDDMMMYYYY();
  	String expected=title+date;
  	Assert.assertEquals(expected, Post);
  	
  	
  }
  public TagsPage gotoTagsPage() throws InterruptedException {
		
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
		Thread.sleep(5000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
		Thread.sleep(5000);
		Thread.sleep(5000);
		//this.searchCommunity(communityName+getDateInDDMMMYYYY());
		click(MANAGEbtn, "Manage");
		Thread.sleep(1000);
		Thread.sleep(5000);
		click(blogs, "Tags");
		waitForElementToPresent(tags);
		click(tags, "Tags");
		return (TagsPage) openPage(TagsPage.class);	
	}
}
