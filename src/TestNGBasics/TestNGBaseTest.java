package TestNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestNGBaseTest {
	WebDriver AutoDriver;
	
  @Test
  public void f() 
  {
	  Reporter.log("Opening chrome browser...", true);
	  Reporter.log("Navigating to target application...", true);
	  AutoDriver.navigate().to("https://demoqa.com/");
	  Reporter.log("Closing chrome browser...", true);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("[Before Method]");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
	  AutoDriver = new ChromeDriver();
	  AutoDriver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("[After Method]");
	  //AutoDriver.close();
	  AutoDriver.quit();
  }

}
