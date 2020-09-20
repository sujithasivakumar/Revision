package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Screenshot 
{
	
	public void TakeScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		System.out.println("SS taken");
		String Screenshot_loc = System.getProperty("user.dir")+"/screenshots/"+name+".png";
		File target= new File(Screenshot_loc);
		FileUtils.copyFile(src, target);
		
	}
}
