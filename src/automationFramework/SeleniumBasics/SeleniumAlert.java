package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert 
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
		
		//Handling simple alerts
		
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
		
		//Handling confirmation alerts
		WebElement confirmButton = AutoDriver.findElement(By.id("confirmButton"));
		confirmButton.click();
		
		//Switch to alert
		Alert confirmAlert = AutoDriver.switchTo().alert();
		
		//Get value of alert
		String confirmAlertValue = confirmAlert.getText();
		System.out.println("Confirm alert value: [" + confirmAlertValue + "]");
		
		//Dismiss alert
		confirmAlert.dismiss();
		
		//Handling prompt alerts
		WebElement promptButton = AutoDriver.findElement(By.id("promtButton"));
		promptButton.click();
		
		//Switch to alert
		Alert promptAlert = AutoDriver.switchTo().alert();
		
		//Get value of alert
		String promptAlertValue = promptAlert.getText();
		System.out.println("Prompt alert value: [" + promptAlertValue + "]");
		
		//Enter value to prompt alert
		 promptAlert.sendKeys("John Wick");
		 
		 //Accept alert
		 promptAlert.accept();
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
	
}
