package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogsSummary  extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(blogsSummary);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
	}

	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;

	@FindBy(xpath = "//h2[normalize-space()='Blog Summary']")
	WebElement blogsSummary;
	
	@FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@role='main']/div/div/div[@class='row']/div[@class='col-md-12 col-sm-12 col-xs-12']/div[@class='x_panel']/div[@class='x_content']/div[@class='row top_tiles']/div[2]")
	WebElement categoriescount;

	@FindBy(xpath = "//div[@class='tile-stats']//a[@title='Manage Categories'][normalize-space()='Categories']")
	WebElement categorires;
	
	@FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@role='main']/div/div/div[@class='row']/div[@class='col-md-12 col-sm-12 col-xs-12']/div[@class='x_panel']/div[@class='x_content']/div[@class='row top_tiles']/div[1]")
	WebElement postcount;
	
	@FindBy(xpath = "//div[@class='tile-stats']//a[@title='Manage Posts'][normalize-space()='Posts']")
	WebElement post;
	
	public CategoriesPage categorycounts() {
		waitForElementToPresent(categoriescount);
		String count=this.categoriescount.getText();
		System.out.print("Total counts of Categories are: " +count);
		click(categorires, "Categories");
		return (CategoriesPage) openPage(CategoriesPage.class);
	}
	public CommunityBlogsPage Postcounts() {
		waitForElementToPresent(postcount);
		String count=this.postcount.getText();
		System.out.print("Total counts of posts are: " +count);
		click(post, "Post");
		return (CommunityBlogsPage) openPage(CommunityBlogsPage.class);
	}
}
