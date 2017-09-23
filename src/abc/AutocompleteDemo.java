package abc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutocompleteDemo {
	WebDriver d;
	@Test
	public void autocomplete() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/autocomplete/");
		Assert.assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//Type text
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions is:"+s.size());
		System.out.println("***** Suggestions are *******");
		for(WebElement e:s)
		{
			System.out.println(e.getText());
		}
		if(s.size()>=3)
		{
			for(int i=0;i<3;i++)
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
			}
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
		}
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
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
