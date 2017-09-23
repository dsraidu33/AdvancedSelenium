package abc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstProgram {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d= new FirefoxDriver();
		d.manage().deleteAllCookies();
		d.get("https://qa.elabcorp.com");
		
	    d.findElement(By.xpath("//input[@type='email']")).sendKeys("subbard@labcorp.com");
	    d.findElement(By.xpath("//input[@type='password']")).sendKeys("Mummy@dady1");
	    d.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	    d.findElement(By.xpath("//*[@id='inner']/div[1]/div[1]/a")).click();
	    d.get("https://qa.elabcorp.com/ui/#/home");
	    Thread.sleep(5000);
	    d.findElement(By.xpath("//*[@id='inner']/div[1]/div[2]/a")).click();
	    /*d.get("https://qa.elabcorp.com/ui/#/home");
	    Thread.sleep(5000);
	    d.findElement(By.xpath("//*[@id='inner']/div[1]/div[3]/a")).click();
	    d.navigate().back();
	    Thread.sleep(5000);
	    d.findElement(By.xpath("//*[@id='inner']/div[2]/div[1]/header")).click();*/

	}

}
