package com.base.noisehive;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.noisehive.Constants;

public class Base {

	public static WebDriver driver;
	public static Properties CONFIG ;
	public static int IMPLICIT_WAIT = 30;
	public static int PAGE_TIMEOUT = 20;
	
	
	// Setting properties file method
	public void initConfig()
	{
		try {
			
			 CONFIG = new Properties();
			 
			 FileInputStream fip = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
			 
			 CONFIG.load(fip);
			 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void initBrowser()
	{
		String browserName = CONFIG.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{			
			System.setProperty("webdriver.chrome.driver", "C:/Users/abc/Desktop/JAR files/Browsers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);	
						
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/abc/Desktop/JAR files/Browsers/geckodriver");
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:/Users/abc/Desktop/JAR files/Browsers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(CONFIG.getProperty("URL"));
				
	}
	
	
	public WebElement wait(WebDriver driver, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	
	public void takesScreenshot(String fileName){
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + File.separator + "screenshot"
					+ File.separator+ fileName + ".jpg"));			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	
	public void switchingToNewWindow() throws InterruptedException
	{
		String winhandlebefore = driver.getWindowHandle();
		
		for(String winhandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winhandle);
		}
		
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.close();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(winhandlebefore);
	
	
	}
	
	
	
	
	
	
	
	
}
