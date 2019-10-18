package com.pages.noisehive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.base.noisehive.Base;




public class Dashboardpage extends Base {
	
	
	public Dashboardpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Define locators
	
	@FindBy(xpath="/html/body/section[2]/div[2]/div/div[1]/p/text()")
	WebElement dashboardMusicHeader;
	
	@FindBy(xpath="//*[@id=\"scroll_down\"]/div/a[2]")
	WebElement moreinfobtn;
	
	
	public void verifyDashboardTitle()
	{
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Noisehive"));
		System.out.println("1. Title on Dashboard Web Page: " +title);
	}
	
	
	public void verifyDashboardHeader()
	{ 
		
		WebElement headertext1 = driver.findElement(By.xpath("//*[@id=\"header5-2\"]/div[2]/div/div[1]/p"));
		String actText = headertext1.getText();
		Assert.assertEquals(actText, "Get #YourMusicOnline");
		System.out.println("2. Header on DashboardPage : " +actText);
		
	}
	

	public void scrollDownPage()
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("3. Scroll down successfully");
	}

	public void clickMoreInformation() throws InterruptedException
	{
		moreinfobtn.click();
		

	}
	

}
