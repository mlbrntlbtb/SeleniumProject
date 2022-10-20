package automationFramework.SeleniumBasics;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotHandler;

public class SeleniumExceptions 
{
private static WebDriver AutoDriver;
Logger logger = LogManager.getLogger(SeleniumExceptions.class);
	
	@BeforeMethod
	public void Initialize() 
	{
		logger.info("Initializing browser...");
		AutoDriver = WebDriverManager.chromedriver().create();
		AutoDriver.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		try 
		{
			String targetURL = "https://demoqa.com/";
			logger.info("Navigating to: [" + targetURL + "]");
			AutoDriver.navigate().to(targetURL);
			
			logger.info("Finding target element... ");
			WebElement someElement = AutoDriver.findElement(By.xpath("//div[@class='category-cardsss']"));
			
			logger.info("Target element displayed: [" + someElement.isDisplayed() + "]");
		}
		catch (NoSuchElementException e) 
		{
			//InvalidSelectorException
            //The element is not present in the DOM when the search operation is performed.
			ScreenshotHandler.takeScreenShot(AutoDriver);
			logger.error("No element found. See log error for details: ");
			logger.error(e.getMessage());
			throw(e);
		}
		catch (StaleElementReferenceException e)
        {
            //The web element is present in the DOM when the search is initiated
            //but the element might have become stale (or its state in the DOM could have changed)
            //when the search call is made.
			ScreenshotHandler.takeScreenShot(AutoDriver);
			logger.error("Element is present but have become stale in the DOM. See log error for details: ");
			logger.error(e.getMessage());
			throw(e);
        }
        catch (ElementNotInteractableException e)
        {
        	//ElementNotVisibleException
        	//ElementNotSelectableException
            //The web element is present in the DOM but it is not yet visible/selectable when the search process is initiated.
        	logger.error("Element not interactable. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
        catch (NoSuchFrameException e)
        {
            //The WebDriver tries switching to a frame which is not a valid one.
        	logger.error("No frame found. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
        catch (NoAlertPresentException e)
        {
            //The WebDriver attempts switching to an alert window which is not yet available.
        	logger.error("No present alert found. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
        catch (NoSuchWindowException e)
        {
            //The WebDriver attempts switching to a window that is not a valid one.
        	logger.error("No window found. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
        catch (TimeoutException e)
        {
            //Using waits, this exception is thrown if the command did not execute or complete within wait time
        	logger.error("Element not found within the set time limit. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
        catch (WebDriverException e)
        {
            //UnhandledAlertException handled: Unexpected alert is displayed
            //Webdriver is acting immediately after ‘closing’ the browser
        	logger.error("No web driver available. See log error for details: ");
        	logger.error(e.getMessage());
        	ScreenshotHandler.takeScreenShot(AutoDriver);
        	throw(e);
        }
		catch (Exception e) 
		{
			logger.error("Unexpected error has occured. See log error for details: ");
			logger.error(e.getMessage());
			ScreenshotHandler.takeScreenShot(AutoDriver);
			throw(e);
		}
		finally
		{
			logger.info("Terminating session...");
			//AutoDriver.close();
			AutoDriver.quit();
		}
	}
	
	@AfterMethod
	public void EndTest() 
	{
		logger.info("Test ended.");
	}
}
