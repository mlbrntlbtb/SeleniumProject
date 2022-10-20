package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SeleniumWebDriverEventHandler 
{
private static WebDriver AutoDriver;
private static EventFiringWebDriver eventFiringWebDriver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		eventFiringWebDriver = new EventFiringWebDriver(AutoDriver);
		SeleniumWebDriverEventListener webDriverEventListener = new SeleniumWebDriverEventListener();
		eventFiringWebDriver.register(webDriverEventListener);
	}
	
	@Test
	public void Test() 
	{
		eventFiringWebDriver.navigate().to("https://demoqa.com/");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
