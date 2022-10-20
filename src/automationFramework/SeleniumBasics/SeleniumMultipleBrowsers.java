package automationFramework.SeleniumBasics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMultipleBrowsers 
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
		AutoDriver.navigate().to("https://demoqa.com/browser-windows");
		
		//Handling multiple windows
		String parentWindowValue = AutoDriver.getWindowHandle();
		System.out.println("Current window: [" + parentWindowValue + "] title: [" + AutoDriver.getTitle() + "]");
		
		//Open new windows
		WebElement newWindowButton = AutoDriver.findElement(By.id("windowButton"));
		for(int o=0;o<3;o++) 
		{
			try 
			{
				newWindowButton.click();
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				//Do nothing
			}
		}
		
		//Get all windows and switch then close
		Set<String> allWindows = AutoDriver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		
		while(iterator.hasNext()) 
		{
			String window = iterator.next();
			if(!window.equals(parentWindowValue)) 
			{
				AutoDriver.switchTo().window(window);
				System.out.println("Current window: [" + window + "] title: [" + AutoDriver.getTitle() + "]");
				AutoDriver.close();
			}
		}
		
		//Switch back to parent window
		AutoDriver.switchTo().window(parentWindowValue);
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
