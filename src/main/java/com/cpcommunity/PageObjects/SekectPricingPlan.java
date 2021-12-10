package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SekectPricingPlan extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(heading);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
	}
	@FindBy(xpath = "//nav[@class='navbar navbar-inverse']")
	WebElement header;
	@FindBy(xpath = "//h4[normalize-space()='Select Plan']")
	WebElement heading;
	@FindBy(xpath = "//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@id='PricingController']/div[@class='reg_cont']/div[@class='row']/div[@id='msform']/fieldset[@class='ng-pristine ng-valid']/div[@ng-show='data.PricingPlans.length']/div[@class='community-plan']/div[@class='row']/div/div[1]")
	List<WebElement> plan;
	@FindBy(xpath = "//button[@id='pricing_plan_80']")
	WebElement withoutsetup;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement next;
	
	
	public MakePaymentPage selectplan(String planName) throws InterruptedException {
		
		int T=plan.size();
		System.out.println(T);
		for(int i=1;i<=T;i++) {
		String  name= driver.findElement(By.xpath("//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@id='PricingController']/div[@class='reg_cont']/div[@class='row']/div[@id='msform']/fieldset[@class='ng-pristine ng-valid']/div[@ng-show='data.PricingPlans.length']/div[@class='community-plan']/div[@class='row']/div[" + i + "]/div[1]//p[@ng-bind='PricingPlan.Name | limitTo :30']")).getText();
		System.out.println(name);
		//Thread.sleep(4000);
		if(name.matches(planName))
		{
		driver.findElement(By.xpath("//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@id='PricingController']/div[@class='reg_cont']/div[@class='row']/div[@id='msform']/fieldset[@class='ng-pristine ng-valid']/div[@ng-show='data.PricingPlans.length']/div[@class='community-plan']/div[@class='row']/div[" + i + "]/div[1]//button[@ng-click='data.OnPlanSelected(PricingPlan)']")).click();
		}		}
		//click(withoutsetup, "without setup plan");
		//Thread.sleep(3000);
		scrollToElement(next);
		//click(next, "Next");
		clickElementByJavaScript(next);
		return (MakePaymentPage) openPage(MakePaymentPage.class);
		
	}
		
}
