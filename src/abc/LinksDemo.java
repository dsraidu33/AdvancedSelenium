package abc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class LinksDemo {
	WebDriver d;
	@Test
	public void links() throws Exception
	{
		//Load web page
		d.get("http://docs.seleniumhq.org/");
		Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("No of links:"+l.size());
		String links[]=new String[l.size()];
		int i=0;
		System.out.println("**** Links are ***********");
		for(WebElement e:l)
		{
			System.out.println(e.getText());
			links[i]=e.getText();
			i++;
		}
		for(String s:links)
		{
			d.findElement(By.linkText(s)).click();
			if(d.getTitle().contains("404"))
			{
				System.out.println("Link:"+s+":is not working");
			}
			else
			{
				System.out.println("Link:"+s+":is working fine");
			}
			
		}
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
