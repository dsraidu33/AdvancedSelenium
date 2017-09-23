package abc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.*;

public class FileDownload_FirefoxProfile {
	WebDriver d;  
	@Test
	public void testFirefoxProfile() throws Exception
	{
		//Load web page
		d.get("http://docs.seleniumhq.org/download/");
		d.findElement(By.linkText("2.53.1")).click();
		Thread.sleep(6000);
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile fp=p.getProfile("Selenium1");
		d=new FirefoxDriver(fp);
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close the browser
        //d.quit();

	}

}
