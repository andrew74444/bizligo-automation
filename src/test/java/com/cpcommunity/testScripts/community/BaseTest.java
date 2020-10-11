package com.cpcommunity.testScripts.community;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.cpcommunity.ExtentListeners.ExtentListeners;
import com.cpcommunity.utilities.DriverCapabilities;
import com.cpcommunity.utilities.DriverFactory;
import com.cpcommunity.utilities.DriverManager;
import com.cpcommunity.utilities.JavaScript;
import com.cpcommunity.utilities.MonitoringMail1;
import com.cpcommunity.utilities.RobotClass;
import com.cpcommunity.utilities.SessionID;
import com.cpcommunity.utilities.waitHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

//	C:\Users\Sasi Vinod\.jenkins\secrets\initialAdminPassword
//	18c07d1bca7142788798626b183ac587
//	http://vimalselvam.com/category/extent-report/
//	https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html
	private WebDriver driver;
	private Properties Config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	public boolean grid = false;
	private String defaultUserName;
	private String defaultPassword;
	private String saUserName;
	private String saPassword;
	private String ExplicitWait;
//	private String createCommunity;
//	private String MemberRejectCommunity;
//	private String approveCommunity;
//	private String communityName;
//	private String rejectCommunity;
//	private String recreateCommunity;
	private String nancykemper;
	private String nancycarton;
	private String harley;
	private String brook;
	private String elizabeth;
	private String justin;
	private String india;
	private String eagle;
	private String cook;
	private String lance;
	private String jennings;
	private String allen;
	private String asolly;
	private String james;
	private String andrew;
	private String curator;
//	private String password;
	private String payPalAPIUsername;
	private String payPalAPIPassword;
	private String payPalAPISignature;
	private String payPalEmail;
	private String payPalPassword;
	private String payPalMerchantEmailID;
	private String payPalMerchantPassword;
//	private String communityName14;

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getCreateCommunity() {
//		return createCommunity;
//	}
//
//	public void setCreateCommunity(String createCommunity) {
//		this.createCommunity = createCommunity;
//	}
//
//	public String getApproveCommunity() {
//		return approveCommunity;
//	}
//
//	public void setApproveCommunity(String approveCommunity) {
//		this.approveCommunity = approveCommunity;
//	}
//
//	public String getRejectCommunity() {
//		return rejectCommunity;
//	}
//
//	public void setRejectCommunity(String rejectCommunity) {
//		this.rejectCommunity = rejectCommunity;
//	}
//
//	public String getRecreateCommunity() {
//		return recreateCommunity;
//	}
//
//	public void setRecreateCommunity(String recreateCommunity) {
//		this.recreateCommunity = recreateCommunity;
//	}
//
//	public String getCommunityName() {
//		return communityName;
//	}
//
//	public void setCommunityName(String communityName) {
//		this.communityName = communityName;
//	}
//
//	public String getCommunityName2() {
//		return MemberRejectCommunity;
//	}
//
//	public void setMemberRejectCommunity(String MemberRejectCommunity) {
//		this.MemberRejectCommunity = MemberRejectCommunity;
//	}
//
//	
//	
//	public String getCommunityName3() {
//		return communityName3;
//	}
//
//	public void setCommunityName3(String communityName3) {
//		this.communityName3 = communityName3;
//	}
//	
//	public String getCommunityName4() {
//		return communityName4;
//	}
//
//	public void setCommunityName4(String communityName4) {
//		this.communityName4 = communityName4;
//	}	
//
//	public String getCommunityName6() {
//		return communityName6;
//	}
//
//	public void setCommunityName6(String communityName6) {
//		this.communityName6 = communityName6;
//	}
//	
//	public String getCommunityName7() {
//		return communityName7;
//	}
//
//	public void setCommunityName7(String communityName7) {
//		this.communityName7 = communityName7;
//	}
//	
//	
//	public String getCommunityName8() {
//		return communityName8;
//	}
//
//	public void setCommunityName8(String communityName8) {
//		this.communityName8 = communityName8;
//	}
//	
//		
//	public String getCommunityName10() {
//		return communityName10;
//	}
//
//	public void setCommunityName10(String communityName10) {
//		this.communityName10 = communityName10;
//	}	
//	
//	public String getCommunityName11() {
//		return communityName11;
//	}
//
//	public void setCommunityName11(String communityName11) {
//		this.communityName11 = communityName11;
//	}	
//
//	public String getCommunityName12() {
//		return communityName12;
//	}
//
//	public void setCommunityName12(String communityName12) {
//		this.communityName12 = communityName12;
//	}	
//	
//	public String getCommunityName13() {
//		return communityName13;
//	}
//
//	public void setCommunityName13(String communityName13) {
//		this.communityName13 = communityName13;
//	}
//	
//	public String getCommunityName14() {
//		return communityName14;
//	}
//
//	public void setCommunityName14(String communityName14) {
//		this.communityName14 = communityName14;
//	}
//	
//	public String getCommunityName15() {
//		return communityName15;
//	}
//
//	public void setCommunityName15(String communityName15) {
//		this.communityName15 = communityName15;
//	}
//	
//	public String getCommunityName16() {
//		return communityName16;
//	}
//
//	public void setCommunityName16(String communityName16) {
//		this.communityName16 = communityName16;
//	}
//	
//	
//	public String getGroupName1() {
//		return groupName1;
//	}
//
//	public void setGroupName1(String groupName1) {
//		this.groupName1 = groupName1;
//	}
//	
//	public String getGroupName() {
//		return groupName;
//	}
//
//	public void setGroupName(String groupName) {
//		this.groupName = groupName;
//	}
//	
//	
//	public String getCommunityName5() {
//		return communityName5;
//	}
//
//	public void setCommunityName5(String communityName5) {
//		this.communityName5 = communityName5;
//	}	
//	
	
	
	
	public String getExplicitWait() {
		return ExplicitWait;
	}

	public void setExplicitWait(String ExplicitWait) {
		this.ExplicitWait = ExplicitWait;
	}

	public String getSaUserName() {
		return saUserName;
	}

	public void setSaUserName(String saUserName) {
		this.saUserName = saUserName;
	}

	public String getSaPassword() {
		return saPassword;
	}

	public void setSaPassword(String saPassword) {
		this.saPassword = saPassword;
	}

	public String getDefaultUserName() {
		return defaultUserName;
	}

	public void setDefaultUserName(String defaultUserName) {
		this.defaultUserName = defaultUserName;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	@BeforeSuite
	public void setUpFramework() {

		configureLogging();
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");

		if (System.getProperty("os.name").equalsIgnoreCase("mac")) {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");

		} else {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
			DriverFactory.setIeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");

		}
		/*
		 * Initialize properties Initialize logs load executables
		 * 
		 */
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		;

	}

	public void logInfo(String message) {

		ExtentListeners.testReport.get().info(message);
	}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties"
				+ File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void destroyFramework() {

	}

	public void openBrowser(String browser) {

		if (System.getenv("ExecutionType") != null && System.getenv("ExecutionType").equals("Grid")) {

			grid = true;
		}

		DriverFactory.setRemote(grid);
		Capabilities caps;
		ChromeOptions options = new ChromeOptions(); 

		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		
		// Create object of HashMap Class
				Map<String, Object> prefs = new HashMap<String, Object>();
		              
		                // Set the notification setting it will override the default setting
				prefs.put("profile.default_content_setting_values.notifications", 2);
		 
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				
		                // Set the experimental option
				options.setExperimentalOption("prefs", prefs);
		
		
		if (DriverFactory.isRemote()) {
			DesiredCapabilities cap = null;

			if (browser.equals("firefox")) {

				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);

			} else if (browser.equals("chrome")) {

				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("ie")) {

				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplore");
				cap.setPlatform(Platform.WIN10);
			}

			try {
				caps = ((RemoteWebDriver) driver).getCapabilities();
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}

		} else

		if (browser.equals("chrome")) {
			System.out.println("Launching : " + browser);
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
//			WebDriverManager.chromedriver().setup();
			
			
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.out.println("Launching : " + browser);
//			System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverExePath());

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}
		caps = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(driver);
		DriverCapabilities.setCapabilities(caps);
		String ID = driver.toString();
		ID = ID.replace("ChromeDriver: chrome on XP (","");
		ID = ID.replace(")", "");
		SessionID.setSessionID(ID);
		System.out.println(ID);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		JavaScript.setJavaScriptObject(js);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		waitHelper.setWebDriverWaitObject(wait);
		try {
			Robot robot = new Robot();
			RobotClass.setRobotClassObject(robot);	
		} catch (AWTException e) {

			e.printStackTrace();
		}
		
		
		
		DriverManager.setWebDriver(driver);
		log.info("Driver Initialized !!!");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
//		System.out.println(sessionid);
//		System.out.println(DriverManager.getDriver().toString());
		
		setDefaultUserName(Config.getProperty("defaultUserName"));
		setDefaultPassword(Config.getProperty("defaultPassword"));
		
		setAndrew(Config.getProperty("andrew"));
		
		setSaUserName(Config.getProperty("saUserName"));
		setSaPassword(Config.getProperty("saPassword"));
		setDefaultPassword(Config.getProperty("ExplicitWait"));
//		setCommunityName(Config.getProperty("communityName"));
//		setCreateCommunity(Config.getProperty("createCommunity"));
//		setApproveCommunity(Config.getProperty("approveCommunity"));
//		setRejectCommunity(Config.getProperty("rejectCommunity"));
//		setRecreateCommunity(Config.getProperty("recreateCommunity"));
		
		setCurator(Config.getProperty("curator"));
//		setPassword(Config.getProperty("password"));
		setDefaultPassword(Config.getProperty("payPalAPIUsername"));
		setDefaultPassword(Config.getProperty("payPalAPIPassword"));
		setDefaultPassword(Config.getProperty("payPalAPISignature"));
		setDefaultPassword(Config.getProperty("payPalEmail"));
		setDefaultPassword(Config.getProperty("payPalPassword"));
		setDefaultPassword(Config.getProperty("payPalMerchantEmailID"));
		setDefaultPassword(Config.getProperty("payPalMerchantPassword"));
//		setCommunityName14(Config.getProperty("communityName14"));
		
//		System.out.println(1);
		
//		System.out.println(Config.getProperty("communityName14"));
//		System.out.println(getAndrew());
		
//		System.out.println(2);
		
	}

	public void quit() {

		DriverManager.getDriver().quit();
		log.info("Test Execution Completed !!!");
	}

	public String getCurator() {
		return curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getPayPalAPIUsername() {
		return payPalAPIUsername;
	}

	public void setPayPalAPIUsername(String payPalAPIUsername) {
		this.payPalAPIUsername = payPalAPIUsername;
	}

	public String getPayPalAPIPassword() {
		return payPalAPIPassword;
	}

	public void setPayPalAPIPassword(String payPalAPIPassword) {
		this.payPalAPIPassword = payPalAPIPassword;
	}

	public String getPayPalAPISignature() {
		return payPalAPISignature;
	}

	public void setPayPalAPISignature(String payPalAPISignature) {
		this.payPalAPISignature = payPalAPISignature;
	}

	public String getPayPalEmail() {
		return payPalEmail;
	}

	public void setPayPalEmail(String payPalEmail) {
		this.payPalEmail = payPalEmail;
	}

	public String getPayPalPassword() {
		return payPalPassword;
	}

	public void setPayPalPassword(String payPalPassword) {
		this.payPalPassword = payPalPassword;
	}

	public String getPayPalMerchantEmailID() {
		return payPalMerchantEmailID;
	}

	public void setPayPalMerchantEmailID(String payPalMerchantEmailID) {
//		payPalMerchantEmailID = payPalMerchantEmailID;
	}

	public String getPayPalMerchantPassword() {
		return payPalMerchantPassword;
	}

	public void setPayPalMerchantPassword(String payPalMerchantPassword) {
//		payPalMerchantPassword = payPalMerchantPassword;
	}

	public String getAndrew() {
		
		
		return andrew;
	}

	public void setAndrew(String andrew) {
		
		this.andrew = andrew;
		

	}

	////////////////////////////////////////////////
	////////////////////
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	
	
	public String getNancykemper() {

		return nancykemper;
	}

	public void setNancykemper(String nancykemper) {
		this.nancykemper = nancykemper;

	}
	
	
			
			
	public String getNancycarton() {

		return nancycarton;
	}

	public void setNancycarton(String nancycarton) {
		this.nancycarton = nancycarton;

	}
	
	public String getHarley() {

		return harley;
	}

	public void setHarley(String harley) {
		this.harley = harley;

	}
	
			
	public String getBrook() {

		return brook;
	}

	public void setBrook(String brook) {
		this.brook = brook;

	}
	
	public String getElizabeth() {

		return elizabeth;
	}

	public void setElizabeth(String elizabeth) {
		this.elizabeth = elizabeth;

	}
	
			
	public String getJustin() {

		return justin;
	}

	public void setJustin(String justin) {
		this.nancykemper = justin;

	}
	
	public String getIndia() {

		return india;
	}

	public void setIndia(String india) {
		this.india = india;

	}
	
	public String getEagle() {

		return eagle;
	}

	public void setEagle(String eagle) {
		this.eagle = eagle;

	}
			
	public String getCook() {

		return cook;
	}

	public void setCook(String cook) {
		this.cook = cook;

	}
	
	public String getLance() {

		return lance;
	}

	public void setLance(String lance) {
		this.lance = lance;

	}
	
	public String getJennings() {

		return jennings;
	}

	public void setJennings(String jennings) {
		this.jennings = jennings;

	}
	
	public String getallen() {

		return allen;
	}

	public void allen(String allen) {
		this.allen = allen;

	}

	public String getJames() {

		return james;
	}

	public void setJames(String james) {
		this.james = james;

	}
	
	public String getAsolly() {

		return asolly;
	}

	public void setAsolly(String asolly) {
		this.asolly = asolly;

	}
	
//	public String getNancykemper() {
//
//		return nancykemper;
//	}
//
//	public void setNancykemper(String nancykemper) {
//		this.nancykemper = nancykemper;
//
//	}
//	
//	public String getNancykemper() {
//
//		return nancykemper;
//	}
//
//	public void setNancykemper(String nancykemper) {
//		this.nancykemper = nancykemper;
//
//	}
	
	
	public String currentTime() {

		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
//		System.out.println(dateFormat.format(date)); //0809190355
		String d = dateFormat.format(date);		
		
		return d;

	}
			
	
	public String date() {
		Date date = new Date();  
	    SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate = formatter.format(date);    
	    System.out.println("Date Format with dd MMMM yyyy : "+strDate);
	    return strDate;
	}
	

	@AfterSuite
	public void sendmail() {
		MonitoringMail1 mail = new MonitoringMail1();
		mail.Sendmail();
	}
	
	public Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
				System.out.println(cal.getTime());
		return cal.getTime();
	}
//	Sun Nov 25 11:45:05 PST 2012
	
	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		System.out.println(cal.getTime());
		return cal.getTime();
	}
	
}
