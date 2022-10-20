package PageObjectDesign.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectDesign.PageObjects.LoginPage;
import utilities.Constants;
import utilities.ExcelHandler;

public class LoginUsingTestData 
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
	public void Test() throws IOException 
	{
		AutoDriver.navigate().to(Constants.URL);	
		
		LoginPage login = new LoginPage(AutoDriver);
		
		ExcelHandler excel = new ExcelHandler(new File(Constants.testDataPath, Constants.fileName).getPath(), Constants.sheetName);
		Iterator<String> userNameList = excel.getColumnData(excel.getColNumberFromHeader("Username")).iterator();
		Iterator<String> passWordList = excel.getColumnData(excel.getColNumberFromHeader("Password")).iterator();
		
		while(userNameList.hasNext() && passWordList.hasNext()) 
		{
			String userName = userNameList.next();
			String passWord = passWordList.next();
			login.LoginCredentials(userName, passWord);
			System.out.println("Loggin credentials with Username: [" + userName + "] and Password: [" + passWord + "]");
			login.CheckInvalidMessage();
		}
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
