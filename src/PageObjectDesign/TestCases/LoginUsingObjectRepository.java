package PageObjectDesign.TestCases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectDesign.PageObjects.*;

public class LoginUsingObjectRepository 
{
	private static WebDriver AutoDriver;
	
	@BeforeClass
	public static void Initialize() 
	{
		AutoDriver = WebDriverManager.chromedriver().create();
		AutoDriver.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/login");
		LoginPageObjectRepository login = new LoginPageObjectRepository(AutoDriver);
		System.out.println("Large banner displayed: [" + login.LargeBanner().isDisplayed() + "]");
		System.out.println("Small banner displayed: [" + login.SmallBanner().isDisplayed() + "]");
		System.out.println("Username Field displayed: [" + login.Username().isDisplayed() + "]");
		System.out.println("Password Field displayed: [" + login.Password().isDisplayed() + "]");
		System.out.println("Login Button displayed: [" + login.Login().isDisplayed() + "]");
		System.out.println("New User Button displayed: [" + login.NewUser().isDisplayed() + "]");
		
		login.LoginCredentials("johnwick", "excommunicado");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}

}
