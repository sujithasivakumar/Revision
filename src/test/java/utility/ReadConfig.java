package utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		
		try
		{
			File src = new File("./configuration/input.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties(); 
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Error Message:"+e.getMessage());
		}
		
	}
	public String getURL()
	{
		String url= pro.getProperty("Url");
		return url;
		
	}
	
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password= pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
		
	}
}