package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;



public class CreateOrEditCommunityPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	

	
	@FindBy(xpath="//h4[contains(text(),'Create Community')]")
	WebElement CreateCommunityHeading;
	
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement Name;
	
	@FindBy(xpath = "//button[@id='btnSave']")
    WebElement Createbtn;
	@FindBy(xpath = "//span[@class='ng-binding']")
	WebElement Savebtn;
 

    @FindBy(xpath = "//input[@id='Name']")
    WebElement CommunityName;
    @FindBy(xpath = "//select[@name='CommunityCategory']")
    WebElement CommunityCategory;
    @FindBy(xpath = "//select[@id='CommunityTypeID']")
    WebElement CommunityType;
    @FindBy(xpath = "//input[@value='1']")
    WebElement PNetworking;
    @FindBy(xpath = "//input[@value='2']")
    WebElement PMarketing;
    @FindBy(xpath = "//input[@value='3']")
    WebElement PBranding;
    @FindBy(xpath = "//input[@value='4']")
    WebElement PBuildingRelationship;
    @FindBy(xpath = "//input[@value='5']")
    WebElement PGrowMyBusiness;
    @FindBy(xpath = "//input[@value='6']")
    WebElement PInvestInBusiness;
    @FindBy(xpath = "//input[@value='7']")
    WebElement POther;
    @FindBy(tagName = "body")
    WebElement enterTextInframe;
    @FindBy(tagName = "iframe")
    WebElement iframe;
//    @FindBy(xpath = "(//iframe)[3]")
//    WebElement termsAndConditions;

    
    @FindBy(xpath = "//button[contains(.,'Ok')]")
    WebElement OkBtn;
    @FindBy(xpath = "//input[@name='State']")
    WebElement State;
    @FindBy(xpath = "//input[@name='City']")
    WebElement City;
    @FindBy(xpath = "//input[@id='FacebookUrl']")
    WebElement Facebook;
    @FindBy(xpath = "//input[@id='TwitterUrl']")
    WebElement Twitter;
    @FindBy(xpath = "//input[@id='LinkedInUrl']")
    WebElement LinkedIn;
    @FindBy(xpath = "//input[@id='Website']")
    WebElement website;
    
  
    
    @FindBy(xpath = "//input[@id='GooglePlusUrl']")
    WebElement GPlus;
    @FindBy(xpath = "//a[contains(.,'Change Logo')]")
    WebElement ChangeLogo;
    @FindBy(xpath = "//a[contains(.,'Change Image')]")
    WebElement ChangeImage;
    @FindBy(xpath = "//*[@id='EditMyCommunityLogoForm']/div[2]/div[2]/div/button")
    WebElement LogoBrowseBtn;
    @FindBy(xpath = "//*[@id='EditMyCommunityLogoForm']/div[3]/div/div[2]/button")
    WebElement LogoUploadBtn;
    @FindBy(xpath = "//*[@id='EditMyCommunityImageForm']/div[2]/div[2]/div/button")
    WebElement ImageBrowseBtn;
    @FindBy(xpath = "//*[@id='EditMyCommunityImageForm']/div[3]/div/div[2]/button")
    WebElement ImageUploadBtn;
    @FindBy(xpath = "//*[@id='CommunityForm']/div[14]/div/div/div/label[1]")
    WebElement ActiveToggeleBtn;
    @FindBy(xpath = "//button[contains(.,'Yes Proceed')]")
    WebElement YesProceedBtn;
	
    @FindBy(xpath = "//label[contains(text(),'Community Update')]")
    WebElement CommunityUpdatelabel;
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
	
	public CreateOrEditCommunityPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		//waitForElement(CreateCommunityHeading,100);
		
		
		
	}
	
	
	 public void TC(String TC) throws InterruptedException{
		 
		 scrollIntoView(CommunityUpdatelabel);
		 List<WebElement> elements = driver.findElements(By.tagName("iframe"));
//		 System.out.println(elements.size());
		 driver.switchTo().frame(2);
		 enterTextInframe.clear();
		 type(enterTextInframe, TC, "Terms and conditons");		 
		 driver.switchTo().defaultContent();
		 clickElementByJavaScript(Savebtn);
		 Thread.sleep(5000);
	 }
	  
	    
	  

		
		
		
	  
	    public void FillCommunityDetails(String Name, String Networking, String Marketing, String BuildingRelationship,
	    		String Branding, String GrowMyBusiness, String InvestInBusiness, String Other, String About, String Category,
	        String type ) throws Exception {	       
	       
			CommunityName.clear();
			type(CommunityName, Name,"Name");
	       
	        driver.switchTo().frame(iframe);
	        enterTextInframe.clear();
	        type(enterTextInframe, About,"CommunityAbout");
	       
	        driver.switchTo().defaultContent();
	        if ("Networking".equalsIgnoreCase(Networking)) {
	        	
	            PNetworking.click();
	        }
	        if ("Marketing".equalsIgnoreCase(Marketing)) {
	        	
	            PMarketing.click();
	        }
	        if ("BuildingRelationship".equalsIgnoreCase(BuildingRelationship)) {
	        	
	        	PBuildingRelationship.click();
	        }
	        if ("Branding".equalsIgnoreCase(Branding)) {
	        	
	            PBranding.click();
	        }
	        if ("GrowMyBusiness".equalsIgnoreCase(GrowMyBusiness)) {
	        	
	            PGrowMyBusiness.click();
	        }
	        if ("InvestInBusiness".equalsIgnoreCase(InvestInBusiness)) {
	        	
	            PInvestInBusiness.click();
	        }
	        if ("Other".equalsIgnoreCase(Other)) {
	        	
	            POther.click();
	        }
	        
	        
	        scrollToElement(Createbtn);       
	        
	        int index = stringToInt(getSystemCurrentDate());
	        if(index>25) {
	        	index = 26;
	        }
	        selectUsingIndex(CommunityCategory, index,"Community Category");
//	        selectByVisibleText(CommunityCategory, Category, "CommunityCategory");
	        selectByVisibleText(CommunityType, type, "CommunityType");
	        
	        
//	        try {				
//				YesProceedBtn.click();
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				
//			}     
	        
	        picture();
	        click(Createbtn,"Create btn");
	       
	        try {
	        	waitForElementToPresent(OkBtn);
	        	 scrollToElement(Createbtn);
	        	 click(OkBtn,"Ok Btn");
	        	 picture();
	           	
			} catch (Exception e) {

			}
	        Thread.sleep(5000);
	        
	    }
	    
	    
	    
	    public void Createcommunity(){
	    	
	    }
	    
	    
	    
	    public void UpdateCommunity(String CommunityName,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,
	    		String InvestInBusiness,String OtherName,String About,String Category,String type,String StateName,String CityName,String FacebookUrl,
	    		String TwitterUrl,String LinkedInUrl,String LogoImagePath, String websiteUrl, String ImagePath,String communityUpdate, String CommunityNameUpdate) throws Exception {
	       
	    	waitForElementToPresent(this.CommunityName);
	        this.CommunityName.clear();
	        scrollToElement(State);
	        
	        Facebook.clear();
	        Twitter.clear();
	        LinkedIn.clear();
//	        GPlus.clear();
	        scrollToElement(this.CommunityName);
	        
	        Thread.sleep(2000);
	        if (PNetworking.isSelected()) {
	        	
	            PNetworking.click();
	        }
	        if (PMarketing.isSelected()) {
	        	
	            PMarketing.click();
	        }
	        if (PBuildingRelationship.isSelected()) {
	        	
	            PBuildingRelationship.click();
	        }
	        if (PBranding.isSelected()) {
	        	
	            PBranding.click();
	        }
	        if (PBuildingRelationship.isSelected()) {
	        	
	            PBuildingRelationship.click();
	        }
	        if (PGrowMyBusiness.isSelected()) {
	        	
	            PGrowMyBusiness.click();
	        }
	        if (PInvestInBusiness.isSelected()) {
	        	
	            PInvestInBusiness.click();
	        }
	        if (POther.isSelected()) {
	        	
	            POther.click();
	        }
	        driver.switchTo().frame(iframe);
	        enterTextInframe.clear();   
	        driver.switchTo().defaultContent();
	        scrollToElement(State);
	        City.clear();
	        State.clear();
	        picture();
	       
	        
	        Thread.sleep(2000);
	        type(City, CityName,"City");
	        type(State, StateName,"StateName");	        	
	        Select Cat = new Select(CommunityCategory);
		       
	        Cat.selectByVisibleText(Category);
	        Facebook.sendKeys(FacebookUrl);
	        
	        Twitter.sendKeys(TwitterUrl);
	       
	        LinkedIn.sendKeys(LinkedInUrl);
	        
	        type(website,websiteUrl,"Website Url");
	      
//	        GPlus.sendKeys(GooglePlusUrl);
	        scrollToElement(LinkedIn); 
//	        ChangeLogo.click();
//	        waitForElementToPresent(LogoBrowseBtn);
//	       
//	        LogoBrowseBtn.click();
	        Thread.sleep(8000);
//	        Runtime.getRuntime().exec(LogoImagePath);
	        Thread.sleep(5000);
	       
//	        LogoUploadBtn.click();
//	        Thread.sleep(3000);
//	       
//	        
//	        
//	        ChangeImage.click();
//	        waitForElementToPresent(ImageBrowseBtn);
//	        
//	        ImageBrowseBtn.click();
//	        Thread.sleep(8000);
//	        Runtime.getRuntime().exec(ImagePath);
	        Thread.sleep(5000);	        
//	        ImageUploadBtn.click();
	        Thread.sleep(5000);
	        scrollToElement(this.CommunityName);
	        
	        type(this.CommunityName, CommunityNameUpdate,"Name");
	        
	        driver.switchTo().frame(iframe);
	        enterTextInframe.clear();
	        Thread.sleep(3000);
	      
	        enterTextInframe.sendKeys(About);
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(1);
	        enterTextInframe.clear();
	       Thread.sleep(3000);
	        enterTextInframe.sendKeys(communityUpdate);
	        
	        driver.switchTo().defaultContent();
	        
	        if ("Networking".equalsIgnoreCase(Networking)) {
	        	
	            PNetworking.click();
	        }
	        if ("Marketing".equalsIgnoreCase(Marketing)) {
	        	
	            PMarketing.click();
	        }
	        if ("BuildingRelationship".equalsIgnoreCase(BuildingRelationship)) {
	        	
	        	PBuildingRelationship.click();
	        }
	        if ("Branding".equalsIgnoreCase(Branding)) {
	        	
	            PBranding.click();
	        }
	        if ("GrowMyBusiness".equalsIgnoreCase(GrowMyBusiness)) {
	        	
	            PGrowMyBusiness.click();
	        }
	        if ("InvestInBusiness".equalsIgnoreCase(InvestInBusiness)) {
	        	
	            PInvestInBusiness.click();
	        }
	        if ("Other".equalsIgnoreCase(OtherName)) {
	        	
	            POther.click();
	        }
	        
	        scrollToElement(ChangeLogo);
	        
	        int index = stringToInt(getSystemCurrentDate());
	        if(index>25) {
	        	index = 26;
	        }
	        selectUsingIndex(CommunityCategory, index,"Community Category");
	        Select Type = new Select(CommunityType);
	       
	        Type.selectByVisibleText(type);
	        try {
			
				YesProceedBtn.click();
				Thread.sleep(2000);
			} catch (Exception e) {
				
			}
	       
	       aShot();
	       clickElementByJavaScript(Savebtn);
	        Thread.sleep(10000);
	        
			//logger.log(LogStatus.INFO,"After Filling community information");
	        //Createbtn.click();
	    }
	    
	    
	    
	    
//		public void FillCommunityDetails1(String Name, String About, String Category, String type
//				) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebDriverWait wait = new WebDriverWait(driver, 20);
//			waitForElementToPresent(CommunityName, timeOutInSeconds);
//	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CommunityNamefield)));
//	        
//	        CommunityName.clear();
//	        CommunityName.sendKeys(Name);
//	    
//	        driver.switchTo().frame(iframe);
//	        CommunityAbout.sendKeys(About);
//	        driver.switchTo().defaultContent();
//	        js.executeAsyncScript("arguments[0].scrollIntoView(true)", Createbtn);
//	        Select Cat = new Select(CommunityCategory);
//	        Cat.selectByVisibleText(Category);
//	        Select Type = new Select(CommunityType);
//	        Type.selectByVisibleText(type);		
//	        
//	        
//	        
//		}
	    
	    
	    
	    
		public void InActiavteCommunity()  throws Exception {
			
			
			
			
	       
	        waitForElementToPresent(CommunityName);
	        Thread.sleep(3000);
			scrollToElement(ActiveToggeleBtn);
	       
			Thread.sleep(1000);
	        ActiveToggeleBtn.click();
	        waitForElementToPresent(YesProceedBtn);
			
			YesProceedBtn.click();			
			Thread.sleep(1000);
			Createbtn.click();		
			Thread.sleep(4000);	
		}
		
		
	
	
	
	
	
	
//	public void logout(){
//		logout.click();
//		log.info("clicked on logout link");
//		waitForElement(LOGINBtn);
//	}
	
	
}
