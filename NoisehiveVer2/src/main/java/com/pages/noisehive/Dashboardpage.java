package com.pages.noisehive;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.noisehive.Base;

import junit.framework.Assert;

public class Dashboardpage extends Base {
	
	public Dashboardpage()
	{
		this.driver = driver;
	}
	
	//Define locators
	
	@FindBy(xpath="")
	WebElement dashboardMusicHeader;
	
	
	public void verifyDashboardTitle()
	{
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Noisehive"));
		System.out.println("1. Title on Dashboard Web Page: " +title);
	}

}
