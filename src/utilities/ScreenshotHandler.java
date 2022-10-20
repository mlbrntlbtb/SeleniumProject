package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHandler 
{
	public static void takeScreenShot(WebDriver AutoDriver) 
	{
		Logger logger = LogManager.getLogger(ScreenshotHandler.class);
		try 
		{
			File screenshot = ((TakesScreenshot)AutoDriver).getScreenshotAs(OutputType.FILE);
			File path = new File("C:\\Users\\Melbourne\\Documents\\SampleLogFiles\\screenshot.png");
			FileUtils.copyFile(screenshot, path);
			logger.info("See screenshot details here: [" + path + "]");
		}
		catch(Exception e) 
		{
			logger.error("Unexpected error has occured while taking screenshot. See log error for details: ");
			logger.error(e.getMessage());
		}	
				
	}
}
