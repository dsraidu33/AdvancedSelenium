package abc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class SliderDemo {
	WebDriver d;
	@Test
	public void slider() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/slider/");
		Assert.assertEquals("Slider | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span1234")), 250,0).perform();
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{

		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
