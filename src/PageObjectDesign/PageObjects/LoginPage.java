package PageObjectDesign.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver AutoDriver;
	WebDriverWait wait;
	
	//Constructor
	public LoginPage(WebDriver autoDriver)
	{
		this.AutoDriver = autoDriver;
		//PageFactory.initElements(autoDriver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(autoDriver, 10) , this); //Alternative for explicit wait
		wait = new WebDriverWait(AutoDriver, Duration.ofSeconds(5));
	}
	
	//Use @FindBy or @FindAll to locate elements
	@FindBy(xpath="//input[@id='userName']")
	public WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement Password;
	
	@FindBy(xpath="//button[@id='login']")
	//@CacheLookup
	public WebElement Login;
	
	public void LoginCredentials(String username, String password) 
	{
		Username.clear();
		Username.sendKeys(username);
		Password.clear();
		Password.sendKeys(password);
		Login.click();
	}
	
	public void CheckInvalidMessage() 
	{
		try
		{
			WebElement invalidMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
			System.out.println("Invalid username or password.");
		}
		catch(TimeoutException e)
		{
			System.out.println("Login successful.");
			Logout();
		}
	}
	
	public void Logout() 
	{
		WebElement Logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
		Logout.click();
		System.out.println("Logging out... ");
		wait.until(ExpectedConditions.invisibilityOf(Logout));
	}
}
