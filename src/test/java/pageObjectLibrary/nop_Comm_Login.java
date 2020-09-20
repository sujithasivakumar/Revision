package pageObjectLibrary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class nop_Comm_Login 
{
	WebDriver driver;
	Logger log;
	@FindBy (id="Email")
	@CacheLookup
	WebElement username;
	@FindBy (xpath="//input[@id='Password']")
	@CacheLookup
	WebElement password;
	@FindBy(xpath=".//input[@value='Log in']")
	@CacheLookup
	WebElement btn_login;
	
	public nop_Comm_Login(WebDriver driver , String testcase_name)
	{
		this.driver = driver;  
		PageFactory.initElements(driver, this);
		log=log.getLogger(testcase_name);
		PropertyConfigurator.configure("Log4j.properties");		
	}
	
	public void Login(String uname , String pwd)
	{
		
		username.clear();
		username.sendKeys(uname);
		log.info("User Id entered");
		log.info("Abot o rnter password");
		password.clear();
		password.sendKeys(pwd);
		log.info("Pasword entered");
		btn_login.click();
		log.info("Logon button Clicked");
	}	
}
