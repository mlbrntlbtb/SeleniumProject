package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFindElement 
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
		
		//Find element by Name
		WebElement nameElement = AutoDriver.findElement(By.name("viewport"));
		
		//Find element by ClassName
		WebElement classNameElement = AutoDriver.findElement(By.className("category-cards"));
		
		AutoDriver.navigate().to("https://demoqa.com/text-box");
		
		//Find element by XPath
		WebElement xPathElement = AutoDriver.findElement(By.xpath("//input[@id='userName']"));
		
		//Find element by ID
		WebElement idElement = AutoDriver.findElement(By.id("userName"));
		
		//Find element by CSS Selector
		WebElement cssSelectorElement = AutoDriver.findElement(By.cssSelector("input[id=userName]"));
		cssSelectorElement = AutoDriver.findElement(By.cssSelector("input#userName"));
		
		AutoDriver.navigate().to("https://demoqa.com/buttons");
		
		//Find element by tag name
		WebElement tagNameElement = AutoDriver.findElement(By.tagName("button"));
		
		AutoDriver.navigate().to("https://demoqa.com/links");
		
		//Find element by LinkText
		WebElement linkTextElement = AutoDriver.findElement(By.linkText("Home"));
		
		//Find element by PartialLinkText
		linkTextElement = AutoDriver.findElement(By.partialLinkText("Content"));
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
	
}
