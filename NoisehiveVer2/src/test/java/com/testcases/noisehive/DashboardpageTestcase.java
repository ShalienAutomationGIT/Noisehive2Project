package com.testcases.noisehive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
	
	Dashboardpage dp = PageFactory.initElements(driver, Dashboardpage.class);
	
	@Test(priority=1)
	public void testdashboardpage()
	{	
		
		dp.verifyDashboardTitle();
		

	}	

	
	  @Test(priority=2) 
	  public void verifyDashboardMusicHeader()
	  {
		  
	  dp.verifyDashboardHeader();
	  
	  }
	  
	  @Test(priority=3)
	  public void clickMoreInfoBtn() throws InterruptedException
	  {
		  dp.clickMoreInformation();
	  }
	 
	  @Test(priority=3)
	  public void checkScrollDown() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  dp.scrollDownPage();
		  Thread.sleep(1000);
	  }
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	

}
