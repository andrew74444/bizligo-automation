package com.cpcommunity.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
 
import javax.imageio.ImageIO;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
 

public class TestDBConn4 {

	public static void main(String[] args) throws Exception   {					 
		 
		 
		
			  WebDriver driver = null;	 
			  
			  System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\SampleProject\\src\\test\\resources\\executables\\chromedriver.exe"); 
		   driver = new ChromeDriver();
		   driver.get("https://cpcommunityqa.azurewebsites.net/community/info/60-Apple-X/1072");
		   Thread.sleep(3000);
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   
		   WebElement element = driver.findElement(By.xpath("//*[@class='header']"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].setAttribute('class','');", element);
			js1.executeScript("arguments[0].scrollIntoView()", element);
		   //Get WebElement reference of logo
		  
		      WebElement logo = driver.findElement(By.xpath("(//*[@class='img-responsive'])[3]"));
		      Shutterbug.shootElement(driver,logo).withName("actualImg").save();
		      String ImageFileName = "expectedImg";
		      
		      File file = new File(System.getProperty("user.dir")+"\\screenshots\\"+ImageFileName+".png");
		      BufferedImage Img = ImageIO.read(file);	
		     
		      File file2 = new File(System.getProperty("user.dir")+"\\screenshots\\actualImg.png");
		      BufferedImage actualImg = ImageIO.read(file2);
		      
		      ImageDiffer imgDiff = new ImageDiffer();
			   ImageDiff dif = imgDiff.makeDiff(Img,actualImg );
			   if(dif.hasDiff()){
			   System.out.println("Both images are different");
			   }else {
			   System.out.println("Both images are same");
			   }
		      
		      driver.quit();
		  }
		
	}
		

			
		
		
		
	


