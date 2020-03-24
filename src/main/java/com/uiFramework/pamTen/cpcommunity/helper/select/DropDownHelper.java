//package com.uiFramework.pamTen.cpcommunity.helper.select;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Select;
//
//import com.w2a.zoho.PageObjects.BasePage;
//
//
///**
// * 
// * @author Sasi Vinod Akula
// *
// */
//public class DropDownHelper extends BasePage{
//	
//    private WebDriver driver;
//	
//	
//	public DropDownHelper(WebDriver driver){
//		this.driver = driver;
////		log.info("DropDownHelper object created..");
//	}
//	
//	public void selectUsingValue(WebElement element, String value){
//		Select select = new Select(element);
////		log.info("selectUsingValue and value is: "+value);
//		select.selectByValue(value);
//	}
//	
//	public void selectUsingIndex(WebElement element, int index){
//		Select select = new Select(element);
////		log.info("selectUsingIndex and index is: "+index);
//		select.selectByIndex(index);
//	}
//	
//	public void selectUsingVisibleText(WebElement element, String visibleText){
//		Select select = new Select(element);
////		log.info("selectUsingVisibleText and visibleText is: "+visibleText);
//		select.selectByVisibleText(visibleText);
//	}
//	
//	public void deSelectUsingValue(WebElement element, String value){
//		Select select = new Select(element);
////		log.info("deSelectUsingValue and value is: "+value);
//		select.deselectByValue(value);
//	}
//	
//	public void deSelectUsingIndex(WebElement element, int index){
//		Select select = new Select(element);
////		log.info("deSelectUsingIndex and index is: "+index);
//		select.deselectByIndex(index);
//	}
//	
//	public void deSelectUsingVisibleText(WebElement element, String visibleText){
//		Select select = new Select(element);
////		log.info("deselectByVisibleText and visibleText is: "+visibleText);
//		select.deselectByVisibleText(visibleText);
//	}
//	
//	public List<String> getAllDropDownData(WebElement element){
//		Select select = new Select(element);
//		List<WebElement> elementList = select.getOptions();
//		List<String> valueList = new LinkedList<String>();
//		for(WebElement ele: elementList){
////			log.info(ele.getText());
//			valueList.add(ele.getText());
//		}
//		return valueList;
//	}
//
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected void getPageScreenSot() {
//		// TODO Auto-generated method stub
//		
//	}
//}
