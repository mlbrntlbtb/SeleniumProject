package automationFramework.SeleniumBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJavaScriptExecutor 
{
private static WebDriver AutoDriver;
private static JavascriptExecutor javaScriptExecutor;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
		javaScriptExecutor = (JavascriptExecutor)AutoDriver;
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		
		//ExecuteScript
        //JavaScriptExecutor.ExecuteScript("<script>"); //Param arg can be empty
		
		//Scroll into view
		WebElement targetElement = AutoDriver.findElement(By.xpath("<sample_xpath>"));
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", targetElement);
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(false);", targetElement);
		
		//Page load completed
		Boolean readyState = javaScriptExecutor.executeScript("return document.readyState").equals("complete");
		
		//Ajax calls - check if jQuery is active
		Boolean isjQueryActive = (Boolean)javaScriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active==0");
		
		//Open browser tab
		javaScriptExecutor.executeScript("window.open();");
		
		//Click
		javaScriptExecutor.executeScript("arguments[0].click", targetElement);
		
		//Alerts
		javaScriptExecutor.executeScript("alert('Hello');");
		
		//Scrolling
		WebElement scrollElement = AutoDriver.findElement(By.xpath("<sample_xpath>"));
		javaScriptExecutor.executeScript("arguments[0].scrollTop += 100", scrollElement);
		javaScriptExecutor.executeScript("arguments[0].scrollLeft += 100", scrollElement);
		
		WebElement tableElement = AutoDriver.findElement(By.xpath("<sample_xpath>"));
		int scrollYPos = (int)javaScriptExecutor.executeScript("return arguments[0].scrollTop", tableElement);
		int scrollXPos = (int)javaScriptExecutor.executeScript("return arguments[0].scrollLeft", tableElement);
		
		javaScriptExecutor.executeScript("arguments[0].scrollTop = 100", scrollElement);
		javaScriptExecutor.executeScript("arguments[0].scrollLeft = 100", scrollElement);
		
		//Scroll height Client height
		int scrollHeight = (int)javaScriptExecutor.executeScript("return arguments[0].scrollHeight", tableElement);
		int clientHeight = (int)javaScriptExecutor.executeScript("return arguments[0].clientHeight", tableElement);
		
		//Inner and outer height
		int outerHeight = (int)javaScriptExecutor.executeScript("return window.outerHeight");
		int innerHeight = (int)javaScriptExecutor.executeScript("return window.innerHeight");
		
		//Zoom level
        int zoomLevel = (int)javaScriptExecutor.executeScript("return window.screen.deviceXDPI");

        //Get check state value checkbox
        WebElement targetCheckBox = AutoDriver.findElement(By.xpath("<sample_xpath>"));
        String checkState = javaScriptExecutor.executeScript("return arguments[0].checked", targetCheckBox).toString();

        //Display
        javaScriptExecutor.executeScript("arguments[0].style.display='block'", targetElement);
        javaScriptExecutor.executeScript("arguments[0].style.display='none'", targetElement);
        javaScriptExecutor.executeScript("arguments[0].style.visibility='visible'", targetElement);

        //Lose focus
        WebElement activeElement = AutoDriver.findElement(By.xpath("<sample_xpath>"));
        javaScriptExecutor.executeScript("document.activeElement.blur()", activeElement);

        //Set focus
        javaScriptExecutor.executeScript("arguments[0].focus();", targetElement);

        //Set attribute
        String attributeName = ""; String value = "";
        javaScriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", targetElement, attributeName, value);

        //Get sibling node value
        String nodeVal = javaScriptExecutor.executeScript("return arguments[0].nextSibling.nodeValue", targetElement).toString();
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
