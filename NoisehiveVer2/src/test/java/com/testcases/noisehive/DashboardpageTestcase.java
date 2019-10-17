package com.testcases.noisehive;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.noisehive.Base;
import com.pages.noisehive.Dashboardpage;

public class DashboardpageTestcase extends Base {
	
	
	@BeforeMethod
	public void setup()
	{
		initConfig();
		initBrowser();
	}
	
	
	@Test
	public void testdashboardpage()
	{
		
		Dashboardpage dp = PageFactory.initElements(driver, Dashboardpage.class);
		dp.verifyDashboardTitle();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	

}
