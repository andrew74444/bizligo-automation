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
 

public class TestDBConn3 {

	public static void main(String[] args) throws Exception   {					 
		 
		 
		
			  WebDriver driver = null;	 
			  
			  System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\SampleProject\\src\\test\\resources\\executables\\chromedriver.exe"); 
		   driver = new ChromeDriver();
		   driver.get("https://cpcommunityqa.azurewebsites.net/community/info/60-Apple-X/1072");
		   Thread.sleep(10000);
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   
		   //Get WebElement reference of logo
		   WebElement logoElement = driver.findElement(By.xpath("(//*[@class='img-responsive'])[3]"));
		   
		   Thread.sleep(3000);
		   
		   //Capture and store logo image
		   Screenshot shot = new AShot().takeScreenshot(driver, logoElement);
		   File file = new File(System.getProperty("user.dir")+"\\src\\test\\logo1.png");
		   System.out.println(file);
		   ImageIO.write(shot.getImage(), "PNG", file);
		   
		   Thread.sleep(10000);
		   //Getting Expected Image
		   BufferedImage expectedImg = ImageIO.read(file);
		
		   //Getting Actual Image
		   Screenshot shot2 = new AShot().takeScreenshot(driver, logoElement);
		   File file2 = new File(System.getProperty("user.dir")+"\\src\\test\\logo2.png");
		   BufferedImage actualImg = shot2.getImage();
		   System.out.println(file2);
		   ImageIO.write(actualImg, "PNG", file2);
		   
		   //Image Comparison
		   ImageDiffer imgDiff = new ImageDiffer();
		   ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
		   if(dif.hasDiff()){
		   System.out.println("Both images are different");
		   }else {
		   System.out.println("Both images are same");
		   }
		   
		   driver.close();
		   driver.quit();
		  }
		
	}
		

			
		
		
		
	


