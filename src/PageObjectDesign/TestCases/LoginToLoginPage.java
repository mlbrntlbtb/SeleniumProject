package PageObjectDesign.TestCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjectDesign.PageObjects.*;

public class LoginToLoginPage 
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
		AutoDriver.navigate().to("https://demoqa.com/login");
		
		LoginPage login = new LoginPage(AutoDriver);
		login.LoginCredentials("johnwick", "excommunicado");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
