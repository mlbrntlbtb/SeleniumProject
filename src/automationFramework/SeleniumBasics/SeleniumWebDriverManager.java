package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriverManager 
{
private static WebDriver AutoDriver;
private static WebDriver AutoDriver2;
	
	@BeforeClass
	public static void Initialize() 
	{
		//Use WebDriverManager to set property path of specific webdrivers binaries automatically - including downloading missing/outdated versions 
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//AutoDriver = new ChromeDriver();
		//AutoDriver = new FirefoxDriver();     
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("headless");
		//AutoDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
		
		AutoDriver = WebDriverManager.chromedriver().create();
		AutoDriver.manage().window().maximize();
		
		//AutoDriver2 = WebDriverManager.firefoxdriver().create();
		//AutoDriver2.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		//AutoDriver2.navigate().to("https://demoqa.com/");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
		//AutoDriver2.quit();
	}
}
