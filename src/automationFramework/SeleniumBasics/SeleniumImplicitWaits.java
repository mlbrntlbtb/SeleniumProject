package automationFramework.SeleniumBasics;
import java.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumImplicitWaits 
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
		AutoDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AutoDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		AutoDriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
		AutoDriver.navigate().to("https://demoqa.com/");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}

}
