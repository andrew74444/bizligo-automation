package com.cpcommunity.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
 
import javax.imageio.ImageIO;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
 

public class TestDBConn2 {

	public static void main(String[] args) throws Exception   {	 
		 
		 
		
		
		MonitoringMail1 mail = new MonitoringMail1();
		mail.Sendmail();
	}
		
		
//			  WebDriver driver = null;	 
//			  
//			  System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\SampleProject\\src\\test\\resources\\executables\\chromedriver.exe"); 
//		   driver = new ChromeDriver();
//		   driver.get("http://www.inviul.com");
//		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		   driver.manage().window().maximize();
//		   
//		   //Get WebElement reference of logo
//		   WebElement logoElement = driver.findElement(By.xpath("//h1[@id='logo']//a//img"));
//		   
//		   Thread.sleep(3000);
//		   
//		   //Capture and store logo image
//		   Screenshot shot = new AShot().takeScreenshot(driver, logoElement);
//		   File file = new File(System.getProperty("user.dir")+"\\logo.png");
//		   System.out.println(file);
//		   ImageIO.write(shot.getImage(), "PNG", file);
//		   
//		   
//		   //Getting Expected Image
//		   BufferedImage expectedImg = ImageIO.read(file);
//		   
//		   //Getting Actual Image
//		   BufferedImage actualImg = shot.getImage();
//		   
//		   //Image Comparison
//		   ImageDiffer imgDiff = new ImageDiffer();
//		   ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
//		   if(dif.hasDiff()){
//		   System.out.println("Both images are different");
//		   }else {
//		   System.out.println("Both images are same");
//		   }
//		   
//		   driver.close();
//		   driver.quit();
//		  }
//		
	}
		

			
		
		
		
	


