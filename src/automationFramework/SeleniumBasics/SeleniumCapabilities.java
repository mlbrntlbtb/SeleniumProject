package automationFramework.SeleniumBasics;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class SeleniumCapabilities 
{
private static WebDriver AutoDriver;
private static ChromeOptions chromeOptions;
private static FirefoxOptions firefoxOptions;
	
	@BeforeClass
	public static void Initialize() 
	{
		//Shared capabilities
		
		chromeOptions = new ChromeOptions();
		firefoxOptions = new FirefoxOptions();
		
		chromeOptions.getBrowserName();
		firefoxOptions.getBrowserName();
		
		chromeOptions.getBrowserVersion();
        firefoxOptions.getBrowserVersion();
        
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL); //NORMAL, EAGER, NON
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        
        chromeOptions.setPlatformName("OS");
        firefoxOptions.setPlatformName("OS");
        
        chromeOptions.setAcceptInsecureCerts(true); //Accepts TLS or SSL certificates
        firefoxOptions.setAcceptInsecureCerts(true);
        
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        
        chromeOptions.setStrictFileInteractability(true); //Checks for input type=file elements
        firefoxOptions.setStrictFileInteractability(true);
        
        Proxy proxy = new Proxy(); //Capture traffic and access networks/url blocked that needs proxy to be accessed
        proxy.setHttpProxy("yoururl:portno");
        proxy.setSslProxy("yoururl:portno");
        proxy.setAutodetect(false);
        chromeOptions.setProxy(proxy);
        firefoxOptions.setProxy(proxy);
        
        
        //Chrome options -- more info chromium command line switches: https://peter.sh/experiments/chromium-command-line-switches/
		chromeOptions.addArguments("start-maximized"); //maximize
		chromeOptions.addArguments("incognito"); //opens in incognito
		chromeOptions.addArguments("headless"); //opens headless state
		chromeOptions.addArguments("--window-size=1920,1080"); //Set window size
		chromeOptions.addArguments("disable-extensions"); //disables existing extensions
		chromeOptions.addArguments("disable-popup-blocking"); //disables popups
        chromeOptions.addArguments("disable-default-apps"); //disables installation of default apps on first run
        chromeOptions.addArguments("make-default-browser"); //makes chrome default browser
        chromeOptions.addArguments("version"); //prints chrome version
        chromeOptions.addArguments("ignore-certificate-errors"); //ignores SSL certificates
        chromeOptions.addArguments("--silent"); //silent mode -- log nothing
        chromeOptions.setExperimentalOption("excludeSwitches", "enable-automation"); //disables infobars e.g. chrome is being controlled..
        chromeOptions.setExperimentalOption("useAutomationExtension", false); //disables developer mode extensions
        chromeOptions.setExperimentalOption("credentials_enable_service", false);
        chromeOptions.setExperimentalOption("profile.password_manager_enabled", false);
        
        
        //Firefox options -- more info command line switches: http://kb.mozillazine.org/About:config_entries & http://kb.mozillazine.org/Category:Preferences
        //FirefoxProfile firefoxProfile = new FirefoxProfile(); 
        ProfilesIni profile = new ProfilesIni();
        
        FirefoxProfile firefoxProfile = profile.getProfile("SeleniumProfile"); //Run firefox.exe -p to create ff profile
        firefoxProfile.setPreference("browser.fixup.alternate.enabled", false);
        firefoxProfile.setPreference("browser.download.useDownloadDir", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "<type of files>");
        firefoxOptions.setProfile(firefoxProfile);
        
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melbourne\\Documents\\WebDrivers\\geckodriver.exe");
		
		AutoDriver = new ChromeDriver();
		AutoDriver.manage().window().maximize();
	}
	
	@Test
	public void Test() 
	{
		AutoDriver.navigate().to("https://demoqa.com/");
	}
	
	@AfterClass
	public static void EndTest() 
	{
		//AutoDriver.close();
		AutoDriver.quit();
	}
}
