package automationFramework.SeleniumBasics;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCookies 
{
	//More info on cookies > DevTools > Application Tab > Storage > Cookies
	//Store cookies > login credentials > reduce execution time
	WebDriver AutoDriver;
	
	@BeforeMethod
	public void Initialize() 
	{
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		AutoDriver = WebDriverManager.chromedriver().capabilities(options).create();
		
		AutoDriver.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		
		//Get all cookies
		//Use 'Set' for collection of cookies -- does not allow duplicate values/elements.
		Set<Cookie> cookiesList = AutoDriver.manage().getCookies();
		for(Cookie cookie : cookiesList) 
		{
			System.out.println("Cookie: [" + cookie + "]");
		}
		
		//Get target cookie using name
		Cookie targetCookie = AutoDriver.manage().getCookieNamed("_gid");
		System.out.println("Cookie: Name [" + targetCookie.getName() + "] Value [" + targetCookie.getValue() + "]");
		
		//Add cookie
		Cookie newCookie = new Cookie("MyCookie","1234567890");
		AutoDriver.manage().addCookie(newCookie);
		Cookie targetNewCookie = AutoDriver.manage().getCookieNamed("MyCookie");
		System.out.println("Cookie: Name [" + targetNewCookie.getName() + "] Value [" + targetNewCookie.getValue() + "]");
		
		//Delete cookie
		AutoDriver.manage().deleteCookieNamed("MyCookie");
		//AutoDriver.manage().deleteAllCookies();
		
		
		
	}
	
	@AfterMethod
	public void EndTest() 
	{
		AutoDriver.quit();
	}
	
}
