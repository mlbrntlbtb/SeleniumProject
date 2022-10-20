package automationFramework.SeleniumBasics;

import java.io.IOException;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAutoIt 
{
private static WebDriver AutoDriver;
private static WebDriverWait wait;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
		wait = new WebDriverWait(AutoDriver, Duration.ofSeconds(10));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void Test() throws InterruptedException, IOException 
	{
		AutoDriver.navigate().to("https://demoqa.com/upload-download");
		WebElement chooseFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='uploadFile']")));
		chooseFile.click();
		
		//Execute executable auto it file script
		Runtime.getRuntime().exec("C:\\Users\\Melbourne\\Documents\\AutoITScripts\\FileUpload.exe"); //"File Upload" title of dialog when run to FF. "Open" in Chrome.
		Thread.sleep(5000);
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
