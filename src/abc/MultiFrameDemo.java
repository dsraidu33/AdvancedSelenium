package abc;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class MultiFrameDemo {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		//Load web page
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		List<WebElement> f=d.findElements(By.tagName("frame"));
		//System.out.println("No of frames:"+f.size());
		//Switch driver focus to 1st frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 2nd frame
		d.switchTo().frame(1);
		d.findElement(By.linkText("Selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 3rd frame
		d.switchTo().frame(2);
		d.findElement(By.linkText("DefaultSelenium")).click();
		Thread.sleep(4000);
	}
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{

		//Launch browser
	   if(browser.equalsIgnoreCase("FF"))
		{
			d=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Education\\Selenium Workspace\\lib\\Browsers\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		} 
		else if(browser.equalsIgnoreCase("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Education\\Selenium Workspace\\lib\\Browsers\\chromedriver.exe");
			d=new ChromeDriver();
		} 
		
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@AfterMethod 
	public void Teardown()
	{
	    d.quit();	
	}

}
