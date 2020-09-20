package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;

import utility.ReadConfig;
import utility.Screenshot;

public class BaseClass 
{
	static WebDriver driver;
	public static ReadConfig readconfig = new ReadConfig() ;
	public String URL = readconfig.getURL();
	public String Chromepath= readconfig.getChromePath();
	public static String username= readconfig.getUsername();
	public static String password= readconfig.getPassword();
	Screenshot sc=  new Screenshot();
	
	@BeforeSuite
	public void setup(ITestContext result)
	{
		Logger log ;
		log=Logger.getLogger(result.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("Inside constructor");
		System.setProperty("webdriver.chrome.driver",Chromepath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver. manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	
	
	@AfterSuite
	public void terminate() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
