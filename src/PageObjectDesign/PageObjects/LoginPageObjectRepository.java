package PageObjectDesign.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjectRepository 
{
	private WebDriver AutoDriver;
	private static WebDriverWait wait;
	
	//Constructor
	public LoginPageObjectRepository(WebDriver autoDriver)
	{
		this.AutoDriver = autoDriver;
		wait = new WebDriverWait(AutoDriver, Duration.ofSeconds(10));
	}
	
	//Page elements
	public WebElement LargeBanner() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
	}
	
	public WebElement SmallBanner() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h5")));
	}
	
	public WebElement Username() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
	}
	
	public WebElement Password() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
	}
	
	public WebElement Login() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
	}
	
	public WebElement NewUser() 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='newUser']")));
	}
	
	
	
	//Keyword Actions
	public void LoginCredentials(String username, String password) 
	{
		Username().clear();
		Username().sendKeys(username);
		Password().clear();
		Password().sendKeys(password);
		Login().click();
	}
}
