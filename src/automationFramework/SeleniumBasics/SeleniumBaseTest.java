package automationFramework.SeleniumBasics;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.BeforeClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;

public class SeleniumBaseTest 
{
	private static WebDriver AutoDriver;
	private static Logger logger;
	
	@BeforeClass
	public static void Initialize() 
	{
		logger = LogManager.getLogger(SeleniumBaseTest.class.getName());
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
		logger.info("Initializing browser... ");
	}
	
	@Test
	public void Test() 
	{
		String targetURL = "https://demoqa.com/";
		logger.info("Navigating to: [" + targetURL + "]");
		AutoDriver.navigate().to(targetURL);
	}
	
	@AfterClass
	public static void EndTest() 
	{
		logger.info("Closing browser... ");
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
