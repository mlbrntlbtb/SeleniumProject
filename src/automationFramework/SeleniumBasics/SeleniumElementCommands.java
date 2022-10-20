package automationFramework.SeleniumBasics;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.BeforeClass;

import java.time.Duration;

import org.junit.AfterClass;

public class SeleniumElementCommands 
{
private static WebDriver AutoDriver;
private static WebDriverWait wait;
	
	@BeforeClass
	public static void Initialize() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
		wait = new WebDriverWait(AutoDriver, Duration.ofSeconds(10));
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/text-box");
		
		//Locator for target element
		String textBox_XPath = "//input[@id='userName']";
		WebElement targetTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textBox_XPath)));
		
		//Displayed
		Boolean tbExists = targetTextBox.isDisplayed();
		System.out.println("Target textbox exists: [" + tbExists + "]");
		
		//Enabled
		Boolean tbEnabled = targetTextBox.isEnabled();
		System.out.println("Target textbox enabled: [" + tbEnabled + "]");
		
		//Click
		targetTextBox.click();
		System.out.println("Target textbox is clicked");
		
		//Send keys
		targetTextBox.sendKeys("Juan Dela Cruz");
		System.out.println("Target textbox value after send keys: [" + targetTextBox.getText() + "]");
		
		//Clear
		targetTextBox.clear();
		System.out.println("Target textbox value after send keys: [" + targetTextBox.getText() + "]");
		
		//Navigate to target checkbox
		AutoDriver.navigate().to("https://demoqa.com/checkbox");
		
		//Locator for target checkbox
		String checkBox_XPath = "//span[@class='rct-checkbox']";
		WebElement targetCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkBox_XPath)));
		
		targetCheckBox.click();
		//Selected
		Boolean cbSelected = targetCheckBox.isSelected();
		System.out.println("Target checkbox selected: [" + cbSelected + "]");
		
		//Navigate to target form
		AutoDriver.navigate().to("https://demoqa.com/automation-practice-form");
		
		//Locator for target form
		String form_XPath = "//form[@id='userForm']";
		WebElement targetForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(form_XPath)));
		
		//Submit
		targetForm.submit();
		System.out.println("Target form submitted");
		
		//Locator for target submit element
		String submit_XPath = "//button[@id='submit']";
		WebElement targetSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_XPath)));
		
		//TagName
		String submitTag = targetSubmit.getTagName();
		System.out.println("Target submit tag: [" + submitTag + "]");
		
		//GetCSSValue
		String submitGetCssBG = targetSubmit.getCssValue("background-color");
		String submitGetCssFS = targetSubmit.getCssValue("font-size");
		System.out.println("Target submit background: [" + submitGetCssBG + "] and font size: [" + submitGetCssFS + "]");
		
		//GetAttribute
		String submitGetAttribute = targetSubmit.getAttribute("class");
		System.out.println("Target submit class attribute value: [" + submitGetAttribute + "]");
		
		//Size
		Dimension size = targetSubmit.getSize();
		System.out.println("Target submit height: [" + size.getHeight() + "] and width: [" + size.getWidth() + "]");
		
		//Location
		Point point = targetSubmit.getLocation();
		System.out.println("Target submit X-Coordinate: [" + point.getX() + "] and Y-Coordinate: [" + point.getY() + "]");
		
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
