package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectLibrary.nop_Comm_Login;
import pageObjectLibrary.pob_addCustomer;
import utility.Screenshot;

public class Add_Customer  extends BaseClass
{
	    @Test(priority=1)
	    public void login() throws IOException
	    {
	    	nop_Comm_Login login; 
	    	login = new nop_Comm_Login(driver, this.getClass().getSimpleName());
	    	login.Login(username,password);
	    	sc.TakeScreenshot(driver, this.getClass().getSimpleName());
	    	
	    }
	    @Test(priority=2)
	    public void  add_cust() throws IOException
	    {
	    	pob_addCustomer addCust;
	    	addCust= new pob_addCustomer(driver, this.getClass().getSimpleName());    	
	    	addCust.add_customer();
	    	sc.TakeScreenshot(driver, this.getClass().getSimpleName());
	    }
	
}
