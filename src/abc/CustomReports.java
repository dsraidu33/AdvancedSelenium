package abc;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomReports
{
	WebDriver d;
	ExtentReports extent;
	ExtentTest test;
	@Test
	public void testHome() throws Exception
	{
		// starting test
		test = extent.startTest("Verify user is able to open home page", "Test1");
		//Load web page
		d.get("http://49.206.196.246:8080/Cyclos/do/login");
		// step log
		test.log(LogStatus.INFO, "Home page opened");
		assertEquals("USABANK-NY Branch",d.getTitle());
		test.log(LogStatus.INFO, "Verified page title");
		test.log(LogStatus.PASS, "Passed....");
		// ending test
		extent.endTest(test);
	}
	@Test
	public void testLogin() throws Exception
	{
		// starting test
		test = extent.startTest("Verify user is able to login", "Test2");
		//Enter user name
		d.findElement(By.id("cyclosUsername")).clear();
		d.findElement(By.id("cyclosUsername")).sendKeys("qttesters");
		test.log(LogStatus.INFO,"User name entered");
		String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
		//Enter password
		d.findElement(By.id("cyclosPassword")).clear();
		d.findElement(By.id("cyclosPassword")).sendKeys("qttesters");
		test.log(LogStatus.INFO,"password entered");
		String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
		//Click on submit
		d.findElement(By.xpath("//input[@value='Submit']")).click();
		test.log(LogStatus.INFO,"submit button clicked");
		d.findElement(By.xpath("//span[text()='Logout']")).click();
		test.log(LogStatus.INFO,"Logout button clicked");
		//Switch driver focus to alert
		Alert al=d.switchTo().alert();
		//ok
		al.accept();
		test.log(LogStatus.INFO,"Ok button clicked");
		test.log(LogStatus.PASS,"Passed....");
		Thread.sleep(4000);
		extent.endTest(test);
	}
	@BeforeClass
	public void setUp()
	{

		//Launch browser
		d=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
		//d=new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		extent = new ExtentReports("E:\\Education\\Selenium Workspace\\Results\\Reports.html", true);
		/*extent.config()
        .documentTitle("Cyclos Automation Report")
        .reportName("Cyclos:")
        .reportHeadline("Sanity")
        .insertCustomStyles(".test { border:2px solid #444; }");*/
	
		
	}
	@AfterClass
	public void tearDown()
	{
		//Close browser
		d.quit();
		// writing everything to document
		extent.flush();
	}


}
