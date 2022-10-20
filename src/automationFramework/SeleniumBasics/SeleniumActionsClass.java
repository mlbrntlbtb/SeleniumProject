package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionsClass 
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
		AutoDriver.navigate().to("https://demoqa.com/text-box");
		
		WebElement targetTextBox = AutoDriver.findElement(By.id("userName"));
		
		//Set upper case value using SHIFT key
		Actions actions = new Actions(AutoDriver);
		actions.keyDown(targetTextBox, Keys.SHIFT).sendKeys("john wick").keyUp(Keys.SHIFT);
		//actions.keyDown(targetTextBox, Keys.SHIFT).sendKeys("john wick").keyUp(Keys.SHIFT).build().perform();
		Action action = actions.build();
		action.perform();
		
		WebElement targetElement = AutoDriver.findElement(By.id("someElement"));
		WebElement fromElement = AutoDriver.findElement(By.id("fromElement"));
		WebElement toElement = AutoDriver.findElement(By.id("toElement"));
		
		//Keyboard events
		actions.keyDown(targetElement, Keys.SHIFT);
		actions.sendKeys("john wick");
		actions.keyUp(targetElement, Keys.SHIFT);
		
		//Mouse events
		actions.click();
		actions.doubleClick();
		actions.contextClick();
		actions.clickAndHold();
		actions.dragAndDrop(fromElement, toElement);
		actions.dragAndDropBy(fromElement, 0, 0);
		actions.moveToElement(targetElement);
		actions.moveByOffset(0, 0);
		actions.release();
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
