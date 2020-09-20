package utility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener extends TestListenerAdapter
{
	ExtentHtmlReporter HtmlReporter;
	ExtentReports Reports;
	ExtentTest test;
	Logger log;
	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("inside sucess");
		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report.html");
		HtmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		Reports = new ExtentReports();
		Reports.attachReporter(HtmlReporter);
		log=Logger.getLogger("Listener");
		PropertyConfigurator.configure("Log4j.properties");
		HtmlReporter.config().setChartVisibilityOnOpen(true);
		HtmlReporter.config().setTheme(Theme.DARK);
		HtmlReporter.config().setDocumentTitle("Report");
		HtmlReporter.config().getTimeStampFormat();
		HtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(" sucess!");
		test= Reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test"+result.getName()+"Passed", ExtentColor.GREEN));
		String SS_loc = System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(SS_loc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Fail!");
		test=Reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Failed", ExtentColor.RED));
		String SS_loc = System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png";
		
		try {
			test.addScreenCaptureFromPath(SS_loc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		test=Reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skipped", ExtentColor.INDIGO));
		String SS_loc = System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(SS_loc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("unable to fetch Screenhot or Screenshot not available!");
		}
	}
	public void onFinish(ITestContext Context)
	{
		Reports.flush();
	}
	
}
