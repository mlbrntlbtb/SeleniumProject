package automationFramework.SeleniumBasics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebTables 
{
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
		AutoDriver.navigate().to("https://demoqa.com/webtables");
		
		String targetColumn = "Last Name";
		int targetRow = 1;
		
		WebElement tableContainer = AutoDriver.findElement(By.xpath("//div[@class='rt-table']"));
		List<WebElement> tableHeaders = tableContainer.findElements(By.xpath(".//div[contains(@class,'header-content')]"));
		List<WebElement> tableRows = tableContainer.findElements(By.xpath(".//div[contains(@class,'rt-tr-group')]"));
		
		int headerIndex = GetColumnHeaderIndex(tableHeaders, targetColumn);
		String cellValue = GetTargetCell(headerIndex, tableRows.get(targetRow)).getText().trim();
		
		System.out.println("Target cell with column: [" + targetColumn + "] and row: [" + targetRow + "] has value of: [" + cellValue + "]");
	}
	
	public int GetColumnHeaderIndex(List<WebElement> tableHeaders, String targetHeader) 
	{
		for(int h=0;h<tableHeaders.size();h++) 
		{
			WebElement currentTableHeader = tableHeaders.get(h);
			String headerValue = currentTableHeader.getText() != null ? currentTableHeader.getText() :
				currentTableHeader.getAttribute("value");
			
			if(headerValue.trim().equals(targetHeader))
				return h;
		}
		return -1;
	}
	
	public WebElement GetTargetCell(int headerIndex, WebElement targetRow) 
	{
		List<WebElement> tableCells = targetRow.findElements(By.xpath(".//div[contains(@class,'rt-td')]"));
		return tableCells.get(headerIndex);
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
