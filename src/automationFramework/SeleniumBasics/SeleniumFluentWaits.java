package automationFramework.SeleniumBasics;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SeleniumFluentWaits 
{
private static WebDriver AutoDriver;
private static FluentWait<WebDriver> fwait;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
		fwait = new FluentWait<WebDriver>(AutoDriver);
		fwait.pollingEvery(Duration.ofMillis(250));
		fwait.withTimeout(Duration.ofSeconds(10));
		fwait.ignoring(NoSuchElementException.class);
		fwait.withMessage("Element to be searched not found");
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		
		//Locators for target category elements
		String categoryItems_XPath = "//div[contains(@class,'top-card')]";
		
		//Fluent waits for category elements
		List<WebElement> categoryItems = fwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(categoryItems_XPath)));
		
		//Get category item value then click
        String firstItemValue = categoryItems.get(0).getText();
        categoryItems.get(0).click();
        System.out.println("Category item: [" + firstItemValue + "]");
        
        //Locators for target accordion elements
        String accordionItems_XPath = "//div[@class='element-group']";
        
        //Fluent waits for accordion elements
        List<WebElement> accordionItems = fwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(accordionItems_XPath)));
        
        //Get accordion item value then click
        firstItemValue = accordionItems.get(0).getText();
        accordionItems.get(0).click();
        System.out.println("Accordion item: [" + firstItemValue + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
