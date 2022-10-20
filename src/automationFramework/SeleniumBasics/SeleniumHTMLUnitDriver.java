package automationFramework.SeleniumBasics;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class SeleniumHTMLUnitDriver 
{
private static HtmlUnitDriver htmlUnitDriver;
	
	@BeforeClass
	public static void Initialize() 
	{
		//htmlUnitDriver = new HtmlUnitDriver(true); //Enables javascript
		htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
	}
	
	@Test
	public void Test() throws InterruptedException 
	{
		htmlUnitDriver.navigate().to("https://demoqa.com/");
		Thread.sleep(5000); //Cons of headless testing -- does not replicate rendering of page and events
		
		System.out.println("Page title: [" + htmlUnitDriver.getTitle() + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		htmlUnitDriver.quit();
	}
}
