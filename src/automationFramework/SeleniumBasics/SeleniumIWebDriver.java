package automationFramework.SeleniumBasics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class SeleniumIWebDriver 
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
		String pageTitle = AutoDriver.getTitle().toString();
		String pageUrl = AutoDriver.getCurrentUrl().toString();
		int pageSourceLength = AutoDriver.getPageSource().length();
		
		System.out.println("Page Title: [" + pageTitle + "]");
		System.out.println("Page URL: [" + pageUrl + "]");
		System.out.println("Page Source Length: [" + pageSourceLength + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		AutoDriver.quit();
	}
}
