package automationFramework.SeleniumBasics;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumRobotClass 
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
	public void Test() throws AWTException, InterruptedException 
	{
		AutoDriver.navigate().to("https://demoqa.com/upload-download");
		
		//Click choose file button to open windows dialog
		WebElement chooseFileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='uploadFile']")));
		chooseFileElement.click();
		
		//Copy file path to clipboard
		StringSelection filePath = new StringSelection("C:\\Users\\Melbourne\\Downloads\\sampleFile.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		
		//Execute keyboard events on windows dialog (CTRL+V then ENTER)
		Robot robot = new Robot();
		Thread.sleep(2000); //Short delay after click
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement uploadedFileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
		System.out.println("Uploaded file: [" + uploadedFileElement.getText() + "]");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
