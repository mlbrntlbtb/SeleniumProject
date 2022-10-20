package automationFramework.SeleniumBasics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumSelections {

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
		AutoDriver.navigate().to("https://demoqa.com/automation-practice-form/");
		
		//Radio buttons
		List<WebElement> radioButtons = AutoDriver.findElements(By.xpath("//input[@name='gender']"));
		
		//Select getting value of selected
		Boolean isRbSelected = radioButtons.get(0).isSelected();
		
		if(!isRbSelected) 
		{
			WebElement radioButtonLabel = radioButtons.get(0).findElement(By.xpath(".//following-sibling::label")); //Click label instead since clicking input throws error
			radioButtonLabel.click();
		}
		
		//Select getting attribute value
		String rbValue = radioButtons.get(1).getAttribute("value");
		if(rbValue.equals("Female")) 
		{
			WebElement radioButton2Label = radioButtons.get(1).findElement(By.xpath(".//following-sibling::label")); //Click label instead since clicking input throws error
			radioButton2Label.click();
		}
		
		//Select getting css value
		WebElement otherRadioButton = AutoDriver.findElement(By.cssSelector("input[value=Other]"));
		WebElement radioButton3Label = otherRadioButton.findElement(By.xpath(".//following-sibling::label"));
		radioButton3Label.click();
		
		//Sample dropdown with <select> tag using Select Class
		Select selectDropDown = new Select(AutoDriver.findElement(By.tagName("select")));
		selectDropDown.selectByIndex(0);
		selectDropDown.selectByValue("");
		selectDropDown.selectByVisibleText("");
		List<WebElement> list = selectDropDown.getOptions();
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
	
}
