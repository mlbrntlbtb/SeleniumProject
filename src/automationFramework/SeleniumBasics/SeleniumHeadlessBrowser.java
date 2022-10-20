package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumHeadlessBrowser 
{
private static WebDriver AutoDriver;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		
		//Add "headless" argument on browser options
		ChromeOptions chromeOptions = new ChromeOptions();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		
		chromeOptions.addArguments("headless");
		firefoxOptions.addArguments("--headless"); //firefoxOptions.setHeadless(true);
		
		//AutoDriver = new ChromeDriver(chromeOptions);
		AutoDriver = new FirefoxDriver(firefoxOptions);
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		System.out.println("Page title: [" + AutoDriver.getTitle() + "]");
		
		WebElement categoryCards = AutoDriver.findElement(By.xpath("//div[@class='category-cards']"));
		System.out.println("Category cards: [" + categoryCards.getText() + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
