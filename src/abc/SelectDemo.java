package abc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {
	WebDriver d;
	
	@Test
	public void testSelect() throws Exception
	{
		d.get("https://bankifsccode.com/");
		
		Select dd = new Select(d.findElement(By.name("SelectURL")));
		//dd.selectByIndex(3);
		Thread.sleep(6000);
		List<WebElement> e = dd.getOptions();
		String array[]=new String[e.size()];
		int i=0;
		for(WebElement ele: e)
		{
			array[i]=ele.getText();
			i++;
		}
		for(i=0;i<e.size();i++)
		{
			System.out.println("Values of array["+i+"] is"+array[i]);
		}
		
		
		
		
	}
	
	
	
	@Before
	public void setUp()
	{

		//Launch browser
		d=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
		//d=new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().deleteAllCookies();		
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}
