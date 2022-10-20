package WrapperFactory;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory 
{
	private static HashMap<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
	private static WebDriver driver;
	
	public static WebDriver Driver() throws Exception
	{
		if(driver == null) 
		{
			throw new Exception("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
		}
		return driver; 
	};
	
	public static WebDriver InitBrowser(String browserName) 
	{
		switch(browserName) 
		{
		case "Firefox":
			driver = drivers.get("Firefox");
			if(driver == null) 
			{
				driver = new FirefoxDriver();
				drivers.put("Firefox",driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if(driver == null) 
			{
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
		return driver;
	}
	
	public static void LoadApplication(String url) 
	{
		driver.navigate().to(url);
	}
	
	public static void MaximizeBrowser() 
	{
		driver.manage().window().maximize();
	}
	
	public static void CloseAllBrowsers()
	{
		for(String key: drivers.keySet())
		{
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
