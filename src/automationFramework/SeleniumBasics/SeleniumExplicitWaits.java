package automationFramework.SeleniumBasics;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SeleniumExplicitWaits 
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
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Element to be searched not found");
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
		
		//Locators for target category elements
		//String categoryMenu_XPath = "//div[@class='category-cards']";
        String categoryItems_XPath = "//div[contains(@class,'top-card')]"; 
        
        //Explicit waits for category elements
        //WebElement categoryMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryMenu_XPath)));
        List<WebElement> categoryItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(categoryItems_XPath)));
        
        //Get category item value then click
        String firstItemValue = categoryItems.get(0).getText();
        categoryItems.get(0).click();
        System.out.println("Category item: [" + firstItemValue + "]");
        
        //Locators for target accordion elements
        //String accordionMenu_XPath = "//div[@class='accordion']";
        String accordionItems_XPath = "//div[@class='element-group']";
        
        //Explicit wait for accordion elements
        //WebElement accordion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accordionMenu_XPath)));
        List<WebElement> accordionItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(accordionItems_XPath)));
        
        //Get accordion item value then click
        firstItemValue = accordionItems.get(0).getText();
        accordionItems.get(0).click();
        System.out.println("Accordion item: [" + firstItemValue + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
	
}
