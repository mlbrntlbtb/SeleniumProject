package TestNGBasics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParallelTest 
{
  @Test
  //@Test (threadPoolSize = 4, invocationCount = 4) //Run parallel test configuring inside test code
  public void ChromeTest() throws MalformedURLException 
  {
	  //System.out.println("Thread ID for Chrome: [" + Thread.currentThread().getId() + "]");
	  //WebDriver AutoDriver = WebDriverManager.chromedriver().create();
	  
	  //Run on selenium grid -- via docker
	  ChromeOptions options = new ChromeOptions();
	  String node = "http://localhost:4444/wd/hub";
	  WebDriver AutoDriver = new RemoteWebDriver(new URL(node), options);
	  
	  AutoDriver.navigate().to("https://demoqa.com/");
	  AutoDriver.quit();
  }	
  
  @Test
  public void FirefoxTest() throws MalformedURLException 
  {
	  //System.out.println("Thread ID for Firefox: [" + Thread.currentThread().getId() + "]");
	  //WebDriver AutoDriver = WebDriverManager.firefoxdriver().create();
	  
	  //Run on selenium grid -- via docker
	  FirefoxOptions options = new FirefoxOptions();
	  String node = "http://localhost:4444/wd/hub";
	  WebDriver AutoDriver = new RemoteWebDriver(new URL(node), options);
	  
	  AutoDriver.navigate().to("https://demoqa.com/");
	  AutoDriver.quit();
  }
}
