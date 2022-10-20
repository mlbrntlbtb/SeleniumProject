package automationFramework.SeleniumBasics;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class SeleniumScreenshot 
{
private static WebDriver AutoDriver;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		
		//Take screenshot
		File screenshot = ((TakesScreenshot)AutoDriver).getScreenshotAs(OutputType.FILE);
		//String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
		//Copy the file to a location and use try catch block for exception
		try 
		{
			File path = new File("C:\\Users\\Melbourne\\Downloads\\SeleniumScreenshotJava.png");
			FileUtils.copyFile(screenshot, path);
			
		}
		catch(IOException e) 
		{
			//Do nothing
		}
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
