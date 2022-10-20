package PageObjectDesign.TestCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjectDesign.PageObjects.LoginPage;
import WrapperFactory.WebDriverFactory;

public class LoginUsingWebDriverFactory 
{
	private static WebDriver AutoDriver;
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		WebDriverFactory.InitBrowser("Chrome");
		WebDriverFactory.MaximizeBrowser();
	}
	
	@Test
	public void Test() 
	{
		try 
		{
			WebDriverFactory.LoadApplication("https://demoqa.com/login");
			LoginPage login = new LoginPage(WebDriverFactory.Driver());
			login.LoginCredentials("johnwick", "excommunicado");
		} 
		catch (Exception e) 
		{
			//Do nothing
		}
	}
	
	@AfterClass
	public static void EndTest() 
	{
		WebDriverFactory.CloseAllBrowsers();
	}
}
