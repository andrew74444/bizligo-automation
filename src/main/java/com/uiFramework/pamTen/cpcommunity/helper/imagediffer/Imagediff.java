package com.uiFramework.pamTen.cpcommunity.helper.imagediffer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpcommunity.PageObjects.BasePage;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
/**
 * 
 * @author Sasi Vinod Akula
 *
 */
public class Imagediff {

	// private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	private static Logger log = Logger.getLogger(Imagediff.class);

	public static void diff(BufferedImage expectedImg, BufferedImage actualImg) {
		ImageDiffer imgDiff = new ImageDiffer();
		log.info("Verifing the the image");
		ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
		if (dif.hasDiff()) {
			log.info("Both images are different");
			AssertionHelper.markFail("Both images are different");
		} else {
			log.info("Both images are same");
		}
	}

	public static BufferedImage readFile(String ImageFileName) throws IOException {
		File file = new File(System.getProperty("user.dir") + ImageFileName);
		BufferedImage Img = ImageIO.read(file);
		return Img;
	}

	public static void check(String expectedImageFileName, String actualImageFileName) throws Exception {
		System.out.println(expectedImageFileName);
		System.out.println(actualImageFileName);
		BufferedImage expectedImg = readFile(expectedImageFileName);
		BufferedImage actualImg = readFile(actualImageFileName);
		diff(expectedImg, actualImg);
	}

}
