package automationFramework.SeleniumBasics;


import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid 
{
private static WebDriver AutoDriver;
	
//	@BeforeClass
//	public static void Initialize() throws MalformedURLException
//	{
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setPlatform(Platform.ANY);
//		capabilities.setBrowserName("chrome");
//		ChromeOptions options = new ChromeOptions();
//		options.merge(capabilities);
//		
//		AutoDriver = new RemoteWebDriver(new URL("http://192.168.100.26:4444"), capabilities);
//	}
//	
	@Test
	public void Test() throws MalformedURLException 
	{
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setPlatform(Platform.ANY);
//		capabilities.setBrowserName("chrome");
//		ChromeOptions options = new ChromeOptions();
//		options.merge(capabilities);
		
		//FirefoxOptions options = new FirefoxOptions();
		ChromeOptions options = new ChromeOptions();
		String node = "http://localhost:4444/wd/hub";
		AutoDriver = new RemoteWebDriver(new URL(node), options);
		//AutoDriver = new RemoteWebDriver(new URL(node), capabilities);
		
		//Get browser name and version
		Capabilities capabilities = ((RemoteWebDriver)AutoDriver).getCapabilities();
		String browserName = capabilities.getBrowserName();
		String browserVersion = capabilities.getBrowserVersion();
		
		System.out.println("Browser Name: [" + browserName + "] Browser Version: [" + browserVersion + "]");
		AutoDriver.navigate().to("https://demoqa.com/");
		AutoDriver.quit();
	}
//	
//	@AfterClass
//	public static void EndTest() 
//	{
//		//AutoDriver.close();
//		AutoDriver.quit();
//	}
	
}
