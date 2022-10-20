package TestNGBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGCrossBrowserTest 
{
  public WebDriver AutoDriver;
	
  @Parameters("browserName")
  
  @BeforeClass
  public void StartBrowser(String browserName) throws Exception 
  {
	  
	  switch(browserName.toLowerCase()) 
	  {
	  case "chrome":
		  AutoDriver = WebDriverManager.chromedriver().create();
		  break;
	  case "firefox":
		  AutoDriver = WebDriverManager.firefoxdriver().create();
		  break;
	  default:
		  throw new Exception("Browser: [" + browserName + "] not available.");
	  }
  }
  
  @Test
  public void NavigateTo() 
  {
	  AutoDriver.navigate().to("https://demoqa.com/");
  }
  
  @AfterClass
  public void EndTest() 
  {
	  AutoDriver.close();
	  AutoDriver.quit();
  }
}
