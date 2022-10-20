package automationFramework.SeleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSwitchCommands 
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
		AutoDriver.navigate().to("https://demoqa.com/alerts");
		
		//Test switch alerts
		
		//Open alert
		WebElement alertButton = AutoDriver.findElement(By.id("alertButton"));
		alertButton.click();
				
		//Switch to alert
		Alert simpleAlert = AutoDriver.switchTo().alert();
				
		//Get value of alert
		String simpleAlertValue = simpleAlert.getText();
		System.out.println("Simple alert value: [" + simpleAlertValue + "]");
				
		//Accept alert
		simpleAlert.accept();		
		
		
		
		
		//Test switch to frame
		
		AutoDriver.navigate().to("https://demoqa.com/frames");
		
		//Switch to frame
		String firstFrameName = "frame1";
		AutoDriver.switchTo().frame(firstFrameName);
		
		//Get element from frame
		WebElement elementFromName = AutoDriver.findElement(By.id("sampleHeading"));
		String elementFromNameValue = elementFromName.getText();
		System.out.println("Element from: [" + firstFrameName + "] Value: [" + elementFromNameValue + "]");
		
		//Switch to parent frame
		AutoDriver.switchTo().parentFrame();
		
		//Switch to frame
		String secondFrameName = "frame2";
		AutoDriver.switchTo().frame(secondFrameName);
		
		//Get element from frame
		WebElement elementFromName2 = AutoDriver.findElement(By.id("sampleHeading"));
		String elementFromName2Value = elementFromName2.getText();
		System.out.println("Element from: [" + secondFrameName + "] Value: [" + elementFromName2Value + "]");
		
		//Switch to default content
		AutoDriver.switchTo().defaultContent();
		
		//Get element from parent frame
		WebElement accordion = AutoDriver.findElement(By.className("accordion"));
		String accordionValue = accordion.getText();
		System.out.println("Element from parent frame: [" + accordionValue + "]");
		
		
		
		
		
		//Test switch to tab
		
		AutoDriver.navigate().to("https://demoqa.com/browser-windows");
		
		//Get parent window
		
		String parentWindowValue = AutoDriver.getWindowHandle();
		System.out.println("Current window: [" + parentWindowValue + "] title: [" + AutoDriver.getTitle() + "]");
		
		//Open new tab
		WebElement newTabButton = AutoDriver.findElement(By.id("tabButton"));
		for(int o=0;o<3;o++) 
		{
			try 
			{
				newTabButton.click();
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				//Do nothing
			}
		}
		
		//Get all tabs and switch then close
		Set<String> allTabs = AutoDriver.getWindowHandles();
		Iterator<String> tabIterator = allTabs.iterator();
		
		while(tabIterator.hasNext()) 
		{
			String tab = tabIterator.next();
			if(!tab.equals(parentWindowValue)) 
			{
				AutoDriver.switchTo().window(tab);
				System.out.println("Current tab: [" + tab + "] title: [" + AutoDriver.getTitle() + "]");
				AutoDriver.close();
			}
		}
		
		//Switch back to parent window
		AutoDriver.switchTo().window(parentWindowValue);
		
		
		
		
		
		//Test switch to window
		
		//Open new window
		parentWindowValue = AutoDriver.getWindowHandle();
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
		Iterator<String> windowIterator = allWindows.iterator();
		
		while(windowIterator.hasNext()) 
		{
			String window = windowIterator.next();
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
