package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;





public class Sharing extends BasePage{
	
	protected WebDriver driver;
	
	
	public Sharing(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(header, "");
		aShot();
		updateClass(header, "navbar-fixed-top");
	}

	
	@FindBy(xpath = "//*[@class='header active']")
	WebElement header;

	@FindBy(xpath="//a[contains(.,'File')]")
	WebElement Filetab;
	 
	@FindBy(xpath="//label[@name='FileUploadLabel']")
	WebElement FileUploadBtn;
	 
	@FindBy(xpath="//button[contains(.,'Post')]")
	WebElement PostBtn;
	 
	@FindBy(xpath="//a[contains(.,'Link')]")
	WebElement LinkTab;
	 
	WebElement HyperlinkURL;
	@FindBy(xpath="//input[@id='HyperlinkName']")
	WebElement HyperlinkName;
	@FindBy(xpath="//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy(xpath="//a[contains(.,'Add Photo')]")
	WebElement AddPhotoBtn;
	@FindBy(xpath="//label[@id='ImageUploadLabel']")
	WebElement ImageUploadLabel;
	@FindBy(xpath="//*[@data-placeholder='Add a comment'][1]")
	WebElement FirstPostComment;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[1]/div/div[3]/i[1]")
	WebElement SendCommentBtn;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[2]/div[1]")
	WebElement LikeFirstPost;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/a/i")
	WebElement FirstComment;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/ul/li/a/span")
	WebElement FirstCommentDelete;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[1]/div[1]/div/div[2]/div/a/span")
	WebElement FirstPost;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[1]/div[1]/div/div[2]/div/ul/li[1]/a")
	WebElement FirstPostDelete;
	@FindBy(xpath="html/body/div[4]/div/div/div[2]/button[2]")
	WebElement OKDeletebtn;
	
	
	@FindBy(xpath=".//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[2]/div[1]/span[3]")
	WebElement NoOfLikes;
	
	@FindBy(xpath="//span[contains(.,'Like ')]")
	WebElement CommmentLike;
	@FindBy(xpath="//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/span[3]")
	WebElement CommmentNoOfLikes;
	
	@FindBy(xpath="//p[contains(.,'No Discussions Found')]")
	WebElement NoDiscussionsFound;
	@FindBy(xpath="//input[@placeholder='Search Discussion...']")
	WebElement searchPost;
	@FindBy(xpath="//*[@ng-click='data.GetSearchDiscussions()']")
	WebElement searchBtn;
	@FindBy(tagName = "iframe")
    WebElement iframe;
	@FindBy(tagName = "body")
	WebElement Postfield;
	@FindBy(xpath="//a[contains(text(),'Discussion')]")
	WebElement Discussion;
	

	
	public void sharePosts(String PostMessage, String postFile, String linkURL, String linkName,String postImage, String postComment) throws Exception {
		
		click(Discussion,"Discussion");

		waitForElementToPresent(PostBtn);
        Thread.sleep(1000);
        click(Filetab,"Filetab");
        waitForElementToPresent(FileUploadBtn);
        click(FileUploadBtn,"FileUploadBtn");
        Thread.sleep(3000);        
        Runtime.getRuntime().exec(postFile);
        Thread.sleep(4000);
       
        click(PostBtn,"PostBtn");
        Thread.sleep(15000);
       
        click(LinkTab,"LinkTab");
        waitForElementToPresent(HyperlinkURL);
        
        
        type(HyperlinkURL, linkURL, "HyperlinkURL");
        
        type(HyperlinkName, linkName, "HyperlinkName");
        click(OKBtn,"OKBtn");
        Thread.sleep(2000);
       
        click(PostBtn,"PostBtn");
        Thread.sleep(6000);
        
        
        click(AddPhotoBtn,"AddPhotoBtn");
        waitForElementToPresent(ImageUploadLabel);
       
        click(ImageUploadLabel,"ImageUploadLabel");
        Thread.sleep(3000);
        Runtime.getRuntime().exec(postImage);
        Thread.sleep(4000);
        
        click(PostBtn,"PostBtn");
        Thread.sleep(10000);
        scrollIntoView(PostBtn);       
                      
        
        type(FirstPostComment, postComment, "FirstPostComment");
        click(SendCommentBtn,"SendCommentBtn");
        Thread.sleep(5000);
        Thread.sleep(5000);
        //String Comment = driver.findElement(new ByAll(By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[5]/div[2]/div/div/div"),By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[4]/div[2]/div/div/div"),By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/div"))).getText();
        WebElement ele = driver.findElement(By.xpath("//*[@class='post-box ng-scope']//*[contains(text(),'"+postComment+"')]"));
        if(ele.isDisplayed())
        {
        	System.out.println("Pass");
        }
        else
        {
        	System.out.println("Fail");
        }
   
        
        String L = NoOfLikes.getText();
//        System.out.println("Total No of Like = "+L);   
        int likes;
        if(L.equals(""))
        	{
        	likes = 0;
        	}
        else 
        {
        	likes=Integer.parseInt(L);
        }     
        likes = likes+1;
        click(LikeFirstPost,"LikeFirstPost");
        Thread.sleep(2000);
        L = NoOfLikes.getText();        
        String UpdatedL = NoOfLikes.getText();        
        int Updatedlikes=Integer.parseInt(UpdatedL);        
        if(Updatedlikes==likes)
            {
        	System.out.println("Pass");
            }
        else
        {
    	System.out.println("Fail");  
        } 
        
        
        
        L = NoOfLikes.getText();
        //System.out.println("Total No of Like = "+L);
        int UpdatedlL=Integer.parseInt(L);
        if(UpdatedlL==1)
        	{
        	L="";
        	}
        else 
        {
        	UpdatedlL = UpdatedlL-1;
        	L=Integer.toString(UpdatedlL);
        }
 
        
        
        
        click(LikeFirstPost,"LikeFirstPost");// Unlikng the Post
        Thread.sleep(2000);
               	
        
        
        String UpdatedLikes = NoOfLikes.getText();        
                
        if(L.equals(UpdatedLikes))
            {
        	System.out.println("Pass");
            }
        else
        {
    	System.out.println("Fail");  
        }
        
        
        CommmentNoOfLikes.getText();
        
        
        L = CommmentNoOfLikes.getText();
        //System.out.println("Total No of Like = "+L);   
        
        if(L.equals(""))
        	{
        	likes = 0;
        	}
        else 
        {
        	likes=Integer.parseInt(L);
        }     
        likes = likes+1;
        click(CommmentLike,"Commment to Like");
        Thread.sleep(2000);
        L = CommmentNoOfLikes.getText();        
        UpdatedL = CommmentNoOfLikes.getText();        
        Updatedlikes=Integer.parseInt(UpdatedL);        
        if(Updatedlikes==likes)
            {
        	System.out.println("Pass");
            }
        else
        {
    	System.out.println("Fail");  
        } 
        
        
        
        L = CommmentNoOfLikes.getText();
        //System.out.println("Total No of Like = "+L);
        UpdatedlL=Integer.parseInt(L);
        if(UpdatedlL==1)
        	{
        	L="";
        	}
        else 
        {
        	UpdatedlL = UpdatedlL-1;
        	L=Integer.toString(UpdatedlL);
        }
 
        
        
        
        click(CommmentLike,"liked Commment");// unliking the comment
        Thread.sleep(2000);
               	
        
        
        UpdatedLikes = CommmentNoOfLikes.getText();        
                
        if(L.equals(UpdatedLikes))
            {
        	System.out.println("Pass");
            }
        else
        {
    	System.out.println("Fail");  
        }
        
        
               
          
        Thread.sleep(2000);
       
        click(FirstComment,"First Comment");
        Thread.sleep(1000);
        

      //  Comment = driver.findElement(By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/div")).getText();
        
        
        click(FirstCommentDelete,"First Comment");
        Thread.sleep(6000);
        
        try {
			
        	String Comment1 = driver.findElement(By.xpath("//*[@id='MainContainer']/div[9]/div[6]/div[2]/div[3]/div[3]/div[2]/div/div/div")).getText();
        //	if(Comment.equals(Comment1))
        	{
        		System.out.println("Pass");
        	}
        	
        //	else {
        		System.out.println("Fail");
        //	}
        	
        	
		} catch (Exception e) {
			System.out.println("Pass");
		}
        
        
        
        
        click(Discussion,"Discussion");
		driver.switchTo().frame(iframe);
        Postfield.clear();
       
        type(Postfield, PostMessage, "Post field");
        driver.switchTo().defaultContent();
      
        PostBtn.click();
        Thread.sleep(2000);
        
        
        
        type(searchPost, PostMessage, "searchPost");
        click(searchBtn,"searchBtn");
         
        scrollIntoView(PostBtn);
       
        Thread.sleep(1000);
       
        click(FirstPost,"First Post");
        Thread.sleep(1000);
       
        click(FirstPostDelete,"Post Delete");
        Thread.sleep(2000);
       
        click(OKDeletebtn,"Delete");
        Thread.sleep(7000);        
        NoDiscussionsFound.isDisplayed();
        
	}



	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}  	    
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
